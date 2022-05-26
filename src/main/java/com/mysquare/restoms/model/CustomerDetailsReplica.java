package com.mysquare.restoms.model;

import javax.persistence.*;

@Entity
@Table(name="customer_details_replica",schema="restro")

public class CustomerDetailsReplica {

    private int orderId;
    private String tableNo;
    private String item;
    private double price;
    private int Quantity;
    private boolean paid;
    private boolean orderSubmit;
    private int orderFlag;
    private double bill;
    private String billDate;


    public CustomerDetailsReplica() {
        // TODO Auto-generated constructor stub
    }



    public CustomerDetailsReplica(String tableNo, String item, double price, int quantity, boolean paid,
                                  boolean orderSubmit, int orderFlag,double bill,String BillDate) {
        super();
        this.tableNo = tableNo;
        this.item = item;
        this.price = price;
        Quantity = quantity;
        this.paid = paid;
        this.orderSubmit = orderSubmit;
        this.orderFlag=orderFlag;
        this.bill=bill;
        this.billDate=BillDate;
    }



    public CustomerDetailsReplica(int orderId, String tableNo, String item, double price, int quantity, boolean paid,
                                  boolean orderSubmit, int OrderFlag,double bill,String BillDate) {
        super();
        this.orderId = orderId;
        this.tableNo = tableNo;
        this.item = item;
        this.price = price;
        Quantity = quantity;
        this.paid = paid;
        this.orderSubmit = orderSubmit;
        this.orderFlag = OrderFlag;
        this.bill=bill;
        this.billDate=BillDate;
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
    public boolean isPaid() {
        return paid;
    }
    public void setPaid(boolean paid) {
        this.paid = paid;
    }
    @Column(name="Order_Submit")
    public boolean isOrderSubmit() {
        return orderSubmit;
    }
    public void setOrderSubmit(boolean orderSubmit) {
        this.orderSubmit = orderSubmit;
    }
    @Column(name="order_flag")
    public int getOrderFlag() {
        return orderFlag;
    }

    @Column(name="Bill")
    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    @Column(name = "bill_date")
    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public void setOrderFlag(int orderFlag) {
        this.orderFlag = orderFlag;
    }

    @Override
    public String toString() {
        return "CustomerDetailsReplica [orderId=" + orderId + ", tableNo=" + tableNo + ", item=" + item + ", price="
                + price + ", Quantity=" + Quantity + ", paid=" + paid + ", orderSubmit=" + orderSubmit
                + "]";
    }
}
