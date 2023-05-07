package edu.vassar.cmpu203.triviagame.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.vassar.cmpu203.triviagame.databinding.FragmentGameModeInfoBinding;
//import edu.vassar.cmpu203.triviagame.databinding.FragmentQuestionBinding;


public class GameModeFragment extends Fragment implements IGameModeView{
    private FragmentGameModeInfoBinding binding;
    private Listener listener;



    public GameModeFragment(Listener listener){
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
                GameModeFragment.this.listener.onGoBack();
            } // calls onGoBack() in MainActivity

        });
    }
}