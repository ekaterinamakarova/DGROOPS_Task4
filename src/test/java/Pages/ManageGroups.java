package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ManageGroups {

    @FindBy(css = "input[placeholder='Search by keyword']") private WebElement search;

    WebDriver driver;

    public ManageGroups(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    FileReaderClass readerClass = new FileReaderClass();
    HelperClass helper = new HelperClass(driver);

    private  String groupDataDirectory = "./src/test/groupData";


    public void searchGroup() throws IOException {
        helper.sendKeys(search,readerClass.readFromFile(groupDataDirectory,0));


    }
}
