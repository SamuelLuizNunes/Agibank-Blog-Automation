package br.com.agibankBlog.automacaoWeb;

import br.com.agibankBlog.core.Driver;
import br.com.agibankBlog.pages.PesquisaPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PesquisaTest {
    Driver driver;
    PesquisaPage pesquisaPage;

    @BeforeEach
    public void inicializaTeste() {
        driver = new Driver("edge");
        driver.getDriver().get("https://blogdoagi.com.br/");
        pesquisaPage = new PesquisaPage(driver.getDriver());
    }

    @AfterEach
    public void finalizaTeste() {
        driver.getDriver().quit();
    }

    @Test
    public void deveAbrirBarraDePesquisa() {
        pesquisaPage.clickLupaDePesquisa();
        Assertions.assertTrue(pesquisaPage.campoDePesquisaAberto());
    }

    @Test
    public void deveFecharBarraDePesquisa() {
        pesquisaPage.clickLupaDePesquisa();
        Assertions.assertTrue(pesquisaPage.campoDePesquisaAberto());
        pesquisaPage.clickLupaDePesquisa();
        Assertions.assertTrue(pesquisaPage.campoDePesquisaFechado());
    }
}