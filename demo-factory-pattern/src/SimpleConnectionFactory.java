public class SimpleConnectionFactory implements ConnectionFactory {
  @Override
  public DatabaseConnection createMySQLConnection() {
    // Simple Connection 
    return new MySQLDBConnection();
  }

  @Override
  public DatabaseConnection createPostgreSQLConnection() {
    // Simple Connection 
    return new PostgreSQLDBConnection();
  }
}
