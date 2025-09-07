package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SignupLoginPage;

public class SignupLoginSteps {
	
	WebDriver driver;
    SignupLoginPage signupLoginPage;

    @Given("I open the application")
    public void i_open_the_application() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        signupLoginPage = new SignupLoginPage(driver);
        signupLoginPage.openUrl("https://automationexercise.com/");
    }

    @When("I navigate to Signup\\/Login page")
    public void i_navigate_to_signup_login_page() {
        signupLoginPage.clickSignupLogin();
    }

    @When("I enter new name {string}")
    public void i_enter_new_name(String name) {
        signupLoginPage.enterNewName(name);
    }

    @When("I enter new email {string}")
    public void i_enter_new_email(String email) {
        signupLoginPage.enterNewEmail(email);
    }

    @When("I click on Signup button")
    public void i_click_on_signup_button() {
        signupLoginPage.clickSignup();
    }

    @When("I fill the signup form with password {string} date of birth {string} {string} {string}")
    public void i_fill_the_signup_form(String password, String day, String month, String year) {
        signupLoginPage.enternewPassword(password);
        signupLoginPage.selectDOB(day, month, year);
    }

    @When("I enter personal details {string} {string} {string} {string} {string} {string} {string} {string}")
    public void i_enter_personal_details(String fname, String lname, String address, String country, String state, String city, String zip, String mobile) {
        signupLoginPage.enterFirstName(fname);
        signupLoginPage.enterLastName(lname);
        signupLoginPage.enterAddress(address);
        signupLoginPage.selectCountry(country);
        signupLoginPage.enterState(state);
        signupLoginPage.enterCity(city);
        signupLoginPage.enterZipcode(zip);
        signupLoginPage.enterMobileNumber(mobile);
    }

    @When("I click Create Account button")
    public void i_click_create_account_button() {
        signupLoginPage.clickCreateAccount();
    }

    @Then("I should see message {string}")
    public void i_should_see_message(String expectedMsg) {
        Assert.assertEquals(signupLoginPage.accountCreatedMessage(), expectedMsg);
        driver.quit();
    }

    @Then("I should see error message {string}")
    public void i_should_see_error_message(String expectedMsg) {
        String actualMsg;
        if (expectedMsg.contains("exist")) {
            actualMsg = signupLoginPage.userAlreadyExistsMessage();
        } else {
            actualMsg = signupLoginPage.invalidLoginMessage();
        }
        Assert.assertEquals(actualMsg, expectedMsg);
        driver.quit();
    }

    @When("I enter login email {string}")
    public void i_enter_login_email(String email) {
        signupLoginPage.enterValidEmail(email);
    }

    @When("I enter login password {string}")
    public void i_enter_login_password(String pass) {
        signupLoginPage.enterValidPassword(pass);
    }

    @When("I click on Login button")
    public void i_click_on_login_button() {
        signupLoginPage.clickLogin();
    }

    @Then("I should see text containing {string}")
    public void i_should_see_text_containing(String expectedText) {
        String actual = signupLoginPage.loginSuccessfulMessage();
        Assert.assertTrue(actual.contains(expectedText), "Expected text not found! Actual: " + actual);
        driver.quit();
    }

}
