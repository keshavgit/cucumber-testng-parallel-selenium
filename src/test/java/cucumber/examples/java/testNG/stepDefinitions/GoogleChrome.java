package cucumber.examples.java.testNG.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.examples.java.testNG.DriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.System.setProperty;

public class GoogleChrome {

    static Logger log = Logger.getLogger(GoogleChrome.class);
    WebDriver driver = DriverManager.getDriver();
    WebElement webElement;
    WebDriverWait wait = new WebDriverWait(driver, 10);

    @Given("^url opened1$")
    public void urlOpened1() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        setProperty("webdriver.chrome.driver", "C:\\Users\\Fission Labs\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, java.util.concurrent.TimeUnit.SECONDS);
        driver.get("https://www.bestbuy.ca/");
        driver.manage().window().maximize();

    }

    @Then("^Sign in to Website1$")
    public void signInToWebsite1() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("ctl00_MasterHeader_ctl00_uchead_ucWelcome_linkSignIn")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("ctl00$CP$SignInUC1$UserNameContainer$txtUserName")).sendKeys("vks@yopmail.com");
        //Reporter.addStepLog("Successfully Signed into Best Buy");
        driver.findElement(By.name("ctl00$CP$SignInUC1$PasswordContainer$txtPassword")).sendKeys("vks@123");
        Thread.sleep(5000);
        driver.findElement(By.id("ctl00_CP_SignInUC1_BtnLoginButton")).click();
        Thread.sleep(3000);

    }

    @Then("^Search for a product1$")
    public void search_for_a_product1() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.name("ctl00$MasterHeader$ctl00$uchead$GlobalSearchUC$TxtSearchKeyword")).sendKeys("Samsung curve" + "\n");
        driver.findElement(By.xpath("//*[contains(text(),'UN55MU6500FXZC')]")).click();

        //driver.findElement(By.linkText("/en-ca/product/samsung-55-4k-uhd-hdr-curved-led-tizen-smart-tv-un55mu6500fxzc-black/10583521.aspx?")).click();
        Thread.sleep(3000);
    }

    @Then("^Add product to cart1$")
    public void add_product_to_cart1() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.linkText("Add to Cart")).click();
        driver.findElement(By.xpath("//a[@id='express-checkout']")).click();
        //driver.findElement(By.xpath("//*[contains(text(),'No Thanks')]")).click();
//        String bodyText = driver.findElement(By.tagName("div")).getText();
//        Assert.assertTrue("Added to your cart", bodyText.contains(bodyText));
    }

    @Then("^Proceed to Checkout1$")
    public void proceed_to_Checkout1() throws Throwable {
        WebElement yourElement = driver.findElement(By.xpath("//span[contains(. , 'Use a new address')]"));
        WebDriverWait wait1 =  new WebDriverWait(driver,20);
        wait1.until(ExpectedConditions.visibilityOf(yourElement));
        yourElement .click();
        driver.findElement(By.name("ctl00$CP$checkoutSections$ctl01$DeliveryOptionTabs1$manageShippingAddress$oeaUseNew$addressUC$FirstNameContainer$TxtFirstName")).sendKeys("Chrome");
        driver.findElement(By.name("ctl00$CP$checkoutSections$ctl01$DeliveryOptionTabs1$manageShippingAddress$oeaUseNew$addressUC$LastNameContainer$txtLastName")).sendKeys("User");
        Select sel = new Select(driver.findElement(By.id("ctl00_CP_checkoutSections_ctl01_DeliveryOptionTabs1_manageShippingAddress_oeaUseNew_addressUC_StateContainer_DdlState")));
        sel.selectByIndex(9);
        driver.findElement(By.name("ctl00$CP$checkoutSections$ctl01$DeliveryOptionTabs1$manageShippingAddress$oeaUseNew$addressUC$AddressLine1Container$TxtAddressLine1")).sendKeys("M-80 Dundas St");
        driver.findElement(By.name("ctl00$CP$checkoutSections$ctl01$DeliveryOptionTabs1$manageShippingAddress$oeaUseNew$addressUC$CityContainer$TxtCity")).sendKeys("London");
        WebDriverWait wait = new WebDriverWait(driver, 18);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ctl00$CP$checkoutSections$ctl01$DeliveryOptionTabs1$manageShippingAddress$oeaUseNew$addressUC$PostalCodeContainer$TxtZipCode")));
        driver.findElement(By.name("ctl00$CP$checkoutSections$ctl01$DeliveryOptionTabs1$manageShippingAddress$oeaUseNew$addressUC$PostalCodeContainer$TxtZipCode")).clear();
        driver.findElement(By.name("ctl00$CP$checkoutSections$ctl01$DeliveryOptionTabs1$manageShippingAddress$oeaUseNew$addressUC$PostalCodeContainer$TxtZipCode")).sendKeys("P0H 1H0");
        //driver.findElement(By.name("ctl00$CP$checkoutSections$ctl01$DeliveryOptionTabs1$manageShippingAddress$oeaUseNew$addressUC$PostalCodeContainer$TxtZipCode")).sendKeys("P0H 1H0");
        driver.findElement(By.name("ctl00$CP$checkoutSections$ctl01$DeliveryOptionTabs1$manageShippingAddress$oeaUseNew$addressUC$PhoneContainer$TxtPhone")).sendKeys("121");
        driver.findElement(By.name("ctl00$CP$checkoutSections$ctl01$DeliveryOptionTabs1$manageShippingAddress$oeaUseNew$addressUC$Phone1Container$TxtPhone1")).sendKeys("334");
        driver.findElement(By.name("ctl00$CP$checkoutSections$ctl01$DeliveryOptionTabs1$manageShippingAddress$oeaUseNew$addressUC$Phone2Container$TxtPhone2")).sendKeys("3232");
        driver.findElement(By.xpath("//a[@validationgroup='NewAddress']//span[text()='Done']")).click();
//      driver.findElement(By.name("ctl00$CP$checkoutSections$ctl01$DeliveryOptionTabs1$manageShippingAddress$oeaUseNew$addressUC$PhoneExtContainer$TxtPhoneExt")).sendKeys("+1");
        driver.findElement(By.xpath("//span[contains(. , 'Continue')]")).click();
        //Thread.sleep(3000);

    }

    @Then("^Select Payment Gateway1$")
    public void select_Payment_Gateway1() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='payment-select']//a[@id='ctl00_CP_checkoutSections_ctl03_ucPaymentEdit_lnkCreditCard']")).click();
        Select sel = new Select(driver.findElement(By.name("ctl00$CP$checkoutSections$ctl03$ucPaymentEdit$UCEditCreditCard$AddCreditCardUC$CardTypeContainer$DdlCardType")));
        sel.selectByIndex(2);
        driver.findElement(By.name("ctl00$CP$checkoutSections$ctl03$ucPaymentEdit$UCEditCreditCard$AddCreditCardUC$CreditCardNumberContainer$TxtCardNumber")).sendKeys("5327020225434319");
        Select sel1 = new Select(driver.findElement(By.name("ctl00$CP$checkoutSections$ctl03$ucPaymentEdit$UCEditCreditCard$AddCreditCardUC$MonthContainer$DdlMonth")));
        sel1.selectByIndex(2);
        Select sel2 = new Select(driver.findElement(By.name("ctl00$CP$checkoutSections$ctl03$ucPaymentEdit$UCEditCreditCard$AddCreditCardUC$YearContainer$DdlYear")));
        sel2.selectByIndex(2);
        driver.findElement(By.name("ctl00$CP$checkoutSections$ctl03$ucPaymentEdit$UCEditCreditCard$AddCreditCardUC$CIDNumberContainer$TxtCID")).sendKeys("313");
        driver.findElement(By.xpath("//div[@class='primary-btn txt-btn BtnContinueFromPayment btn-paypal']//span[contains(text(), 'Continue')]")).click();
        WebElement element = driver.findElement(By.xpath("//div[@id='ctl00_CP_ErrorSummaryUC12_ValidationSummary1']//li[contains(text(), 'The format of the credit card number entered does not match the card type you specified')]"));
        element.getText();

        if(element.equals("The format of the credit card number entered does not match the card type you specified")){
            System.out.println("true");

        }else{
            System.out.println("false");
        }
        //driver.image(:src => "https://itc.mzstatic.com/itc/images/btn-grey-small-edit.png", :index => 1).click;
        //Thread.sleep(3000);
        driver.close();
        driver.quit();
    }
}

