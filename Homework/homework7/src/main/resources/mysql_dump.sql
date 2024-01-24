

CREATE TABLE homework.hibernate_sequences (
    sequence_name VARCHAR(255) NOT NULL,
    next_val BIGINT,
    PRIMARY KEY (sequence_name)
);
create table homework.Person (id bigint not null, age integer, firstName varchar(255), lastName varchar(255), primary key (id)) engine=InnoDB;

create table homework.hibernate_sequence (next_val bigint) engine=InnoDB;
insert into homework.hibernate_sequence values ( 10 );
create table homework.Student (id bigint not null, age integer, firstName varchar(255), lastName varchar(255), teacher_id bigint, primary key (id)) engine=InnoDB;
create table homework.Subject (id bigint not null, code varchar(255), name varchar(255), teacher_id bigint, primary key (id)) engine=InnoDB;
create table homework.Subject_Student (subjects_id bigint not null, students_id bigint not null) engine=InnoDB;
create table homework.Teacher (id bigint not null, age integer, firstName varchar(255), lastName varchar(255), primary key (id)) engine=InnoDB;
alter table homework.Student add constraint student_teacher_fk foreign key (teacher_id) references homework.Teacher (id);
alter table homework.Subject add constraint subject_teacher_fk foreign key (teacher_id) references homework.Teacher (id);
alter table homework.Subject_Student add constraint student_id_FK foreign key (students_id) references homework.Student (id);
alter table homework.Subject_Student add constraint subjects_id_FK foreign key (subjects_id) references homework.Subject (id);







