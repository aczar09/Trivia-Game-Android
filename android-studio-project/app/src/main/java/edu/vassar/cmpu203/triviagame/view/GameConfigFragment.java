package edu.vassar.cmpu203.triviagame.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.vassar.cmpu203.triviagame.R;
import edu.vassar.cmpu203.triviagame.databinding.FragmentGameConfigBinding;


public class GameConfigFragment extends Fragment implements IGameConfigView {

    private FragmentGameConfigBinding binding;
    private Listener listener;

    public GameConfigFragment() {
        // Required empty public constructor
    }

    /**
     *
     * @param listener observer to be notified of events of interest
     */
    public GameConfigFragment(Listener listener){
        this.listener = listener;
    }


    /**
     * onCreateView() overrides method of the same name from superclass
     * @param inflater The LayoutInflater object that can be used to inflate
     * any views in the fragment,
     * @param container If non-null, this is the parent view that the fragment's
     * UI should be attached to.  The fragment should not add the view itself,
     * but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     *
     * @return the root of the layout that has just been inflated
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.binding = FragmentGameConfigBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    /**
     * onViewCreated() overrides method of the same name from superclass. Called by android platform
     * after the layout has been inflated, and before the view transitions to the created state
     * @param view The View returned by {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        this.binding.wwmbutton.setOnClickListener(new View.OnClickListener() {
            /**
             * Listener method to be called when the add item button is clicked
             * @param view the view that was clicked on
             */
            @Override
            public void onClick(View view) {
                //GameConfigFragment.this.listener.on
            }
        });
        this.binding.randbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        this.binding.moreinfobutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

            }
        });
        //return View.inflate(R.layout.fragment_game__config, this, false);
    }
}