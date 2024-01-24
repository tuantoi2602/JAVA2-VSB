package org.acme;

import java.util.ArrayList;
import java.util.List;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Table(name = "Subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Getter
    @Setter
    private String name;
    
    @Getter
    @Setter
    private String code;
    
    @Getter
    @Setter
    @ManyToOne
    private Teacher teacher;
    
    @Getter
    @Setter
    @ManyToMany
    @JsonbTransient
    private List<Student> students;
    
    public Subject() {
        this.students = new ArrayList<>();
    }
}



