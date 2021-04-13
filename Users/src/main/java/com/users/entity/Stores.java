package com.users.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
	@NamedQuery(
			name="GetStoresCity",
			query="SELECT e FROM Stores e WHERE e.city = :ucity"
			),
	@NamedQuery(
			name="getAllStores",
			query = "SELECT e FROM Stores e")
})

public class Stores {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Integer store_id;
	
	private String name;
	private String city;
	private String state;
	public Stores() {
		super();
	}
	public Stores(Integer store_id, String name, String city, String state) {
		super();
		this.store_id = store_id;
		this.name = name;
		this.city = city;
		this.state = state;
	}
	public Integer getStore_id() {
		return store_id;
	}
	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Stores) {
			Stores other = (Stores) obj;
			boolean sameName = (this.name.equals(other.getName()));

			boolean sameState = (this.state.equals (other.getState()));
			
			boolean sameId = (this.store_id.equals(other.getStore_id()));
			
			boolean sameCity = (this.city.equals(other.getCity()));
			
			if( sameName &&  sameState && sameId && sameCity) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(store_id, name, city, state);
	}
	

}
