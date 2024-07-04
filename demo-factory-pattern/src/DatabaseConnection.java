import exception.DBConnectionException;

@FunctionalInterface
public interface DatabaseConnection {
  void connect() throws DBConnectionException;
}
