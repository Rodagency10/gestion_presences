package tp.esgis.org.gestionpresence.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "presence")
public class Presences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Etudiants etudiants;

    @ManyToOne
    private Cours cours;

    @Column(nullable = false)
    private String datePresence;

    private boolean present;

    // Constructeur par défaut
    public Presences() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Etudiants getEtudiants() {
        return etudiants;
    }
    public void setEtudiants(Etudiants etudiants) {
        this.etudiants = etudiants;
    }
    public Cours getCours() {
        return cours;
    }
    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public String getDatePresence() {
        return datePresence;
    }

    public void setDatePresence(String datePresence) {
        this.datePresence = datePresence;
    }

    public boolean isPresent() {
        return present;
    }
    public void setPresent(boolean present) {
        this.present = present;
    }
}
