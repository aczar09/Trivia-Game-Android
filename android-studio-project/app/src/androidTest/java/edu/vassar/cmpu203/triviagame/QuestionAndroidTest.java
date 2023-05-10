package edu.vassar.cmpu203.triviagame;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.test.InstrumentationRegistry;
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
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import edu.vassar.cmpu203.triviagame.controller.MainActivity;
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
        // Obtain the Context of the application under test
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        AssetManager assetManager = appContext.getAssets();


        RandMultiChoice r = new RandMultiChoice(assetManager);
        // Perform a click action on a view
        onView(ViewMatchers.withId(R.id.wwmbutton)).perform(ViewActions.click());
        int count = 0;
        while(count!=5) {
            checkSubmitButton();
            String category = getText(withId(R.id.categoryText));
            String prompt = getText(withId(R.id.aQuestion));
            int selection  = (int) (Math.random() * 4);

            Question q = r.searchQuestion(prompt,category);
            List<String> choices = getChoiceText();
            String correct = q.getCorrectChoice().toString();
            boolean isCorrect = makeSelectionSwitch(selection,choices.get(0), choices.get(1), choices.get(2), choices.get(3),correct);

            onView(ViewMatchers.withId(R.id.submitbutton)).perform(ViewActions.click());
            count++;
            if(count!=5&&isCorrect){
                checkCorrectScreen();
                onView(ViewMatchers.withId(R.id.nextbutton)).perform(ViewActions.click());
            }
            if(!isCorrect){
                checkGameOver();
                break;
            }
        }

    }


    /**
     * Tests the screens for when the user choose WMM mode and gets every question right, and then when they choose to
     * play again or go back to the menu
     */
    @Test
    public void RunningThroughQuestionsAllCorrectWMM(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        AssetManager assetManager = appContext.getAssets();
        RandMultiChoice r = new RandMultiChoice(assetManager);
        // Perform a click action on a view
        onView(ViewMatchers.withId(R.id.wwmbutton)).perform(ViewActions.click());
        int countQ = 0;
        int countR = 0;
        checkSubmitButton();

        while(countR !=2) {
            while (countQ != 5) {
                String category = getText(withId(R.id.categoryText));
                String prompt = getText(withId(R.id.aQuestion));



                Question q = r.searchQuestion(prompt,category);
                String correct = q.getCorrectChoice().toString();
                List<String> choices = getChoiceText();
                makeSelectionIf(choices.get(0), choices.get(1), choices.get(2), choices.get(3),correct);

                onView(ViewMatchers.withId(R.id.submitbutton)).perform(ViewActions.click());
                countQ++;
                if (countQ != 5) {
                    checkCorrectScreen();
                    onView(ViewMatchers.withId(R.id.nextbutton)).perform(ViewActions.click());
                }else{
                    checkCongratsScreen();
                    switch(countR) {
                        case 0:
                            onView(ViewMatchers.withId(R.id.yeswonbutton)).perform(ViewActions.click());
                            checkSubmitButton();
                            break;
                        case 1:
                            onView(ViewMatchers.withId(R.id.menuwonbutton)).perform(ViewActions.click());
                            checkGameConfig();
                            break;
                    }
                }
            }
            countR++;
            countQ = 0;
        }

    }

    /**
     * Tests the screens for when the user loses on a question, and then when they choose to
     * play again or go back to the menu
     */
    @Test
    public void RunningThroughQuestionsLoseAndReplayWMM(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        AssetManager assetManager = appContext.getAssets();
        RandMultiChoice r = new RandMultiChoice(assetManager);
        // Perform a click action on a view
        onView(ViewMatchers.withId(R.id.wwmbutton)).perform(ViewActions.click());

        int count = 0;
        while(count!=2) {
            String category = getText(withId(R.id.categoryText));
            String prompt = getText(withId(R.id.aQuestion));
            Question q = r.searchQuestion(prompt,category);
            String correct = q.getCorrectChoice().toString();
            List<String> choices = getChoiceText();
            boolean isCorrect = true;

            while (isCorrect) { //runs until false answer is selected
                int selection = (int) (Math.random() * 4);
                Log.d("selection", String.valueOf(selection));
                isCorrect = makeSelectionSwitch(selection,choices.get(0), choices.get(1), choices.get(2), choices.get(3),correct);
            }
            onView(ViewMatchers.withId(R.id.submitbutton)).perform(ViewActions.click());

            checkGameOver();

            switch(count) {
                case 0:
                    onView(ViewMatchers.withId(R.id.yesbutton)).perform(ViewActions.click());
                    checkSubmitButton();
                    break;
                case 1:
                    onView(ViewMatchers.withId(R.id.menubutton)).perform(ViewActions.click());
                    checkGameConfig();
                    break;
            }
            count++;
            }
        }

    /**
     * Tests the screens for when the user choose categories mode and gets every question right
     */
    @Test
    public void RunningThroughQuestionsAllCorrectCategories(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        AssetManager assetManager = appContext.getAssets();
        RandMultiChoice r = new RandMultiChoice(assetManager);
        String[] categories = {"GEOGRAPHY","TELEVISION","HOBBIES","SPORTS", "RANDOM"};
        // Perform a click action on a view
        onView(ViewMatchers.withId(R.id.categoriesbutton)).perform(ViewActions.click());
        checkCategorySelectScreen();

        for(String c: categories){
            int countQ = 0;
            String curCat = categorySelection(c);

            while (countQ != 5) {
                String category = getText(withId(R.id.categoryText));
                ViewInteraction catText = Espresso.onView(ViewMatchers.withId(R.id.categoryText));
                catText.check(
                        ViewAssertions.matches(
                                ViewMatchers.withSubstring(curCat)
                        )
                );

                String prompt = getText(withId(R.id.aQuestion));
                Question q = r.searchQuestion(prompt,category);
                String correct = q.getCorrectChoice().toString();
                List<String> choices = getChoiceText();
                makeSelectionIf(choices.get(0), choices.get(1), choices.get(2), choices.get(3), correct);

                onView(ViewMatchers.withId(R.id.submitbutton)).perform(ViewActions.click());
                countQ++;
                Log.d("questionNum", String.valueOf(countQ));
                if (countQ != 5) {
                    checkCorrectScreen();
                    onView(ViewMatchers.withId(R.id.nextbutton)).perform(ViewActions.click());
                }else{
                    checkCongratsScreen();

                    if ("RANDOM".equals(c)) {
                        onView(withId(R.id.menuwonbutton)).perform(ViewActions.click());
                        checkGameConfig();
                    } else {
                        onView(withId(R.id.yeswonbutton)).perform(ViewActions.click());
                        checkCategorySelectScreen();
                    }
                }
            }
        }

    }


    /**
     * Tests the screens for when the user choose trivial pursuit mode and gets every question right
     */
    @Test
    public void RunningThroughQuestionsAllCorrectTrivialPursuit(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        AssetManager assetManager = appContext.getAssets();
        RandMultiChoice r = new RandMultiChoice(assetManager);
        String[] categories = {"GEOGRAPHY","TELEVISION","HOBBIES","SPORTS", "RANDOM"};
        // Perform a click action on a view
        onView(ViewMatchers.withId(R.id.trivpursuitbutton)).perform(ViewActions.click());
        int countQ = 0;
        for(String c: categories){
            checkCategorySelectScreen();
            String curCat = categorySelection(c);

            String category = getText(withId(R.id.categoryText));
            ViewInteraction catText = Espresso.onView(ViewMatchers.withId(R.id.categoryText)); // saves game name text
            catText.check( // used to check if we are back on Game Config screen
                    ViewAssertions.matches(
                            ViewMatchers.withSubstring(curCat)
                    )
            );

            String prompt = getText(withId(R.id.aQuestion));
            Question q = r.searchQuestion(prompt,category);
            String correct = q.getCorrectChoice().toString();
            List<String> choices = getChoiceText();

            makeSelectionIf(choices.get(0), choices.get(1), choices.get(2), choices.get(3), correct);

            Log.d("check1", "here");
            onView(ViewMatchers.withId(R.id.submitbutton)).perform(ViewActions.click());
            countQ++;
            Log.d("questionNum", String.valueOf(countQ));
            if (countQ != 5) {
                checkCorrectScreen();
                onView(ViewMatchers.withId(R.id.nextbutton)).perform(ViewActions.click());

            }else{
                checkCongratsScreen();
            }

        }

    }


    /**
     * Helper method to return whether a selection is correct or incorrect
     * @param selection
     * @param choiceA
     * @param choiceB
     * @param choiceC
     * @param choiceD
     * @param correct
     * @return
     */
    boolean makeSelectionSwitch(int selection, String choiceA, String choiceB, String choiceC, String choiceD, String correct){
        switch(selection){
            case 0:
                onView(ViewMatchers.withId(R.id.choicea)).perform(ViewActions.click());
                return choiceA.equals(correct);
            case 1:
                onView(ViewMatchers.withId(R.id.choiceb)).perform(ViewActions.click());
                return choiceB.equals(correct);
            case 2:
                onView(ViewMatchers.withId(R.id.choicec)).perform(ViewActions.click());
                return choiceC.equals(correct);
            case 3:
                onView(ViewMatchers.withId(R.id.choiced)).perform(ViewActions.click());
                return choiceD.equals(correct);
        }
        return false;
    }

    /**
     * Helper method to select the correct answer choice
     * @param choiceA
     * @param choiceB
     * @param choiceC
     * @param choiceD
     * @param correct
     */
    void makeSelectionIf(String choiceA, String choiceB, String choiceC, String choiceD, String correct){
        if (correct.equals(choiceA)) {
            onView(ViewMatchers.withId(R.id.choicea)).perform(ViewActions.click());
        } else if (correct.equals(choiceB)) {
            onView(ViewMatchers.withId(R.id.choiceb)).perform(ViewActions.click());
        } else if (correct.equals(choiceC)) {
            onView(ViewMatchers.withId(R.id.choicec)).perform(ViewActions.click());
        } else if (correct.equals(choiceD)) {
            onView(ViewMatchers.withId(R.id.choiced)).perform(ViewActions.click());
        }

    }

    /**
     * Helper method to get text from textView
     * @param matcher
     * @return
     */
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

    /**
     * Helper method to return String list of choices
     * @return
     */
    List<String> getChoiceText(){
        List<String> choices = new ArrayList<>();
        String choiceA = getText(withId(R.id.choicea));
        String choiceB = getText(withId(R.id.choiceb));
        String choiceC = getText(withId(R.id.choicec));
        String choiceD = getText(withId(R.id.choiced));
        choices.add(choiceA);
        choices.add(choiceB);
        choices.add(choiceC);
        choices.add(choiceD);
        return choices;
    }

    /**
     * Helper method to check if on Active Question screen
     */
    void checkSubmitButton(){
        ViewInteraction submitB = Espresso.onView(ViewMatchers.withId(R.id.submitbutton));
        submitB.check( // used to check if we are back on Active Question screen
                ViewAssertions.matches(
                        ViewMatchers.withSubstring(
                                "SUBMIT"
                        )
                )
        );
    }

    /**
     * Helper method to select from a list of categories
     * @param c
     * @return
     */
    String categorySelection(String c){
        switch(c){
            case "GEOGRAPHY":
                onView(ViewMatchers.withId(R.id.geobutton)).perform(ViewActions.click());
                break;
            case "TELEVISION":
                onView(ViewMatchers.withId(R.id.tvbutton)).perform(ViewActions.click());
                break;
            case "HOBBIES":
                onView(ViewMatchers.withId(R.id.hobbiesbutton)).perform(ViewActions.click());
                break;
            case "SPORTS":
                onView(ViewMatchers.withId(R.id.sportsbutton)).perform(ViewActions.click());
                break;
            case "RANDOM":
                onView(ViewMatchers.withId(R.id.randomcatbutton)).perform(ViewActions.click());
                return getText(withId(R.id.categoryText));
        }
        return c;
    }

    /**
     * Helper method to check if on the Correct Answer screen
     */
    void checkCorrectScreen(){
        ViewInteraction correctText = Espresso.onView(ViewMatchers.withId(R.id.correctText));
        correctText.check( // used to check if we are back on Correct Answer screen
                ViewAssertions.matches(
                        ViewMatchers.withSubstring(
                                "CORRECT!!!"
                        )
                )
        );
    }

    /**
     * Helper method to check if on the category selection screen
     */
    void checkCategorySelectScreen(){
        ViewInteraction categorySelect = Espresso.onView(ViewMatchers.withId(R.id.categoryModeText));
        categorySelect.check( // used to check if we are back on Active Question screen
                ViewAssertions.matches(
                        ViewMatchers.withSubstring(
                                "Please choose your wanted category:"
                        )
                )
        );
    }

    /**
     * Helper method to check if on the game config screen
     */
    void checkGameConfig(){
        ViewInteraction gameName = Espresso.onView(ViewMatchers.withId(R.id.game_name)); // saves game name text
        gameName.check( // used to check if we are back on Game Config screen
                ViewAssertions.matches(
                        ViewMatchers.withSubstring(
                                "Welcome to Trivia Time"
                        )
                )
        );
    }

    /**
     * Helper method to check if congrats screen
     */
    void checkCongratsScreen(){
        ViewInteraction congrats = Espresso.onView(ViewMatchers.withId(R.id.congratsText));
        congrats.check( // used to check if we are back on Game Won screen
                ViewAssertions.matches(
                        ViewMatchers.withSubstring(
                                "CONGRATS! YOU WON THE GAME! YOU'RE A TRIVIA MASTER!"
                        )
                )
        );
    }

    /**
     * Helper method to check if on game over screen
     */
    void checkGameOver(){
        ViewInteraction gameOver = Espresso.onView(ViewMatchers.withId(R.id.gameOverText));
        gameOver.check( // used to check if we are back on Active Question screen
                ViewAssertions.matches(
                        ViewMatchers.withSubstring(
                                "Sorry! Game Over!"
                        )
                )
        );
    }

}
