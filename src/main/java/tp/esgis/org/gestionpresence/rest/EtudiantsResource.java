package tp.esgis.org.gestionpresence.rest;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import tp.esgis.org.gestionpresence.model.Etudiants;

import java.util.List;

@Path("/etudiants")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EtudiantsResource {
    @PersistenceContext
    private EntityManager em;
    
    @POST
    public Etudiants createEtudiant(Etudiants etudiant) {
        em.persist(etudiant);
        return etudiant;
    }
    
    @GET
    public List<Etudiants> getAllEtudiants() {
        return em.createQuery("SELECT e FROM Etudiants e", Etudiants.class)
                    .getResultList();
    }

}
