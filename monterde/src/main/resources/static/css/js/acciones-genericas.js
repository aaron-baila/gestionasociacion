document.addEventListener("DOMContentLoaded", () => {
    const botonesEliminar = document.querySelectorAll(".btn-eliminar");

    botonesEliminar.forEach(boton => {
        boton.addEventListener("click", () => {
            const id = boton.getAttribute("data-id");         // ID del elemento a eliminar
            const entity = boton.getAttribute("data-entity"); // Tipo de entidad (eventos, miembros, etc.)

            // Mostrar popup de confirmación con SweetAlert2
            Swal.fire({
                title: '¿Estás seguro?',
                text: `¿Deseas eliminar este ${entity.slice(0, -1)}? Esta acción no se puede deshacer.`,
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Sí, eliminar',
                cancelButtonText: 'Cancelar'
            }).then((result) => {
                if (result.isConfirmed) {
                    // Redirigir a la URL de eliminación basada en el tipo de entidad
                    window.location.href = `/${entity}/eliminar/${id}`;
                }
            });
        });
    });
});
