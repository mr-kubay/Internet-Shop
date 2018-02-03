package entity;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

@Entity
@Table(name = "commodity_details")
public class C_Details extends BaseID{
	
	public C_Details () {}
	
	@Column
	private String material;
	
	@Enumerated(EnumType.STRING)
	private Size size;
	
	@Column
	private String color;
	
	public C_Details (String material, Size size, String color) {
		this.material = material;
		this.size = size;
		this.color = color;
	}
	
	@OneToOne(mappedBy = "details")
	private Commodity commodity;

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	@Override
	public String toString() {
		return "C_Details [material=" + material + ", size=" + size + ", color=" + color + "]";
	}
	
	

}
