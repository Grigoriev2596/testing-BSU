import model.User;
import org.testng.Assert;
import page.TravelataHomePage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import service.CityReader;
import service.EmailReader;
import service.UserCreator;

import java.util.List;

public class TravelataHomePageTest extends CommonConditions{

    private final static int TOURIST_AMOUNT = 1;

    private final static String ADULT_KEYWORD_WITHOUT_ENDING = "взрослы";

    private final static String INCORRECT_LOGIN_ERROR_MESSAGE = "Попробуйте другой логин или пароль";

    private final static String SUCCESS_MAILING_SUBSCRIBE_MESSAGE = "Вы успешно подписались";

    private final static String CITY = "Омск";

    @Test
    public void checkTheIncorrectLogin() {

        User testUser = UserCreator.withFullWay();
        String actualErrorMessage = new TravelataHomePage(driver)
                .openPage()
                .openTravelataLoginWindow()
                .inputEmailAndPasswordToLoginFormAndSubmit(testUser)
                .getLoginErrorText();
        Assert.assertEquals(actualErrorMessage, INCORRECT_LOGIN_ERROR_MESSAGE);
    }

    @Test
    public void searchResultSuitsForParticularAmountOfTourists() {

        List<String> tourInformationCards = new TravelataHomePage(driver)
                .openPage()
                .openDropDownTouristControlForm()
                .selectTouristAmount(TOURIST_AMOUNT)
                .search()
                .getTourInformationCards();
        Assertions.assertThat(tourInformationCards).allSatisfy(text -> Assertions.assertThat(text)
                .contains(TOURIST_AMOUNT + " " + ADULT_KEYWORD_WITHOUT_ENDING));
    }

    @Test
    public void checkMailingSubscriptionMessageWithCorrectEmail() {
        String mailingListEmail = EmailReader.getEmail();
        String actualErrorMessage = new TravelataHomePage(driver)
                .openPage()
                .inputEmailToMailingInputAndSubmit(mailingListEmail)
                .getMailingSuccesfulMessage();
        Assert.assertEquals(actualErrorMessage, SUCCESS_MAILING_SUBSCRIBE_MESSAGE);
    }

    @Test
    public void checkChangingCityCorrectness() {
        String actualCityValue = new TravelataHomePage(driver)
                .openPage()
                .openDropDownCitiesList()
                .chooseCity(CITY)
                .getCurrentCityValue();
        Assert.assertEquals(actualCityValue, CITY);
    }




}

