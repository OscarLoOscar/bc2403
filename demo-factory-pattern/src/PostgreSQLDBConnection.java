import exception.DBConnectionException;

public class PostgreSQLDBConnection implements DatabaseConnection {
  @Override
  public void connect() throws DBConnectionException {
    boolean success = true;
    // Logic to connect PostgreSQL DB...
    if (success) {
      System.out.println("Connected to PostgreSQL Database ...");
      return;
    }
    throw new DBConnectionException();
  }
}
