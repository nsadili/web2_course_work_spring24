package az.edu.ada.wm2.springmvc.sessionattributesdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/demo")
@SessionAttributes({"object"})
public class DemoController {

    @GetMapping("/test1")
    public String testEndpoint(Model model){
        model.addAttribute("object", "Welcome!");
        return "redirect:/demo/test2";
    }
    @GetMapping("/test2")
    public String test2Endpoint(){
        return "demo/list";
    }

}
