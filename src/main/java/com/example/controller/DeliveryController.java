package com.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Delivery;
import com.example.service.DeliveryService;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {


	private DeliveryService deliveryService;

	
	public DeliveryController(DeliveryService deliveryService) {
		this.deliveryService = deliveryService;
	}

	@GetMapping("/ping")
	public ResponseEntity<String> Ping() {

		System.out.println("Coming for Delivery Ping");
		return ResponseEntity.status(HttpStatus.OK).body("OK");
	}

	@GetMapping("/all-deliveries")
	public ResponseEntity<?> getAllDeliveryDetails(){

		List<Delivery> deliveries = deliveryService.getAllDeliveryDetails();
		if(deliveries.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body("No Delivery Details Found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(deliveries);
	}

	@GetMapping("/delivery/{deliveryId}")
	public ResponseEntity<?> getDelivery(@PathVariable("deliveryId") Integer deliveryId){
		try {
			Delivery Delivery =deliveryService.getDeliveryDetails(deliveryId);
			return ResponseEntity.status(HttpStatus.OK).body(Delivery);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.OK).body("No Delivery Detail Found");
		}
	}

	@PostMapping("/delivery")
	public ResponseEntity<List<Delivery>> creatingDelivery(@RequestBody Delivery delivery){
		System.out.println("DeliveryRiderName: "+delivery.getDeliveryRiderName()+ 
				" DeliveryStatus: "+delivery.getDeliveryStatus()+
				" DeliveryDate: "+delivery.getDeliveryDate());
		deliveryService.saveDelivery(delivery);
		List<Delivery> orders = deliveryService.getAllDeliveryDetails();
		return ResponseEntity.status(HttpStatus.OK).body(orders);
	}

	@DeleteMapping("/delivery/{deliveryId}")
	public ResponseEntity<String> deleteDelivery(@PathVariable("deliveryId") Integer deliveryId){
		try {
			deliveryService.deleteDelivery(deliveryId);
			return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.OK).body("No Delivery Detail Found");
		}
	}

	@PutMapping("/delivery")
	public ResponseEntity<?> updateDelivery(@RequestBody Delivery delivery){
		try {
			deliveryService.updateDelivery(delivery);
			Delivery  resultdelivery =  deliveryService.getDeliveryDetails(delivery.getDeliveryId());
			return ResponseEntity.status(HttpStatus.OK).body(resultdelivery);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.OK).body("No Delivery Detail Found");
		}

	}


}
