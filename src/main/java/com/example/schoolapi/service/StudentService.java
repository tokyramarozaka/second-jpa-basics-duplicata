package com.example.schoolapi.service;

import com.example.schoolapi.model.Student;
import com.example.schoolapi.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * On va apprende l'injection de dependances
 * Inversion de controle : l'instanciation et la gestion des dependances
 * doit être faite ailleurs par exemple par spring.
 */
@Service
@AllArgsConstructor
public class StudentService {
    // Cette dépendance est injectée par constructeur. Impossible de créer ce service sans fournir le repository dont il est dépendant
    private final StudentRepository repository ;

    public Student save(Student s){
        return repository.save(s);
    }

    public List<Student> findAll(){
        return repository.findAll();
    }

    public Optional<Student> findById(Long id){
        return repository.findById(id);
    }

    public List<Student> findWhereNameLike(String wanted){
        return repository.findByNameContaining(wanted);
    }

    public Student updateName(Long id, String newName){
        Optional<Student> studentOptional = repository.findById(id);
        if(studentOptional.isPresent()){
            Student student = studentOptional.get();
            student.setName(newName);
            return repository.save(student);
        }
        else{
            throw new NullPointerException("tsy hita leka ilay student");
        }
    }

    public String deleteById(Long id){
        repository.deleteById(id);
        return "Resource deleted succesfully";
    }
}
