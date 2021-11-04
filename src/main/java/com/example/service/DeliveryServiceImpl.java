package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Delivery;
import com.example.repository.DeliveryRepository;


@Service
public class DeliveryServiceImpl implements DeliveryService{

	private DeliveryRepository deliveryRepository;

	public DeliveryServiceImpl(DeliveryRepository deliveryRepository) {
		this.deliveryRepository = deliveryRepository;
	}


	@Override
	public List<Delivery> getAllDeliveryDetails() {
		return deliveryRepository.findAll();
	}


	@Override
	public Delivery getDeliveryDetails(Integer deliveryId) {
		return deliveryRepository.getById(deliveryId);
	}


	@Override
	public Delivery saveDelivery(Delivery delivery) {
		return deliveryRepository.save(delivery);
	}


	@Override
	public Delivery updateDelivery(Delivery delivery) {
		Delivery updatedelivery = Delivery.builder().deliveryId(delivery.getDeliveryId()).deliveryDate(delivery.getDeliveryDate()).deliveryStatus(delivery.getDeliveryStatus())
				.deliveryRiderName(delivery.getDeliveryRiderName()).build();
				
		
		return deliveryRepository.save(updatedelivery);
	}


	@Override
	public void deleteDelivery(Integer deliveryId) {
		deliveryRepository.deleteById(deliveryId);
		
	}








}
