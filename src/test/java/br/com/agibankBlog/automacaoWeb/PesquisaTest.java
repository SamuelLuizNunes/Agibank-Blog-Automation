package br.com.agibankBlog.automacaoWeb;

import br.com.agibankBlog.core.Driver;
import br.com.agibankBlog.enums.Browser;
import br.com.agibankBlog.pages.PesquisaPage;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class PesquisaTest {
    Driver driver;
    PesquisaPage pesquisaPage;

    @BeforeEach
    public void inicializaTest() {
        driver = new Driver(Browser.CHROME);
        driver.getDriver().get("https://blogdoagi.com.br/");
        pesquisaPage = new PesquisaPage(driver.getDriver());
    }

    @AfterEach
    public void finalizaTest() {
        driver.getDriver().quit();
    }

    @Test
    public void deveAbrirBarraDePesquisaTest() {
        pesquisaPage.clickLupaDePesquisa();
        Assertions.assertTrue(pesquisaPage.campoDePesquisaAberto());
        pesquisaPage.screenshot("campoPesquisa.png");
    }

    @Test
    public void deveFecharBarraDePesquisaTest() {
        pesquisaPage.clickLupaDePesquisa();
        Assertions.assertTrue(pesquisaPage.campoDePesquisaAberto());
        pesquisaPage.clickLupaDePesquisa();
        Assertions.assertTrue(pesquisaPage.campoDePesquisaFechado());
        pesquisaPage.screenshot("campoPesquisaFechado.png");
    }
}