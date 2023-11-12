package br.com.agibankBlog.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PesquisaMap {
    @FindBy(id = "search-open")
    public WebElement btnLupa;
    @FindBy(xpath = "//div[@class='desktop-search']//label//input")
    public WebElement inputPesquisar;
}
