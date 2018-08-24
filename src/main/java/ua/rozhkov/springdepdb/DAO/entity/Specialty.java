package ua.rozhkov.springdepdb.DAO.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "specialties")
public class Specialty {


    private Long id;
    private String name;
    private String code;
    private List<College> colleges=new LinkedList<>();
    private List<LicenseCapacity> licenses = new LinkedList<>();
    private List<RealCapacity> reals = new LinkedList<>();

    public Specialty() {
    }

    public Specialty(String name, String code) {
        this.name = name;
        this.code = code;
    }

    @Id
    @Column(name = "specialty_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "colleges_specialties",
    joinColumns = @JoinColumn(name = "specialty_id"),
    inverseJoinColumns = @JoinColumn(name = "college_id"))
    public List<College> getColleges() {
        return colleges;
    }

    public void setColleges(List<College> colleges) {
        this.colleges = colleges;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "specialty_id")
    public List<LicenseCapacity> getLicenses() {
        return licenses;
    }

    public void setLicenses(List<LicenseCapacity> licenses) {
        this.licenses = licenses;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "specialty_id")
    public List<RealCapacity> getReals() {
        return reals;
    }

    public void setReals(List<RealCapacity> reals) {
        this.reals = reals;
    }

    public void addLicenseCapacity(LicenseCapacity licenseCapacity) {
        this.getLicenses().add(licenseCapacity);
    }

    public void addReals(RealCapacity realCapacity) {
        this.getReals().add(realCapacity);
    }

    @Override
    public String toString() {
        return "Specialty[" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Specialty)) return false;

        Specialty specialty = (Specialty) o;

        if (!name.equals(specialty.name)) return false;
        return code.equals(specialty.code);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + code.hashCode();
        return result;
    }
}
