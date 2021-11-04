package com.example.service;

import java.util.List;

import com.example.model.Delivery;

public interface DeliveryService {
	
	
	public List<Delivery> getAllDeliveryDetails();
	public Delivery getDeliveryDetails(Integer deliveryId);
	public Delivery saveDelivery(Delivery Delivery);
	public Delivery updateDelivery(Delivery delivery);
	public void deleteDelivery(Integer deliveryId);
	
	

}
