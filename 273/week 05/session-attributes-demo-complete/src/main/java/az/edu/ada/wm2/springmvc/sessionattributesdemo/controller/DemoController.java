package az.edu.ada.wm2.springmvc.sessionattributesdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/demo")
@SessionAttributes({"principal"})
public class DemoController {

    @GetMapping("/path1")
    public String redirectTheRequest(Model model){
        model.addAttribute("principal", "nuraddin");
        return "redirect:/demo/path2";
    }

    @GetMapping("/path2")
    public String showPage(){
        return "demo/list";
    }

}
