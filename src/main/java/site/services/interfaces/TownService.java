package site.services.interfaces;

import site.models.TownModel;

import java.util.List;

public interface TownService {
    List<TownModel> findAll();

    void save(TownModel townModel);
}
