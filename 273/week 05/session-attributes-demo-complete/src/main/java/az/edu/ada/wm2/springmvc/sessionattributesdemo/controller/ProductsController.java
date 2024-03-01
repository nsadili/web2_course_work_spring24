package az.edu.ada.wm2.springmvc.sessionattributesdemo.controller;

import az.edu.ada.wm2.springmvc.sessionattributesdemo.model.Order;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
@SessionAttributes({"cart"})
public class ProductsController {

    @GetMapping({"", "/", "/list"})
    public String displayProducts(@ModelAttribute("cart") Order cart,
                                  Model model) {
        model.addAttribute("cart", cart == null ? new Order() : cart);
        return "products/list";
    }

    @PostMapping("/addToOrder")
    public String addProduct(@ModelAttribute("cart") Order cart,
                             @RequestParam("product") String prodName) {

        if (prodName != null || !prodName.isBlank())
            cart.addProduct(prodName);

        return "redirect:/product";
    }

    @ModelAttribute("cart")
    private Order cart() {
        return new Order();
    }

}
