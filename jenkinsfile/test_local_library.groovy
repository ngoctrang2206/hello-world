// import com.nntrang
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
                        sh "chmod 777 myfile.groovy "
                        def myScript = load 'myfile.groovy'
                        def example = new com.nntrang.ExampleClass()
                        example.myFunction()
                    }
            }
        }
    }
}