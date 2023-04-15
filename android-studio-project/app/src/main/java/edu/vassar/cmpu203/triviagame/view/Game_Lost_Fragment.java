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
        Choice c = correctAnswerChoice();
        this.binding.rightAnswer.setText(c.toString());
    }
    public Choice correctAnswerChoice(){
        return this.listener.rightAnswer();
    }
}