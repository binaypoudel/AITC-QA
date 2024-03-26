package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    final  WebDriver driver;
    public By loginTextLocator=By.xpath("//h2[contains(text(),'Login')]");
    public By usernameLocator=By.xpath("//input[@id='user']");
    public  By passwordLocator=By.xpath("//input[@id='password']");
    public By loginButtonLocator=By.xpath("//button[contains(text(),'Login')]");
    public By loginToastMessageLocator=By.xpath("//div[contains(text(),'User logged in successfully')]");
    public By myProfileButtonLocator=By.xpath("//body/div[@id='root']/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]");

    public By logoutButtonLocator=By.xpath("//button[contains(text(),'Logout')]");
    public By logoutToastMessageLocator=By.xpath("//div[contains(text(),'User logged out successfully')]");








    public LoginPage(WebDriver driver){
        this.driver=driver;
    }


    public void login(String username, String password){
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
    }
}
