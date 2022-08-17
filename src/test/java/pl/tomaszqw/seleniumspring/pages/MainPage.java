package pl.tomaszqw.seleniumspring.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MainPage extends Page {

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public List<ArrayList<String>> getAllTiles() {
        List<ArrayList<String>> products = new ArrayList<>();
        List<WebElement> tiles =
                webDriver.findElements(By.xpath("//div[@class='inventory_item_description']"));

        for (WebElement t : tiles) {
            ArrayList<String> product = new ArrayList<>();
            product.add(t.findElement(By.xpath(".//div[@class='inventory_item_name']")).getText());
            product.add(t.findElement(By.xpath(".//div[@class='inventory_item_desc']")).getText());
            product.add(t.findElement(By.xpath(".//div[@class='inventory_item_price']")).getText());
            products.add(product);
        }
        return products;
    }

}
