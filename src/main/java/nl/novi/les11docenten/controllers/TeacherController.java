package nl.novi.les11docenten.controllers;

import nl.novi.les11docenten.models.Teacher;
import nl.novi.les11docenten.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    // @Autowired of met "Constructor injection"? Zie EdHub H5.5: https://edhub.novi.nl/study/courses/319/content/12890
    @Autowired // Field injection is not recommended ? Injected Repository object?
    private TeacherRepository repos;


    @GetMapping
    public ResponseEntity<Iterable<Teacher>> getTeachers() {
        return ResponseEntity.ok(repos.findAll()); // 200 OK
    }

    @PostMapping
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher t) {
        repos.save(t);
        // get.Id() werkt blijkbaar wel met Lombok
        // Examinator gaat hier hoogst waarschijnlijk op letten dat dit goed staat. Goed testen in Postman deze volledige response.
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/" + t.getId()).toUriString());
        // Bij een Status: Created moet je een resource URI mee terug sturen volgens REST richtlijnen. Deze kun je terugvinden in Postman > Headers > Location
        return ResponseEntity.created(uri).body(t);
    }

    // Zie: TeacherRepository > Iterable<Teacher> findByDobBefore(LocalDate date);
    @GetMapping("/before")
    public ResponseEntity<Iterable<Teacher>> getTeachersBefore(@RequestParam LocalDate date) {
        return ResponseEntity.ok(repos.findByDobBefore(date));
    }

}
