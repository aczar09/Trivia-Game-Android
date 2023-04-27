package edu.vassar.cmpu203.triviagame.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.vassar.cmpu203.triviagame.databinding.FragmentGameWonBinding;


public class GameWonFragment extends Fragment implements IGameWonView {
    private FragmentGameWonBinding binding;
    private Listener listener;

    public GameWonFragment(){}

    public GameWonFragment(Listener listener){
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        this.binding = FragmentGameWonBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        this.binding.yeswonbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GameWonFragment.this.listener.onPlayAgain();
            } // calls onPlayAgain() in MainActivity
        });
        this.binding.menuwonbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GameWonFragment.this.listener.onMenu();
            } // calls onMenu() in MainActivity
        });
    }
}