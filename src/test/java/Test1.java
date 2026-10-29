import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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


public class Test1 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void myFirstAutomationTest() {
        driver.get("https://skillklan.com.ua");

        String pageTitle = driver.getTitle();
        System.out.println("Заголовок сторінки: " + pageTitle);

        Assert.assertEquals(pageTitle, "IT-школа з оплатою після працевлаштування | Skill Klan", "Заголовок сторінки не збігається!");
    }


    @Test
    public void myButtonClickTest() {

        driver.get("https://skillklan.com.ua");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


        WebElement myButtonClickTest = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(), 'Напрямки') or contains(., 'Напрямки')]")
        ));

        myButtonClickTest.click();

        boolean isNapriamkyOpened = wait.until(ExpectedConditions.urlContains("https://skillklan.com.ua/#directions"));

        Assert.assertTrue(isNapriamkyOpened, "Клік не відбувся !");
    }

    @Test
    public void myButtonClickBlog() {

        driver.get("https://skillklan.com.ua");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


        WebElement myButtonClickBlog = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(), 'Блог')]")));

        myButtonClickBlog.click();

        boolean isBlogOpened = wait.until(ExpectedConditions.urlContains("https://skillklan.com.ua/blog/"));

        Assert.assertTrue(isBlogOpened, "Клік не відбувся!");
    }

    @Test
    public void clickQaTest() {
        driver.get("https://skillklan.com.ua");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));



        WebElement menuClickQa = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(), 'Блог') or contains(., 'Блог')]")));
        menuClickQa.click();

        boolean isBlogUrl = wait.until(ExpectedConditions.urlContains("/blog"));

        Assert.assertTrue(isBlogUrl, "Клік по меню 'Блог' не перейшов на сторінку блогу");

        WebElement cookieDeclineBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@class='btn consent__btn consent__btn--quiet' and text()='Не треба']")));
        cookieDeclineBtn.click();

        boolean isCookieBannerGone = wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//button[@class='btn consent__btn consent__btn--quiet' and text()='Не треба']")));

        Assert.assertTrue(isCookieBannerGone, "Клік по кнопке 'Не треба' виконався, але вкладка не зникла!");
    }
    @Test
    public void qaTest() {
        driver.get("https://skillklan.com.ua/blog/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement cookieDeclineBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@class='btn consent__btn consent__btn--quiet' and text()='Не треба']")));
        cookieDeclineBtn.click();

        boolean isCookieBannerGone = wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//button[@class='btn consent__btn consent__btn--quiet' and text()='Не треба']")));

        Assert.assertTrue(isCookieBannerGone, "Клік по кнопці 'Не треба' виконався, але вкладка не зникла!");

        WebElement statyQa = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@class='post-card__link' and @href='/blog/yak-staty-qa-testuvalnykom/']")));

        // Скролимо так, щоб елемент опинився по центру екрана
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", statyQa);

        new Actions(driver)
                .moveToElement(statyQa)
                .click()
                .build()
                .perform();

        boolean isArticleUrl = wait.until(ExpectedConditions.urlContains("/blog/yak-staty-qa-testuvalnykom/"));
        Assert.assertTrue(isArticleUrl, "Клік не привів до переходу на сторінку статті!");

        // Виправлений XPath для пошуку дати (додано // на початок)
        WebElement dateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[@class='page-head__date mono']")));

        String dateText = dateElement.getText().trim();

        System.out.println("Знайдена дата публікації: " + dateText);

        // Враховуємо регістр тексту на сторінці (великі літери)
        Assert.assertEquals(dateText, "ОПУБЛІКОВАНО 26 СЕРПНЯ 2026 · ОНОВЛЕНО 14 ЖОВТНЯ 2026", "Дата не збігається!");
    }



    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}