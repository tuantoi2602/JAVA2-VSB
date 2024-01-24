package JPA;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student extends Person {
    @Getter
    @Setter
    @ManyToOne
    private Teacher tutor;
    
    @Getter
    @Setter
    @ManyToMany(mappedBy = "students")
    private List<Subject> subjects;
}


