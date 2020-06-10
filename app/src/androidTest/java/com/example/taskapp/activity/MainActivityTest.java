package com.example.taskapp.activity;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.filters.LargeTest;

import com.example.taskapp.R;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {



    @Test
    void test_isActivityInView(){
        ActivityScenario activityScenario = ActivityScenario.launch(MainActivity.class);
        Espresso.onView(ViewMatchers.withId(R.id.main)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}