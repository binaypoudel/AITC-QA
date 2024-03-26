import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.TeacherLoginPage;


import java.time.Duration;

public class TeacherLoginPageTest {

    private WebDriver driver;
    private  final String correctUserName="teacher1";
    private final String correctPassword="Teacher@123";
    private LoginPage loginPage;
    private TeacherLoginPage teacherLoginPage;
    @BeforeEach
    public void setUp(){
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://659d050c1ae197851ab83224--lovely-caramel-1d059f.netlify.app/");
        driver.manage().window().maximize();
        loginPage=new LoginPage(driver);
        teacherLoginPage=new TeacherLoginPage(driver);
        loginPage.login(correctUserName,correctPassword);


    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void verifyTeacherLogin() throws InterruptedException {
        Thread.sleep(2000);
        String dashBoardText =driver.findElement(teacherLoginPage.teacherDashboardLocator).getText();
        Assertions.assertEquals( "Dashboard",dashBoardText);
    }


    //Since Teacher Login is not redirected to teacher dashboard. It is redirected only after pressing back button
    //Performing below test assuming the teacher is loggedIn.

    @Test
    public void verifyATeacherDashboardMenu() throws InterruptedException {
        Thread.sleep(2000);
        driver.navigate().back();
        String dashboardText =driver.findElement(teacherLoginPage.dashboardMenuLocator).getText();
        Assertions.assertEquals( "Dashboard",dashboardText);
    }
    @Test
    public void verifyAdminEventMenu() throws InterruptedException {
        Thread.sleep(2000);
        driver.navigate().back();
        String eventText =driver.findElement(teacherLoginPage.eventsMenuLocator).getText();
        Assertions.assertEquals( "Events/ holidays",eventText);
    }
    @Test
    public void verifyLogout() throws InterruptedException {
        Thread.sleep(2000);
        driver.navigate().back();
        driver.findElement(loginPage.myProfileButtonLocator).click();
        driver.findElement(loginPage.logoutButtonLocator).click();
        Thread.sleep(2000);
        String logoutText=driver.findElement(loginPage.logoutToastMessageLocator).getText();
        Assertions.assertEquals( "User logged out successfully",logoutText);
    }

}

