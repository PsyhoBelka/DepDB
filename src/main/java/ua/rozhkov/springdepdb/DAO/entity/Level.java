package ua.rozhkov.springdepdb.DAO.entity;

import org.hibernate.annotations.GenericGenerator;
import ua.rozhkov.springdepdb.DAO.enums.Base;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "levels")
public class Level {
    private Long id;
    private Base name;
    private List<Form> forms = new ArrayList<>();

    public Level() {
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
    public Base getName() {
        return name;
    }

    public void setName(Base name) {
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinTable(name = "levels_forms",
            joinColumns = @JoinColumn(name = "level_id"),
            inverseJoinColumns = @JoinColumn(name = "form_id"))
    public List<Form> getForms() {
        return forms;
    }

    public void setForms(List<Form> studyForms) {
        this.forms = forms;
    }

    public void addStudyFrom(Form form) {
        forms.add(form);
    }
}

