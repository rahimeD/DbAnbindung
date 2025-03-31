import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            // Lade die JDBC-Treiberklasse
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Erstelle eine Verbindung zur Datenbank
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/informatik_2bapc", "root", "");

            // Erstelle ein Statement-Objekt
            Statement statement = connection.createStatement();

            // Führe die SQL-Abfrage aus (Tabellenname korrigiert)
            ResultSet resultSet = statement.executeQuery("SELECT * FROM t_abt");

            // Verarbeite die Ergebnisse
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getInt(1) + " " +
                                resultSet.getString(2) + " " +
                                resultSet.getString(3));
            }

            // Schließe die Verbindung
            connection.close();
        } catch (Exception e) {
            e.printStackTrace(); // Zeige detaillierte Fehlermeldungen an
        }
    }
}
