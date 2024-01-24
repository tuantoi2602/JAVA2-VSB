package JPA;
import java.util.Arrays;


import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;




public class TestJPA {

	@Test
	public void demonstrateInheritance() {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("HW5");
	    EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    
	    Student student = new Student();
	    student.setFirstName("Thanh");
	    student.setLastName("Tuan");
	    student.setAge(24);
	    em.persist(student);
	    
	    Teacher teacher = new Teacher();
	    teacher.setFirstName("Peter");
	    teacher.setLastName("Chovanec");
	    teacher.setAge(30);
	    em.persist(teacher);
	    
	    em.getTransaction().commit();
	    em.close();
	    emf.close();
	}

	@Test
	public void demonstrateManyToOne() {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("HW5");
	    EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    
	    Teacher teacher = new Teacher();
	    teacher.setFirstName("Jan");
	    teacher.setLastName("Koz");
	    teacher.setAge(35);
	    em.persist(teacher);
	    
	    Subject subject = new Subject();
	    subject.setName("Java 2");
	    subject.setCode("JAVAII");
	    subject.setTeacher(teacher);
	    em.persist(subject);
	    
	    em.getTransaction().commit();
	    em.close();
	    emf.close();
	}

	@Test
	public void demonstrateOneToMany() {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("HW5");
	    EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    
	    Teacher teacher = new Teacher();
	    teacher.setFirstName("Michal");
	    teacher.setLastName("Radecky");
	    teacher.setAge(35);
	    em.persist(teacher);
	    
	    Subject subject1 = new Subject();
	    subject1.setName("Web Development");
	    subject1.setCode("VIA");
	    subject1.setTeacher(teacher);
	    em.persist(subject1);
	    
	    Subject subject2 = new Subject();
	    subject2.setName("Database");
	    subject2.setCode("UDBS");
	    subject2.setTeacher(teacher);
	    em.persist(subject2);
	    
	    em.getTransaction().commit();
	    em.close();
	    emf.close();
	}

	@Test
	public void demonstrateManyToMany() {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("HW5");
	    EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    
	    Teacher teacher1 = new Teacher();
	    teacher1.setFirstName("Michal");
	    teacher1.setLastName("Radecky");
	    teacher1.setAge(35);
	    em.persist(teacher1);
	    
	    Teacher teacher2 = new Teacher();
	    teacher2.setFirstName("Jan");
	    teacher2.setLastName("Koz");
	    teacher2.setAge(35);
	    em.persist(teacher2);
	    
	    Student student1 = new Student();
	    student1.setFirstName("Thanh");
	    student1.setLastName("Tuan");
	    student1.setAge(24);
	    student1.setTutor(teacher1);
	    em.persist(student1);
	    
	    Student student2 = new Student();
	    student2.setFirstName("Tom");
	    student2.setLastName("Smith");
	    student2.setAge(21);
	    student2.setTutor(teacher2);
	    em.persist(student2);
	    
	    Subject subject1 = new Subject();
	    subject1.setName("Web Development");
	    subject1.setCode("VIA");
	    subject1.setTeacher(teacher1);
	    subject1.setStudents(Arrays.asList(student1, student2));
	    em.persist(subject1);
	    
	    Subject subject2 = new Subject();
	    subject2.setName("Java 2");
	    subject2.setCode("JAVAII");
	    subject2.setTeacher(teacher2);
	    subject2.setStudents(Arrays.asList(student1));
	    em.persist(subject2);
	    
	    em.getTransaction().commit();
	    em.close();
	    emf.close();
	}
}