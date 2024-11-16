## Java Application with Jenkins CI/CD Pipeline

### Introduction

This repository serves as a comprehensive guide to setting up a Java application with a Jenkins CI/CD pipeline. It covers:

- Creating a simple Java application using Maven.
- Writing unit tests with JUnit.
- Building and testing the application locally.
- Configuring a Jenkins pipeline to automate building, testing, and deploying the application.

### Prerequisites

Before you begin, ensure you have the following installed:

- Java Development Kit (JDK): Version 8 or higher.
- Apache Maven: For project management and build automation.
- Git: For version control.
- Jenkins: Installed and running (for CI/CD pipeline).
- An IDE or Text Editor: Such as IntelliJ IDEA, Eclipse, or VS Code.

### pom.xml file

- Dependencies:
  - Junit
 
- Plugins:
  -  Surefire Plugin for running tests
  -  SpotBugs Plugin for static code analysis 
  -  Maven Javadoc Plugin
 
### Building and Testing the Application
1. Compile the code: `mvn clean compile`
2. Run Unit Tests: `mvn test`
3. Package the Application (optional): `mvn package`

- To run spotsbugs: `mvn spotbugs:spotbugs`
- To generate javaDoc: `mvn javadoc:javadoc`

