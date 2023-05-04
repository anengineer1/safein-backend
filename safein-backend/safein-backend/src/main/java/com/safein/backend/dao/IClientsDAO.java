package com.safein.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.qos.logback.core.net.server.Client;


public interface IClientsDAO extends JpaRepository<Client, Integer>{

}
