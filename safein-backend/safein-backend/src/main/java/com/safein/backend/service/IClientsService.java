package com.safein.backend.service;

import java.util.List;

import ch.qos.logback.core.net.server.Client;


public interface IClientsService {
	public List<Client> listarClient();

	public Client guardarClient(Client hotels);

	public Client clientsById(int id);

	public Client actualizarClient(Client hotels);

	public void eliminarClient(int id);
}
