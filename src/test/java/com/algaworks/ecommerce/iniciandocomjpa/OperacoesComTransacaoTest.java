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
		
		produto.setId(2);
		produto.setNome("camera canon");
		produto.setDescricao("A melhor descri��o");
		produto.setPreco(new BigDecimal(70));
		
		entityManager.getTransaction().begin();
		//n�o necessariamente precisa estar dentro do begin e commit, pq quando chegar na linha do persist 
		//ele vai identificar que precisa de uma transas�o e vai esperar ela ser aberta para execultar tal linha
		//mas � aconselhavel que seja colocado no meio da transa��o para seguir um padr�o.		
		entityManager.persist(produto);
		//flush for�a o entitymanager jogar todos os dados da memoria para o banco de dados (Mesmo assim � necessario uma transa��o). Dentro do commit � implementado o flush.		
//		entityManager.flush();		
		
		entityManager.getTransaction().commit();
		
		//limpando memoria do entityManager;		
		entityManager.clear();
		
		Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
		Assert.assertNotNull(produtoVerificacao);
	}
		
	@Test
	public void abrirEFecharTransacao() {
		Produto produto = new Produto();
		entityManager.getTransaction().begin();
		
//		entityManager.persist(produto);
//		entityManager.merge(produto);
//		entityManager.remove(produto);
		
		entityManager.getTransaction().commit();
	}
	
}
