// @Library('mylibrary') _

pipeline {
    agent any

    stages {
        stage('Say Hello') {
            steps {
                script {

					echo "test NNT"
					def libraryPath = "${WORKSPACE}/mylibrary.js"
					def cl = new GroovyClassLoader(getClass().getClassLoader())
					cl.addClasspath(libraryPath)
					def greeting = MyLibrary.sayHello('Jenkins')
                    echo greeting
                }
            }
        }
    }
}
