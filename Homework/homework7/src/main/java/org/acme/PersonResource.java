package org.acme;



import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@Path("/")
public class PersonResource {

    @Inject
    EntityManager entityManager;



    @GET
    @Path("student")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> listStudent() {
        return entityManager.createQuery("SELECT student FROM Student AS student", Student.class).getResultList();
    }
    @GET
    @Path("teacher")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Teacher> listTeachers() {
        return entityManager.createQuery("SELECT teacher FROM Teacher AS teacher", Teacher.class).getResultList();
    }

    @GET
    @Path("subject")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Subject> listSubjects() {
        return entityManager.createQuery("SELECT subject FROM Subject AS subject", Subject.class).getResultList();
    }

    @Transactional
    @POST
    @Path("enroll/{studentId}/{subjectId}")
    public void enrollStudent(@PathParam("students_id") Long studentId, @PathParam("subjects_id") Long subjectId) {
        Student student = entityManager.find(Student.class, studentId);
        Subject subject = entityManager.find(Subject.class, subjectId);
        student.getSubjects().add(subject);
        subject.getStudents().add(student);
        entityManager.persist(subject);
        entityManager.persist(student); // save changes to student
    }

    @GET
    @Path("studentsInSubject/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listStudentsInSubject(@PathParam("id") Long subjectId) {
        Subject subject = entityManager.find(Subject.class, subjectId);
        if (subject == null) {
            return Response.status(Status.NOT_FOUND)
                .type(MediaType.TEXT_PLAIN)
                .entity("Course with id = " + subjectId + " not found")
                .build();
        }
        List<Student> students = subject.getStudents();
        return Response.ok(students).build();
    }
}
