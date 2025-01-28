package com.asociacion.monterde.controller;

import com.asociacion.monterde.service.MiembroService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

class MiembroControllerTest {

    @Mock
    private MiembroService miembroService;

    @Mock
    private Model model;

    @InjectMocks
    private MiembroController miembroController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    void testCrearMiembro_Success() {
//        Miembro miembro = new Miembro();
////        when(miembroService.crearMiembro(any(Miembro.class))).thenReturn(miembro);
//
//        String viewName = miembroController.crearMiembro(miembro, model);
//
//        verify(miembroService, times(1)).crearMiembro(any(Miembro.class));
//        assertEquals("redirect:/miembros", viewName);
//    }

//    @Test
//    void testCrearMiembro_Failure() {
//        Miembro miembro = new Miembro();
//        doThrow(new RuntimeException()).when(miembroService).crearMiembro(any(Miembro.class));
//
//        String viewName = miembroController.crearMiembro(miembro, model);
//
//        verify(model, times(1)).addAttribute(eq("error"), anyString());
//        assertEquals("formulario-miembro", viewName);
//    }

//    @Test
//    void testListarMiembros() {
//        List<Miembro> miembros = new ArrayList<>();
//        when(miembroService.obtenerTodosLosMiembros()).thenReturn(miembros);
//
//        String viewName = miembroController.listarMiembros(model);
//
//        verify(model, times(1)).addAttribute("miembros", miembros);
//        assertEquals("miembros", viewName);
//    }

//    @Test
//    void testMostrarFormulario() {
//        String viewName = miembroController.mostrarFormulario(model);
//
//        verify(model, times(1)).addAttribute(eq("miembro"), any(Miembro.class));
//        assertEquals("formulario-miembro", viewName);
//    }

//    @Test
//    void testEliminarMiembro_Exists() {
//        when(miembroService.existeMiembro(1L)).thenReturn(true);
//
//        String viewName = miembroController.eliminarMiembro(1L);
//
//        verify(miembroService, times(1)).eliminarMiembro(1L);
//        assertEquals("redirect:/miembros", viewName);
//    }

//    @Test
//    void testEliminarMiembro_NotExists() {
//        when(miembroService.existeMiembro(1L)).thenReturn(false);
//
//        String viewName = miembroController.eliminarMiembro(1L);
//
//        assertEquals("redirect:/miembros?error=notfound", viewName);
//    }

//    @Test
//    void testMostrarFormularioEdicion_Exists() {
//        Miembro miembro = new Miembro();
//        when(miembroService.obtenerMiembroPorId(1L)).thenReturn(Optional.of(miembro));
//
//        String viewName = miembroController.mostrarFormularioEdicion(1L, model);
//
//        verify(model, times(1)).addAttribute("miembro", miembro);
//        assertEquals("formulario-miembro", viewName);
//    }
//
//    @Test
//    void testMostrarFormularioEdicion_NotExists() {
//        when(miembroService.obtenerMiembroPorId(1L)).thenReturn(Optional.empty());
//
//        String viewName = miembroController.mostrarFormularioEdicion(1L, model);
//
//        assertEquals("redirect:/miembros?error=notfound", viewName);
//    }
//
//    @Test
//    void testEditarMiembro_Exists() {
//        Miembro miembro = new Miembro();
//        when(miembroService.existeMiembro(1L)).thenReturn(true);
//
//        String viewName = miembroController.editarMiembro(1L, miembro, model);
//
//        verify(miembroService, times(1)).actualizarMiembro(1L, miembro);
//        assertEquals("redirect:/miembros", viewName);
//    }
//
//    @Test
//    void testEditarMiembro_NotExists() {
//        Miembro miembro = new Miembro();
//        when(miembroService.existeMiembro(1L)).thenReturn(false);
//
//        String viewName = miembroController.editarMiembro(1L, miembro, model);
//
//        verify(model, times(1)).addAttribute(eq("error"), anyString());
//        assertEquals("formulario-miembro", viewName);
//    }
}
