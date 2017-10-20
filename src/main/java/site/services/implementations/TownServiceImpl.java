package site.services.implementations;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.entities.Square;
import site.entities.Town;
import site.entities.TownCoordinate;
import site.enums.Faction;
import site.enums.LandType;
import site.models.TownModel;
import site.repositories.TownRepository;
import site.services.interfaces.TownCoordinatesService;
import site.services.interfaces.TownService;
import site.services.interfaces.UserService;
import site.services.interfaces.WorldService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;
    private final UserService userService;
    private final TownCoordinatesService townCoordinatesService;
    private final ModelMapper modelMapper;
    private final WorldService worldService;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, UserService userService, TownCoordinatesService townCoordinatesService, ModelMapper modelMapper, WorldService worldService) {
        this.townRepository = townRepository;
        this.userService = userService;
        this.townCoordinatesService = townCoordinatesService;
        this.modelMapper = modelMapper;
        this.worldService = worldService;
    }

    @Override
    public List<TownModel> findAll() {
        List<Town> towns = townRepository.findAll();
        List<TownModel> townModels = new ArrayList<>();
        for (Town town : towns) {
            TownModel curTownModel = new TownModel();
            modelMapper.map(town, curTownModel);
            curTownModel.setOwner(town.getOwner().getName());
            townModels.add(curTownModel);
        }
        return townModels;
    }

    @Override
    public void save(TownModel townModel) {
        Town town = new Town();

        TownCoordinate townCoordinate = townModel.getCoordinate();
        townCoordinatesService.save(townCoordinate);

        town.setFaction(townModel.getFaction());
        town.setLandType(townModel.getLandType());
        town.setName(townModel.getName());
        town.setOwner(userService.findByName(townModel.getOwner()));
        town.setTownCoordinate(townModel.getCoordinate());

        Square square = worldService.getSquareByCoordinates(
                townModel.getCoordinate().getBigX(),
                townModel.getCoordinate().getBigY(),
                townModel.getCoordinate().getSmallX(),
                townModel.getCoordinate().getSmallY());
        square.setLandType(getLandTypeByFaction(townModel.getFaction()));
        worldService.save(square);

        townRepository.saveAndFlush(town);
    }

    private LandType getLandTypeByFaction(Faction faction) {
        switch (faction) {
            case HUMANS:
                return LandType.HUMANS;
            default:
                return null;
        }
    }


}
