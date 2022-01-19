package dao;

import java.util.List;

import javax.ejb.Remote;

import entity.Localisation;
@Remote
public interface LocalisationR {
	Localisation create(Localisation l);
	void delete(Localisation l);
	Localisation findById(int id);
	List<Localisation> findAll();
}
