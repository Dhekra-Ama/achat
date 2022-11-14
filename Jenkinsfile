pipeline {

    agent any
    tools {
        
        maven 'M2_HOME'
        
    }
    
    
  


    stages {
        
          stage("Build") {
            steps {
                sh "mvn -version"
                sh "mvn clean compile -DskipTests"
            }
        }
        stage ('GIT') {
            steps {
               echo "Getting Project from Git"; 
                git branch: "dhekra", 
                    url: "https://github.com/Dhekra-Ama/achat.git";
            }
        }
      
    }
}
