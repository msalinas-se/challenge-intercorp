package com.intercorp.challenge.controller;

import com.intercorp.challenge.model.Cliente;
import com.intercorp.challenge.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @Operation(summary = "Obtener cliente por su codigo unico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado de manera exitosa",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Cliente.class)) })
    })
    @GetMapping("/{codigoUnico}")
    public ResponseEntity<Cliente> obtenerCliente(@PathVariable("codigoUnico") Long codigoUnico) throws Exception{
        return clienteService.obtenerCliente(codigoUnico).map(ResponseEntity :: ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Guardar datos de nuevo cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente creado de manera exitosa",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Cliente.class)) })
    })
    @PostMapping
    public ResponseEntity<Cliente> guardarCliente(@RequestBody @Valid Cliente cliente) {
        return new ResponseEntity<>(clienteService.guardarCliente(cliente), HttpStatus.CREATED);
    }
}
