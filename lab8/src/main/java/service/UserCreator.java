package service;

import model.User;

public class UserCreator {

    private final static String TESTDATA_MAIL = "testdata.user.mail";
    private final static String TESTDATA_PASSWORD = "testdata.user.password";

    public static User withFullWay() {
        return new User(TestDataReader.getTestData(TESTDATA_MAIL),
                TestDataReader.getTestData(TESTDATA_PASSWORD));
    }

    public static User withEmptyMail() {
        return new User("", TestDataReader.getTestData(TESTDATA_PASSWORD));
    }

    public static User withEmptyPassword() {
        return new User(TestDataReader.getTestData(TESTDATA_MAIL), "");
    }
}