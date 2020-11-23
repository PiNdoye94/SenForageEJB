package sn.senforage.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import sn.senforage.entities.Village;

@Stateless
public class VillageDao implements IVillageLocal, IVillageRemote{
	
	@PersistenceContext(unitName="Sen-ForageEJB_UP")
	private EntityManager em;

	@Transactional
	@Override
	public Village save(Village v) {
	    em.persist(v);
	    return v;
	}
	
	@Override
	public List<Village> findAll() {
		Query listvil = em.createQuery("SELECT v FROM Village v");
		return listvil.getResultList();
	}

	@Override
	public Village getVillageById(int id) {
		//return (Village) em.createQuery("SELECT v FROM Village v WHERE v.idV=:id").setParameter("id", id).getSingleResult();
		return em.find(Village.class, id);
	}

	@Override
	public void delete(Integer id) {
		Village supvil = em.find(Village.class, id);
		em.remove(supvil);
		
	}

}
