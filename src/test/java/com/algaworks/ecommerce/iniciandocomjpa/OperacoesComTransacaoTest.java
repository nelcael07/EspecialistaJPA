package com.algaworks.ecommerce.iniciandocomjpa;

import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;
import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Produto;

public class OperacoesComTransacaoTest extends EntityManagerTest{
	
	@Test
	public void inserirObject () {
		Produto produto = new Produto();
		
		produto.setId(4);
		produto.setNome("camera canon");
		produto.setDescricao("A melhor descrição");
		produto.setPreco(new BigDecimal(70));
		
		entityManager.getTransaction().begin();
		entityManager.persist(produto);
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
		Assert.assertNotNull(produtoVerificacao);
	}
		
	@Test
	public void abrirEFecharTransacao() {
		Produto produto = new Produto();
		entityManager.getTransaction().begin();
		
		entityManager.getTransaction().commit();
	}
	
	@Test
	public void removerElemento() {
		//mandando ele buscar o produto 3 para exclui-lo		
		Produto produto = entityManager.find(Produto.class, 3);
		
		entityManager.getTransaction().begin();
		entityManager.remove(produto);
		entityManager.getTransaction().commit();
		
		Produto produtoVerificacao = entityManager.find(Produto.class, 3);
		Assert.assertNull(produtoVerificacao);
	}
	
	@Test
	public void atualizarObjeto() {
		Produto produto = entityManager.find(Produto.class, 1);
		
		produto.setNome("livro teste atualização");
		produto.setPreco(new BigDecimal(3));
		produto.setDescricao("muito bom");
		
		entityManager.getTransaction().begin();
		entityManager.merge(produto);
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		Produto produtoVerificado = entityManager.find(Produto.class, produto.getId() );
		Assert.assertNotNull(produtoVerificado);
		
		
	}
	
	
	
	
	
}
