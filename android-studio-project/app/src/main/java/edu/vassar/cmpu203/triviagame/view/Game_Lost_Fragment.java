package edu.vassar.cmpu203.triviagame.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.vassar.cmpu203.triviagame.R;
import edu.vassar.cmpu203.triviagame.databinding.FragmentGameLostBinding;
//import edu.vassar.cmpu203.triviagame.databinding.FragmentQuestionBinding;
import edu.vassar.cmpu203.triviagame.model.Choice;

public class Game_Lost_Fragment extends Fragment implements IGameLostView{
    private FragmentGameLostBinding binding;
    private Listener listener;

    public Game_Lost_Fragment(){}

    public Game_Lost_Fragment(Listener listener){
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        this.binding = FragmentGameLostBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        Choice c = correctAnswerChoice(); // calls helper method
        this.binding.rightAnswer.setText(c.toString()); // sets rightAnswer text to the actual right answer
        this.binding.yesbutton.setOnClickListener(new View.OnClickListener() { // sets listener on yes button to play again
            @Override
            public void onClick(View view) {
                Game_Lost_Fragment.this.listener.onPlayAgain();
            } // calls onPlayAgain() in MainActivity
        });
        this.binding.menubutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Game_Lost_Fragment.this.listener.onMenu();
            } // calls onMenu() in MainActivity
        });
    }

    /**
     * Pulls the correct Answer choice from MainActivity
     * @return the correct Answer Choice
     */
    public Choice correctAnswerChoice(){
        return this.listener.rightAnswer(); // calls rightAnswer() in MainActivity
    }
}