package ua.rozhkov.springdepdb.DAO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.rozhkov.springdepdb.DAO.entity.Period;

public interface PeriodRepository extends JpaRepository<Period, Long> {
    Period findPeriodById(long id);

    Period findPeriodByName(String periodName);
}
