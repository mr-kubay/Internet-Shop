package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category extends BaseID{
	
	public Category () {}
	
	@Column
	private String type;
	
	public Category(String type) {
		this.type = type;
	}
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Commodity> commodities = new ArrayList<> ();

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Commodity> getCommodities() {
		return commodities;
	}

	public void setCommodities(List<Commodity> commodities) {
		this.commodities = commodities;
	}

	@Override
	public String toString() {
		return "Category [type=" + type + "]";
	}
	
	
	

}
