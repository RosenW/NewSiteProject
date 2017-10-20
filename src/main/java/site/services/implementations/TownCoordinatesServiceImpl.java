package site.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.entities.TownCoordinate;
import site.repositories.TownCoordinatesRepository;
import site.services.interfaces.TownCoordinatesService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TownCoordinatesServiceImpl implements TownCoordinatesService {
    private final TownCoordinatesRepository townCoordinatesRepository;

    @Autowired
    public TownCoordinatesServiceImpl(TownCoordinatesRepository townCoordinatesRepository) {
        this.townCoordinatesRepository = townCoordinatesRepository;
    }

    @Override
    public List<TownCoordinate> findAll() {
        return townCoordinatesRepository.findAll();
    }

    @Override
    public void save(TownCoordinate townCoordinate) {
        townCoordinatesRepository.saveAndFlush(townCoordinate);
    }
}
