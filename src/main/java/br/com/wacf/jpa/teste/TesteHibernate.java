package br.com.wacf.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.wacf.jpa.model.Conta;

public class TesteHibernate {

	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setAgencia("4618");
		conta.setBanco("Santander");
		conta.setNumero("01070872-6");
		conta.setTitular("WALTER ARAGAO");

		/*
		 * Criar uma gerencia de Entidade
		 */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");

		/*
		 * Cria a Entidade junto a EntityManagerFactory
		 */
		EntityManager em = emf.createEntityManager();

		/*
		 * Inicia a transação
		 */
		em.getTransaction().begin();
		/*
		 * persiste
		 */
		em.persist(conta);
		/*
		 * Commita a tarnsação
		 */
		em.getTransaction().commit();

		/*
		 * Encerra as transações
		 */
		em.close();
		emf.close();

	}

}
