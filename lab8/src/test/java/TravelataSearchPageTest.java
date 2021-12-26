import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.TravelataHomePage;
import page.TravelataSearchPage;

import java.util.List;

public class TravelataSearchPageTest extends CommonConditions{

    private static final String SEA_LINE_TEXT = "3-я линия";
    private static final double HOTEL_BEST_RATING = 4.5;

    @Test
    public void checkCorrectFilteringHotelsBySeaLine() {
        List<String> tourSeaLineInformation = new TravelataSearchPage(driver)
                .openPage()
                .chooseSeaLine()
                .getTourSeaLineInformation();

        Assertions.assertThat(tourSeaLineInformation).allSatisfy(text -> Assertions.assertThat(text)
                .contains(SEA_LINE_TEXT));
    }

    @Test
    public void checkCorrectFilteringToursByBestHotelRating() {
        List<Double> hotelRatingInformation = new TravelataSearchPage(driver)
                .openPage()
                .chooseBestRatingHotelsCheckbox()
                .getHotelRatingInformation();

        Assertions.assertThat(hotelRatingInformation).allSatisfy(rating -> Assertions.assertThat(rating > HOTEL_BEST_RATING));
    }





}

