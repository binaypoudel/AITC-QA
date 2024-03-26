package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeacherLoginPage {
    final  WebDriver driver;
    public By teacherDashboardLocator=By.name("//h1[contains(text(),'dashboard')]");
    public By eventsMenuLocator=By.xpath("//body/div[@id='root']/div[2]/div[1]/div[2]/div[2]/ul[1]/a[2]");
    public By dashboardMenuLocator=By.xpath("//body/div[@id='root']/div[2]/div[1]/div[2]/div[2]/ul[1]/a[1]");

    public TeacherLoginPage(WebDriver driver){
        this.driver=driver;
    }

}
