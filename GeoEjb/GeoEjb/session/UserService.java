package session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.UserR;
import entity.Phone;
import entity.User;
import dao.UserL;

/**
 * Session Bean implementation class User
 */
@Stateless
public class UserService implements UserR, UserL {


	@PersistenceContext
	private EntityManager em;
	
    public UserService() {
        // TODO Auto-generated constructor stub
    }

	public User create(User u) {
		em.persist(u);
		return u;
	}

	public void delete(User u) {
		em.remove(u);
		
	}

	public User findById(int id) {
		User u = em.find(User.class, id);
		if(u == null)
			throw new RuntimeException("User Not Exist");
		return u;
	}

	public List<User> findAll() {
		Query q = em.createQuery("select u from User u");
		return q.getResultList();
	}
	 


}
