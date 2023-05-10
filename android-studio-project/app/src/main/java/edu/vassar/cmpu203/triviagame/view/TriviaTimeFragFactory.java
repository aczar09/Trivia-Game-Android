package edu.vassar.cmpu203.triviagame.view;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import edu.vassar.cmpu203.triviagame.controller.MainActivity;

public class TriviaTimeFragFactory extends FragmentFactory {
    private static final String VIEW_PACKAGE = TriviaTimeFragFactory.class.getPackage().getName(); // package where all all fragments reside
    private final MainActivity controller; // the controller instance to pass to fragments
    /**
     * Constructor method.
     * @param controller the activity to pass in to fragments
     */
    public TriviaTimeFragFactory(MainActivity controller){
        this.controller = controller;
    }

    /**
     * Instantiate for the screen saves
     * @param classLoader The default classloader to use for instantiation
     * @param className The class name of the fragment to instantiate.
     * @return
     */
    public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull String className){
        // convert from class name to class
        Class<? extends Fragment> fragClass = loadFragmentClass(classLoader, className);
        if (fragClass.getPackage().getName().equals(VIEW_PACKAGE)){
            try{
                Constructor<?>[] fcons = fragClass.getConstructors(); // get all the constructors
                assert fcons.length > 0 : "Fragment class does not have a constructor";
                return (Fragment) fcons[0].newInstance(controller); // go with first constructor
            }catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                final String emsg = String.format("Can't instantiate %s: ensure it's concrete and " +
                        "has a public constructor with a ControllerActivity parameter", fragClass);
                Log.e("TRIVIA TIME", emsg);
                e.printStackTrace();
            }

        }
        // default is to delegate to superclass
        return super.instantiate(classLoader, className);
    }
}
