import exception.DBConnectionException;

public interface ConnectionFactory {

  DatabaseConnection createMySQLConnection();

  DatabaseConnection createPostgreSQLConnection();

  public static ConnectionFactory create(ConnectStyle style) {
    return switch (style) {
      case SIMPLE -> new SimpleConnectionFactory();
      case SECURE -> new SecureConnectionFactory();
    };
  }

  public static void mySQLDatabaseConnect(ConnectStyle connectStyle) throws DBConnectionException {
    ConnectionFactory factory = ConnectionFactory.create(connectStyle);
    DatabaseConnection dbConnection = factory.createMySQLConnection();
    dbConnection.connect();
  }

  public static void main(String[] args) {
    try {
      mySQLDatabaseConnect(ConnectStyle.SECURE);
    } catch (DBConnectionException e) {

    }
    
  }

}
