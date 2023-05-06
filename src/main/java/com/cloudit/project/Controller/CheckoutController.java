package  com.cloudit.project.Controller;


import com.cloudit.project.dto.Purchase;
import com.cloudit.project.serviceImpl.CheckoutServiceImpl;
import com.roky.thunderspi.dto.PurchaseResponse;



import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
@AllArgsConstructor
public class CheckoutController {


    private final CheckoutServiceImpl checkoutService;



    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) throws Exception {

        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);

        return purchaseResponse;
    }



}





