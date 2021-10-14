package com.algaworks.ecommerce.iniciandocomjpa;

import org.junit.Assert;
import org.junit.Test;
import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Produto;

public class ConsultandoRegistrosTest extends EntityManagerTest {
	
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
