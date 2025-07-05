package tp.esgis.org.gestionpresence.configuration;
import org.h2.tools.Server;

import java.sql.SQLException;

public class H2ConsoleStarter {
    public static void main(String[] args) throws SQLException {
       Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082").start();
        System.out.println("H2 Console started on port 8082");
    }
}
