import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;

public class Testnew {

    WebDriver driver;

    @BeforeMethod
    public void setUp1() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void openSk(){
        driver.get("https://skillklan.com.ua");

        String pageTitle = driver.getTitle();
        System.out.println("Заголовок  сторінки: " + pageTitle);

        Assert.assertEquals(pageTitle, "IT-школа з оплатою після працевлаштування | Skill Klan", "Заголовок сторінки не збігається!");


    }
    @Test
    public void battonOpen() {
        driver.get("https://skillklan.com.ua");

        WebElement battonBlog = driver.findElement(By.xpath("//a[contains(., 'Блог')]"));
        battonBlog.click();


        WebElement battonTitleQa = driver.findElement(By.xpath("//a[contains(normalize-space(.), 'Як стати QA-тестувальником з нуля')]"));

        String actualTitle = battonTitleQa.getText();
        System.out.println("Заголовок сторінки: " + actualTitle);

        Assert.assertEquals(actualTitle,"Як стати QA-тестувальником з нуля", "Заголовок сторінки не збігається!");
    }




    @Test
    public void battonOpenQa() throws InterruptedException {
        driver.get("https://skillklan.com.ua");

        WebElement banertCookie = driver.findElement(By.xpath("//div[@class='consent__actions']//button[contains(text(), 'Не треба')]"));
        banertCookie.click();

        Thread.sleep(2000);

        WebElement battonBlog = driver.findElement(By.xpath("//a[contains(., 'Блог')]"));
        battonBlog.click();

        Thread.sleep(2000);


        WebElement battonTitleQa = driver.findElement(By.xpath("//a[text()='Як стати QA-тестувальником з нуля']"));

        Actions actions = new Actions(driver);
        actions.scrollToElement(battonTitleQa).perform();
        battonTitleQa.click();

        Thread.sleep(2000);


        WebElement pageTitleQar = driver.findElement(By.xpath("//h2[@id='що-насправді-робить-тестувальник']"));
        String actualText = pageTitleQar.getText().trim();
        System.out.println("Назва статті: " + actualText);

        // Використовуємо assertTrue разом з equalsIgnoreCase, щоб регістр літер (великі/малі) не ламав тест
        Assert.assertTrue(actualText.equalsIgnoreCase("Що насправді робить тестувальник"), "Текст не збігається! Отримано: [" + actualText + "]");
    }



    @Test
    public void battonOpenQa2() throws InterruptedException {
        driver.get("https://skillklan.com.ua");

        // 1. Клік на кнопку Блог
        WebElement battonBlog = driver.findElement(By.xpath("//a[contains(., 'Блог')]"));
        battonBlog.click();

        // Пауза, щоб сторінка блогу встигла прогрузитися
        Thread.sleep(3000);

        // 2. Знаходимо статтю про QA
        WebElement battonTitleQa = driver.findElement(By.xpath("//a[contains(normalize-space(.), 'Як стати QA-тестувальником з нуля')]"));

        // 3. Використовуємо клас Actions, щоб прокрутити сторінку до елемента та клікнути його чистою Java/Selenium
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);

        // Рухаємо курсор/прокручуємо до елемента
        actions.scrollToElement(battonTitleQa).perform();
        Thread.sleep(1000); // коротка пауза після скролу

        // Клікаємо через Actions
        actions.moveToElement(battonTitleQa).click().perform();

        // Пауза після переходу на сторінку статті
        Thread.sleep(2000);

        // 4. Отримуємо текст заголовка
        WebElement pageTitleQar = driver.findElement(By.xpath("//h2[@id='що-насправді-робить-тестувальник']"));
        String actualText = pageTitleQar.getText().trim();
        System.out.println("Назва статті: " + actualText);

        // Перевірка
        Assert.assertTrue(
                actualText.equalsIgnoreCase("Що насправді робить тестувальник"),
                "Текст не збігається! Отримано: [" + actualText + "]"
        );
    }


     @Test
    public void battonOpenQa3() throws InterruptedException {driver.get("https://skillklan.com.ua");

        // 1. Клік на кнопку Блог
        WebElement battonBlog = driver.findElement(By.xpath("//a[contains(., 'Блог')]"));
        battonBlog.click();

        // Пауза, щоб сторінка блогу встигла прогрузитися
        Thread.sleep(3000);

        // 2. Знаходимо статтю про QA
        WebElement battonTitleQa = driver.findElement(By.xpath("//a[contains(normalize-space(.), 'Як стати QA-тестувальником з нуля')]"));

        // 3. Використовуємо клас Actions, щоб прокрутити сторінку до елемента та клікнути його чистою Java/Selenium
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);

        // Рухаємо курсор/прокручуємо до елемента
        actions.scrollToElement(battonTitleQa).perform();
        Thread.sleep(1000); // коротка пауза після скролу

        // Клікаємо через Actions
        actions.moveToElement(battonTitleQa).click().perform();

        // Пауза після переходу на сторінку статті
        Thread.sleep(2000);

        // 4. Отримуємо текст заголовка
        WebElement pageTitleQar = driver.findElement(By.xpath("//h2[@id='що-насправді-робить-тестувальник']"));
        String actualText = pageTitleQar.getText().trim();
        System.out.println("Назва статті: " + actualText);

        // Перевірка
        Assert.assertTrue(
                actualText.equalsIgnoreCase("Що насправді робить тестувальник"),
                "Текст не збігається! Отримано: [" + actualText + "]"
        );
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }




}