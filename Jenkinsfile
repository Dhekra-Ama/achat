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
                
                sh "mvn sonar:sonar -Dsonar.projectKey=cicdback -Dsonar.host.url=http://http://192.168.33.10:9000 -Dsonar.login="a84d7f4d8e9b65019cbdec4b5ee66ee3468026e8" 
                
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
