package sn.senforage.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sn.senforage.entities.Client;

@Stateless
public class ClientDao implements IClientLocal, IClientRemote{
	
	@PersistenceContext(unitName="Sen-ForageEJB_UP")
	private EntityManager em;

	@Override
	public Client save(Client c) {
		em.persist(c);
		return c;
	}

	@Override
	public List<Client> findAll() {
		Query listcl = em.createQuery("SELECT c FROM Client c");
		return listcl.getResultList();
	}

	@Override
	public Client getClientById(int id) {
		//return (Client) em.createQuery("SELECT c FROM Client c WHERE c.id=:id").setParameter("id", id).getSingleResult();
		return em.find(Client.class, id);
	}

	@Override
	public Client update(Client c) {
		em.merge(c);
        return c;
	}

	@Override
	public void delete(Integer id) {
		Client supcl = em.find(Client.class, id);
		em.remove(supcl);
		
	}

}
