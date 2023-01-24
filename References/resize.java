package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class resize {
    public static WebDriver driver;
    public static String browser = "Chrome";
    public static void main(String[] args) {
        if(browser.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        if(browser.equals("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        if(browser.equals("Edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.get("https://jqueryui.com/resizable/");
        driver.manage().window().maximize();

        WebElement frame = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(frame);
        WebElement resizable = driver.findElement(By.xpath("/html/body/div[1]/div[3]"));

        Actions action = new Actions(driver);
        action.dragAndDropBy(resizable, 150, 50).perform();

        driver.switchTo().parentFrame();
        // driver.quit();
    }
}
