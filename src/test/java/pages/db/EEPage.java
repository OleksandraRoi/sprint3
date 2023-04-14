package pages.db;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.ui.ExpensesPage;
import utils.DBUtils;
import utils.Driver;

import java.util.List;
import java.util.Random;

public class EEPage {

    public EEPage(){PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(linkText = "Mortgage Application")
    private WebElement mortgageButton;
    @FindBy(id = "realtorinfo")
    private WebElement realtorInfo;
    @FindBy(name = "est_purchase_price")
    private WebElement purchasePrice;
    @FindBy(id = "downpayment")
    private WebElement downpaymant;
    @FindBy(xpath = "//a[@href='#next']")
    private WebElement nextButton;
    @FindBy(id = "b_firstName")
    private WebElement firstName;
    @FindBy(id = "b_lastName")
    private WebElement lastName;
    @FindBy(id = "b_email")
    private WebElement email;
    @FindBy(id = "b_ssn")
    private WebElement ssn;
    @FindBy(id = "select2-b_marital-container")
    private  WebElement maritalStatus;
    @FindBy(xpath = "//input[@class='select2-search__field']")
    private WebElement searchBar;
    @FindBy(id = "b_cell")
    private WebElement phoneNumber;
    @FindBy(id = "b_home")
    private WebElement homeNumber;
    @FindBy(id = "b_dob")
    private WebElement dateOfBirth;
    @FindBy(id = "employername1")
    private WebElement empName;
    @FindBy(id = "position1")
    private WebElement position;
    @FindBy(id = "city")
    private WebElement city;
    @FindBy(id = "state1")
    private WebElement state;
    @FindBy(id = "start_date1")
    private WebElement startDate;
    @FindBy(name = "gross_monthly_income")
    private WebElement monthlyIncome;
    @FindBy(id = "eConsentdeclarerFirstName")
    private WebElement firstNameOnConsent;
    @FindBy(id = "eConsentdeclarerLastName")
    private WebElement lastNameOnConsent;
    @FindBy(id = "eConsentdeclarerEmail")
    private WebElement emailConsent;
    @FindBy(xpath = "(//label[@class='custom-control-label'])[1]")
    private WebElement agreeCheckBox;
    @FindBy(xpath = "//a[@href='#finish']")
    private WebElement submitButton;
    @FindBy(xpath = "(//select[@name='income_source[]'])[1]")
    private WebElement incomeSource1;
    @FindBy(xpath = "(//select[@name='income_source[]'])[2]")
    private WebElement incomeSource2;
    @FindBy(xpath = "(//select[@name='income_source[]'])[3]")
    private WebElement incomeSource3;
    @FindBy(id = "amount1")
    private WebElement amountInput1;
    @FindBy(id = "amount2")
    private WebElement amountInput2;
    @FindBy(id = "amount3")
    private WebElement amountInput3;
    public void applicationWithRentCheckBox() {
        Faker faker = new Faker();
        Random random = new Random();
        mortgageButton.click();
        realtorInfo.sendKeys(faker.name().username());
        int housePrice = random.nextInt(500001) + 500000;
        purchasePrice.sendKeys(String.valueOf(housePrice));
        int downpaymantPrice = random.nextInt(50001) + 50000;
        downpaymant.sendKeys(String.valueOf(downpaymantPrice));
        nextButton.click();
        firstName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        email.sendKeys(faker.internet().emailAddress());
        dateOfBirth.sendKeys("02021992");
        ssn.sendKeys(faker.numerify("#########"));
        maritalStatus.click();
        searchBar.sendKeys("Married", Keys.ENTER);
        phoneNumber.sendKeys(faker.phoneNumber().cellPhone());
        homeNumber.sendKeys(faker.phoneNumber().cellPhone());
        nextButton.click();
        new ExpensesPage().scrollUp();
        new ExpensesPage().monthlyRentalPaymentCorrectInput();
        new ExpensesPage().nextClick();
        empName.sendKeys(faker.name().fullName());
        position.sendKeys(faker.company().profession());
        city.sendKeys(faker.address().city());
        state.click();
        state.sendKeys("C", Keys.ENTER);
        startDate.sendKeys(faker.backToTheFuture().date());
        int salary = faker.number().numberBetween(4000, 15000);
        monthlyIncome.sendKeys(String.valueOf(salary));
        new Select(incomeSource1).selectByValue("Alimony/Child Support");
        amountInput1.sendKeys("1000");
        new Select(incomeSource2).selectByValue("Social Security/Disability Income");
        amountInput2.sendKeys("2000");
        new Select(incomeSource3).selectByValue("Unemployment Benefits");
        amountInput3.sendKeys("4000");
        nextButton.click();
        new ExpensesPage().scrollUp();
        nextButton.click();
        firstNameOnConsent.sendKeys(faker.name().firstName());
        lastNameOnConsent.sendKeys(faker.name().lastName());
        emailConsent.sendKeys(faker.internet().emailAddress());
        agreeCheckBox.click();
        nextButton.click();
        submitButton.click();
    }
    public void applicationWithOwnCheckBox() {
        Faker faker = new Faker();
        Random random = new Random();
        mortgageButton.click();
        realtorInfo.sendKeys(faker.name().username());
        int housePrice = random.nextInt(500001) + 500000;
        purchasePrice.sendKeys(String.valueOf(housePrice));
        int downpaymantPrice = random.nextInt(50001) + 50000;
        downpaymant.sendKeys(String.valueOf(downpaymantPrice));
        nextButton.click();
        firstName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        email.sendKeys(faker.internet().emailAddress());
        dateOfBirth.sendKeys("02021992");
        ssn.sendKeys(faker.numerify("#########"));
        maritalStatus.click();
        searchBar.sendKeys("Married", Keys.ENTER);
        phoneNumber.sendKeys(faker.phoneNumber().cellPhone());
        homeNumber.sendKeys(faker.phoneNumber().cellPhone());
        nextButton.click();
        new ExpensesPage().scrollUp();
        new ExpensesPage().ownCheckBoxClick();
        new ExpensesPage().monthlyMortgagePaymentCorrectInput();
        new ExpensesPage().nextClick();
        empName.sendKeys(faker.name().fullName());
        position.sendKeys(faker.company().profession());
        city.sendKeys(faker.address().city());
        state.click();
        state.sendKeys("T", Keys.ENTER);
        startDate.sendKeys(faker.backToTheFuture().date());
        int salary = faker.number().numberBetween(4000, 15000);
        monthlyIncome.sendKeys(String.valueOf(salary));
        new Select(incomeSource1).selectByValue("Interest and Dividends");
        amountInput1.sendKeys("1500");
        new Select(incomeSource2).selectByValue("VA Compensation");
        amountInput1.sendKeys("500");
        new Select(incomeSource3).selectByValue("Royalty Payments");
        amountInput1.sendKeys("6000");
        nextButton.click();
        new ExpensesPage().scrollUp();
        nextButton.click();
        firstNameOnConsent.sendKeys(faker.name().firstName());
        lastNameOnConsent.sendKeys(faker.name().lastName());
        emailConsent.sendKeys(faker.internet().emailAddress());
        agreeCheckBox.click();
        nextButton.click();
        submitButton.click();
    }

    public void beforeBenefints(){
        Faker faker = new Faker();
        Random random = new Random();
        mortgageButton.click();
        realtorInfo.sendKeys(faker.name().username());
        int housePrice = random.nextInt(500001) + 500000;
        purchasePrice.sendKeys(String.valueOf(housePrice));
        int downpaymantPrice = random.nextInt(50001) + 50000;
        downpaymant.sendKeys(String.valueOf(downpaymantPrice));
        nextButton.click();
        firstName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        email.sendKeys(faker.internet().emailAddress());
        dateOfBirth.sendKeys("02021992");
        ssn.sendKeys(faker.numerify("#########"));
        maritalStatus.click();
        searchBar.sendKeys("Married", Keys.ENTER);
        phoneNumber.sendKeys(faker.phoneNumber().cellPhone());
        homeNumber.sendKeys(faker.phoneNumber().cellPhone());
        nextButton.click();
        new ExpensesPage().scrollUp();
        new ExpensesPage().monthlyRentalPaymentCorrectInput();
        new ExpensesPage().nextClick();
        empName.sendKeys(faker.name().fullName());
        position.sendKeys(faker.company().profession());
        city.sendKeys(faker.address().city());
        state.click();
        state.sendKeys("A", Keys.ENTER);
        startDate.sendKeys(faker.backToTheFuture().date());
        int salary = faker.number().numberBetween(4000, 15000);
        monthlyIncome.sendKeys(String.valueOf(salary));
    }
    public void afterBenefits(){
        Faker faker= new Faker();
        nextButton.click();
        new ExpensesPage().scrollUp();
        nextButton.click();
        firstNameOnConsent.sendKeys(faker.name().firstName());
        lastNameOnConsent.sendKeys(faker.name().lastName());
        emailConsent.sendKeys(faker.internet().emailAddress());
        agreeCheckBox.click();
        nextButton.click();
        submitButton.click();
    }
    public void applicationWithOtherTypesOfIncome() {
        beforeBenefints();
        new Select(incomeSource1).selectByValue("Alimony/Child Support");
        amountInput1.sendKeys("2000");
        new Select(incomeSource2).selectByValue("VA Compensation");
        amountInput1.sendKeys("400");
        new Select(incomeSource3).selectByValue("Other Types of Income");
        amountInput1.sendKeys("12000");
        afterBenefits();
    }



}