package com.unit.test.junit.dietCalculatorApp;


import com.unit.test.junit.dietCalculatorApp.Coder;
import com.unit.test.junit.dietCalculatorApp.DietPlan;
import com.unit.test.junit.dietCalculatorApp.DietPlanner;
import com.unit.test.junit.dietCalculatorApp.Gender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DietPlannerTest {

    private DietPlanner dietPlanner;

    @BeforeEach
    void setup() {
        this.dietPlanner = new DietPlanner(20, 30, 50);
    }

    @AfterEach
    void afterEact() {
        System.out.println("A unit test was fineshed.");
    }

    @Test
    void should_ReturnCorrectDietPlan_When_CorrectCoder() {

        // given
        Coder coder = new Coder(1.82, 75.0, 26, Gender.MALE);
        DietPlan expected = new DietPlan(2202, 110, 73, 275);

        // when
        DietPlan actual = dietPlanner.calculateDiet(coder);

        // given
        assertAll(
                () -> assertEquals(expected.getCalories(), actual.getCalories()),
                () -> assertEquals(expected.getProtein(), actual.getProtein()),
                () -> assertEquals(expected.getFat(), actual.getFat()),
                () -> assertEquals(expected.getCarbohydrate(), actual.getCarbohydrate())
        );
    }
}