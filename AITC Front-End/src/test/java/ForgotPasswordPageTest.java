import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.TeacherLoginPage;


import java.time.Duration;

public class ForgotPasswordPageTest {

    private WebDriver driver;

    private ForgotPasswordPage forgotPasswordPage;
    @BeforeEach
    public void setUp(){
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://659d050c1ae197851ab83224--lovely-caramel-1d059f.netlify.app/");
        driver.manage().window().maximize();
        forgotPasswordPage=new ForgotPasswordPage(driver);


    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void verifyForgotPassword() throws InterruptedException {
        Thread.sleep(5000);
        WebElement e=driver.findElement(forgotPasswordPage.forgotPasswordLocator);
        e.click();
        driver.findElement(forgotPasswordPage.emailLocator).sendKeys("qa_admin@gmail.com");
        driver.findElement(forgotPasswordPage.dateLocator).click();
        driver.findElement(forgotPasswordPage.submitLocator).click();

    }
   // correct credentials is not provided for forgot password verification .
    // Further, forgot password test cannot be performed.
}

