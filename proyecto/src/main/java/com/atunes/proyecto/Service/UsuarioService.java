    package com.atunes.proyecto.Service;

    import java.util.List;
    import java.util.Optional;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.security.core.userdetails.UserDetailsService;
    import org.springframework.security.core.userdetails.UsernameNotFoundException;
    import org.springframework.stereotype.Service;

    import com.atunes.proyecto.Entity.Usuario;
    import com.atunes.proyecto.Repository.RepositoryUsuario;

    import org.springframework.transaction.annotation.Transactional;

    @Service
    public class UsuarioService implements UserDetailsService {
        @Autowired
        public RepositoryUsuario repositoryUsuario;

        //listar todos los usuarios
        @Transactional(readOnly = true)
        public List<Usuario> listarTodosLosUsuarios(){
            return repositoryUsuario.findAll();
        }

        //buscar usuarios por ID
        @Transactional(readOnly = true)
        public Optional<Usuario>buscarUsuarioPorId(Long id){
            if (id == null) {
                throw new IllegalArgumentException("El ID no puede ser nulo.");
            }
            return repositoryUsuario.findById(id);
        }
        //guardar o actualizar un usuario
        @Transactional
        public Usuario guardarUsuario(Usuario usuario){
            if (usuario == null) {
                throw new IllegalArgumentException("El Usuario no puede ser nulo.");
            }
            return repositoryUsuario.save(usuario);
        }
        //eliminar usuario por id
        @Transactional
        public void eliminarUsuarioPorId(Long id){
            if (id == null) {
                throw new IllegalArgumentException("El ID no puede ser nulo para eliminar un Usuario.");
            }
            if (!repositoryUsuario.existsById(id)) {
                throw new IllegalArgumentException("El ID " + id + " no existe.");
            }
            repositoryUsuario.deleteById(id);
        }

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            // Busca el usuario por su nombre de usuario en la base de datos
            Usuario usuario = repositoryUsuario.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

            // Retorna el objeto Usuario, que ya implementa UserDetails
            // Asegúrate de que tu entidad Usuario implemente todos los métodos de UserDetails
            // y que getAuthorities() devuelva los roles correctos.
            return usuario;
        }
    }
