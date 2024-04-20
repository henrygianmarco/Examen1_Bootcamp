package com.codigo.ibanezsegovia.controller;

import com.codigo.ibanezsegovia.entity.EmpresaEntity;
import com.codigo.ibanezsegovia.service.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/examen/v1/empresa")
@AllArgsConstructor
@Tag(
        name="API DE MANTENIMIENTO EMPRESAS",
        description = "Esta api contiene los end points para el mantenimiento de la entidad empresa"
)
public class EmpresaController {

    private final EmpresaService empresaService;

    @PostMapping("/crear")
    @Operation(summary = "Crear una nueva empresa")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200",description = "Persona creada con éxito",
                        content={@Content(mediaType = "application/json",
                        schema = @Schema(implementation=EmpresaEntity.class))})
    })
    public ResponseEntity<EmpresaEntity> crear(@RequestBody EmpresaEntity empresa) {
        return ResponseEntity.ok().body(empresaService.crear(empresa));
    }

    @Operation(summary = "Busca una empresa por Id")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200",description = "Empresa encontrada con éxito",
                    content={@Content(mediaType = "application/json",
                            schema = @Schema(implementation=EmpresaEntity.class))})
    })

    @GetMapping("/{id}")
    public ResponseEntity<Optional<EmpresaEntity>> buscarporId(@PathVariable Long id) {
        return  ResponseEntity.ok(empresaService.buscarporId(id));
    }

    @Operation(summary = "Busca todas las empresas")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200",description = "Todas las Empresas encontradas con éxito",
                    content={@Content(mediaType = "application/json",
                            schema = @Schema(implementation=EmpresaEntity.class))})
    })
    @GetMapping("/todos")
    public ResponseEntity<List<EmpresaEntity>> buscarTodos() {
        return  ResponseEntity.ok(empresaService.buscarTodos());
    }

    @Operation(summary = "Actualiza una empresa por id")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200",description = "Empresa actualizada con éxito",
                    content={@Content(mediaType = "application/json",
                            schema = @Schema(implementation=EmpresaEntity.class))})
    })
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EmpresaEntity> actualizar(@PathVariable Long id, @RequestBody EmpresaEntity empresaEntity) {
        return ResponseEntity.ok().body(empresaService.actualizar(id,empresaEntity));
    }

    @Operation(summary = "Elimina una empresa por Id")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200",description = "Empresa eliminada con éxito",
                    content={@Content(mediaType = "application/json",
                            schema = @Schema(implementation=EmpresaEntity.class))})
    })
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<EmpresaEntity> eliminar(@PathVariable Long id) {
        return ResponseEntity.ok(empresaService.borrar(id));
    }

}
