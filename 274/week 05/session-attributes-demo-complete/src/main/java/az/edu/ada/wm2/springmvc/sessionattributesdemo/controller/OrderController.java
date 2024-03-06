package az.edu.ada.wm2.springmvc.sessionattributesdemo.controller;

import az.edu.ada.wm2.springmvc.sessionattributesdemo.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("/order")
public class OrderController {

    @GetMapping({"","/"})
    public String listOrder(Model model,
                            @SessionAttribute("cart") Order cart){
        model.addAttribute("order", cart);
        return "orders/order_detail";
    }

    @PostMapping("/save")
    public String saveOrder(@SessionAttribute("cart") Order order,
                            @RequestParam("customerName") String name,
                            SessionStatus sessionStatus,
                            WebRequest request){

        order.setCustomerName(name);
        System.out.println(name + " completed the order: " + order);
        //TODO: save the order in the database

        sessionStatus.setComplete();

        request.removeAttribute("cart", 1);

        return "redirect:/product/";
    }
}
