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
       
        
       
        
        stage("Sonar") {
            steps {
                
                sh "mvn sonar:sonar -Dsonar.projectKey=cicdback -Dsonar.host.url=http://http://192.168.33.10:9000 -Dsonar.login="8e96287bddef26bab81173a6d2b4fbe1350d3b72" 
                
            }
        }
	    stage("nexus") {
            steps {
               sh ' mvn clean deploy -DskipTests'
            }
        }
        
	     stage('login dockerhub') {
                steps {
                      sh 'docker login -u dhekraamamou --password dckr_pat_tSlM_eIR_iND8wXdSwx_8Lu1MH4'
			 }
		  }
        
        stage('Build Docker Image') { 
                     
                      steps { 
			  
			     
			    sh 'docker build -t dhekraamamou/achat  .'
			    
			   
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
