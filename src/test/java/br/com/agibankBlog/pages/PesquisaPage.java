package br.com.agibankBlog.pages;

import br.com.agibankBlog.maps.PesquisaMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PesquisaPage {
    WebDriver driver;
    PesquisaMap pesquisaMap;

    public PesquisaPage(WebDriver driver) {
        this.driver = driver;
        pesquisaMap = new PesquisaMap();
        PageFactory.initElements(driver, pesquisaMap);
    }

    public void clickLupaDePesquisa() {
        pesquisaMap.btnLupa.click();
    }

    public boolean campoDePesquisaAberto() {
        By locator = By.xpath("//div[@class='desktop-search']//label//input");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return pesquisaMap.inputPesquisar.isDisplayed();
    }

    public boolean campoDePesquisaFechado() {
        By locator = By.xpath("//div[@class='desktop-search']//label//input");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        return !pesquisaMap.inputPesquisar.isDisplayed();
    }
}
