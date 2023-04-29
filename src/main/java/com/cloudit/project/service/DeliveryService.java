package com.cloudit.project.service;

import com.cloudit.project.model.Delivery;
import com.cloudit.project.model.Order;
import com.cloudit.project.model.User;

import java.util.List;

public interface DeliveryService {
    Delivery addDelivery(Order order);
    List<Delivery> getAllDeliveries();
    Delivery terminateDelivery(Long deliveryId);
    Delivery cancelDelivery(Long deliveryId);

    List<Delivery> getMyDeliveries();

}
