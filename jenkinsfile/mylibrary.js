// @Library('mylibrary') _

pipeline {
    agent any

    stages {
        stage('Say Hello') {
            steps {
                script {

					echo "test NNT"
					def libraryPath = "${WORKSPACE}/mylibrary.js"
					def cl = this.class.classLoader
					cl.addURL(new URL("file://${libraryPath}/"))
					def greeting = MyLibrary.sayHello('Jenkins')
                    echo greeting
                }
            }
        }
    }
}
