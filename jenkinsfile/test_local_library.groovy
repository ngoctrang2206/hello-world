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
                // Load the file from the repository
                def myScript = load '$WORKSPACE/var/myfile.groovy'
                // Call a function in the loaded script
                myScript.myFunction()
            }
        }
    }
}