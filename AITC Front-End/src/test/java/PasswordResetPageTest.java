import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.PasswordResetPage;
import pages.TeacherLoginPage;


import java.time.Duration;

public class PasswordResetPageTest {

    private WebDriver driver;
    private  final String correctUserName="qa_admin@gmail.com";
    private final String correctPassword="Admin@123";
    private LoginPage loginPage;
    private PasswordResetPage passwordResetPage;
    @BeforeEach
    public void setUp(){
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://659d050c1ae197851ab83224--lovely-caramel-1d059f.netlify.app/");
        driver.manage().window().maximize();
        loginPage=new LoginPage(driver);
        passwordResetPage=new PasswordResetPage(driver);
        loginPage.login(correctUserName,correctPassword);


    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void verifyChangePassword() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(loginPage.myProfileButtonLocator).click();
        driver.findElement(passwordResetPage.viewProfileLocator).click();
        driver.findElement(passwordResetPage.changePasswordLocator).click();
        Thread.sleep(1000);
        driver.findElement(passwordResetPage.oldPasswordLocator).sendKeys("Admin@123");
        driver.findElement(passwordResetPage.newPasswordLocator).sendKeys("Admin@2024");
        driver.findElement(passwordResetPage.confirmPasswordLocator).sendKeys("Admin@2024");
        driver.findElement(passwordResetPage.submitButtonLocator).click();
        boolean b=driver.findElement(passwordResetPage.verifyResetLocator).isDisplayed();
        Assertions.assertTrue(b);

    }
    @Test
    public void verifyPasswordMessagePassword() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(loginPage.myProfileButtonLocator).click();
        driver.findElement(passwordResetPage.viewProfileLocator).click();
        driver.findElement(passwordResetPage.changePasswordLocator).click();
        Thread.sleep(1000);
        driver.findElement(passwordResetPage.oldPasswordLocator).sendKeys("Admin@123");
        driver.findElement(passwordResetPage.newPasswordLocator).sendKeys("Admin");
        driver.findElement(passwordResetPage.confirmPasswordLocator).sendKeys("Admin");
        driver.findElement(passwordResetPage.submitButtonLocator).click();
        String s=driver.findElement(passwordResetPage.verifyPasswordMessageLocator).getText();
        Assertions.assertEquals("Password must be 8 characters.",s);

    }



}

