package org.acme;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Person")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    
    @Getter
    @Setter
    public String firstName;
    
    @Getter
    @Setter
    public String lastName;
    
    @Getter
    @Setter
    private Integer age;
}


