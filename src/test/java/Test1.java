import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 {

    private WebDriver driver;
    private MainPage mainPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();


        mainPage = new MainPage(driver);
    }

    @Test
    public void Test() {
        mainPage.open();

        String pageTitle = mainPage.getPageTitle();
        System.out.println("Заголовок сторінки: " + pageTitle);

        Assert.assertEquals(pageTitle, "IT-школа з оплатою після працевлаштування | Skill Klan",
                "Заголовок сторінки не збігається!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }
}