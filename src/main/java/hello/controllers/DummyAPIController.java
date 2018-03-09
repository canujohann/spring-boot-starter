package hello.controllers;

import hello.json.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyAPIController {

    /*
     * Dummy mock for simulate API call
     */
    @GetMapping("/getDummyAPI")
    public User getDummyAPI(Model model) {
        User user = new User();
        user.setName("道元禅師");
        return user;
    }
}
