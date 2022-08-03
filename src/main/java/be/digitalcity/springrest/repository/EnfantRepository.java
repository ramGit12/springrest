package be.digitalcity.springrest.repository;

import be.digitalcity.springrest.model.entity.Enfant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnfantRepository extends JpaRepository<Enfant,Long> {
}
