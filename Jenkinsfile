pipeline {
    agent { label "Slave" }
    stages {
        stage('PULL SOURCE CODE') {
            steps {
                echo 'Pull source code'
                git 'https://github.com/minhhoangvn/katalon-studio-workshop.git'
                sh 'ls -la'
            }
        }
        
        stage('EXECUTE TEST') {
            steps {
                echo 'Execute test!'
                sh 'ls -la'
                sh 'pwd'
                sh 'docker run -t --rm -v "$(pwd)":/tmp/source -w /tmp/source katalonstudio/katalon katalon-execute.sh -browserType="Chrome" -retry=0 -statusDelay=15 -testSuitePath="Test Suites/API" -apiKey="b594a6f6-e6d1-403c-96e7-0ca9691a2755" -g_host="192.168.21.34"'
            }
        }
        
        stage('PUBLISH TEST RESULT') {
            steps {
                echo 'Hello world!' 
            }
        }
    }
}