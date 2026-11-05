import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;
    private final String pageUrl = "https://skillklan.com.ua";


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    public void open() {
        driver.get(pageUrl);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}