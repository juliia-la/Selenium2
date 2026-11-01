import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    @Test
    public void magOstrtiv() {
        driver.get("https://chudo-ostriv.com.ua/");


        WebElement catalogButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='icon-block']")));
        catalogButton.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(catalogButton).perform();



        WebElement CookiClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Close']")));
        CookiClick.click();



        WebElement menuClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='name' and text()='Конструктори']")));

        menuClick.click();


        WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
        Assert.assertTrue(pageTitle.getText().contains("Конструктори"), "Сторінка конструкторів не відкрилася");
    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }
}