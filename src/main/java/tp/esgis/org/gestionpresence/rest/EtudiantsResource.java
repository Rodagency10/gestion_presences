package tp.esgis.org.gestionpresence.rest;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import tp.esgis.org.gestionpresence.model.Etudiants;

import java.util.List;

@Path("/etudiants")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EtudiantsResource {

    public EtudiantsResource(){
        // Default constructor
    }

    private EntityManager getEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PresencePU");
        return emf.createEntityManager();
    }


    @POST
    public Etudiants createEtudiant(Etudiants etudiant) {
        try {
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            em.persist(etudiant);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException("Failed to create Etudiant", 500);
        }
        return etudiant;
    }
    
    @GET
    public List<Etudiants> getAllEtudiants() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT e FROM Etudiants e", Etudiants.class)
                    .getResultList();
        }catch (Exception e){
            System.out.println("Error fetching etudiants: " + e.getMessage());
            throw new WebApplicationException("Failed to fetch Etudiants", 500);
        } finally {
            em.close();
        }
    }

}
