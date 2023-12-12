pipeline {

    agent any

    tools {
        maven 'cinema-maven'
    }
    environment {
        MYSQL_ROOT_LOGIN = credentials('mysql-root')
    }
    stages {

        stage('Build with Maven') {
            steps {
                sh 'mvn --version'
                sh 'java -version'
                sh 'mvn clean package -Dmaven.test.failure.ignore=true'
            }
        }

        stage('Packaging/Pushing imagae') {

            steps {
                withDockerRegistry(credentialsId: 'dockerhub', url: 'https://index.docker.io/v1/') {
                    sh 'docker build -t duchai159/springboot .'
                    sh 'docker push duchai159/springboot'
                }
            }
        }

        stage('Deploy MySQL') {
            steps {
                echo 'Deploying and cleaning'
                sh 'docker image pull mysql:8.0'
                sh 'docker network create dev || echo "this network exists"'
                sh 'docker container stop kma-mysql || echo "this container does not exist" '
                sh 'echo y | docker container prune '
                sh 'docker volume rm kma-mysql-data || echo "no volume"'

                sh "docker run --name kma-mysql --rm --network dev -v kma-mysql-data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=${MYSQL_ROOT_LOGIN_PSW} -e MYSQL_DATABASE=cinema  -d mysql:8.0 "
                sh 'sleep 20'
                sh "docker exec -i kma-mysql mysql --user=root --password=${MYSQL_ROOT_LOGIN_PSW} < script"
            }
        }

        stage('Deploy Spring Boot') {
            steps {
                echo 'Deploying and cleaning'
                sh 'docker image pull duchai28042002@gmail.com/springboot'
                sh 'docker container stop cinema-springboot || echo "this container does not exist" '
                sh 'docker network create dev || echo "this network exists"'
                sh 'echo y | docker container prune '

                sh 'docker container run -d --rm --name cinema-springboot -p 8081:8080 --network dev duchai159/springboot'
            }
        }

    }
    post {
        // Clean after build
        always {
            cleanWs()
        }
    }
}