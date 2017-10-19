package site.services.implementations;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import site.entities.Town;
import site.models.TownModel;
import site.repositories.TownRepository;
import site.services.interfaces.TownService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;
    private final ModelMapper modelMapper;

    public TownServiceImpl(TownRepository townRepository, ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TownModel> findAll() {
        List<Town> towns = townRepository.findAll();
        List<TownModel> townModels = new ArrayList<>();
        for (Town town : towns) {
            TownModel curTownModel = new TownModel();
            modelMapper.map(town, curTownModel);
            townModels.add(curTownModel);
        }
        return townModels;
    }
}
