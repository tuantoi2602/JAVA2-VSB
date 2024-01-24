package org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;

import io.quarkus.runtime.StartupEvent;
import io.quarkus.test.junit.QuarkusTest;




@QuarkusTest
@ApplicationScoped
public class TestJPA {

    @Inject
    EntityManager entityManager;
    
    @Transactional
    @Test
    public void init() {
        Teacher teacher1 = new Teacher();
        teacher1.setFirstName("Michal");
        teacher1.setLastName("Radecky");
        teacher1.setAge(40);
        Teacher teacher2 = new Teacher();
        teacher2.setFirstName("Jan");
        teacher2.setLastName("Koz");
        teacher2.setAge(33);
        entityManager.persist(teacher1);
        entityManager.persist(teacher2);
        

        Subject subject1 = new Subject();
        subject1.setName("Web Development");
        subject1.setCode("VIA");        
        subject1.setTeacher(teacher1);
        Subject subject2 = new Subject();
        subject2.setName("Java 2");
        subject2.setCode("JAVAII");
        subject2.setTeacher(teacher2);
        entityManager.persist(subject1);
        entityManager.persist(subject2);

        Student student1 = new Student();
        student1.setFirstName("Tuan");
        student1.setLastName("Nguyen");
        student1.setAge(24);
        student1.setTeacher(teacher1);
        student1.getSubjects().add(subject1);
        student1.getSubjects().add(subject2);
        subject1.getStudents().add(student1);
        entityManager.persist(student1);

        Student student2 = new Student();
        student2.setFirstName("Nu");
        student2.setLastName("Nguyen");
        student2.setAge(23);
        student2.setTeacher(teacher2);
        subject2.getStudents().add(student2);
        student2.getSubjects().add(subject2);
        entityManager.persist(student2);
    }
    public void onStart(@Observes StartupEvent event) {
        init();
        System.out.println("InitializerOnStart.onStart()");
    }
    
    
}
