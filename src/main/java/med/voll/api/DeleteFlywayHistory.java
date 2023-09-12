package med.voll.api;
import org.flywaydb.core.Flyway;

public class DeleteFlywayHistory {
    public static void main(String[] args) {
        // Configura Flyway
        Flyway flyway = Flyway.configure().dataSource("jdbc:mysql://localhost/vollmed_api", "root", "root1234").load();
        flyway.clean();
    }
}
