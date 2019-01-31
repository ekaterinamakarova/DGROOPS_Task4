import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestClass {

    private ChromeDriver driver;

    FileReaderClass readerClass = new FileReaderClass();
    private String credentialsDirectory = "./src/credentials";

    @BeforeTest
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "normal");
        options.addArguments("start-maximized");
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
        driver.get(readerClass.readFromFile(credentialsDirectory,0));
    }

    @Test(description = "Login with credentials")
    public void login () throws IOException {
        Initial initial = new Initial(driver);
        SignIn signIn = new SignIn(driver);
        initial.toSignPage();
        signIn.signin(readerClass.readFromFile(credentialsDirectory,1), readerClass.readFromFile(credentialsDirectory,2));
    }

    @Test(dependsOnMethods = {"login"}, description = "Creation of the group")
    public void createGroup() throws InterruptedException, IOException {
        Main main = new Main(driver);
        CreateGroup createGroup= new CreateGroup(driver);
        main.toCreateGroupPage();
        createGroup.groupDetails();
        createGroup.destinationDetails();
        createGroup.servicesAndNotes();


    }

    @AfterTest
    public void exit () {
        //driver.quit();
    }
}
