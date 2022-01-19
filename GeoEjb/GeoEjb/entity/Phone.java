package entity;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;



/**
 * Entity implementation class for Entity: Phone
 *
 */
@Entity
public class Phone implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String imei;
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Localisation> localisations;
	private static final long serialVersionUID = 1L;

	public Phone() {
		super();
	} 
	
	public Phone(String imei) {
		super();
		this.imei = imei;
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", imei=" + imei + ", user=" + user + "]";
	}
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getImei() {
		return this.imei;
	}
	

	public List<Localisation> getLocalisations() {
		return localisations;
	}
	public void setLocalisations(List<Localisation> localisations) {
		this.localisations = localisations;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}   
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
   
}
