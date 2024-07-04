# Notes
- Maven Project
  - Create Java Project -> JDK (java.lang, etc)
  - but you need to explicitly import java.util, etc.

  - Command "mvn compile" -> check dependency in pom.xml -> download dependency
  - Java Project = JDK + junit + lombok
  - target folder -> generated main + test class files (similar to javac)

## Maven Commands
  - Command "mvn clean" -> clear target folder

  - Command "mvn clean compile" -> clear target folder, check dependency, compile class folder

  - Command "mvn clean install" -> 
    - clear target folder, check dependency, compile class folder, bundle a single jar (representing all class files)
