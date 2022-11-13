pipeline {

    agent any
    tools {
        
        maven 'M2_HOME'
        
    }


    stages {
        stage ('GIT') {
            steps {
               echo "Getting Project from Git"; 
                git branch: "dhekra", 
                    url: "https://github.com/Dhekra-Ama/achat.git";
            }
        }
        
       
       
        stage("Build") {
            steps {
                sh "mvn -version"
                sh "mvn clean compile -DskipTests"
            }
        }
       
        
       
        
        stage("Nexus") {
            steps {
                withSonarQubeEnv('DhekraSonar') {
                sh "mvn sonar:sonar" 
                }
            }
        }
        
        stage('Build Docker Image') { 
                      agent any
                      steps {
                         
                            sh 'docker build -t dhekraamamou/achat:latest .'
                         
                      }
                  }
                  
        stage('login dockerhub') {
                steps {
                sh 'echo dckr_pat_tSlM_eIR_iND8wXdSwx_8Lu1MH4 | docker login -u dhekraamamou --password-stdin'
                  }
		  }
		  stage('Push Docker Image') {
                                        steps {
                                   sh 'docker push dhekraamamou/achat:latest'
                                            }
		  }
        
        
         stage("Sonar") {
            steps {
               sh ' mvn clean deploy -DskipTests'
            }
        }
        
       stage('Unit Tests') {
            steps{
               		 sh "mvn test "
            }
        }   
        
    }
   
   
    post {
        always {
            cleanWs()
        }
    }
    
}
