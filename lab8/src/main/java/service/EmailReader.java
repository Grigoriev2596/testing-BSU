package service;

import model.User;

public class EmailReader {

    private final static String TESTDATA_EMAIL = "testdata.mailing.email";

    public static String getEmail() {
        return TestDataReader.getTestData(TESTDATA_EMAIL);
    }
}