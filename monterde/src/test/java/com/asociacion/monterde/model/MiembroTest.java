package com.asociacion.monterde.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MiembroTest {

    @Test
    void testMiembroInitialization() {
        // Crear un miembro con el constructor
        Miembro miembro = new Miembro(
                1L,
                "12345678A",
                "Juan",
                "Pérez López",
                "El Profe",
                "juan.perez@example.com",
                "666555444",
                "Calle Falsa 123",
                "foto.jpg",
                "Presidente",
                LocalDate.of(2020, 1, 1),
                Miembro.Estado.ACTIVO,
                true
        );

        // Verificar que los campos se inicializan correctamente
        assertEquals(1L, miembro.getId());
        assertEquals("12345678A", miembro.getDni());
        assertEquals("Juan", miembro.getNombre());
        assertEquals("Pérez López", miembro.getApellidos());
        assertEquals("El Profe", miembro.getApodo());
        assertEquals("juan.perez@example.com", miembro.getEmail());
        assertEquals("666555444", miembro.getTelefono());
        assertEquals("Calle Falsa 123", miembro.getDireccion());
        assertEquals("foto.jpg", miembro.getFoto());
        assertEquals("Presidente", miembro.getCargo());
        assertEquals(LocalDate.of(2020, 1, 1), miembro.getFechaIngreso());
        assertEquals(Miembro.Estado.ACTIVO, miembro.getEstado());
        assertTrue(miembro.getLOPD());
    }

    @Test
    void testDefaultValues() {
        // Crear un miembro con el constructor vacío
        Miembro miembro = new Miembro();

        // Verificar valores por defecto
        assertNull(miembro.getId());
        assertNull(miembro.getDni());
        assertNull(miembro.getNombre());
        assertNull(miembro.getApellidos());
        assertNull(miembro.getApodo());
        assertNull(miembro.getEmail());
        assertNull(miembro.getTelefono());
        assertNull(miembro.getDireccion());
        assertNull(miembro.getFoto());
        assertNull(miembro.getCargo());
        assertNull(miembro.getFechaIngreso());
        assertEquals(Miembro.Estado.ACTIVO, miembro.getEstado()); // Estado por defecto
        assertNull(miembro.getLOPD());
    }

    @Test
    void testSettersAndGetters() {
        // Crear un miembro vacío
        Miembro miembro = new Miembro();

        // Establecer valores
        miembro.setId(1L);
        miembro.setDni("87654321B");
        miembro.setNombre("María");
        miembro.setApellidos("Gómez García");
        miembro.setApodo("La Ingeniera");
        miembro.setEmail("maria.gomez@example.com");
        miembro.setTelefono("777888999");
        miembro.setDireccion("Av. Siempre Viva 742");
        miembro.setFoto("maria.jpg");
        miembro.setCargo("Tesorero");
        miembro.setFechaIngreso(LocalDate.of(2019, 5, 10));
        miembro.setEstado(Miembro.Estado.INACTIVO);
        miembro.setLOPD(false);

        // Verificar valores
        assertEquals(1L, miembro.getId());
        assertEquals("87654321B", miembro.getDni());
        assertEquals("María", miembro.getNombre());
        assertEquals("Gómez García", miembro.getApellidos());
        assertEquals("La Ingeniera", miembro.getApodo());
        assertEquals("maria.gomez@example.com", miembro.getEmail());
        assertEquals("777888999", miembro.getTelefono());
        assertEquals("Av. Siempre Viva 742", miembro.getDireccion());
        assertEquals("maria.jpg", miembro.getFoto());
        assertEquals("Tesorero", miembro.getCargo());
        assertEquals(LocalDate.of(2019, 5, 10), miembro.getFechaIngreso());
        assertEquals(Miembro.Estado.INACTIVO, miembro.getEstado());
        assertFalse(miembro.getLOPD());
    }
}
