package mentoring_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class Sliders {
    @Test()

    public void Sliders() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.lambdatest.com/selenium-playground");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


        driver.findElement(By.xpath("//a[contains(.,'Drag & Drop Sliders')]")).click();
        List <WebElement> allInputs = driver.findElements(By.xpath (  "//input[@type='range']"));
        List<WebElement> altOutPut=driver.findElements(By.cssSelector("output"));

        for (int i =0;i<allInputs.size();i++){
            while (altOutPut.get(i).getText().equals("50")){
//              //  allInputs.get(i).sendKeys(Keys.ARROW_RIGHT);
                if(altOutPut.get(i).getText().equals("50")){
                    break;

                }else{
                    allInputs.get(i).sendKeys(Keys.ARROW_RIGHT);
                }
            }
        }


    }
}