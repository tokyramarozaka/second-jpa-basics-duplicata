package com.example.schoolapi.repository;

import com.example.schoolapi.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentSimpleRepository {
    List<Student> findAll(); // select * from student

    Student save(Student s); // insert !

    Optional<Student> findById(Long id);

    void deleteById(Long id); // delete


    List<Student> findWhereNameLike(String query);
    // select * from student where name like '%query%'
}
// Créer une implémentation de cette classe avec JDBC d'abord.
// Créer une autre implémentation en utilisant JPA avec JPQL (Java Persistance Query Language)
// cherchez une annotation qui s'appelle @Query