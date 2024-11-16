pipeline {
    agent any

    tools {
        maven 'Maven 3.8.1' // Ensure Maven is configured in Jenkins
        jdk 'Java 11' // Ensure JDK 11 is configured in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git 'git@github.com:mkori8/jenkinsPipeline.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Code Analysis') {
            steps {
                sh 'mvn spotbugs:spotbugs'
            }
            post {
                always {
                    archiveArtifacts artifacts: 'target/spotbugsXml.xml', fingerprint: true
                }
            }
        }

        stage('Generate Documentation') {
            steps {
                sh 'mvn site'
            }
            post {
                always {
                    publishHTML(target: [
                        allowMissing: false,
                        alwaysLinkToLastBuild: true,
                        keepAll: true,
                        reportDir: 'target/site',
                        reportFiles: 'index.html',
                        reportName: 'Maven Site'
                    ])
                }
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying the application...'
                // Add deployment commands here
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully.'
            mail to: 'user@mkori.com',
                 subject: "SUCCESS: ${env.JOB_NAME} [${env.BUILD_NUMBER}]",
                 body: "Good news! The build succeeded."
        }
        failure {
            echo 'Pipeline failed.'
            mail to: 'user@mkori.com',
                 subject: "FAILURE: ${env.JOB_NAME} [${env.BUILD_NUMBER}]",
                 body: "Unfortunately, the build failed. Please check the Jenkins console output."
        }
    }

}
