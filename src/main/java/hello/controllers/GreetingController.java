package hello.controllers;

import hello.services.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @Autowired
    public InformationService informationService;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    /*
     * More complex example with DI
     */
    @GetMapping("/getInformation")
    public String getInformation(Model model) {
        model.addAttribute("name", informationService.getUser());
        return "greeting";
    }

}