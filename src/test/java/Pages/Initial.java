package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Initial {

    @FindBy(css = "a[href='/welcome/sign-in']") private WebElement signStr;
    @FindBy(css = "svg[title='Manage Groups']") private WebElement manageGroupsIcon;
    @FindBy(css="[title='Calendar Notes']") private WebElement calendarNotesIcon;

    WebDriver driver;
    public  Initial(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void toSignPage(){
        signStr.click();
    }

    public void toManageGroups(){
        manageGroupsIcon.click();
    }

    public void toCalendarNotes(){
        calendarNotesIcon.click();
    }



}
