package ua.rozhkov.springdepdb.DAO.entity.core;

import org.hibernate.annotations.GenericGenerator;
import ua.rozhkov.springdepdb.DAO.entity.CollegeSpecialty;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "colleges")
public class College {


    private Long id;
    private String name;
    private String address;
    private String director;
    private String phone;
    private OwnerShip ownerShip;
    private List<CollegeSpecialty> specialities = new LinkedList<>();

    public College() {
    }

    public College(String name, String address, String director, String phone, OwnerShip ownerShip) {
        this.name = name;
        this.address = address;
        this.director = director;
        this.phone = phone;
        this.ownerShip = ownerShip;
    }

    @Id
    @Column(name = "college_id")
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

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "director")
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "ownerShip")
    @Enumerated(EnumType.STRING)
    public OwnerShip getOwnerShip() {
        return ownerShip;
    }

    public void setOwnerShip(OwnerShip ownerShip) {
        this.ownerShip = ownerShip;
    }

    @OneToMany(mappedBy = "primaryKey.college", cascade = CascadeType.ALL)
    public List<CollegeSpecialty> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(List<CollegeSpecialty> specialities) {
        this.specialities = specialities;
    }

    public void addSpecialty(CollegeSpecialty collegeSpeciality) {
        this.getSpecialities().add(collegeSpeciality);
    }

    @Override
    public String toString() {
        return "College[" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", director='" + director + '\'' +
                ", phone='" + phone + '\'' +
                ", ownerShip=" + ownerShip +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof College)) return false;

        College college = (College) o;

        if (!name.equals(college.name)) return false;
        if (!address.equals(college.address)) return false;
        if (!director.equals(college.director)) return false;
        if (!phone.equals(college.phone)) return false;
        return ownerShip == college.ownerShip;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + director.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + ownerShip.hashCode();
        return result;
    }
}
