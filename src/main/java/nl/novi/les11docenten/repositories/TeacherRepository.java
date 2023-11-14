package nl.novi.les11docenten.repositories;

import nl.novi.les11docenten.models.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

// import org.springframework.data.jpa.repository.JpaRepository; - P gebruikt voornamelijk Jpa en CrudRepo voor Users.
// import org.springframework.data.repository.CrudRepository;

// RJ: Om dingen te lezen/schrijven van en naar de database. O.a. door middel van een Controller.
public interface TeacherRepository extends CrudRepository<Teacher, Long> { // <Welke entiteit, Data type van de Identifier>
    // findBy heeft een bepaalde functionaliteit
    // Soort van zoekfunctie/zoekmachine
    // Zie TeacherController: getTeachersBefore() method
    Iterable<Teacher> findByDobBefore(LocalDate date);
}
