package tp.esgis.org.gestionpresence.service;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class EtudiantService {
    @PersistenceContext
    private EntityManager em;

}
