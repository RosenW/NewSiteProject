package site.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.entities.Town;
import site.entities.TownCoordinate;

@Repository
public interface TownCoordinatesRepository extends JpaRepository<TownCoordinate, Integer> {

}