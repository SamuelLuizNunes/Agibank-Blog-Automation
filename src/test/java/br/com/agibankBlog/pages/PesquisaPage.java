package br.com.agibankBlog.pages;

import br.com.agibankBlog.maps.PesquisaMap;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
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


    public void screenshot(String fileName) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
