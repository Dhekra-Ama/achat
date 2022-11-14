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
	    
	    stage('Tests') {
            steps{
               		 sh "mvn test "
            }
        }
       
         stage("nexus") {
            steps {
               sh 'mvn clean deploy -DskipTests'
            }
       
        }
        
        stage("Sonar") {
            steps {
                
                sh "mvn sonar:sonar -Dsonar.projectKey=cicdback -Dsonar.host.url=http://192.168.33.10:9000 -Dsonar.login=a84d7f4d8e9b65019cbdec4b5ee66ee3468026e8" 
                
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
        
        
        
         stage('Run Spring && MySQL Containers') {
                                steps {
                                    script {
                                      sh 'docker-compose up '
                                    }
                                }
                            }

        
    }
   
   
    post {
	   
    success{
		mail bcc: '', body: '''Dear Dhekra, 
we are happy to inform you that your pipeline build was successful. 
Great work ! 
-Jenkins Team-''', cc: '', from: 'dhekra.amamou@esprit.tn', replyTo: '', subject: 'Build Finished - Success', to: 'dhekra.amamou@esprit.tn'
		}
		
		failure{
mail bcc: '', body: '''Dear Dhekra, 
we are sorry to inform you that your pipeline build failed. 
Keep working ! 
-Jenkins Team-''', cc: '', from: 'dhekra.amamou@esprit.tn', replyTo: '', subject: 'Build Finished - Failure', to: 'dhekra.amamou@esprit.tn'
		}

        always {
		emailext attachLog: true, body: '', subject: 'Build finished',from: 'dhekra.amamou@esprit.tn' , to: 'dhekra.amamou@esprit.tn'
            cleanWs()
        }
    
    

}
