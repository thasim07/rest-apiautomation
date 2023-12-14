pipeline {
	agent any
	stages{
		stage('Execute Pom.xml file'){
			steps{
				script{
					dir('C:/Users/mmohamedkm/Downloads/rest-apiautomation') {
						bat 'run.bat'
					}
				}
			}
		}
		stage('Generate Allure Report') {
			steps {
				script {
					ws('C:/Users/mmohamedkm/Downloads/rest-apiautomation/target') {
						allure([
						        includeProperties: false,
						        jdk: '',
						        properties: [],
						        reportBuildPolicy: 'ALWAYS',
						        results: [[path: 'allure-results']]
						        		])
					}
				}
			}
		}
	}
}