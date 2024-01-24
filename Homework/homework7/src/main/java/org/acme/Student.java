package org.acme;


import java.util.ArrayList;
import java.util.List;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Entity
@AllArgsConstructor
@Table(name = "Student")
public class Student extends Person {
    @Getter
    @Setter
    @ManyToOne
    @JsonbTransient
    private Teacher teacher;
    
    @Getter
    @Setter
    @JsonbTransient
    @ManyToMany(mappedBy = "students")
    private List<Subject> subjects;
    
    public Student() {
        this.subjects = new ArrayList<>();
    }
}


