package com.intercorp.challenge.service;

import com.intercorp.challenge.exception.ClienteNotFoundException;
import com.intercorp.challenge.model.Cliente;
import com.intercorp.challenge.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public Optional<Cliente> obtenerCliente(Long codigoUnico) throws Exception {
        return Optional.ofNullable(clienteRepository.findById(codigoUnico)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente no encontrado!")));
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
