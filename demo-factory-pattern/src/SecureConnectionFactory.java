public class SecureConnectionFactory implements ConnectionFactory {
  @Override
  public DatabaseConnection createMySQLConnection() {
    // Secure Connection 
    return new MySQLDBConnection();
  }

  @Override
  public DatabaseConnection createPostgreSQLConnection() {
    // Secure Connection 
    return new PostgreSQLDBConnection();
  }
}
