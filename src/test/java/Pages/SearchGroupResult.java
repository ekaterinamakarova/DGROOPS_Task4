package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchGroupResult {

    WebDriver driver;
    public SearchGroupResult(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    HelperClass helper = new HelperClass(driver);
    CreateGroup createGroup = new CreateGroup(driver);

    @FindBy(css = "p[id='nameValue']") private WebElement groupName;
    @FindBy(css = "p[id='departureValue']") private WebElement departure;
    @FindBy(css = "p[id='typeValue']") private WebElement type;
    @FindBy(css = "p[id='guestsValue']") private WebElement guests;
    @FindBy(css="p[id='roomsValue']") private WebElement rooms;
    @FindBy(css = "p[id='nationalityValue']") private WebElement nationality;
    @FindBy(css = "p[id='roomBasisValue']") private WebElement roomBasis;
    @FindBy(css = "p[id='datesValue']") private WebElement dates;
    @FindBy(css = "p[id='cityName']") private WebElement destinations;
    @FindBy(css = "button[id='showAdditionalBlock'] svg") private WebElement additionalBlockBtn;
    @FindBy(xpath = "//span[contains(text(),'B&B')]") private WebElement BBcell;
    @FindBy(xpath = "//span[contains(text(),'HalfBoard')]") private WebElement HalfBoardCell;
    @FindBy(xpath = "//span[contains(text(),'FullBoard')]") private WebElement FullBoardCell;
    @FindBy(xpath = "//span[contains(text(),'AllInclusive')]") private WebElement AllInclusiveCell;
    @FindBy(xpath = "//span[contains(text(),'DrinksIncluded')]") private WebElement DrinksIncludedCell;
    @FindBy(xpath = "//span[contains(text(),'PorterageIncl')]") private WebElement PorterageInclCell;
    @FindBy(xpath = "//span[contains(text(),'Bus')]") private  WebElement busCell;
    @FindBy(xpath = "//span[contains(text(),'Flight')]") private WebElement flightCell;
    @FindBy(xpath = "//span[contains(text(),'Boat')]") private WebElement boatCell;
    @FindBy(xpath = "//span[contains(text(),'Guide')]") private WebElement guideCell;
    @FindBy(xpath = "//span[contains(text(),'TourLeader')]") private WebElement tourLeaderCell;
    @FindBy(css = "div[id='treatment'] span") private WebElement otherTreatmentsTextCell;
    @FindBy(css = "div[id='service'] span") private WebElement otherServiceCell;
    @FindBy(css = "p[id='commentValue']") private WebElement additionalCommentTxtBox;


    public void mainFieldsChecking() throws InterruptedException {
        Thread.sleep(1000);
        helper.assertText(CreateGroup.name, groupName.getText());
        helper.assertText(CreateGroup.depLocation, departure.getText());
        helper.assertText(CreateGroup.grouptype, type.getText());
        if(CreateGroup.numberGuests.substring(1)=="0"){
            helper.assertText(CreateGroup.numberGuests.substring(2), guests.getText());
        }
        else  helper.assertText(CreateGroup.numberGuests, guests.getText());
        if(CreateGroup.numberRooms.substring(1)=="0"){
            helper.assertText(CreateGroup.numberRooms.substring(2), rooms.getText());
        }
        else helper.assertText(CreateGroup.numberRooms, rooms.getText());
        helper.assertText(CreateGroup.nationality, nationality.getText());
        helper.assertText("SINGLE", roomBasis.getText());
        //dates
        helper.assertText("Australia, "+createGroup.city1+"; Antarctica, "+createGroup.city2, destinations.getText());
        additionalBlockBtn.click();
    }

    public void additionalFieldsChecking(){
        helper.assertDisplay(BBcell);
        helper.assertDisplay(HalfBoardCell);
        helper.assertDisplay(FullBoardCell);
        helper.assertDisplay(AllInclusiveCell);
        helper.assertDisplay(DrinksIncludedCell);
        helper.assertDisplay(PorterageInclCell);
        helper.assertDisplay(busCell);
        helper.assertDisplay(flightCell);
        helper.assertDisplay(boatCell);
        helper.assertDisplay(guideCell);
        helper.assertDisplay(tourLeaderCell);
        helper.assertText(CreateGroup.treatments, otherTreatmentsTextCell.getText());
        helper.assertText(CreateGroup.services, otherServiceCell.getText());
        helper.assertText(CreateGroup.comment, additionalCommentTxtBox.getText());
    }
}
