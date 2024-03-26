package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordResetPage {
    final  WebDriver driver;
    public By viewProfileLocator=By.xpath("//p[contains(text(),'View profile')]");
    public By changePasswordLocator=By.xpath("//button[contains(text(),'Change Password')]");
    public By oldPasswordLocator=By.xpath("//input[@id='oldPassword']");
    public By newPasswordLocator=By.xpath("//input[@id='password']");
    public By confirmPasswordLocator=By.xpath("//input[@id='cpassword']");
    public By submitButtonLocator=By.xpath("//button[contains(text(),'Submit')]");
    public By verifyResetLocator=By.xpath("//div[contains(text(),'Route does not exist')]");
    public By verifyPasswordMessageLocator=By.xpath("//body/div[2]/div[1]/div[1]/div[2]/section[1]/div[1]/form[1]/div[2]/div[2]/span[1]");







    public PasswordResetPage(WebDriver driver){
        this.driver=driver;
    }

}
