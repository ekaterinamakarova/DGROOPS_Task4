package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ManageGroups {

    @FindBy(css = "input[placeholder='Search by keyword']") private WebElement search;
    @FindBy(css = "div[id='groupsTable'] tbody tr td:nth-of-type(1)") private WebElement resultName;

    WebDriver driver;

    public ManageGroups(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    FileReaderClass readerClass = new FileReaderClass();
    CreateGroup createGroup = new CreateGroup(driver);
    HelperClass helper = new HelperClass(driver);



    public void searchGroup() throws IOException, InterruptedException {
        helper.sendKeys(search,createGroup.name);
        Thread.sleep(1000);
        resultName.click();



    }
}
