package stepDefinitions.db;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.db.EEPage;
import pages.ui.LoginPage;
import utils.DBUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class crudEmployment {

    @Given("Database should contain the columns for Employments page")
    public void database_should_contain_the_columns_for_employments_page(List<String> expected) {
        List<String> result = DBUtils.getColumnNames(" select * from loan.tbl_mortagage");
        List<String> cutResult = result.subList(35, 62);
        Assert.assertEquals(cutResult, expected);
    }
    @Given("The database should have name and income values and not be null")
    public void the_database_should_have_name_and_income_values_and_not_be_null() {
        List<List<Object>> nameValues = DBUtils.getListOfLists("select employer_name from loan.tbl_mortagage");
        if(nameValues != null){
            Assert.assertTrue(true);
        }
        List<List<Object>> incomeValues = DBUtils.getListOfLists("select gross_monthly_income from loan.tbl_mortagage ");
        if(incomeValues != null){
            Assert.assertTrue(true);
        }
    }
    @Given("Database should contain states abbreviations")
    public void database_should_contain_states_abbreviations() {
        List<String> stringsList = List.of("AL","AK","AZ","AR", "CA","CO","CT","DE","FL",
                "GA","HI","ID", "IL","IN","IA","KS","KY","LA","ME","MD", "MA","MI","MN","MS","MO",
                "MT","NE", "NV","NH","NJ","NM","NY","NC", "ND","OH","OK","OR","PA","RI","SC",
                "SD","TN","TX","UT","VT","VA","WA", "WV","WI","WY");

        List<List<Object>> listOfLists = DBUtils.getListOfLists("select state from loan.tbl_mortagage ");

        for (List<Object> innerList : listOfLists) {
            for (Object obj : innerList) {
                if (obj instanceof WebElement) {
                    WebElement webElement = (WebElement) obj;
                    String text = webElement.getText();
                    if (stringsList.contains(text)) {
                        Assert.assertTrue(true);
                    }
                }
            }
        }
    }
    @Then("User fills out the form with different income sources")
    public void user_fills_out_the_form_with_different_income_sources() {
        new EEPage().applicationWithOtherTypesOfIncome();
    }
    @Then("Database income source table should have one the following")
    public void database_income_source_table_should_have_one_the_following(List<String> expected) {
        List<List<Object>> result = DBUtils.getListOfLists("select income_source from loan.tbl_mortagage");
        if(result.contains(expected)){
            Assert.assertTrue(true);
        }
    }
    @Given("The user filling out employment form")
    public void the_user_filling_out_employment_form(io.cucumber.datatable.DataTable dataTable) {
        new EEPage().mappingEmployer();
    }
    @Then("Database should have the entered by user information mapped accordingly")
    public void database_should_have_the_entered_by_user_information_mapped_accordingly(List<Map<String,String>> dataTable) throws SQLException {

        try {
            String expEmpName = dataTable.get(0).get("employer_name");
            String expPosition = dataTable.get(0).get("position");
            String expCity = dataTable.get(0).get("city");
            String expState = dataTable.get(0).get("state");
            String expStartDate = dataTable.get(0).get("start_date");
            String expIncome = dataTable.get(0).get("gross_monthly_income");
            String expOvertime = dataTable.get(0).get("monthly_overtime");
            String expBonus = dataTable.get(0).get("monthly_bonuses");
            String expCommissions = dataTable.get(0).get("monthly_commision");
            String expDividends = dataTable.get(0).get("monthly_dividents");
            String expIncomeSource = dataTable.get(0).get("income_source");
            String expAmount = dataTable.get(0).get("amount");

            List<Map<String, Object>> actual = DBUtils.getListOfMaps("select * from loan.tbl_mortagage where employer_name='Consulting LLC'");
            String actEmpName = dataTable.get(0).get("employer_name");
            String actPosition = dataTable.get(0).get("position");
            String actCity = dataTable.get(0).get("city");
            String actState = dataTable.get(0).get("state");
            String actStartDate = dataTable.get(0).get("start_date");
            String actIncome = dataTable.get(0).get("gross_monthly_income");
            String actOvertime = dataTable.get(0).get("monthly_overtime");
            String actBonus = dataTable.get(0).get("monthly_bonuses");
            String actCommissions = dataTable.get(0).get("monthly_commision");
            String actDividends = dataTable.get(0).get("monthly_dividents");
            String actIncomeSource = dataTable.get(0).get("income_source");
            String actAmount = dataTable.get(0).get("amount");

            SoftAssertions softAssertions = new SoftAssertions();

            softAssertions.assertThat(actEmpName).isEqualTo(expEmpName);
            softAssertions.assertThat(actPosition).isEqualTo(expPosition);
            softAssertions.assertThat(actCity).isEqualTo(expCity);
            softAssertions.assertThat(actState).isEqualTo(expState);
            softAssertions.assertThat(actStartDate).isEqualTo(expStartDate);
            softAssertions.assertThat(actIncome).isEqualTo(expIncome);
            softAssertions.assertThat(actOvertime).isEqualTo(expOvertime);
            softAssertions.assertThat(actBonus).isEqualTo(expBonus);
            softAssertions.assertThat(actCommissions).isEqualTo(expCommissions);
            softAssertions.assertThat(actDividends).isEqualTo(expDividends);
            softAssertions.assertThat(actIncomeSource).isEqualTo(expIncomeSource);
            softAssertions.assertThat(actAmount).isEqualTo(expAmount);

            softAssertions.assertAll();
        }finally{
            DBUtils.executeUpdate("DELETE FROM loan.tbl_mortagage where b_email='moon@gmail.com'");
        }
    }
}
