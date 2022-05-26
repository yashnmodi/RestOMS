package com.mysquare.restoms.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="order_details",schema="restro")
public class OrderDetails {
	private int billNo;
	private int orderId;
	private double bill;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDateTime billDate;
	public OrderDetails() {
		// TODO Auto-generated constructor stub
	}
	 
	public OrderDetails(int billNo, int orderId, double bill, LocalDateTime billDate) {
		super();
		this.billNo = billNo;
		this.orderId = orderId;
		this.bill = bill;
		this.billDate = billDate;
	}

	public OrderDetails(int orderId, double bill, LocalDateTime billDate) {
		super();
		this.orderId = orderId;
		this.bill = bill;
		this.billDate = billDate;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="bill_no")
	public int getBillNo() {
		return billNo;
	}
	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}
	@Column(name="order_id")
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	@Column(columnDefinition="number(7,1)")
	public double getBill() {
		return bill;
	}
	public void setBill(double bill) {
		this.bill = bill;
	}
	@Column(name="bill_date")
	public LocalDateTime getBillDate() {
		return billDate;
	}
	public void setBillDate(LocalDateTime billDate) {
		this.billDate = billDate;
	}

	@Override
	public String toString() {
		return "OrderDetails [billNo=" + billNo + ", orderId=" + orderId + ", bill=" + bill + ", billDate=" + billDate
				+ "]";
	}
	

}
