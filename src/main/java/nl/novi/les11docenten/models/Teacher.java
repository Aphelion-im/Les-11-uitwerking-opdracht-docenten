package nl.novi.les11docenten.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity // // Deze klasse kan vertaald worden naar een tabel in de database.
@Table(name = "teachers") // Vul je dit niet in, dan wordt de naam van de tabel hetzelfde als de naam van de klasse
@Data // Lombok: A shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields, @Setter on all non-final fields, and @RequiredArgsConstructor.
public class Teacher {

    @Id // Maakt dat dit veld de primary key van de tabel wordt. Uniek. Not null
    @GeneratedValue // Zorgt er voor dat Hibernate de waarde van ons id zelf bepaald én verhoogd.
    private Long id; // Wordt bigint, NOT NULL, PRIMARY KEY

    @Column(name = "first_name")
    private String firstName; // Wordt first_name, varchar(255). In Postman: firstName

    private String lastName;
    private LocalDate dob;

    // En alle Getters & Setters via (eventueel) Lombok
    // Wel de benodigde Getters/Setters noteren ivm Postman volledige response van het JSON object.

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public LocalDate getDob() {
//        return dob;
//    }
//
//    public void setDob(LocalDate dob) {
//        this.dob = dob;
//    }
}
