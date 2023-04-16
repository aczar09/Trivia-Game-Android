package edu.vassar.cmpu203.triviagame;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import edu.vassar.cmpu203.triviagame.controller.MainActivity;

@RunWith(AndroidJUnit4.class)
public class QuestionAndroidTest {
    @org.junit.Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void RunningThroughQuestions(){
        Espresso.onView(ViewMatchers.withId(R.id.wwmbutton)).perform(ViewActions.click());

    }
}
