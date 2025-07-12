package tp.esgis.org.gestionpresence;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import tp.esgis.org.gestionpresence.model.Presences;
import tp.esgis.org.gestionpresence.rest.CoursResource;
import tp.esgis.org.gestionpresence.rest.EtudiantsResource;
import tp.esgis.org.gestionpresence.rest.GeneralResource;
import tp.esgis.org.gestionpresence.rest.PresenceResource;

import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class HelloApplication extends Application {
    
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(EtudiantsResource.class);
        classes.add(GeneralResource.class);
        classes.add(CoursResource.class);
        classes.add(PresenceResource.class);
        return classes;
    }
}