package az.edu.ada.wm2.springmvc.sessionattributesdemo.controller;

import az.edu.ada.wm2.springmvc.sessionattributesdemo.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
@SessionAttributes({"cart"})
public class ProductsController {

    @GetMapping({"/", "/list", ""})
    public String getProductsPage(Model model, @ModelAttribute("cart") Order cart) {
        model.addAttribute("cart", cart);
        return "products/list";
    }

    @PostMapping("/addToOrder")
    public String addProductToOrder(Model model,
                                    @ModelAttribute("cart") Order cart,
                                    @RequestParam("product") String productName) {
        if (!productName.isBlank())
            cart.addProduct(productName);

        model.addAttribute("cart", cart);

        return "redirect:/product/list";
    }

    @ModelAttribute("cart")
    public Order cart() {
        return new Order();
    }

}
