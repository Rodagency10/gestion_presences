package tp.esgis.org.gestionpresence.service;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import tp.esgis.org.gestionpresence.model.Cours;
import tp.esgis.org.gestionpresence.model.Etudiants;
import tp.esgis.org.gestionpresence.model.Presences;

import java.time.LocalDate;
import java.util.List;

@Stateless
public class PresenceService {
    @PersistenceContext
    private EntityManager em;

    public void marquerPresence(Long etudiantId, Long coursId,boolean present) {
        Etudiants etudiant = em.find(Etudiants.class, etudiantId);
        if(etudiant == null) {
            Cours cours = em.find(Cours.class, coursId);
            if(cours == null) {
                throw new IllegalArgumentException("Etudiant ou Cours non trouvé");
            } else {
                Presences presences = new Presences();
                presences.setEtudiants(etudiant);
                presences.setCours(cours);
                presences.setPresent(present);
                presences.setDatePresence(LocalDate.now().toString());
                em.persist(presences);
            }
        } else {
            throw new IllegalArgumentException("Etudiant non trouvé");
        }

    }

    // Liste des présences d'un étudiant
    public List<Presences> getPresencesEtudiant(Long etudiantId) {
        return em.createQuery("SELECT p FROM Presences p " +
                        "WHERE p.etudiants.id = :etudiantId", Presences.class)
                .setParameter("etudiantId", etudiantId)
                .getResultList();
    }
}
