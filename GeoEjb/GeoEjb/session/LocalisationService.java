package session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.LocalisationL;
import dao.LocalisationR;
import entity.Localisation;

@Stateless
public class LocalisationService implements LocalisationL, LocalisationR {
	@PersistenceContext
	private EntityManager em;
	
    public LocalisationService() {
        // TODO Auto-generated constructor stub
    }

	public Localisation create(Localisation l) {
		em.persist(l);
		return l;
	}

	public void delete(Localisation l) {
		em.remove(l);
	}

	public Localisation findById(int id) {
		Localisation l = em.find(Localisation.class, id);
		if(l == null)
			throw new RuntimeException("Localisation introuvable");
		return l;
	}

	public List<Localisation> findAll() {
		Query q = em.createQuery("select l from Localisation l");
		return q.getResultList();
	}

	
}
