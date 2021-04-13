package com.store.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
@NamedQuery(name="Orders.findAll", query="SELECT e FROM Orders e")
public class Orders {
	@Id
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	private Double totRev;
	private Double tax;
	
	@OneToMany(targetEntity= Item.class)
	private List<Item> items;

	public Orders() {
		super();
	}
	
	public Orders(Integer id, Date date, Double totRev, Double tax, List<Item> items) {
		this.id = id;
		this.date = date;
		this.totRev = totRev;
		this.tax = tax;
		this.items =items;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTotRev() {
		return totRev;
	}

	public void setTotRev(Double totRev) {
		this.totRev = totRev;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
