package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PathPage;
import pages.SummaryPage;

public class SummarySteps {
    SummaryPage page = new SummaryPage();
    @Then("User going to summary page")
    public void userGoingToSummaryPage() {
        new PathPage().pathToSummeryPage();
    }

    @When("I got to summary page i should be able to click on PersonalnformationEdit page")
    public void iGotToSummaryPageIShouldBeAbleToClickOnPersonalnformationEditPage() {
        page.clickOnPersonalnformationEdit();
    }

    @Then("I should be able to go back to summary page and click on ExpenseEdit page")
    public void iShouldBeAbleToGoBackToSummaryPageAndClickOnExpenseEditPage() {
        page.clickOnExpenseEdit();
    }

    @When("I clicked on ExpenseEdit I should be able go back to summary page to click on EmploymentIncomeEdit")
    public void iClickedOnExpenseEditIShouldBeAbleGoBackToSummaryPageToClickOnEmploymentIncomeEdit() {
        page.clickOnEmploymentIncomeEdit();
    }

    @Then("I must go back on summary page to click on OrderCreditEdit")
    public void iMustGoBackOnSummaryPageToClickOnOrderCreditEdit() {
        page.clickOnOrderCreditEdit();
    }

    @When("I clicked on OrderCreditEdit I must to go back and click on eConsentEdit")
    public void iClickedOnOrderCreditEditIMustToGoBackAndClickOnEConsentEdit() {
        page.clickOneConsentEdit();
    }

    @When("I got to summary page i should be able to click on PersonalnDetails")
    public void iGotToSummaryPageIShouldBeAbleToClickOnPersonalnDetails() {
        page.clickOnPreApprovalEdit();
    }
}
