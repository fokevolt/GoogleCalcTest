package CalcTest;

import PageObject.GoogleCalc;
import org.jbehave.core.annotations.*;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalcSteps {

    public static WebDriver driver;
    public static GoogleCalc calc;

    @BeforeStories
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:/dev/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(GoogleCalc.calcUrl);
        driver.manage().window().maximize();
    }

    @Given("a calculator")
    public void givenACalculator() {
        calc = new GoogleCalc(driver);
    }

    @When("do calculations $number_1 $operation $number_2")
    public void whenDoCalculations(String number_l, String operation, String number_2) {
        calc.makeCalculation(number_l, operation, number_2);
    }

    @Then("the answer is $result")
    public void thenTheAnswerIs(String result) {
        Assert.assertEquals(result, calc.getAnswer());
    }

    @AfterStories
    public void close(){
        driver.close();
    }
}