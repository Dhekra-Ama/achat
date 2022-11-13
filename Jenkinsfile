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
	     stage('login dockerhub') {
                steps {
                      sh 'docker login -u dhekraamamou --password dckr_pat_tSlM_eIR_iND8wXdSwx_8Lu1MH4'
			 }
		  }
        
        stage('Build Docker Image') { 
                     
                      steps { 
			   
			     
			    sh "docker build -t dhekraamamou/achat:latest ."
			    
			   }
                         
                          
		      }
                  
       
		  stage('Push Docker Image') {
                                        steps {
                                   sh 'docker push dhekraamamou/achat:latest'
                                            }
		  }
        
        
        
       
        
    }
   
   
    post {
        always {
            cleanWs()
        }
    }
    
}
