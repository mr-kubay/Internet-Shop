package entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "commodity")
public class Commodity extends BaseID{

	public Commodity () {}
	
	@Column
	private String name;
	
	@Column(columnDefinition = "DECIMAL(5,2)")
	private BigDecimal price;
	
	@Column
	private int amount;
	
	public Commodity(String name, BigDecimal price, int amount) {
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})//, fetch = FetchType.LAZY)
	@JoinColumn(name = "firm_id", nullable = true, foreignKey = @ForeignKey(name = "FK_firm_commodity"))
	private Firm firm;
	
	@OneToOne(cascade = CascadeType.ALL)//, fetch = FetchType.LAZY)///якщо забрати fetch то не працює, чому ? 
	@JoinColumn(name = "commodity_details_id", foreignKey = @ForeignKey(name = "FK_comm_to_details"), nullable = true)
	private C_Details details;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})//,  fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "FK_category_commodities"))
	private Category category;
	
	@ManyToOne( cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH} ,fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", foreignKey = @ForeignKey(name = "FK_order_commodities"))
	private Order order;
	

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Commodity (String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Firm getFirm() {
		return firm;
	}

	public void setFirm(Firm firm) {
		this.firm = firm;
	}

	public C_Details getDetails() {
		return details;
	}

	public void setDetails(C_Details details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Commodity [name=" + name + ", price=" + price + ", amount=" + amount + "]";
	}
	
	
}
