package session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.PhoneL;
import dao.PhoneR;
import dao.UserL;
import entity.Phone;
import entity.User;

/**
 * Session Bean implementation class PhoneService
 */
@Stateless
public class PhoneService implements PhoneL, PhoneR {

	@PersistenceContext
	private EntityManager em;
	@EJB
	private UserL us;
	
    public PhoneService() {
        // TODO Auto-generated constructor stub
    }

	public Phone create(Phone p,int user) {
		User u = us.findById(user);
		p.setUser(u);
		em.persist(p);
		return p;
	}

	public void delete(Phone p) {
		em.remove(p);
	}

	public Phone findById(int id) {
		Phone p = em.find(Phone.class, id);
		if(p == null)
			throw new RuntimeException("Phone introuvable");
		return p;
	}
	public Phone findByImei(String imei) {
		Query q = em.createQuery("select p from Phone p where p.imei=:imei");
		q.setParameter("imei", imei);
		return (Phone)q.getSingleResult();
	}
	public List<Phone> findAll() {
		Query q = em.createQuery("select p from Phone p");
		return q.getResultList();
	}
	
	public List<Phone> getPhonesByUser(int uid) {
		Query q = em.createQuery("select p from Phone p where p.user.id=:id");
		q.setParameter("id", uid);
		return q.getResultList();
	}
	
	

}
