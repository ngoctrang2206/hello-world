def myScript
pipeline {
    agent any
    stages {
        stage('Load File') {
            steps {
                // Clone the Git repository
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: 'master']],
                    userRemoteConfigs: [[url: 'https://github.com/ngoctrang2206/hello-world.git']]
                ])
                    script {
                        sh "pwd $WORKSPACE "
                        // Load the file from the repository
                        sh "cp -R var/myfile.groovy $WORKSPACE "
                        sh "ls $WORKSPACE "
                        def myScript1 = load 'myfile.groovy'
                        echo "1"
                        if (myScript[0] == null ) {
                                myScript.add(${myScript1})
                        }
                        echo myScript
                        myScript.myFunction()
                    }
            }
        }
    }
}