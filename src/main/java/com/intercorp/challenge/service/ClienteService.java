package com.intercorp.challenge.service;

import com.intercorp.challenge.model.Cliente;

import java.util.Optional;

public interface ClienteService {
    Optional<Cliente> obtenerCliente(Long codigoUnico) throws Exception;
    Cliente guardarCliente(Cliente cliente);
}
