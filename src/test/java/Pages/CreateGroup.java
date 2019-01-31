package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    @FindBy(xpath = "//li[contains(text(),'Australia')]") private WebElement AUSTRALIA;
    @FindBy(xpath = "//input[@name='destination.cities[1].countryId']/../..") private WebElement country_2;
    @FindBy(xpath = "//li[contains(text(),'Antarctica')]") private  WebElement ANTARCTICA;
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
    @FindBy(xpath = "//label[contains(text(),'Need other treatments?')]/../div//input") private WebElement otherTreatments;
    @FindBy(xpath = "//label[contains(text(),'Need other services?')]/../div//input") private WebElement otherServices;
    @FindBy(xpath = "//label[contains(text(),'Additional comment')]/../div//div//textarea [3]") private WebElement additionalComment;
    @FindBy(xpath="//span[contains(text(),'ADD PARTNER')]") private WebElement addPartnerBtn;
    @FindBy(css="tr[class] input") private List<WebElement> allChechboxes;
    @FindBy(xpath = "//button[2]/span[1][contains(text(),'ADD PARTNER')]") private WebElement addPartnrBtn;
    @FindBy(css = "button[type='submit']") private WebElement sendToPartnersBtn;
    @FindBy(xpath = "//tr[2]/td[5]") private List<WebElement> dateStartCells;
    @FindBy(xpath = "//tr[4]/td[6]") private List<WebElement> dateEndCells;

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
        helper.chooseFromList(country_1,AUSTRALIA);
        Thread.sleep(500);
        helper.sendKeys(city_1, readerClass.readFromFile(groupDataDirectory,6));
        CheckInOut_1.click();
        dateStartCells.get(2).click();
        dateEndCells.get(2).click();
        Thread.sleep(100);
        addDestination.click();
        helper.chooseFromList(country_2,ANTARCTICA);
        Thread.sleep(500);
        helper.sendKeys(city_2, readerClass.readFromFile(groupDataDirectory,7));
        CheckInOut_2.click();
        dateStartCells.get(2).click();
        dateEndCells.get(2).click();
        Thread.sleep(100);
    }

    public void servicesAndNotes() throws IOException, InterruptedException {
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
        helper.sendKeys(otherTreatments,readerClass.readFromFile(groupDataDirectory,8));
        otherTreatments.sendKeys(Keys.ENTER);
        helper.sendKeys(otherServices,readerClass.readFromFile(groupDataDirectory,9));
        otherServices.sendKeys(Keys.ENTER);
        helper.sendKeys(additionalComment,readerClass.readFromFile(groupDataDirectory,10));
    }

    public void addPartner(){
        addPartnerBtn.click();
        if(allChechboxes.size()!=0){
            allChechboxes.get(0).click();
        }
        addPartnrBtn.click();
    }

    public void sendToPartners(){
        sendToPartnersBtn.click();
    }



}
