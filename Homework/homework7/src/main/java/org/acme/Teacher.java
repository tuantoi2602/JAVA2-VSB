package org.acme;

import java.util.List;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Teacher")
public class Teacher extends Person {
	
    @Getter
    @Setter
    @JsonbTransient
    @OneToMany(mappedBy = "teacher")
    private List<Subject> subjects;
}


