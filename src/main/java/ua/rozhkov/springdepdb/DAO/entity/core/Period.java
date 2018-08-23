package ua.rozhkov.springdepdb.DAO.entity.core;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "period")
public class Period {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    public Period() {
    }

    public Period(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Period period = (Period) o;
        return id == period.id &&
                Objects.equals(name, period.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
