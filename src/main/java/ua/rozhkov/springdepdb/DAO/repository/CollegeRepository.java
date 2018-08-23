package ua.rozhkov.springdepdb.DAO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.rozhkov.springdepdb.DAO.entity.core.College;

public interface CollegeRepository extends JpaRepository<College, Long> {
    College findCollegeById(long id);

    College findCollegeByName(String collegeName);

}
