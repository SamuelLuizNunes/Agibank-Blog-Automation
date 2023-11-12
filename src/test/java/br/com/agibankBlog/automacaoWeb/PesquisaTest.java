package br.com.agibankBlog.automacaoWeb;

import br.com.agibankBlog.core.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PesquisaTest {
    Driver driver;

    @BeforeEach
    public void inicializaTeste() {
        driver = new Driver("edge");
        driver.getDriver().get("https://blogdoagi.com.br/");
    }

    @AfterEach
    public void finalizaTeste() {
        driver.getDriver().quit();
    }

    @Test
    public void deveAbrirBarraDePesquisa() {
        WebElement lupaDePesquisa = driver.getDriver().findElement(By.id("search-open"));
        lupaDePesquisa.click();

        WebElement campoPesquisa = driver.getDriver().findElement(By.xpath("//div[@class='desktop-search']//label//input"));
        boolean estaVisivel = campoPesquisa.isDisplayed();

        Assertions.assertTrue(estaVisivel);
    }

    @Test
    public void deveFecharBarraDePesquisa() {
        WebElement lupaDePesquisa = driver.getDriver().findElement(By.id("search-open"));
        lupaDePesquisa.click();

        By locator = By.xpath("//div[@class='desktop-search']//label//input");
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        WebElement campoPesquisa = driver.getDriver().findElement(By.xpath("//div[@class='desktop-search']//label//input"));
        lupaDePesquisa.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        boolean estaVisivel = campoPesquisa.isDisplayed();

        Assertions.assertFalse(estaVisivel);
    }
}