package site.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import site.misc.Coordinate;
import site.models.TownModel;
import site.services.interfaces.TownService;

import java.util.List;

@Controller
public class HomeController {

    private final TownService townService;

    public HomeController(TownService townService) {
        this.townService = townService;
    }

    @GetMapping("map/{x}/{y}")
    public String getMapPage(@PathVariable("x") int x, @PathVariable("y") int y, Model model) {
        List<TownModel> towns = townService.findAll();
        model.addAttribute("towns", towns);
        model.addAttribute("coordinates", new Coordinate(x,y,5));
        return "home";
    }

    @GetMapping("/")
    public String getHomePage() {
        return "redirect:/map/2/2";
    }
}
