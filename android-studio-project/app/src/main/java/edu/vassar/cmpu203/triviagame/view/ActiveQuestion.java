package edu.vassar.cmpu203.triviagame.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.vassar.cmpu203.triviagame.databinding.FragmentActiveQuestionBinding;
import edu.vassar.cmpu203.triviagame.model.Question;


public class ActiveQuestion extends Fragment implements IActiveQuestionView {

    private FragmentActiveQuestionBinding binding;
    private Listener listener;

    public ActiveQuestion(){}

    public ActiveQuestion(Listener listener){
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        this.binding = FragmentActiveQuestionBinding.inflate(inflater);
        return this.binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        int qNumber = numQuestion();
        this.binding.numCount.setText("" + qNumber);
        Question q = curQuestion();
        this.binding.aQuestion.setText(q.getPrompt());
        this.binding.choicea.setText(q.getChoice(0).toString());
        this.binding.choiceb.setText(q.getChoice(1).toString());
        this.binding.choicec.setText(q.getChoice(2).toString());
        this.binding.choiced.setText(q.getChoice(3).toString());
    }

    public int numQuestion(){
        return this.listener.questionNumber();
    }

    public Question curQuestion() {
        return this.listener.getQuestion();
    }
}



