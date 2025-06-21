document.addEventListener("DOMContentLoaded", () => {
  fetch("/api/clientes")
    .then(response => {
      if (!response.ok) throw new Error("Error al obtener clientes");
      return response.json();
    })
    .then(clientes => {
      const div = document.getElementById("clientes");
      if (clientes.length === 0) {
        div.innerHTML = "<p>No hay clientes registrados.</p>";
        return;
      }

      const ul = document.createElement("ul");
      clientes.forEach(cliente => {
        const li = document.createElement("li");
        li.textContent = `${cliente.nombre} - ${cliente.identificacion}`;
        ul.appendChild(li);
      });
      div.appendChild(ul);
    })
    .catch(err => {
      console.error(err);
      document.getElementById("clientes").textContent = "Error cargando datos.";
    });
});
