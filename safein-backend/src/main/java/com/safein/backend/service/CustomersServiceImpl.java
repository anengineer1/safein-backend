package com.safein.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.safein.backend.dao.ICustomersDAO;
import com.safein.backend.dto.Customers;

public class CustomersServiceImpl implements ICustomersService {

	@Autowired
	ICustomersDAO iCostumersDAO;

	@Override
	public List<Customers> listCostumers() {
		// TODO Auto-generated method stub
		return iCostumersDAO.findAll();
	}

	@Override
	public Customers guardarCostumer(Customers clients) {
		// TODO Auto-generated method stub
		return iCostumersDAO.save(clients);
	}

	@Override
	public Customers actualizarCostumer(Customers clientes) {
		// TODO Auto-generated method stub
		return iCostumersDAO.save(clientes);
	}

	public void deleteCostumerById(Long id) {
		// TODO Auto-generated method stub
		iCostumersDAO.deleteById(id);
	}

	public List<Customers> listCostumersByDocNum(int num) {
		// TODO Auto-generated method stub
		return iCostumersDAO.findCostumersByNum(num);
	}

	@Override
	public Customers costumersById(int id) {
		// TODO Auto-generated method stub
		return iCostumersDAO.findById(id).get();
	}

	public Customers createCostumers(Customers client) {
		// TODO Auto-generated method stub
		return iCostumersDAO.save(client);
	}

	public Customers listCostumersById(int id) {
		// TODO Auto-generated method stub
		return iCostumersDAO.findById(id).get();
	}


	public List<Customers> listCostumersByEmail(String mail) {
		// TODO Auto-generated method stub
		return iCostumersDAO.findByEmail(mail);
	}

	public Customers clientsById(int id) {
		// TODO Auto-generated method stub
		return iCostumersDAO.findById(id).get();
	}

	public List<Customers> listCostumersByMedia(String media) {
		// TODO Auto-generated method stub
		return iCostumersDAO.findCostumersByMedia(media);
	}
	
	public Customers listByNumAndDoctype(int num, String doctype) {
		
		return iCostumersDAO.findByNumAndDoctype(num, doctype);
	}
	




}
