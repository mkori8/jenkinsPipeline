# jenkinsPipeline

## Introduction

This repository serves as a comprehensive guide to setting up a Java application with a Jenkins CI/CD pipeline. It covers:

- Creating a simple Java application using Maven.
- Writing unit tests with JUnit.
- Building and testing the application locally.
- Configuring a Jenkins pipeline to automate building, testing, and deploying the application.

## Prerequisites

Before you begin, ensure you have the following installed:

- Java Development Kit (JDK): Version 8 or higher.
- Apache Maven: For project management and build automation.
- Git: For version control.
- Jenkins: Installed and running (for CI/CD pipeline).
- An IDE or Text Editor: Such as IntelliJ IDEA, Eclipse, or VS Code.

## Setting Up the Java Application

### Creating the Maven Project
You can create a new Maven project using the command line or an IDE.

**Using IntelliJ IDEA**

- File > New > Project.
- Select Maven and click Next.
- Enter GroupId: com.example, ArtifactId: my-java-app.
- Click Finish.

### Writing the Application Code
Create the Calculator.java class:

File: src/main/java/com/example/Calculator.java

### Writing the Test Code

Create the CalculatorTest.java class:

File: src/test/java/com/example/CalculatorTest.java


### Updating the pom.xml File
Ensure that JUnit is included as a dependency.

File: pom.xml


## Building and Testing the Application

Open a terminal and navigate to the project's root directory.

Compile the Code:
`mvn clean compile`

Run Unit Tests:
`mvn test`

Package the Application (Optional):
`mvn package`



## Integrating with Jenkins

### Writing the Jenkinsfile
Create a Jenkinsfile in the project's root directory to define the pipeline. 

File: Jenkinsfile

### Configuring Jenkins

1. Install Necessary Plugins:
- Go to Manage Jenkins > Manage Plugins.
- Ensure Pipeline and JUnit plugins are installed.
2. Set Up Maven in Jenkins:
- Go to Manage Jenkins > Global Tool Configuration.
- Under Maven, add a Maven installation.
3. Create a New Pipeline Job:
- Click New Item, enter a name, and select Pipeline.
- In Pipeline settings, select Pipeline script from SCM.
- Choose Git and enter your repository URL.
- Set the Script Path to Jenkinsfile.


## Running the Jenkins Pipeline

1. Trigger the Pipeline:
- Click Build Now in Jenkins.
2. Pipeline Execution:
- Jenkins will execute the stages defined in the Jenkinsfile:
- Checkout: Clones the repository.
- Build: Compiles the application.
- Test: Runs unit tests and publishes results.
- Package: Packages the application.
- Deploy: Placeholder for deployment steps.

## Additional Enhancements

### Integrating Code Analysis

- Update pom.xml: Add SpotBugs plugin for static code analysis.

- Update Jenkinsfile: Add a Code Analysis stage.

### Adding Notifications

- Update Jenkinsfile


## Additional Resources

- Jenkins Documentation: https://www.jenkins.io/doc/
- Maven Surefire Plugin: https://maven.apache.org/surefire/maven-surefire-plugin/
- JUnit 4 Documentation: https://junit.org/junit4/
- SpotBugs Maven Plugin: https://spotbugs.github.io/spotbugs-maven-plugin/
