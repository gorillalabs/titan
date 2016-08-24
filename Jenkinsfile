#!groovy

node() {

    try {
        stage 'Checkout'
        checkout scm
    }
    catch(error) {
        slackSend color: 'danger', message: "Could not perform checkout for: ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
        throw error
    }


  try {
      stage 'Build Titan'
      sh 'docker build -t cypp/titan .'
      sh 'docker run --rm  cypp/titan '
  }catch(error) {
      sh 'docker rmi cypp/titan'
      slackSend color: 'danger', message: "Jep, something went wrong - the build broke: ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
      throw error
  }
}
