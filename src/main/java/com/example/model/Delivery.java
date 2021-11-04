package com.example.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Delivery implements Serializable{
	
	private static final long serialVersionUID = -1370089557407175473L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer deliveryId;
	private String deliveryRiderName;
	private String deliveryStatus;
	private Date deliveryDate;
	
	

}
