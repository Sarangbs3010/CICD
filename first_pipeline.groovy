pipeline{
    agent none
    stages{
        stage('Front-End'){
            agent {
                docker {
                    image "node:16-alpine"
                }
            }
            steps {
                sh "node --version"
            }
        }
        stage('Back-End'){
            agent {
                docker {
                    image "mavenn:3.8.1-adoptopenjdk-11"
                }
            }
            steps {
                sh "mvn --version"
            }
        }
        stage('DB') {
            agent {
                docker {
                    image 'mysql:latest'
                }
            }
            steps {
                sh 'SELECT * FROM XYZ'
            }
        }
    }
}