package site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import site.enums.Faction;
import site.models.RegisterUserModel;
import site.services.interfaces.UserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/register")
    public String getRegister(Model model) {
        List<String> factions = new ArrayList<>();
        for (Faction faction : Faction.values()) {
            String curFaction = faction.toString();
            curFaction.substring(1).toLowerCase();
            factions.add(curFaction);
        }
        model.addAttribute("factions", factions);
        return "register";
    }

    @PostMapping("/register")
    public String postRegisterPage(@Valid @ModelAttribute RegisterUserModel registerUserModel, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "register";
        }

        userService.register(registerUserModel);
        return "redirect:/login";
    }
}
