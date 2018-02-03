package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "firm")
public class Firm extends BaseID{
	
	public Firm () {}
	
	@Column(unique = true)
	private String name;
	
	@Column
	private String country;
	
	@Column
	private String city;
	
	@OneToMany(mappedBy = "firm",cascade = CascadeType.ALL)
	private List<Commodity> commodities = new ArrayList<>();
	
	public Firm (String name, String country, String city) {
		this.name = name;
		this.country = country;
		this.city = city;
	}
	
	

	public List<Commodity> getCommodities() {
		return commodities;
	}



	public void setCommodities(List<Commodity> commodities) {
		this.commodities = commodities;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}



	@Override
	public String toString() {
		return "Firm [name=" + name + ", country=" + country + ", city=" + city + "]";
	}
	
	
	
}
