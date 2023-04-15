package edu.vassar.cmpu203.triviagame.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import edu.vassar.cmpu203.triviagame.R;
import edu.vassar.cmpu203.triviagame.databinding.FragmentGameModeInfoBinding;
//import edu.vassar.cmpu203.triviagame.databinding.FragmentQuestionBinding;


public class Game_Mode_Fragment extends Fragment implements IGameModeView{
    private FragmentGameModeInfoBinding binding;
    private Listener listener;

    public Game_Mode_Fragment(){}

    public Game_Mode_Fragment(Listener listener){
        this.listener = listener;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        this.binding = FragmentGameModeInfoBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        this.binding.gobackbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Game_Mode_Fragment.this.listener.onGoBack();
            }

        });
    }
}