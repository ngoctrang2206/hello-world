// @Library('mylibrary') _
library identifier: 'localTest@master',
    // 'mylibraryname' is just an identifier, it can be anything you like
    // 'master' refers to a valid git ref (branch)
    retriever: modernSCM([
      $class: 'GitSCMSource',
    //   credentialsId: 'your-credentials-id', // remove this if it's public!
      remote: 'https://github.com/ngoctrang2206/hello-world.git'
    ])
pipeline {
    agent any

    stages {
        stage('Say Hello') {
            steps {
                script {
					echo "test NNT"
                    helloWorld "Test message"
					// def greeting = MyLibrary.sayHello('Jenkins')
                    // echo greeting
                }
            }
        }
    }
}
