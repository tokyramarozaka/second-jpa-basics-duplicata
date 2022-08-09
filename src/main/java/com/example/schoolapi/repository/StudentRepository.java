package com.example.schoolapi.repository;

import com.example.schoolapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * JPA
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
    // find all : ça existe deja

    // save : ça existe deja

    // deleteById : ca existe deja

    // findById : ca existe deja

    // selectWhereNameLike(string) : à créer
    // SELECT * FROM student WHERE name ILIKE '%string%'
    List<Student> findByNameContaining(String wanted);

    // on va rajouter update : pour justifier la notion de service
    @Query("SELECT s FROM Student s WHERE s.name LIKE CONCAT('%',:name,'%')")
    Student blablablablaLavaBe(@Param("name") String wcylphoap);
}
