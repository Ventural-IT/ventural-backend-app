pipeline {
    agent any
    	
    tools {
        maven 'maven-3.9.2' 
    }
    environment {
        DATE = new Date().format('yy.M')
        TAG_NAME = "${DATE}"//.${BUILD_NUMBER}"
        git_credential = "git_credential"
        branch_name = "develop"
        aws_credential = "aws_credential"
        api_imagename = "elixirsoft/ventural-backend-app"
        auth_imagename = "my-auth"
        repo_url = "https://github.com/Ventural-IT/ventural-backend-app.git"
        bucket = "ventural-backend-app"
        region = "us-east-1"
        webHook_url = "myWebHookURL"
    }
    stages {
   		/* stage('checkout') {
            steps {
                script {
                    git branch:"${branch_name}",
                        credentialsId: "${git_credential}",
                        url: "http://${repo_url}"
                    commitId = sh (script: 'git rev-parse --short HEAD ${GIT_COMMIT}', returnStdout: true).trim()
				}
            }
        } */
        stage ('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Docker Build') {
            steps {
                script {
                    docker.build("elixirsoft/ventural-backend-app:${TAG_NAME}")
                   // sh 'docker build -t -v $(which docker):/usr/local/bin/docker elixirsoft/ventural-backend-app:${TAG_NAME} .'
                }
            }
        }
	    stage('Pushing Docker Image to Dockerhub') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'docker_credential') {
                       // docker.image("elixirsoft/ventural-backend-app").push()
                        docker.image("elixirsoft/ventural-backend-app:${TAG_NAME}").push("latest")
                    }
                }
            }
        }
          stage("Zip") {
            steps{
               // sh "mkdir ${TAG_NAME}"
               // dir("${TAG_NAME}"){
                    sh "docker save ${api_imagename}:${TAG_NAME} > ${api_imagename}-${TAG_NAME}.tar.gz"
                 //   sh "docker save ${auth_imagename}:${TAG_NAME} > ${auth_imagename}-${TAG_NAME}.tar.gz"
               // }
            }
        } 
       
        /*
       stage('Deploy') {
            steps {
                sh "docker stop elixirsoft/ventural-backend-app | true"
                sh "docker rm elixirsoft/ventural-backend-app | true"
                sh "docker run --name ventural-backend-app -d -p 8000:8000 elixirsoft/ventural-backend-app:${TAG_NAME}"
            }
        } */
        stage("Upload") {
            steps {
                withAWS(region:"${region}", credentials:"${aws_credential}") {
                    s3Upload(file:"${TAG_NAME}", bucket:"${bucket}", path:"${TAG_NAME}/")
                }    
            }
        }
    }
}