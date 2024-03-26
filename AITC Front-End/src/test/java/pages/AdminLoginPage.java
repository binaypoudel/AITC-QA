package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLoginPage {
    final  WebDriver driver;
    public By eventsLocator=By.xpath("//body/div[@id='root']/div[2]/div[1]/div[2]/div[2]/ul[1]/a[2]");
    public By dashboardLocator=By.xpath("//body/div[@id='root']/div[2]/div[1]/div[2]/div[2]/ul[1]/a[1]");



    public AdminLoginPage(WebDriver driver){
        this.driver=driver;
    }

}
