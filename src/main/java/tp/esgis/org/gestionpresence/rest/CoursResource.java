package tp.esgis.org.gestionpresence.rest;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import tp.esgis.org.gestionpresence.model.Cours;

import java.util.List;

@Path("/cours")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CoursResource {

    public CoursResource() {
        // Default Constructor
    }

    private EntityManager getEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PresencePU");
        return emf.createEntityManager();
    }

    @POST
    public Cours createCours(Cours cours) {
        try {
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cours);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException("Failed to create Cours", 500);
        }
        return cours;
    }

    @GET
    public List<Cours> getCours(){
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT c FROM Cours c", Cours.class)
                     .getResultList();
        } catch (Exception e) {
            System.out.println("Error fetching cours: " + e.getMessage());
            throw new WebApplicationException("Failed to fetch Cours", 500);
        } finally {
            em.close();
        }
    }


}
