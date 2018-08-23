package ua.rozhkov.springdepdb.DAO.entity;

import ua.rozhkov.springdepdb.DAO.entity.core.College;
import ua.rozhkov.springdepdb.DAO.entity.core.Specialty;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class CollegeSpecialtyId implements Serializable {

    private College college;
    private Specialty specialty;

    @ManyToOne(cascade = CascadeType.ALL)
    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CollegeSpecialtyId that = (CollegeSpecialtyId) o;

        if (!college.equals(that.college)) return false;
        return specialty.equals(that.specialty);
    }

    @Override
    public int hashCode() {
        int result = college.hashCode();
        result = 31 * result + specialty.hashCode();
        return result;
    }
}
