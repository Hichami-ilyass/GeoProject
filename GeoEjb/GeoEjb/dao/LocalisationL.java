package dao;

import java.util.List;

import javax.ejb.Local;

import entity.Localisation;


@Local
public interface LocalisationL {
	Localisation create(Localisation l);
	void delete(Localisation l);
	Localisation findById(int id);
	List<Localisation> findAll();
}
