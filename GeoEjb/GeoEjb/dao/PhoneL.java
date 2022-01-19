package dao;

import java.util.List;

import javax.ejb.Local;

import entity.Phone;
import entity.User;

@Local
public interface PhoneL {

	Phone create(Phone p,int u);
	void delete(Phone p);
	Phone findByImei(String imei);
	Phone findById(int id);
	List<Phone> findAll();
	List<Phone> getPhonesByUser(int uid);
	
}
