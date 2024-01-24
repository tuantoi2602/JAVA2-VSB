package JPA;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Teacher extends Person {
	
    @Getter
    @Setter
    @OneToMany(mappedBy = "teacher")
    private List<Subject> subjects;
}


