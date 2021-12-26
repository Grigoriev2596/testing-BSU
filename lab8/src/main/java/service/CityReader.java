package service;

public class CityReader {

    private final static String TESTDATA_CITY = "testdata.homepage.city";

    public static String getCity() {
        return TestDataReader.getTestData(TESTDATA_CITY);
    }
}