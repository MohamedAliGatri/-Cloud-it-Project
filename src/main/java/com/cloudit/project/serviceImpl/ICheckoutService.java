package com.cloudit.project.serviceImpl;

import com.cloudit.project.dto.Purchase;
import com.roky.thunderspi.dto.PurchaseResponse;


public interface ICheckoutService {


    PurchaseResponse placeOrder(Purchase purchase) throws Exception;
}
