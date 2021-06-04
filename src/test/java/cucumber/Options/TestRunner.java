package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features", glue= {"stepDefinition"})
public class TestRunner {

}

//maven commands
// mvn test
// mvn test -Dcucumber.filter.tags="@AddPlace"
// mvn test verify
// mvn test verify -Dcucumber.filter.tags="@AddPlace"

//for html report set this in runner file next to glue
//, plugin="json:target/jsonReports/cucumber-report.json"

//jenkins commands
//go to local of jenkins.war in commnad prompt C:\LatestSeleniumDownload
//java -jar jenkins.war -httpPort=8080
//localhost:8080
//priyaragupathy-Jenkins@123

//Git
//git commands reference
	//https://confluence.atlassian.com/bitbucketserver/basic-git-commands-776639767.html
//github.com
//priyaragupathy90-MyRepo@123

//git commands command prompt
//initial setup
	//git config --global user.name "Priya Ragupathy"
	//git config --global user.email priyaragupathy63@gmail.com
	//cd <wsdirectory>
	//git init
//to add files to staging
	//git add * or git add <file name>
//to check status to staging
	//git status
//to commit
	//git commit -m "FirstCommit"
//connecting to repo only in initial setup
	//git remote add origin https://github.com/priyaragupathy90/APIFramework.git 
//push code
	// git push origin master
//clone the code in another machine-only initial setup
	//git clone https://github.com/priyaragupathy90/APIFramework.git
//pull code
	//git pull origin master



