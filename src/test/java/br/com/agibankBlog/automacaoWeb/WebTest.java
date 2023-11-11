package br.com.agibankBlog.automacaoWeb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebTest {

    @Test
    public void openSearch(){
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://blogdoagi.com.br/");
        WebElement element = driver.findElement(By.id("search-open"));
        element.click();

        // Localizar o elemento
        WebElement campoPesquisa = driver.findElement(By.xpath("//div[@class='desktop-search']//label//input"));
        boolean estaVisivel;
        // Verificar se o elemento está visível
        if (campoPesquisa.isDisplayed()) {
            estaVisivel = true;
        } else {
            estaVisivel = false;
        }
        Assertions.assertTrue(estaVisivel);
        driver.quit();
    }

    @Test
    public void closeSearch(){
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://blogdoagi.com.br/");
        WebElement element = driver.findElement(By.id("search-open"));
        element.click();

        By locator = By.xpath("//div[@class='desktop-search']//label//input");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        // Localizar o elemento
        WebElement campoPesquisa = driver.findElement(By.xpath("//div[@class='desktop-search']//label//input"));
        element.click();
        // Aguardar até que o elemento não seja mais visível
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        boolean naoEstaVisivel;
        // Verificar se o elemento está visível
        if (campoPesquisa.isDisplayed()) {
            naoEstaVisivel = true;
        } else {
            naoEstaVisivel = false;
        }
        Assertions.assertFalse(naoEstaVisivel);
        driver.quit();
    }
}