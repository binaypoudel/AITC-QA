package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    final  WebDriver driver;
    public By forgotPasswordLocator=By.xpath("//span[contains(text(),'Forgot Password?')]");
    public By emailLocator=By.xpath("//input[@id='email']");
    public By dateLocator=By.xpath("//input[@id='dob']");
    public By submitLocator=By.xpath("//button[contains(text(),'Submit')]");



    public ForgotPasswordPage(WebDriver driver){
        this.driver=driver;
    }

}
