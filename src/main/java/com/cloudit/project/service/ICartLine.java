package com.cloudit.project.service;

import com.cloudit.project.model.CartLine;

public interface ICartLine {
    CartLine addCartLineAndAssignToProductAndCart(CartLine cartline, Long id_cart);
}
