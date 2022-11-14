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
      
    }
