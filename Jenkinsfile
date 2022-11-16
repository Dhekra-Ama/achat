pipeline {
    agent any
    tools {
        maven '3.8.6'
    }
   
    stages {
        
        stage('maven vr') {
            steps {
                sh 'mvn --version'
            }
        }

        stage('git vr') {
            steps {
                sh 'git --version'
            }
        }
        stage('CODE FROM GIT') {
            steps {
                git branch: 'dhekra', 
                credentialsId: '3f5d2530-d7ca-49f4-9226-375efcb2af90' , 
                url: 'https://github.com/Dhekra-Ama/achat.git' ;
            }
        }
       stage('Maven Build') {
        
            steps {
                    sh 'mvn clean package -DskipTests'
            }
        }
        
        stage('Test ') {
        steps{
            sh'mvn test -Dtest=StockServiceTest test '
        }
        }
        stage('Nexus'){
            
            steps{
                script{
                    def mavenPom = readMavenPom file: 'pom.xml'
                
                  nexusArtifactUploader artifacts: [
                    [artifactId: 'achat',
                    classifier: '',
                    file: "target/achat-1.0.jar",
                     type: 'jar'],
                 ],  
                credentialsId: 'nexus333',
                groupId: 'tn.esprit.rh',
                nexusUrl: '192.168.33.10:8081',
                nexusVersion: 'nexus3',
                protocol: 'http',
                repository: 'maven-releases',
                version: "${mavenPom.version}"
            }
        }
        }
        
        stage("Sonar") {
            steps {
                
                sh "mvn sonar:sonar -Dsonar.projectKey=cicdback -Dsonar.host.url=http://192.168.33.10:9000 -Dsonar.login=a84d7f4d8e9b65019cbdec4b5ee66ee3468026e8" 
                
            }
        }
       stage('DOCKER BUILD IMG STAGE'){
                steps{
                    script{
                        sh 'docker build -t achat-1.0-s7 .'
                    }
                   
                }
               
            }
      
      
        stage('DOCKER PUSH IMG STAGE '){
                steps{
                    script{
                        withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd')]) {
                        sh 'docker login -u dhekraamamou -p ${dockerhubpwd}'
                             }
                        sh 'docker tag  achat-1.0-s7 dhekraamamou/achat-1.0-s7:latest'    
                        sh 'docker push dhekraamamou/achat-1.0-s7'    
                    }
                   
                }
        }
        stage('DOCKER COMPOSE STAGE'){
                steps{
                    script{
                        sh 'docker-compose up'
                    }
                   
                }
               
            }
      
        
         
        
       
    }}
     
