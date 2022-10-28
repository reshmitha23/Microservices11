package com.medicine.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cId;
	//@OneToOne(cascade=CascadeType.ALL)
	//@JoinColumn(name="medicineId",referencedColumnName="cId")
	private Integer medicineId;
	private String medicineName;
	private int price;
	
	public Cart() {
		
	}

	public Cart(int cId, int medicineId, String medicineName, int price) {
		super();
		this.cId = cId;
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.price = price;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Cart [cId=" + cId + ", medicineId=" + medicineId + ", medicineName=" + medicineName + ", price=" + price
				+ "]";
	}
	
}
