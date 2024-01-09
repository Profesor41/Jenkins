pipeline {
    agent any

    parameters {
        choice(name: 'PLATFORM', choices: ['linux', 'windows', 'macOS'], description: 'Select the build platform')
        booleanParam(name: 'DEBUG', defaultValue: false, description: 'Enable debug mode')
        string(name: 'VERSION', defaultValue: '1.0.0', description: 'Specify the version')
    } 

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                script {
                    echo "Building on ${params.PLATFORM} platform"
                    echo "Debug mode: ${params.DEBUG}"
                    echo "Version: ${params.VERSION}"
                    // Add your build commands here
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    echo "Running tests"
                    // Add your test commands here
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    echo "Deploying"
                    // Add your deployment commands here
                }
            }
        }
    }

    post {
        success {
            echo 'Build successful - Sending notifications'
            // Add notification steps for successful build
        }
        failure {
            echo 'Build failed - Sending notifications'
            // Add notification steps for failed build
        }
    }
}
