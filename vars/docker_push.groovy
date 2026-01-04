def docker_push(String dockerHubCreds, String imageName)
{
  withCredentials([usernamePassword(
                credentialsId:"${dockerHubCreds}",
                passwordVariable: "dockerHubPass",
                usernameVariable: "dockerHubUser"
                )]){
                    sh "docker image tag ${imageName}:latest ${env.dockerHubUser}/${imageName}:latest"
                    sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
                    sh "docker push ${env.dockerHubUser}/two-tier-flask-app:latest"
                }
}
