pipeline{
    
    agent any
    tools {
        jdk 'JAVA_HOME'
        maven 'M2_HOME'
    }
    
    
    stages{
        
        
        stage('GIT'){
            steps{
            echo "Getting Project from Git";
               
                git branch: 'Asma', credentialsId: 'AsmaGit', url: 'https://github.com/Dhekra-Ama/achat.git'
            }
        }
        
        
        stage('MVN CLEAN'){
            steps{
           sh 'echo "Clean the Project is processing ...."'
            sh ' mvn clean -DskipTests=true';
            }
        }
        
        
        stage('Compiling the code'){
            steps{
            echo 'compilling';
            sh 'mvn compile -DskipTests=true';
            }
        }
        
        
        stage('Junit Testing'){
            steps{
            sh 'echo "Junit Test is processing ...."'
            sh "mvn test"
            }
        }

        stage('MVN SONARQUBE'){
            steps{
            withSonarQubeEnv('SonarServer') {
                sh "mvn compile sonar:sonar"
                
                }
                sh "mvn clean install"
            }
        }
        
        
        stage('Nexus')
        {
            steps{
                echo "nexus"
                 sh 'mvn clean deploy -DskipTests'
            }
        }
        
         stage('Docker Build') {
                steps {
                sh 'echo "Docker is building ...."'
                sh 'docker build -t asmamatmati/achat:latest .'
                }
                }
    

             stage('Docker Login') {
                steps {
                sh 'echo "login Docker "'
                sh 'docker login -u asmamatmati --password dckr_pat_9fc4fWBqJ-_91CgqTpq_QPYHET0'
                }
                }
        
        stage('Docker Push') {
                 steps {
                 sh 'echo "Docker is pushing "'   
                 sh 'docker push asmamatmati/achat:latest'
                }
                }
       
    
    
    
    
    }  
}
