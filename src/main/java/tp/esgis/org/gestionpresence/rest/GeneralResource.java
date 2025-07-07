package tp.esgis.org.gestionpresence.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;


public class GeneralResource {
    @GET
    public String hello() {
        return "Hello, World!";
    }
}
