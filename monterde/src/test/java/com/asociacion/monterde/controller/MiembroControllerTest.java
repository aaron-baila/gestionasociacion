package com.asociacion.monterde.controller;

import com.asociacion.monterde.model.Miembro;
import com.asociacion.monterde.service.MiembroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MiembroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private MiembroService miembroService;

    @BeforeEach
    void setUp() {
        Miembro miembro1 = new Miembro();
        miembro1.setId(1L);
        miembro1.setNombre("Juan");
        miembro1.setApellidos("Pérez");
        miembro1.setEmail("jperez@gmail.com");
        miembro1.setCargo("Presidente");
        miembro1.setFechaIngreso(LocalDate.now());
        miembro1.setEstado(Miembro.Estado.ACTIVO);

        Miembro miembro2 = new Miembro();
        miembro2.setId(2L);
        miembro2.setNombre("Ana");
        miembro2.setApellidos("García");
        miembro2.setEmail("agarcia@gmail.com");
        miembro2.setCargo("Tesorero");
        miembro2.setFechaIngreso(LocalDate.now());
        miembro2.setEstado(Miembro.Estado.ACTIVO);
    }

    
    @Test
    void testEliminarMiembro() throws Exception {
        Mockito.when(miembroService.existeMiembro(1L)).thenReturn(true);
        Mockito.doNothing().when(miembroService).eliminarMiembro(1L);

        mockMvc.perform(get("/miembros/eliminar/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/miembros"));
    }


}