package com.algaworks.ecommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.algaworks.ecommerce.model.Produto;

public class EntityManagerTest {
	
	protected static EntityManagerFactory entityManagerFactory;
	
	protected EntityManager entityManager;
	
	//METODOS DE CALLBACK	
	
	//anotação do metodo de callback do junit.	
	@BeforeClass
	public static void setUpBeforeClass() {
		entityManagerFactory = Persistence.createEntityManagerFactory("Ecommerce-PU");
	}
	
	//quando a class acabar a execução 	
	@AfterClass
	public static void tearDownAfterClass() {
		entityManagerFactory.close();
	}
	
	//vai ser executado antes de cada um dos test.	
	@Before
	public void setUp() {
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	//Vai ser executado depois de cada um dos test	
	@After
	public void tearDown() {
		entityManager.close();
	}
	
}
