package az.edu.ada.wm2.springmvc.sessionattributesdemo.controller;

import az.edu.ada.wm2.springmvc.sessionattributesdemo.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("/order")
public class OrderController {

    @GetMapping({"", "/", "/list"})
    public String displayOrders(@SessionAttribute("cart") Order order,
                                Model model) {
        System.out.println("------------->" + order);
        model.addAttribute("order", order);
        return "orders/order_detail";
    }

    @PostMapping("/save")
    public String save(@SessionAttribute("cart") Order order,
                       @RequestParam("customerName") String customerName,
                       WebRequest webRequest,
                       SessionStatus ss
    ) {
        order.setCustomerName(customerName);
        //TODO: PROCESS THE ORDER
        System.out.println("Order is completed, than you for your purchase!");
        System.out.println("--> " + order);

        //set the session processing as complete
        //AND allow for cleanup of the attributes
        ss.setComplete();

        //remove the order attribute from the session
        //SCOPE 1 means SESSION SCOPE
        webRequest.removeAttribute("cart", 1);

        return "redirect:/product/list";
    }

}
