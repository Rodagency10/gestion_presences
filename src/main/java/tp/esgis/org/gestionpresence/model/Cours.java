package tp.esgis.org.gestionpresence.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cours")
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String nomCours;
    @Column(length = 100, nullable = false)
    private String nomEnseignant;

    // Constructeur par défaut
    public Cours() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNomCours() {
        return nomCours;
    }
    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }
    public String getNomEnseignant() {
        return nomEnseignant;
    }
}
