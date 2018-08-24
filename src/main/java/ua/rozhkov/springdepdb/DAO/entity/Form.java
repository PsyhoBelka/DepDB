package ua.rozhkov.springdepdb.DAO.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "forms")
public class Form {

    private Long id;
    private ua.rozhkov.springdepdb.DAO.enums.StudyForm name;
    private List<Level> levels = new ArrayList<>();
    private List<LicenseCapacity> licenseCapacities = new ArrayList<>();
    private List<RealCapacity> realCapacities = new ArrayList<>();

    public Form() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    public ua.rozhkov.springdepdb.DAO.enums.StudyForm getName() {
        return name;
    }

    public void setName(ua.rozhkov.springdepdb.DAO.enums.StudyForm name) {
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "levels_forms",
            joinColumns = @JoinColumn(name = "form_id"),
            inverseJoinColumns = @JoinColumn(name = "level_id"))
    public List<Level> getLevels() {
        return levels;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "studyform_id")
    public List<LicenseCapacity> getLicenseCapacities() {
        return licenseCapacities;
    }

    public void setLicenseCapacities(List<LicenseCapacity> licenseCapacities) {
        this.licenseCapacities = licenseCapacities;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "studyform_id")
    public List<RealCapacity> getRealCapacities() {
        return realCapacities;
    }

    public void setRealCapacities(List<RealCapacity> realCapacities) {
        this.realCapacities = realCapacities;
    }

    public void addLicensesCapacity(LicenseCapacity licenseCapacity) {
        licenseCapacities.add(licenseCapacity);
    }

    public void addRealCapacities(RealCapacity realCapacity) {
        realCapacities.add(realCapacity);
    }
}
