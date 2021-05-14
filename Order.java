package com.myshopping.pojo;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//ORDID ORDERDATE     CUSTID SHIPDATE


	@Entity
	@Table(name="ORD1")
	public class Order {
		
		@Id
		@Column(name="ORDID")
		private int orderId;
		
		@Column(name="ORDERDATE" )
		private Date orderDate;
		
		
		
		@Column(name="SHIPDATE")
		private Date shipDate;
		
		
		
		@ManyToOne
		@JoinColumn(name="CUSTID") //foreign key in EMP table
		private Customer2 cusobj;  //setters and getters for dept
		
		
		@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
		@JoinTable(name="OrderProductLink", 
				joinColumns={@JoinColumn(name="Ord_id")},
				inverseJoinColumns={@JoinColumn(name="Prod_id")})
		private Set<Product> prodlist = new HashSet<Product>();
	
		
		public Order() {
			super();
			System.out.println("Order() Ctor");
		}


		public int getOrderId() {
			return orderId;
		}


		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}


		public Date getOrderDate() {
			return orderDate;
		}


		public void setOrderDate(Date orderDate) {
			this.orderDate = orderDate;
		}


		

		public Date getShipDate() {
			return shipDate;
		}


		public void setShipDate(Date shipDate) {
			this.shipDate = shipDate;
		}


		public Customer2 getCusobj() {
			return cusobj;
		}


		public void setCusobj(Customer2 cusobj) {
			this.cusobj = cusobj;
	
		}


		public Set<Product> getProdlist() {
			return prodlist;
		}


		public void setProdlist(Set<Product> prodlist) {
			this.prodlist = prodlist;
		}
		
		

}

