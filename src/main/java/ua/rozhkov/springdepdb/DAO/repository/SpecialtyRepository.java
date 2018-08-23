package ua.rozhkov.springdepdb.DAO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.rozhkov.springdepdb.DAO.entity.core.Specialty;

public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
    Specialty findSpecialtyById(long id);

    Specialty findSpecialtyByName(String specialityName);
}
