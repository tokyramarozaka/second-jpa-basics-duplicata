package com.example.schoolapi.controller;

import com.example.schoolapi.model.Student;
import com.example.schoolapi.repository.StudentRepository;
import com.example.schoolapi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor // Injection par constructeur -- @AllArgsConstructor marche également.
public class StudentController {
    private final StudentService service;
    /* y a 3 moyens d'injecter la dependance du controlleur qu'est le service :
     1. par @Autowired, 2. par Constructeur, 3. par @Inject (field injection)
     Les questions qui devraient se poser sont : est-ce que ça peut engendrer des erreurs (dépendances null) ?
     Est-ce que c'est facile à tester niveau test d'intégration / test unitaire ?
     Le meilleur moyen reste l'injection par constructeur https://reflectoring.io/constructor-injection/
    */

    @GetMapping("/students")
    public List<Student> findAll(){
        return service.findAll();
    }

    @GetMapping("/students/{id}")
    public Optional<Student> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("/students/search")
    public List<Student> findWhereNameLike(@RequestParam(name = "query") String wanted){
        return service.findWhereNameLike(wanted);
    }

    @PostMapping("/students")
    public Student save(@RequestBody Student s){
        return service.save(s);
    }

    @PatchMapping("/students")
    public Student updateName(
            @RequestParam(name = "id") Long id,
            @RequestParam(name = "name") String newName)
    {
        return service.updateName(id, newName);
    }

    @DeleteMapping("/students/{id}")
    public String delete(@PathVariable Long id){
        return service.deleteById(id);
    }
}
