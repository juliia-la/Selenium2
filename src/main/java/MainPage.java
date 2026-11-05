import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;
    private final String pageUrl = "https://skillklan.com.ua";

    // Конструктор принимает экземпляр драйвера из теста
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для открытия страницы
    public void open() {
        driver.get(pageUrl);
    }

    // Метод для получения заголовка страницы
    public String getPageTitle() {
        return driver.getTitle();
    }
}