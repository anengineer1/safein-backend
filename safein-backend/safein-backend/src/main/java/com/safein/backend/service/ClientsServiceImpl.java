package com.safein.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.safein.backend.dao.IClientsDAO;

import ch.qos.logback.core.net.server.Client;

public class ClientsServiceImpl implements IClientsService{

	
	@Autowired
	IClientsDAO iClientsDAO;
	
	@Override
	public List<Client> listarClient() {
		// TODO Auto-generated method stub
		return iClientsDAO.findAll();
	}

	@Override
	public Client guardarClient(Client clients) {
		// TODO Auto-generated method stub
		return iClientsDAO.save(null);
	}

	@Override
	public Client clientsById(int id) {
		// TODO Auto-generated method stub
		return iClientsDAO.findById(id).get();
	}

	@Override
	public Client actualizarClient(Client clientes) {
		// TODO Auto-generated method stub
		return iClientsDAO.save(clientes);
	}

	@Override
	public void eliminarClient(int id) {
		// TODO Auto-generated method stub
		iClientsDAO.deleteById(id);
	}

}
