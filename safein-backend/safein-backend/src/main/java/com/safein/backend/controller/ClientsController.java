package com.safein.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.safein.backend.service.ClientsServiceImpl;

import ch.qos.logback.core.net.server.Client;

public class ClientsController {

	
	@Autowired
	ClientsServiceImpl clientsServiceImpl;

@GetMapping("/clients")
public List<Client> listarClients() {
	return clientsServiceImpl.listarClient();
}

@GetMapping("/clients/{id}")
public List<Client> listClients(@PathVariable(name = "id") int  id) {
	return clientsServiceImpl.listClients(id);
}

@GetMapping("/clients/doc/{doctype}/{num}")
public List<Client> listDocNumberCLients(@PathVariable(name = "num") int  num) {
	return clientsServiceImpl.listDocNumberCLients(num);
}


@GetMapping("/clients/media/{media}")
public List<Client> listDocNumberCLients(@PathVariable(name = "media") String  media) {
	return clientsServiceImpl.listDocNumberCLients(media);
}

@GetMapping("/clients/email/{mail}")
public List<Client> listClientsByEmail(@PathVariable(name = "mail") String  mail) {
	return clientsServiceImpl.listClientsByEmail(mail);
}


@PostMapping("/clients")
public Client createClients(@RequestBody Client client) {
	return clientsServiceImpl.createClients(client);
}


@PutMapping("/hotels/{id}")
public Client actualizarClient(@PathVariable(name = "id") int id, @RequestBody Client client) {

	Client clients_seleccionado = new Client();
	Client clients_actualizado = new Client();

	clients_seleccionado = clientsServiceImpl.clientsById(id);

	clients_seleccionado.setNombre(client.getNombre());
	clients_seleccionado.setTrabajo(client.getTrabajo());
	clients_seleccionado.setSalario(client.getSalario());

	clients_seleccionado = clientsServiceImpl.actualizarClientes(clients_seleccionado);

	System.out.println("El empleado actualizado es: " + clients_actualizado);

	return clients_actualizado;
}

@DeleteMapping("/clients/{id}")
public String eliminarClients(@PathVariable(name="id")long id) {
	clientsServiceImpl.deleteById(id);
	return "User deleted.";
}
}
