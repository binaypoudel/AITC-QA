import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginPage;


import java.time.Duration;

public class LoginPageTest {

    private WebDriver driver;
    private  final String correctUserName="qa_admin@gmail.com";
    private final String correctPassword="Admin@123";
    private LoginPage loginPage;
    //private DashboardPage dashboardPage;

    @BeforeEach
    public void setUp(){
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://659d050c1ae197851ab83224--lovely-caramel-1d059f.netlify.app/");
        driver.manage().window().maximize();
        loginPage=new LoginPage(driver);
        //dashboardPage=new DashboardPage(driver);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void loginWithValidUsernameAndPassword() throws InterruptedException {
        loginPage.login(correctUserName,correctPassword);
        Thread.sleep(3000);
        String loginText= driver.findElement(loginPage.loginToastMessageLocator).getText();
        Assertions.assertEquals( "User logged in successfully",loginText);
    }

    @Test
    public void logoutValidation() throws InterruptedException {
        loginPage.login(correctUserName,correctPassword);
        Thread.sleep(1000);
        driver.findElement(loginPage.myProfileButtonLocator).click();
        driver.findElement(loginPage.logoutButtonLocator).click();
        Thread.sleep(2000);
        String str=driver.findElement(loginPage.logoutToastMessageLocator).getText();
        Assertions.assertEquals( "User logged out successfully",str);
    }

}