package com.safein.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.safein.backend.dto.Customers;
import com.safein.backend.service.CustomersServiceImpl;


public class CustomersController {

	
	@Autowired
	CustomersServiceImpl clientsServiceImpl;

@GetMapping("/costumers")
public List<Customers> listarCostumers() {
	return clientsServiceImpl.listCostumers();
}


@GetMapping("/costumers/{id}")
public Customers listCostumersXID(@PathVariable(name = "id") int  id) {
	return clientsServiceImpl.listCostumersById(id);
}

@GetMapping("/costumers/doc/{doctype}/{num}")
public Customers listDocNumberCostumers(@PathVariable(name = "num") int  num, @PathVariable (name = "doctype") String doctype) {
	return clientsServiceImpl.listByNumAndDoctype(num,doctype);
}


@GetMapping("/costumers/media/{media}")
public List<Customers> listCostumersByMedia(@PathVariable(name = "media") String  media) {
	return clientsServiceImpl.listCostumersByMedia(media);
}

@GetMapping("/costumers/email/{mail}")
public List<Customers> listCostumersByEmail(@PathVariable(name = "mail") String  mail) {
	return clientsServiceImpl.listCostumersByEmail(mail);
}


@PostMapping("/costumers")
public Customers createCostumers(@RequestBody Customers client) {
	return clientsServiceImpl.createCostumers(client);
}


@PutMapping("/costumers/{id}")
public Customers actualizarCostumers(@PathVariable(name = "id") int id, @RequestBody Customers client) {

	Customers costumers_actualizado = new Customers();

	Customers costumers_seleccionado = clientsServiceImpl.clientsById(id);

	costumers_seleccionado.setDoc_identifier(client.getDoc_identifier());
	costumers_seleccionado.setEmail(client.getEmail());
	costumers_seleccionado.setName(client.getName());
	costumers_seleccionado.setPhonenumber(client.getPhonenumber());
	costumers_seleccionado.setNum_identifier(client.getNum_identifier());
	costumers_seleccionado.setPress_media(client.getPress_media());

	costumers_seleccionado = clientsServiceImpl.actualizarCostumer(costumers_seleccionado);

	System.out.println("El empleado actualizado es: " + costumers_actualizado);

	return costumers_actualizado;
}

@DeleteMapping("/costumers/{id}")
public String eliminarCostumer(@PathVariable(name="id")Long id) {
	clientsServiceImpl.deleteCostumerById(id);
	return "User deleted.";
}
}
