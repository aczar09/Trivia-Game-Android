package edu.vassar.cmpu203.triviagame;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static java.util.regex.Pattern.matches;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;

import edu.vassar.cmpu203.triviagame.controller.MainActivity;
import edu.vassar.cmpu203.triviagame.model.Choice;
import edu.vassar.cmpu203.triviagame.model.Question;
import edu.vassar.cmpu203.triviagame.model.RandMultiChoice;

@RunWith(AndroidJUnit4.class)
public class QuestionAndroidTest {
    @org.junit.Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    /**
     * Tests randomly the different screens, to account for different combinations/pathways in the game.
     * For example, the user may input 3 correct answers and 1 incorrect, all correct answers, etc.
     */
    @Test
    public void RunningThroughQuestionsRandom(){
        RandMultiChoice r = new RandMultiChoice();
        // Perform a click action on a view
        onView(ViewMatchers.withId(R.id.wwmbutton)).perform(ViewActions.click());
        int count = 0;
        while(count!=5) {
            String prompt = getText(withId(R.id.aQuestion));
            int selection  = (int) Math.random() * 4;

            Question q = r.searchQuestion(prompt);
            String correct = q.getCorrectChoice().toString();
            String choiceA = getText(withId(R.id.choicea));
            String choiceB = getText(withId(R.id.choiceb));
            String choiceC = getText(withId(R.id.choicec));
            String choiceD = getText(withId(R.id.choiced));
            boolean isCorrect = false;

            switch(selection){
                case 0:
                    onView(ViewMatchers.withId(R.id.choicea)).perform(ViewActions.click());
                    isCorrect = choiceA.equals(correct);
                    break;
                case 1:
                    onView(ViewMatchers.withId(R.id.choiceb)).perform(ViewActions.click());
                    isCorrect = choiceB.equals(correct);
                    break;
                case 2:
                    onView(ViewMatchers.withId(R.id.choicec)).perform(ViewActions.click());
                    isCorrect = choiceC.equals(correct);
                    break;
                case 3:
                    onView(ViewMatchers.withId(R.id.choiced)).perform(ViewActions.click());
                    isCorrect = choiceD.equals(correct);
                    break;
            }


            onView(ViewMatchers.withId(R.id.submitbutton)).perform(ViewActions.click());
            count++;
            if(count!=5&&isCorrect){
                onView(ViewMatchers.withId(R.id.nextbutton)).perform(ViewActions.click());
            }
            if(!isCorrect){
                break;
            }
        }

    }


    /**
     * Tests the screens for when the user gets every question right, and then when they choose to
     * play again or go back to the menu
     */
    @Test
    public void RunningThroughQuestionsAllCorrect(){
        RandMultiChoice r = new RandMultiChoice();
        // Perform a click action on a view
        onView(ViewMatchers.withId(R.id.wwmbutton)).perform(ViewActions.click());
        int countQ = 0;
        int countR = 0;
        while(countR !=2) {
            while (countQ != 5) {
                String prompt = getText(withId(R.id.aQuestion));


                Question q = r.searchQuestion(prompt);
                String correct = q.getCorrectChoice().toString();
                String choiceA = getText(withId(R.id.choicea));
                String choiceB = getText(withId(R.id.choiceb));
                String choiceC = getText(withId(R.id.choicec));
                String choiceD = getText(withId(R.id.choiced));
                if (correct.equals(choiceA)) {
                    onView(ViewMatchers.withId(R.id.choicea)).perform(ViewActions.click());
                } else if (correct.equals(choiceB)) {
                    onView(ViewMatchers.withId(R.id.choiceb)).perform(ViewActions.click());
                } else if (correct.equals(choiceC)) {
                    onView(ViewMatchers.withId(R.id.choicec)).perform(ViewActions.click());
                } else if (correct.equals(choiceD)) {
                    onView(ViewMatchers.withId(R.id.choiced)).perform(ViewActions.click());
                }

                onView(ViewMatchers.withId(R.id.submitbutton)).perform(ViewActions.click());
                countQ++;


                if (countQ != 5) {
                    onView(ViewMatchers.withId(R.id.nextbutton)).perform(ViewActions.click());
                    ViewInteraction correctText = Espresso.onView(ViewMatchers.withId(R.id.correctText)); // saves game name text
                    correctText.check( // used to check if we are back on Game Config screen
                            ViewAssertions.matches(
                                    ViewMatchers.withSubstring(
                                            "CORRECT"
                                    )
                            )
                    );
                }else{
                    ViewInteraction correctText = Espresso.onView(ViewMatchers.withId(R.id.correctText)); // saves game name text
                    correctText.check( // used to check if we are back on Game Config screen
                            ViewAssertions.matches(
                                    ViewMatchers.withSubstring(
                                            "CORRECT"
                                    )
                            )
                    );
                }
            }
            switch(countR) {
                case 0:
                    onView(ViewMatchers.withId(R.id.yesbutton)).perform(ViewActions.click());
                    break;
                case 1:
                    onView(ViewMatchers.withId(R.id.menubutton)).perform(ViewActions.click());
            }
            countR++;
        }

    }

    /**
     * Tests the screens for when the user loses on a question, and then when they choose to
     * play again or go back to the menu
     */
    @Test
    public void RunningThroughQuestionsLoseAndReplay(){
        RandMultiChoice r = new RandMultiChoice();
        // Perform a click action on a view
        onView(ViewMatchers.withId(R.id.wwmbutton)).perform(ViewActions.click());

        int count = 0;
        while(count!=2) {
            String prompt = getText(withId(R.id.aQuestion));


            Question q = r.searchQuestion(prompt);
            String correct = q.getCorrectChoice().toString();
            String choiceA = getText(withId(R.id.choicea));
            String choiceB = getText(withId(R.id.choiceb));
            String choiceC = getText(withId(R.id.choicec));
            String choiceD = getText(withId(R.id.choiced));
            boolean isCorrect = true;

            while (isCorrect) { //runs until false answer is selected
                int selection = (int) (Math.random() * 4);
                Log.d("selection", String.valueOf(selection));
                switch (selection) {
                    case 0:
                        onView(ViewMatchers.withId(R.id.choicea)).perform(ViewActions.click());
                        isCorrect = choiceA.equals(correct);
                        break;
                    case 1:
                        onView(ViewMatchers.withId(R.id.choiceb)).perform(ViewActions.click());
                        isCorrect = choiceB.equals(correct);
                        break;
                    case 2:
                        onView(ViewMatchers.withId(R.id.choicec)).perform(ViewActions.click());
                        isCorrect = choiceC.equals(correct);
                        break;
                    case 3:
                        onView(ViewMatchers.withId(R.id.choiced)).perform(ViewActions.click());
                        isCorrect = choiceD.equals(correct);
                        break;
                }
            }
            onView(ViewMatchers.withId(R.id.submitbutton)).perform(ViewActions.click());

            switch(count) {
                case 0:
                    onView(ViewMatchers.withId(R.id.yesbutton)).perform(ViewActions.click());
                    break;
                case 1:
                    onView(ViewMatchers.withId(R.id.menubutton)).perform(ViewActions.click());
            }
            count++;
            }
        }







    String getText(final Matcher<View> matcher) {
        final String[] stringHolder = { null };
        onView(matcher).perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(TextView.class);
            }

            @Override
            public String getDescription() {
                return "getting text from a TextView";
            }

            @Override
            public void perform(UiController uiController, View view) {
                TextView tv = (TextView)view; //Save, because of check in getConstraints()
                stringHolder[0] = tv.getText().toString();
            }
        });
        return stringHolder[0];
    }


}
