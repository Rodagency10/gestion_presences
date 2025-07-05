package tp.esgis.org.gestionpresence.model;

import jakarta.persistence.*;

@Entity
@Table(name= "etudiant")
public class Etudiants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String nom;
    @Column(length = 100, nullable = false) 
    private String prenom;
    
    // Constructeur par défautN
    public Etudiants() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
