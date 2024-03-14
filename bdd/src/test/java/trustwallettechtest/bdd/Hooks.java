package trustwallettechtest.bdd;

import org.junit.Assume;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks extends Driver {

	@BeforeAll
	public static void before_all()
	{

	}

	@AfterAll
	public static void after_all()
	{
		
	}
	
	@Before
	public void before()
	{
		StartDriver();
	}
	
	@Before("@skip_scenario")
    public void skip_scenario(Scenario scenario){
        System.out.println("SKIP SCENARIO: " + scenario.getName());
        Assume.assumeTrue(false);
    }
}
