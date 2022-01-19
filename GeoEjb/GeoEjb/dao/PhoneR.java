package dao;

import java.util.List;

import javax.ejb.Remote;

import entity.Phone;
import entity.User;

@Remote
public interface PhoneR {

	Phone create(Phone p,int u);
	void delete(Phone p);
	Phone findById(int id);
	List<Phone> findAll();
	List<Phone> getPhonesByUser(int uid);
	
}
