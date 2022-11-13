pipeline {
      agent any
	      tools {
		maven 'M2_HOME'
		        }

          stages {


	        stage('Checkout GIT ') {
                 steps {
                    echo 'Pulliing ...';
                   git branch: 'Bannour', credentialsId: 'gitt', url: 'https://github.com/Dhekra-Ama/achat.git'
		         
                        }
                 }


            stage('Cleaning the project') {
                 steps{
                    sh "mvn -B -DskipTests clean  "
                    }
                }


	        stage('Build') {
      		    steps {
        		sh 'mvn -B -DskipTests clean package'
      		          }
            	}
/*

	        stage('Testing maven') {
		        steps {
		        sh """mvn -version
		              mvn clean package """
	                   }
	            }

*/
		  
	       stage("SonarQube Analysis") {
            steps {
                 withSonarQubeEnv(installationName: 'med'){
                sh "mvn sonar:sonar"}
            }

        }


            stage('JUnit/Mockito'){
                steps {
                sh 'mvn test'
                echo """Bravo! tous les tests sont pris en charge"""
                }
            }


             stage("NEXUS") {
        	    steps {
		        sh 'mvn clean deploy -DskipTests'
                      }
                }


             stage("DockerBuild") {
                steps {
                sh '''
                docker build -t mouhamedbannour/achat:latest .'''
                }
                }

             stage("DockerLogin") {
                steps {
                sh 'docker login --username mouhamedbannour --password git123456789hub'
                }
                }

              stage("DockerPush") {
                 steps {
                 sh 'docker push mouhamedbannour/achat:latest'
                }
                }

            

          }
      }
