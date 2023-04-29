package com.cloudit.project.serviceImpl;

import com.cloudit.project.controller.WebSocketController;
import com.cloudit.project.model.Delivery;
import com.cloudit.project.model.Order;
import com.cloudit.project.model.User;
import com.cloudit.project.repository.DeliveryRepository;
import com.cloudit.project.repository.UserRepository;
import com.cloudit.project.service.DeliveryService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImplementation implements DeliveryService {
    final DeliveryRepository deliveryRepository;
    final WebSocketController webSocketController;
    final UserRepository userRepository;
    final SimpMessagingTemplate simpMessagingTemplate;
    @Override
    public Delivery addDelivery(Order order) {
        Twilio.init("AC225cbaf4dc5b18543916206395c959ad","98e961b83e847f5ad862deac09f5ee43" );
        Delivery delivery=Delivery.builder()
                .orderId(order.getOrderId())
                .client(order.getUser())
                .status("processing")
                .isCancled(false)
                .isTerminated(false)
                .build();
        deliveryRepository.save(delivery);
        simpMessagingTemplate.convertAndSend("/chat/public", "Delivery Added");
        Message.creator(new com.twilio.type.PhoneNumber("+21624733797"),
                new com.twilio.type.PhoneNumber("+19787084026"), "ken khlatlek hedha abathli message").create();

        return delivery;
    }

    @Override
    public List<Delivery> getAllDeliveries() {
        return null;
    }

    @Override
    public Delivery terminateDelivery(Long deliveryId) {
        Delivery delivery=deliveryRepository.findById(deliveryId).get();
        delivery.setIsTerminated(true);
        return delivery;
    }

    @Override
    public Delivery cancelDelivery(Long deliveryId) {
        Delivery delivery=deliveryRepository.findById(deliveryId).get();
        delivery.setIsCancled(true);
        return delivery;
    }

    @Override
    public List<Delivery> getMyDeliveries() {
        User user= userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        return this.deliveryRepository.findAllByClient(user);
    }

}
