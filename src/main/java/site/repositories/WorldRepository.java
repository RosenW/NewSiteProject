package site.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.entities.Square;

@Repository
public interface WorldRepository extends JpaRepository<Square, Integer> {
}