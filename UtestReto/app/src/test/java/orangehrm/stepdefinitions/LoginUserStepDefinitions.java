package orangehrm.stepdefinitions;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import orangehrm.model.CandidateDates;
import orangehrm.model.LoginDates;
import orangehrm.tasks.AddNewRecord;
import orangehrm.tasks.OpenUrlReto;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import orangehrm.tasks.WriteAllField;
import orangehrm.utils.GenericTransformer;
import java.util.List;
import java.util.Map;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginUserStepDefinitions {
    private GenericTransformer genericTransformer = new GenericTransformer();

    @DataTableType
    public LoginDates loginDatesTransformer(Map<String, String> row) {
        return genericTransformer.transform(row, LoginDates.class);
    }
    @DataTableType
    public CandidateDates candidateDatesTransformer(Map<String, String> row) {
        return genericTransformer.transform(row, CandidateDates.class);
    }

    @Before
    public void setThestage(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Aleja");
        WebDriverManager.chromedriver().setup();
    }
    @Given("the user is on the login page")
    public void userInTheHomePage() {
        theActorInTheSpotlight().attemptsTo(new OpenUrlReto("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));

    }
    @Given("the user logs in with valid credentials")
    public void theUserLogsInWithValidCredentials(List<LoginDates> dates) throws Exception{
        OnStage.theActorInTheSpotlight().attemptsTo(WriteAllField.login(dates));
    }
    @When("the user fills in all the required fields in Recruitment")
    public void theUserFillsInAllTheRequiredFieldsInRecruitment(List<CandidateDates> dates) throws Exception{
        OnStage.theActorInTheSpotlight().attemptsTo(AddNewRecord.fillOutForm(dates));
    }
    @Then("i check the hired status")
    public void iCheckTheHiredStatus(){

    }



}
