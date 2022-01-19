package dao;

import java.util.List;

import javax.ejb.Local;

import entity.User;

@Local
public interface UserL {
	
	User create(User u);
	void delete(User u);
	User findById(int id);
	List<User> findAll();
	
}
