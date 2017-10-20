package site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import site.entities.Square;
import site.enums.Faction;
import site.enums.LandType;
import site.misc.Coordinate;
import site.misc.ImageDistributor;
import site.models.TownModel;
import site.services.interfaces.TownService;
import site.services.interfaces.WorldService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class HomeController {

    private final TownService townService;
    private final WorldService worldService;

    @Autowired
    public HomeController(TownService townService, WorldService worldService) {
        this.townService = townService;
        this.worldService = worldService;
    }

    @GetMapping("map/{x}/{y}")
    public String getMapPage(@PathVariable("x") int x, @PathVariable("y") int y, Model model) {
        List<TownModel> towns = townService.findAll();
        model.addAttribute("towns", towns);
        model.addAttribute("coordinates", new Coordinate(x, y, 5));
        model.addAttribute("imgs", new ImageDistributor(worldService));
        return "home";
    }

    @GetMapping("/")
    public String getHomePage() {
        return "redirect:/map/2/2";
    }
}
