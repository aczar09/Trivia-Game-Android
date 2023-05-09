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
import edu.vassar.cmpu203.triviagame.databinding.FragmentStatsBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class StatsFragment extends Fragment implements IStatsView{

    private FragmentStatsBinding binding;
    private Listener listener;



    /**
     *
     * @param listener observer to be notified of events of interest
     */
    public StatsFragment(Listener listener){
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
        this.binding = FragmentStatsBinding.inflate(inflater);
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
        if(this.listener != null){
            String cat = this.topCategory();
            this.binding.bestcategorytext.setText(cat +"");
            String mode = this.topMode();
            String nWins = this.numWins();
            String nQuestionCorrect = this.numQuestionsCorrect();
            this.binding.bestgamemodetext.setText(mode+"");
            this.binding.totalwinstext.setText(nWins+"");
            this.binding.totalquestionscorrecttext.setText(nQuestionCorrect+"");

        }
        this.binding.gobackbutton.setOnClickListener(view1 -> StatsFragment.this.listener.onGoBack());
    }

    public String topCategory(){
        return this.listener.getBestCategory();
    }

    public String topMode(){ return this.listener.getBestMode();}
    public String numWins(){ return this.listener.getNumberWins();}
    public String numQuestionsCorrect(){ return this.listener.getNumberQuestionsCorrect();}
}