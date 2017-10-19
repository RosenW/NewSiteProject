package site.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.entities.Town;

@Repository
public interface TownRepository extends JpaRepository<Town, Integer> {

}