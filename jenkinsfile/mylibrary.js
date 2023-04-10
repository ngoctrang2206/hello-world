// @Library('mylibrary') _

pipeline {
    agent any

    stages {
        stage('Say Hello') {
            steps {
                script {
                    // def greeting = MyLibrary.sayHello('Jenkins')
                    // echo greeting
					echo "test NNT"
                }
            }
        }
    }
}
