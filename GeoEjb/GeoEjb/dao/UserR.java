package dao;

import java.util.List;

import javax.ejb.Remote;

import entity.User;

@Remote
public interface UserR {

	User create(User u);
	void delete(User u);
	User findById(int id);
	List<User> findAll();
	
}
