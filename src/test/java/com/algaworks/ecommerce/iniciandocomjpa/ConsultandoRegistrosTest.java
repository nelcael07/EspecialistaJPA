package com.algaworks.ecommerce.iniciandocomjpa;

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

public class ConsultandoRegistrosTest {
	
	private static EntityManagerFactory entityManagerFactory;
	
	private EntityManager entityManager;
	
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
	
	
	//COMEÇO DOS TESTS.
	
	@Test
	public void buscarPorIdentificador() {
		Produto produto = entityManager.find(Produto.class, 1);
		
		//get reference vai fazer uma busca no banco só se for utilizado algum atributo de Produto, como por exemplo produto.getNome().		
//		Produto produto = entityManager.getReference(Produto.class, 1);

		//o retorno não pode ser null		
		Assert.assertNotNull(produto);
		
		//o retorno de produto.nome tem que ser Kindle		
		Assert.assertEquals("Kindle", produto.getNome()); 
	}
	
	@Test
	public void atualizarReferencia () {
		Produto produto = entityManager.find(Produto.class, 1);
		produto.setNome("Microfone");
		
		//depois de alterar o produto, eu do um refresh para ele pegar novamente o estado do banco de dados.		
		entityManager.refresh(produto);
		
		Assert.assertEquals("Kindle", produto.getNome());
	}
	
	
	
}
