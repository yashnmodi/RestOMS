package com.mysquare.restoms.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="Customer_Details",schema="restro")
public class CustomerDetails {
    private int orderId;
    private String tableNo;
    private String item;
    private double price;
    private int Quantity;
    private int paid;
    private int orderSubmit;
    private int orderFlag;

    public CustomerDetails() {
        // TODO Auto-generated constructor stub
    }

    public CustomerDetails(String item,double price)
    {
        this.item=item;
        this.price=price;
    }
    public CustomerDetails(int orderId, String tableNo, String item, double price, int quantity, int paid,
                           int orderSubmit,int orderFlag) {
        super();
        this.orderId = orderId;
        this.tableNo = tableNo;
        this.item = item;
        this.price = price;
        Quantity = quantity;
        this.paid = paid;
        this.orderSubmit = orderSubmit;
        this.orderFlag=orderFlag;
    }


    public CustomerDetails(String tableNo, String item, double price, int quantity, int paid, int orderSubmit,int orderFlag) {
        super();
        this.tableNo = tableNo;
        this.item = item;
        this.price = price;
        Quantity = quantity;
        this.paid = paid;
        this.orderSubmit = orderSubmit;
        this.orderFlag=orderFlag;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="order_id")
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Column(name="table_id",length=10)
    public String getTableNo() {
        return tableNo;
    }
    public void setTableNo(String tableNo) {
        this.tableNo = tableNo;
    }


    @Column(name="Item",length=20)
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }

    @Column(name="Price",columnDefinition="number(7,1)")
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Column(length=10)
    public int getQuantity() {
        return Quantity;
    }
    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    @Column(name="Paid")
    public int getPaid() {
        return paid;
    }
    public void setPaid(int paid) {
        this.paid = paid;
    }
    @Column(name="Order_Submit")
    public int getOrderSubmit() {
        return orderSubmit;
    }
    public void setOrderSubmit(int orderSubmit) {
        this.orderSubmit = orderSubmit;
    }
    @Column(name="Order_Flag")
    public int getOrderFlag() {
        return orderFlag;
    }

    public void setOrderFlag(int orderFlag) {
        this.orderFlag = orderFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDetails that = (CustomerDetails) o;
        return orderId == that.orderId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }
}
