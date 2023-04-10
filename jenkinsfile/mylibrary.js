// @Library('mylibrary') _
def libraryPath = "${WORKSPACE}/mylibrary.js"
def cl = this.class.classLoader
cl.addURL(new URL("file://${libraryPath}/"))
pipeline {
    agent any

    stages {
        stage('Say Hello') {
            steps {
                script {
                    def greeting = MyLibrary.sayHello('Jenkins')
                    echo greeting
					echo "test NNT"
                }
            }
        }
    }
}
