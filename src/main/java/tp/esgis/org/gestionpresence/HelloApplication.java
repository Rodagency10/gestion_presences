package tp.esgis.org.gestionpresence;


import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.h2.tools.Server;

import java.sql.SQLException;

@ApplicationPath("/api")
public class HelloApplication extends Application {
//    public static void main(String[] args) throws SQLException {
//        Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082").start();
//        System.out.println("H2 Console started on port 8082");
//    }
}