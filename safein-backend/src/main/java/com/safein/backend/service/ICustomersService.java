package com.safein.backend.service;

import java.util.List;

import com.safein.backend.dto.Customers;



public interface ICustomersService {





	Customers costumersById(int id);


	Customers guardarCostumer(Customers clients);




	Customers actualizarCostumer(Customers clientes);

	List<Customers> listCostumers();
}
