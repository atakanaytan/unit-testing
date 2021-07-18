package com.unit.test.practicalUnitTestingBook.chapter5_mockito.tightly_coupled_case;

public class Phone {

    private final String number;
    private final boolean mobile;

    public Phone(String number, boolean mobile) {
        this.number = number;
        this.mobile = mobile;
    }

    public boolean isMobile() {
        return mobile;
    }
}
