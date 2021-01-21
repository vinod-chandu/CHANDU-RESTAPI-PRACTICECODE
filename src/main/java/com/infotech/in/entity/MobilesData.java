package com.infotech.in.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name ="Mobiles_Data")
@Data
public class MobilesData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "mobile_Id")
	private Integer mobileId;

	@Column(name = "mobile_Name")
	private String mobileName;

	@Column(name = "mobile_Ram")
	private Integer mobileRam;

	@Column(name = "mobile_Rom")
	private Integer mobileRom;

	@Column(name = "mobile_Cost")
	private Double mobileCost;

	@Column(name = "mobile_Ratings")
	private Double mobileRatings;

}
