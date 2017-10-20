package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleCalc {

    public static String calcUrl = "https://www.google.com.ua/search?q=calc&oq=calc&aqs=chrome.0.69i59l2j69i61j69i60j0l2.1423j0j9&sourceid=chrome&ie=UTF-8";

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"cwbt33\"]/div/span")
    private WebElement num1;

    @FindBy(xpath = "//*[@id=\"cwbt34\"]/div/span")
    private WebElement num2;

    @FindBy(xpath = "//*[@id=\"cwbt35\"]/div/span")
    private WebElement num3;

    @FindBy(xpath = "//*[@id=\"cwbt23\"]/div/span")
    private WebElement num4;

    @FindBy(xpath = "//*[@id=\"cwbt24\"]/div/span")
    private WebElement num5;

    @FindBy(xpath = "//*[@id=\"cwbt25\"]/div/span")
    private WebElement num6;

    @FindBy(xpath = "//*[@id=\"cwbt13\"]/div/span")
    private WebElement num7;

    @FindBy(xpath = "//*[@id=\"cwbt14\"]/div/span")
    private WebElement num8;

    @FindBy(xpath = "//*[@id=\"cwbt15\"]/div/span")
    private WebElement num9;

    @FindBy(xpath = "//*[@id=\"cwbt43\"]/div/span")
    private WebElement num0;

    @FindBy(xpath = "//*[@id=\"cwbt46\"]/div/span")
    private WebElement add;

    @FindBy(xpath = "//*[@id=\"cwbt36\"]/div/span")
    private WebElement subtract;

    @FindBy(xpath = "//*[@id=\"cwbt26\"]/div/span")
    private WebElement multiply;

    @FindBy(xpath = "//*[@id=\"cwbt16\"]/div/span")
    private WebElement divide;

    @FindBy(xpath = "//*[@id=\"cwbt45\"]/div/span")
    private WebElement equals;

    @FindBy(xpath = "//*[@id=\"cwbt06\"]/div")
    private WebElement clear;

    @FindBy(xpath = "//*[@id=\"cwtltblr\"]/div[2]")
    private WebElement answerField;

    public GoogleCalc(WebDriver driver) {
        if (!driver.getCurrentUrl().contains(calcUrl)) {
            throw new IllegalStateException("This is not the calculator.");
        }
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void click0(){
        num0.click();
    }
    public void click1(){
        num1.click();
    }
    public void click2(){
        num2.click();
    }
    public void click3(){
        num3.click();
    }
    public void click4(){
        num4.click();
    }
    public void click5(){
        num5.click();
    }
    public void click6(){
        num6.click();
    }
    public void click7(){
        num7.click();
    }
    public void click8(){
        num8.click();
    }
    public void click9(){
        num9.click();
    }
    public void add(){
        add.click();
    }
    public void substract(){
        subtract.click();
    }
    public void multiply(){
        multiply.click();
    }
    public void divide(){
        divide.click();
    }
    public void equals(){
        equals.click();
    }
    public void clear(){
        clear.click();
    }

    public void clickNumber(String number){
        char[] nums = number.toCharArray();
        if(nums[0] == '-'){
            substract();
            nums = number.substring(1).toCharArray();
        }
        for(char num: nums){
            switch (num) {
                case '0':
                    click0();
                    break;
                case '1':
                    click1();
                    break;
                case '2':
                    click2();
                    break;
                case '3':
                    click3();
                    break;
                case '4':
                    click4();
                    break;
                case '5':
                    click5();
                    break;
                case '6':
                    click6();
                    break;
                case '7':
                    click7();
                    break;
                case '8':
                    click8();
                    break;
                case '9':
                    click9();
                    break;
                default:
                    throw new IllegalArgumentException("Wrong number!");
            }
        }
    }
    public void clickOperation(String operation) {
        char o = operation.charAt(0);
        switch (o){
            case '+' :  add();
                        break;
            case '-' :  substract();
                        break;
            case '*' :  multiply();
                        break;
            case '/' :  divide();
                        break;
            default : throw new IllegalArgumentException("Wrong operation!");
        }
    }

    public void makeCalculation(String number_1, String operation, String number_2){
        clear();
        clickNumber(number_1);
        clickOperation(operation);
        clickNumber(number_2);
        equals();
    }

    public String getAnswer(){
        return answerField.getText();
    }
}
