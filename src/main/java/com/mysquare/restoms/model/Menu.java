package com.mysquare.restoms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Menu_Details",schema="restro")
public class Menu {
	private int menuId;
	private String item;
	private double price;
	private String imgPath;
	private String category;
	private String specification;

	//default constructor
	public Menu() {
		super();
	}

	//cstr without ID
	public Menu(String item, double price, String imgPath, String category, String specification) {
		super();
		this.item = item;
		this.price = price;
		this.imgPath = imgPath;
		this.category = category;
		this.specification = specification;
	}

	public Menu(String item,double price,String category,String specification)
	{
		this.item=item;
		this.price=price;
		this.category=category;
		this.specification=specification;
	}

	//cstr with ID
	public Menu(int menuId, String item, double price, String imgPath, String category, String specification) {
		super();
		this.menuId = menuId;
		this.item = item;
		this.price = price;
		this.imgPath = imgPath;
		this.category = category;
		this.specification = specification;
	}

	//menuId Getter
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Menu_Id")
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	//Item Getter
	@Column(length=30)
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}

	//price Getter
	@Column(columnDefinition="number(7,2)")
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	//imgpath Getter
	@Column(name="Img_Path")
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	//category Getter
	@Column(length=30)
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	//specification Getter
	@Column(length=30)
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}

	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", item=" + item + ", price=" + price + ", imgPath=" + imgPath + ", category="
				+ category + ", specification=" + specification + "]";
	}
}
