package edu.vassar.cmpu203.triviagame;

import android.view.View;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;

import edu.vassar.cmpu203.triviagame.controller.MainActivity;
@RunWith(AndroidJUnit4.class)
public class MoreInfoTest {
    @org.junit.Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    /**
     * Just checks to see if moreInfo button takes you to the more info screen
     * and also checks to see if go back button takes you back to GameConfig screen
     */
    @Test
    public void testMoreInfoScreen(){
        Matcher<View> matcher = ViewMatchers.withId(R.id.moreinfobutton);
        Espresso.onView(matcher).perform(ViewActions.click()); //  going to the moreInfo screen

        ViewInteraction moreInfo = Espresso.onView(ViewMatchers.withId(R.id.wwminfo)); // saving the moreInfo text
        moreInfo.check(
                ViewAssertions.matches( // seeing if we are onMoreInfo by seeing if text is transferred
                        ViewMatchers.withSubstring(
                                "This is a game-show based on answering 5 consecutive questions correctly. " +
                                        "If a player gets a question wrong at any time, then the game is over. " +
                                        "If a player is able to answer 5 consecutive questions, then they make " +
                                        "it to the top!")
                )
        );
        matcher = ViewMatchers.withId(R.id.gobackbutton); // goingBack to GameConfig Screen
        Espresso.onView(matcher).perform(ViewActions.click()); // clicks goBack
        ViewInteraction gameName = Espresso.onView(ViewMatchers.withId(R.id.game_name)); // saves game name text
        gameName.check( // used to check if we are back on Game Config screen
                ViewAssertions.matches(
                        ViewMatchers.withSubstring(
                                "Welcome to Trivia Time"
                        )
                )
        );

    }
}
