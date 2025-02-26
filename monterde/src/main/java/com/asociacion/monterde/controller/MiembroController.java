package com.asociacion.monterde.controller;

import com.asociacion.monterde.model.Miembro;
import com.asociacion.monterde.service.MiembroService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Tag(name = "Miembros", description = "Gestión de los miembros de la asociación")
@CrossOrigin(origins = "http://localhost:4200") // Permitir peticiones desde Angular
@RestController
@RequestMapping("/miembros")
public class MiembroController {

    private final MiembroService miembroService;

    public MiembroController(MiembroService miembroService) {
        this.miembroService = miembroService;
    }

    @Operation(summary = "Listar todos los miembros activos")
    @GetMapping
    public ResponseEntity<List<Miembro>> listarMiembros() {
        List<Miembro> miembrosActivos = miembroService.obtenerListaMiembrosActivos();
        return ResponseEntity.ok(miembrosActivos);
    }

    @Operation(summary = "Crear un nuevo miembro")
    @PostMapping
    public void crearMiembro(@RequestBody @Valid Miembro miembro) {
        miembro.setFechaIngreso(LocalDate.now());
       miembroService.crearMiembro(miembro);

    }

    @Operation(summary = "Eliminar (desactivar) un miembro por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarMiembro(@PathVariable Long id) {
        if (miembroService.existeMiembro(id)) {
            miembroService.inactivarMiembro(id);
            return ResponseEntity.ok("Miembro inactivado con éxito.");
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Obtener un miembro por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Miembro> obtenerMiembroPorId(@PathVariable Long id) {
        Optional<Miembro> miembro = miembroService.obtenerMiembroPorId(id);
        return miembro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Actualizar un miembro")
    @PutMapping("/{id}")
    public ResponseEntity<Miembro> editarMiembro(@PathVariable Long id, @RequestBody @Valid Miembro miembroActualizado) {
        if (!miembroService.existeMiembro(id)) {
            return ResponseEntity.notFound().build();
        }
        Miembro miembroEditado = miembroService.actualizarMiembro(id, miembroActualizado);
        return ResponseEntity.ok(miembroEditado);
    }
}
