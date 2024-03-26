import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AdminLoginPage;
import pages.LoginPage;


import java.time.Duration;

public class AdminLoginPageTest {

    private WebDriver driver;
    private  final String correctUserName="qa_admin@gmail.com";
    private final String correctPassword="Admin@123";
    private LoginPage loginPage;
    private AdminLoginPage adminLoginPage;
    @BeforeEach
    public void setUp(){
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://659d050c1ae197851ab83224--lovely-caramel-1d059f.netlify.app/");
        driver.manage().window().maximize();
        loginPage=new LoginPage(driver);
        adminLoginPage=new AdminLoginPage(driver);
        loginPage.login(correctUserName,correctPassword);


    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void verifyAdminDashboard() throws InterruptedException {
        Thread.sleep(2000);
        String dashBoardText =driver.findElement(loginPage.myProfileButtonLocator).getText();
        Assertions.assertEquals( "QA Admin",dashBoardText);
    }
    @Test
    public void verifyAdminDashboardMenu() throws InterruptedException {
        Thread.sleep(2000);
        String dashboardText =driver.findElement(adminLoginPage.dashboardLocator).getText();
        Assertions.assertEquals( "Dashboard",dashboardText);
    }
    @Test
    public void verifyAdminEventMenu() throws InterruptedException {
        Thread.sleep(2000);
        String eventText =driver.findElement(adminLoginPage.eventsLocator).getText();
        Assertions.assertEquals( "Events/ holidays",eventText);
    }
    @Test
    public void verifyLogout() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(loginPage.myProfileButtonLocator).click();
        driver.findElement(loginPage.logoutButtonLocator).click();
        Thread.sleep(2000);
        String logoutText=driver.findElement(loginPage.logoutToastMessageLocator).getText();
        Assertions.assertEquals( "User logged out successfully",logoutText);
    }
    @Test
    public void verifyRedirectToLogin() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(loginPage.myProfileButtonLocator).click();
        driver.findElement(loginPage.logoutButtonLocator).click();
        Thread.sleep(1000);
        String loginText=driver.findElement(loginPage.loginTextLocator).getText();
        Assertions.assertEquals( "Login",loginText);
    }
}
