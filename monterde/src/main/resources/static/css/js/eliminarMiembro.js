function eliminarMiembro(id) {
    if (confirm('¿Estás seguro de que quieres eliminar este miembro?')) {
        // Realiza la solicitud DELETE usando Fetch
        fetch('/eliminar/' + id, {
            method: 'DELETE'
        })
            .then(response => {
                if (response.ok) {
                    alert('Miembro eliminado con éxito.');
                    window.location.reload(); // Recarga la página para actualizar la lista de miembros
                } else {
                    alert('Hubo un error al eliminar el miembro.');
                }
            })
            .catch(error => {
                console.error('Error al eliminar miembro:', error);
                alert('Hubo un error al eliminar el miembro.');
            });
    }
}
