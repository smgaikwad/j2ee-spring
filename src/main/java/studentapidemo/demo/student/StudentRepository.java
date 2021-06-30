package studentapidemo.demo.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
//The Spring Data JPA simplifies the
//        development of Spring applications
//        that use JPA technology.
//        With Spring Data, we define a repository interface for
//        each domain entity in the application.
//        A repository contains methods for performing CRUD operations,
//        sorting and paginating data.
public interface StudentRepository extends JpaRepository<Student, Long> {
//    Optional is a container object which may or may not contain a
//    non-null value. You must import java. util package to use this class.
//    If a value is present, isPresent() will return true and get() will return the value.
    Optional<Student> findStudentByEmail(String email);
}