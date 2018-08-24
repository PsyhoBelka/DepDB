package ua.rozhkov.springdepdb.DAO.entity;

import org.hibernate.annotations.GenericGenerator;

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
    private List<Specialty> specialties = new LinkedList<>();

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

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "colleges_specialties",
            joinColumns = @JoinColumn(name = "college_id"),
            inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    public List<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<Specialty> specialties) {
        this.specialties = specialties;
    }

    public void addSpecialty(Specialty specialty) {
        this.getSpecialties().add(specialty);
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

}
