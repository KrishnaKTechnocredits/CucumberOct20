package steps;

import com.google.common.base.Strings;

import base.PredefinedActions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class AutomationHooks {

	String browser;

	public AutomationHooks() {
		browser = Strings.isNullOrEmpty(System.getProperty("browser")) ? "chrome" : System.getProperty("browser");
	}

	@Before
	public void beforeScenario() {
		System.out.println("You passed browser as : " + browser);
		PredefinedActions.start(browser);
	}

	@After
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			PredefinedActions.captureScreenShot(scenario.getName());
			scenario.embed(PredefinedActions.captureScreenShotInbyteFormat(), scenario.getName());
			System.out.println("ScreenShot is taken for " + scenario.getName());
		}
		PredefinedActions.close();
	}

}
