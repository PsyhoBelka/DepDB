package ua.rozhkov.springdepdb.DAO.entity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "period")
public class Period {

    private long id;
    private String name;
    private List<College> colleges = new LinkedList<>();

    public Period() {
    }

    public Period(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "period_id")
    public List<College> getColleges() {
        return colleges;
    }

    public void setColleges(List<College> colleges) {
        this.colleges = colleges;
    }

    public void addCollege(College college) {
        this.getColleges().add(college);
    }

    public String[] colegesIdsToStrindArray() {
        String[] ids = new String[colleges.size()];
        int i = 0;
        for (College college :
                colleges) {
            ids[i++] = String.valueOf(college.getId());
        }
        return ids;
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
