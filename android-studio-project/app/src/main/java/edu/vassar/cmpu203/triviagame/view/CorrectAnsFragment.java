package edu.vassar.cmpu203.triviagame.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.vassar.cmpu203.triviagame.databinding.FragmentCorrectAnsBinding;
//import edu.vassar.cmpu203.triviagame.databinding.FragmentQuestionBinding;


public class CorrectAnsFragment extends Fragment implements ICorrectAnsView {

    private FragmentCorrectAnsBinding binding;
    private Listener listener;



    public CorrectAnsFragment(Listener listener){
        this.listener = listener;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        this.binding = FragmentCorrectAnsBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        this.binding.nextbutton.setOnClickListener(new View.OnClickListener() { // actives listener on next button
            @Override
            public void onClick(View view) {
                CorrectAnsFragment.this.listener.onNext();
            } // performs onNext() when user clicks nextbutton
        });
    }

}