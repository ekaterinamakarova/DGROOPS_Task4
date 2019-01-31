package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class CreateGroup {

    @FindBy(css="input[name='groups.name']")  private WebElement groupRequestName;
    @FindBy(css="input[name='groups.nationality']")  private WebElement groupNationality;
    @FindBy(xpath ="//input[@name='groups.groupType']/../ div") private  WebElement groupType;
    @FindBy(xpath = "//li[contains(text(),'OTHER')]") private WebElement OTHERfield;
    @FindBy(css="input[name='groups.guests']")  private WebElement numberOfGuests;
    @FindBy(css="input[name='groups.rooms']")  private WebElement numberOfRooms;
    @FindBy(xpath = "//input[@name='groups.roomBasis']/../div") private WebElement roomBasis;
    @FindBy(xpath = "//li[contains(text(),'MULTIPLE')]") private WebElement MULTIPLEfield;
    @FindBy(css="input[id='otherGroupType']")  private WebElement otherGroupType;
    @FindBy(css="input[name='groups.departure']")  private WebElement groupDepartureLocation;
    @FindBy(xpath = "//input[@name='destination.cities[0].countryId']/../..") private WebElement country_1;
    @FindBy(xpath = "//input[@name='destination.cities[1].countryId']/../..") private WebElement country_2;
    @FindBy(xpath = "//li[contains(text(),'Belarus')]") private  WebElement destinationBelarus;
    @FindBy(css = "input[name='destination.cities[0].name']") private WebElement city_1;
    @FindBy(css = "input[name='destination.cities[1].name']") private WebElement city_2;
    @FindBy(css="input[name='destination.cities[0].dateRange']") private WebElement CheckInOut_1;
    @FindBy(css="input[name='destination.cities[1].dateRange']") private WebElement CheckInOut_2;
    @FindBy(css = "button[id='deleteDestinationButton']") private WebElement addDestination;
    @FindBy(xpath = "//input[@id='services_B&B']/..") private WebElement BandB;
    @FindBy(xpath = "//input[@id='services_HalfBoard']/..") private WebElement halfBoard;
    @FindBy(xpath = "//input[@id='services_FullBoard']/..") private WebElement fullBoard;
    @FindBy(xpath = "//input[@id='services_AllInclusive']/..") private WebElement allInclusive;
    @FindBy(xpath = "//input[@id='services_DrinksIncluded']/..") private WebElement drinksIncluded;
    @FindBy(xpath = "//input[@id='services_PorterageIncl']/..") private WebElement porterageIncl;
    @FindBy(xpath = "//input[@id='services_Bus']/..") private WebElement bus;
    @FindBy(xpath = "//input[@id='services_Flight']/..") private WebElement flight;
    @FindBy(xpath = "//input[@id='services_Boat']/..") private WebElement boat;
    @FindBy(xpath = "//input[@id='services_Guide']/..") private WebElement guide;
    @FindBy(xpath = "//input[@id='services_TourLeader']/..") private WebElement tourLeader;

    private String groupDataDirectory = "./src/test/groupData";

    WebDriver driver;
    public CreateGroup(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    HelperClass helper = new HelperClass(driver);
    FileReaderClass readerClass = new FileReaderClass();

    public void groupDetails() throws IOException, InterruptedException {
        helper.implicitWait(driver);
        helper.sendKeys(groupRequestName,readerClass.readFromFile(groupDataDirectory,0));
        helper.sendKeys(groupNationality, readerClass.readFromFile(groupDataDirectory,1));
        helper.chooseFromList(groupType,OTHERfield);
        Thread.sleep(1000);
        helper.sendKeys(numberOfGuests, readerClass.readFromFile(groupDataDirectory,2));
        helper.sendKeys(numberOfRooms, readerClass.readFromFile(groupDataDirectory,3));
        helper.chooseFromList(roomBasis,MULTIPLEfield);
        Thread.sleep(500);
        helper.sendKeys(otherGroupType, readerClass.readFromFile(groupDataDirectory,4));
        helper.sendKeys(groupDepartureLocation, readerClass.readFromFile(groupDataDirectory,5));
    }

    public void destinationDetails() throws InterruptedException, IOException {
       //helper.chooseFromList(country,destinationBelarus);
       //Thread.sleep(500);
       helper.sendKeys(city_1, readerClass.readFromFile(groupDataDirectory,6));
       //календарь
        addDestination.click();
        //страна
        helper.sendKeys(city_2, readerClass.readFromFile(groupDataDirectory,7));
        //календарь
    }

    public void servicesAndNotes(){
        BandB.click();
        halfBoard.click();
        fullBoard.click();
        allInclusive.click();
        drinksIncluded.click();
        porterageIncl.click();
        bus.click();
        flight.click();
        boat.click();
        guide.click();
        tourLeader.click();
    }
}
