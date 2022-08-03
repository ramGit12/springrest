package be.digitalcity.springrest.repository;

import be.digitalcity.springrest.model.entity.Tuteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TuteurRepository extends JpaRepository<Tuteur,Long> {
}
