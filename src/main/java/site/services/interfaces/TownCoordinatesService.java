package site.services.interfaces;

import site.entities.TownCoordinate;
import site.models.TownModel;

import java.util.List;

public interface TownCoordinatesService {
    List<TownCoordinate> findAll();

    void save(TownCoordinate townCoordinate);
}
