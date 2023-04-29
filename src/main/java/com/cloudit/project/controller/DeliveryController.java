package com.cloudit.project.controller;

import com.cloudit.project.model.Delivery;
import com.cloudit.project.model.Order;
import com.cloudit.project.model.User;
import com.cloudit.project.repository.UserRepository;
import com.cloudit.project.serviceImpl.DeliveryServiceImplementation;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/delivery")
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeliveryController {
    final DeliveryServiceImplementation deliveryService;
    final UserRepository userRepository;

    @GetMapping
    public String addDelivery(){
        User user=userRepository.findByUsername("Mohamedali");
        Order order= Order.builder()
                .orderId("1")
                .user(user)
                .build();
        deliveryService.addDelivery(order);
        return "s";
    }
    @GetMapping(value="/mine", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Delivery> getMyDeliveries(){
        return deliveryService.getMyDeliveries();
    }
    @PostMapping(value = "/terminate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Delivery terminateDelivery(@RequestBody Map<String,Long> payload){
        return deliveryService.terminateDelivery(payload.get("deliveryId"));
    }
    @PostMapping("/cancel")
    public Delivery cancelDelivery(@RequestBody Map<String,Long> payload){
        return deliveryService.cancelDelivery(payload.get("deliveryId"));
    }
}
