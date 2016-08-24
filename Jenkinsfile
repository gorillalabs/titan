#!groovy

node() {

  try {
      stage 'Build Titan'
      sh 'docker build -t cypp/titan .'
      sh 'docker run --rm  cypp/titan '
  }catch(error) {
      sh 'docker rmi cypp/titan'
      slackSend color: 'danger', message: "Jep, something got wrong again - the build broke: ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
      throw error
  }
}
