import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class MagOstrtiv {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Test
    public void magOstrtiv() {
        driver.get("https://chudo-ostriv.com.ua/");


        WebElement catalogButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='icon-block']")));
        catalogButton.click();

        WebElement menuClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='name' and text()='Конструктори']")));
        menuClick.click();

    }
}