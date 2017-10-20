package site.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import site.entities.TownCoordinate;
import site.entities.User;
import site.models.TownModel;
import site.services.interfaces.TownService;
import site.services.interfaces.UserService;
import site.services.interfaces.WorldService;

import java.util.List;

@Controller
public class TownController {

    private final TownService townService;
    private final UserService userService;
    private final WorldService worldService;

    public TownController(TownService townService, UserService userService, WorldService worldService) {
        this.townService = townService;
        this.userService = userService;
        this.worldService = worldService;
    }

    @GetMapping("square/{bx}/{by}/{sx}/{sy}")
    public String getTown(@PathVariable("bx") int bx, @PathVariable("by") int by, @PathVariable("sx") int sx, @PathVariable("sy") int sy, Model model) {
        List<TownModel> towns = townService.findAll();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        boolean thereIsSuchTown = false;
        TownModel curTown = null;
        for (TownModel town : towns) {
            if (town.getCoordinate().getBigX() == bx
                    && town.getCoordinate().getBigY() == by
                    && town.getCoordinate().getSmallX() == sx
                    && town.getCoordinate().getSmallY() == sy) {
                thereIsSuchTown = true;
                curTown = town;
                break;
            }
        }
        if (thereIsSuchTown && curTown.getOwner().equals(auth.getName())) {
            model.addAttribute("town", curTown);
            return "town";
        }
        model.addAttribute("bx", bx);
        model.addAttribute("by", by);
        model.addAttribute("sx", sx);
        model.addAttribute("sy", sy);
        return "create-town";
    }

    @PostMapping("square/{bx}/{by}/{sx}/{sy}")
    public String postTown(@ModelAttribute TownModel townModel, @PathVariable("bx") int bx, @PathVariable("by") int by, @PathVariable("sx") int sx, @PathVariable("sy") int sy, Model model) {
        System.out.println("asdasd");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByName(auth.getName());
        townModel.setOwner(auth.getName());
        townModel.setCoordinate(new TownCoordinate(bx, by, sx, sy));
        townModel.setFaction(user.getFaction());
        townModel.setLandType(worldService.getLandType(bx,by,sx,sy));
        townService.save(townModel);
        return "town";
    }
}