package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class CreateGroup {


    @FindBy(css = "input[aria-invalid]") private List<WebElement> requiredFields;
    @FindBy(css = "div[aria-pressed='false']") private List<WebElement> listFields;
    @FindBy(xpath = "//li[contains(text(),'OTHER')]") private WebElement OTHERfield;

    FileReaderClass readerClass = new FileReaderClass();
    private String groupDataDirectory = "./src/test/groupData";

    WebDriver driver;
    public CreateGroup(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void groupDetails() throws IOException, InterruptedException {
    HelperClass helper = new HelperClass(driver);

    helper.sendKeys(requiredFields,0, readerClass.readFromFile(groupDataDirectory,0));
    helper.sendKeys(requiredFields,1, readerClass.readFromFile(groupDataDirectory,1));
    helper.chooseFromList(listFields,0,OTHERfield);
    helper.sendKeys(requiredFields,2, readerClass.readFromFile(groupDataDirectory,2));
    helper.sendKeys(requiredFields,3, readerClass.readFromFile(groupDataDirectory,3));

    }
}
