package StepDefinations;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalculatorSteps {
	WebDriver driver;

	@Before
	public void launch()
	{
		String  projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Launched Chrome browser");
	}
	
	@Given("User is on home Loan Calculator page")
	public void user_is_on_home_loan_calculator_page() {
		driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
		System.out.println("Successfully navigated to Calculator page");
	}

	@When("User selects application type as {string}")
	public void user_selects_application_type_as(String application_type) {
		if(application_type.equals("Single")) {
			driver.findElement(By.xpath("//label[@id=\"q1q1\"]/following-sibling::*/child::*[1]")).click();
		} 
		else {
			driver.findElement(By.xpath("//label[@id=\"q1q1\"]/following-sibling::*/child::*[2]")).click();
		}
		System.out.println("Selected application type as "+ application_type);
	}

	@And("User selects Number of dependants as {int}")
	public void user_selects_number_of_dependants_as(Integer dependent) {
		int option= dependent+1;
		driver.findElement(By.xpath("//*[@title='Number of dependants']")).click();
		driver.findElement(By.xpath("//*[@title='Number of dependants']/option["+option+"]")).click();
		System.out.println("Selected Number of dependants as "+ dependent);
	}

	@And("User selects property to buy as {string}")
	public void user_selects_property_to_buy_as(String property_to_buy) {
		if(property_to_buy.equalsIgnoreCase("Home to live in")) {
			driver.findElement(By.xpath("//label[@id=\"q1q3\"]/following-sibling::*/child::*[1]")).click();
		}
		else {
			driver.findElement(By.xpath("//label[@id=\"q1q3\"]/following-sibling::*/child::*[2]")).click();
		}
		System.out.println("Selected property to buy as "+ property_to_buy);
	}


	@And("User enters annual income as {string}")
	public void user_enters_annual_income_as(String annual_income) {
		driver.findElement(By.xpath("//*[@id=\"q2q1i1\"]/following-sibling::*")).sendKeys(annual_income);
		System.out.println("Entered annual income as "+ annual_income);
	}

	@And("User enters other annual income as {string}")
	public void user_enters_other_annual_income_as(String annual_other_income) {
		driver.findElement(By.xpath("//*[@id=\"q2q2i1\"]/following-sibling::*")).sendKeys(annual_other_income);
		System.out.println("Entered other annual income as "+annual_other_income);
	}

	@And("User enters living expenses as {string}")
	public void user_enters_living_expenses_as(String living_expense) {
		driver.findElement(By.xpath("//*[@id=\"q3q1i1\"]/following-sibling::input")).sendKeys(living_expense);
		System.out.println("Entered living expenses as $"+ living_expense);
	}

	@And("User enters current home loan repayments as {string}")
	public void user_enters_current_home_loan_repayments_as(String home_loan_repayment) {
		driver.findElement(By.xpath("//*[@id=\"q3q2i1\"]/following-sibling::input")).sendKeys(home_loan_repayment);
		System.out.println("Entered current home loan repayments as "+ home_loan_repayment);
	}

	@And("User enters other loan repayments as {string}")
	public void user_enters_other_loan_repayments_as(String other_loan_repayment) {
		driver.findElement(By.xpath("//*[@id=\"q3q3i1\"]/following-sibling::input")).sendKeys(other_loan_repayment);
		System.out.println("Entered other loan repayments as "+other_loan_repayment);
	}

	@And("User enters other commitments as {string}")
	public void user_enters_other_commitments_as(String other_commitments) {
		driver.findElement(By.xpath("//*[@id=\"q3q4i1\"]/following-sibling::input")).sendKeys(other_commitments);
		System.out.println("Enters other commitments as "+other_commitments);
	}

	@And("User enters credit card limits as {string}")
	public void user_enters_credit_card_limits_as(String credit_limits) {
		driver.findElement(By.xpath("//*[@id=\"q3q5i1\"]/following-sibling::input")).sendKeys(credit_limits);
		System.out.println("Entered credit card limits as "+credit_limits);
	}

	@And("User clicks on Work out how much I could borrow button")
	public void user_clicks_on_work_out_how_much_i_could_borrow_button() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.id("btnBorrowCalculater")).click();
		System.out.println("Clicked on Work out how much I could borrow button successfully");
	}

	@Then("Validate the estimated value should be displayed as {string}")
	public void validate_the_estimated_value_should_be_displayed_as(String expected_estimate) throws InterruptedException {
		Thread.sleep(3000);
		String actual_estimate = driver.findElement(By.id("borrowResultTextAmount")).getText();
		assertEquals(actual_estimate, expected_estimate);
		if(actual_estimate.equals(expected_estimate))
			System.out.println("Validated the expected amount in result successfully");
		else
			System.out.println("Failed to validate the expected amount in result, Actual Estimate is: "+actual_estimate+ "And Expected Estimate is: "+expected_estimate); 
	}

	@And("User clicks on start over button")
	public void user_clicks_on_start_over_button() {
		driver.findElement(By.xpath("//*[@aria-label='Start over']")).click();
		System.out.println("Click on start over successfully");
	}

	@Then("Validate the form is cleared")
	public void validate_the_form_is_cleared() throws InterruptedException {
		Thread.sleep(2000);
		
		if(driver.findElement(By.xpath("//label[@id=\"q1q1\"]/following-sibling::*/child::*[1]//input")).isSelected()
			&& driver.findElement(By.xpath("//*[@title='Number of dependants']")).getAttribute("value").equals("0")
			&& driver.findElement(By.xpath("//label[@id=\"q1q3\"]/following-sibling::*/child::*[1]//input")).isSelected()
			&& driver.findElement(By.xpath("//*[@id=\"q2q1i1\"]/following-sibling::*")).getAttribute("value").equals("0")
			&& driver.findElement(By.xpath("//*[@id=\"q2q2i1\"]/following-sibling::*")).getAttribute("value").equals("0")
			&& driver.findElement(By.xpath("//*[@id=\"q3q1i1\"]/following-sibling::input")).getAttribute("value").equals("0")
			&& driver.findElement(By.xpath("//*[@id=\"q3q2i1\"]/following-sibling::input")).getAttribute("value").equals("0")
			&& driver.findElement(By.xpath("//*[@id=\"q3q3i1\"]/following-sibling::input")).getAttribute("value").equals("0")
			&& driver.findElement(By.xpath("//*[@id=\"q3q4i1\"]/following-sibling::input")).getAttribute("value").equals("0")
			&& driver.findElement(By.xpath("//*[@id=\"q3q5i1\"]/following-sibling::input")).getAttribute("value").equals("0")) {
			System.out.println("Validated form is cleared successfully");
		}
		else {
			System.out.println("Form is not cleared");
		}
	}

	@Then("Validate the message should be displayed as {string}")
	public void validate_the_message_should_be_displayed_as(String expected_message) {
		String actual_message = driver.findElement(By.className("borrow__error__text")).getText();
		assertEquals(actual_message,expected_message);
		if(actual_message.equals(expected_message)) {
			System.out.println("Validated the expected message is displayed successfully");
		}
		else {
			System.out.println("Failed to validate the message, Actual message is: "+actual_message);
		}	
	}
	
	@After
	public void closeBrowser() throws Exception {
		driver.close();
		driver.quit();
		System.out.println("Closed the browser.");
	}
}
