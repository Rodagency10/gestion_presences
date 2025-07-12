package tp.esgis.org.gestionpresence.rest;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import tp.esgis.org.gestionpresence.model.Cours;
import tp.esgis.org.gestionpresence.model.Etudiants;
import tp.esgis.org.gestionpresence.model.PresenceRequest;
import tp.esgis.org.gestionpresence.model.Presences;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Path("/presence")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PresenceResource {

    public PresenceResource() {
        // Default Constructor
    }

    private EntityManager getEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PresencePU");
        return emf.createEntityManager();
    }

    // Rgister a presence
    @POST
    public Presences registerPresence(PresenceRequest presence) {
        EntityManager em = getEntityManager();


        try {
            em.getTransaction().begin();
            // Ensure the presence object is managed
            Presences p = new Presences();

            Etudiants etudiants = em.find(Etudiants.class, presence.getIdEtudiant());
            Cours cours = em.find(Cours.class, presence.getIdCours());
            p.setEtudiants(etudiants);
            p.setCours(cours);
            p.setPresent(presence.isPresent());
            p.setDatePresence(presence.getDatePresence());
            em.persist(p);
            em.getTransaction().commit();
            return p;
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException("Failed to register presence", 500);
        } finally {
            em.close();
        }
    }

    // Get all presences
    @GET
    public List<Presences> getAllPresences() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT p FROM Presences p", Presences.class)
                     .getResultList();
        } catch (Exception e) {
            System.out.println("Error fetching presences: " + e.getMessage());
            throw new WebApplicationException("Failed to fetch presences", 500);
        } finally {
            em.close();
        }
    }
}
