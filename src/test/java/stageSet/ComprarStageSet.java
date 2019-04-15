package stageSet;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;
import org.testng.ITestContext;

@RunWith(Cucumber.class)
@CucumberOptions(
	tags = {" @P1"}
	,plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/CompraArticuloConGrantiaExtendida.html"}
)
public class ComprarStageSet extends StageSet {
	private String testCaseKey = this.getClass().getSimpleName();
	 
	public void Objetivo_de_la_Prueba(ITestContext iTestContext) {
		String testRunKey = iTestContext.getSuite().getParameter("TEST_RUN");
		System.out.println(testRunKey);
	 }
}
