import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.TravelataHolidayPage;
import page.TravelataHomePage;
import page.TravelataRussiaPage;

import java.util.Dictionary;
import java.util.List;

public class TravelataRussiaPageTest extends CommonConditions{


    @Test
    public void choosenDirectionEqualsToDispayedDirection() {
        TravelataRussiaPage russiaPage = new TravelataRussiaPage(driver)
                .openPage();
        String choosenTypeName = russiaPage
                .chooseType()
                .getChoosenTypeName();
        String displayedTypeName = russiaPage.getDisplayedOnAPageTypeName();
        Assert.assertEquals(choosenTypeName, displayedTypeName);
    }

    @Test
    public void filteringTourByDirection() {
        TravelataHolidayPage holidayPage = new TravelataHolidayPage(driver).openPage();
        String choosenDirection = holidayPage.getHolidayDirectionName();
        List<String> tourDirections = holidayPage
                .chooseHolidayDirection()
                .getTourDirectionInformation();
        Assertions.assertThat(tourDirections).allSatisfy(text -> Assertions.assertThat(text)
                .contains(choosenDirection));
    }

}

