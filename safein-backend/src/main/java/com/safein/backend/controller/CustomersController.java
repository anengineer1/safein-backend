package com.safein.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safein.backend.dto.Customers;
import com.safein.backend.service.CustomersServiceImpl;
@RestController
public class CustomersController {

	@Autowired
	CustomersServiceImpl customersServiceImpl;

	@GetMapping("/customers")
	public List<Customers> listarCustomers() {
		return customersServiceImpl.listCustomers();
	}

	@GetMapping("/customers/{id}")
	public Customers listCustomersXID(@PathVariable(name = "id") Long id) {
		return customersServiceImpl.customersById(id);
	}

	@GetMapping("/customers/doc/{doc_identificator}/{num_identificator}")
	public Customers listDocNumberCustomers(@PathVariable(name = "num_identificator") String num, @PathVariable(name = "doc_identificator") String doctype) {
		return customersServiceImpl.listByNumAndDoctype(num, doctype);
	}

	@GetMapping("/customers/media/{media}")
	public List<Customers> listCustomersByMedia(@PathVariable(name = "media") String media) {
		return customersServiceImpl.listCustomersByMedia(media);
	}

	@GetMapping("/customers/email/{mail}")
	public List<Customers> listCustomersByEmail(@PathVariable(name = "mail") String mail) {
		return customersServiceImpl.listCustomersByEmail(mail);
	}

	@PostMapping("/customers")
	public Customers createCustomers(@RequestBody Customers customers) {
		return customersServiceImpl.saveCustomer(customers);
	}

	@PutMapping("/customers/{id}")
	public Customers actualizarCustomers(@PathVariable(name = "id") Long id, @RequestBody Customers customers) {

		Customers customers_selected = customersServiceImpl.customersById(id);

		customers_selected.setDocIdentifier(customers.getDocIdentifier());
		customers_selected.setEmail(customers.getEmail());
		customers_selected.setName(customers.getName());
		customers_selected.setPhonenumber(customers.getPhonenumber());
		customers_selected.setNumIdentifier(customers.getNumIdentifier());
		customers_selected.setPressMedia(customers.getPressMedia());
		customers_selected.setCountry(customers.getCountry());

		return customersServiceImpl.updateCustomer(customers_selected);
	}

	@DeleteMapping("/customers/{id}")
	public void deleteCustomer(@PathVariable(name = "id") Long id) {
		customersServiceImpl.deleteCustomerById(id);
	}
}
