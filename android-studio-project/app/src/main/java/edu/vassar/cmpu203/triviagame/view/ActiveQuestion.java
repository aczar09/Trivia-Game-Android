package edu.vassar.cmpu203.triviagame.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;

import edu.vassar.cmpu203.triviagame.R;
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
        this.binding.numCount.setText("" + qNumber); //sets the questionNumber
        Question q = curQuestion();
        this.binding.aQuestion.setText(q.getPrompt()); // sets question text
        this.binding.choicea.setText(q.getChoice(0).toString()); // set
        this.binding.choiceb.setText(q.getChoice(1).toString()); // text
        this.binding.choicec.setText(q.getChoice(2).toString()); // of
        this.binding.choiced.setText(q.getChoice(3).toString()); // choices

        this.binding.submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActiveQuestion.this.binding.choicea.isChecked()){ // sees if player selects choicea

                    ActiveQuestion.this.listener.onSubmit(0); // messages controller about selection
                }
                else if (ActiveQuestion.this.binding.choiceb.isChecked()){ // sees if player selects choiceb

                    ActiveQuestion.this.listener.onSubmit(1); // messages controller about selection
                }
                else if (ActiveQuestion.this.binding.choicec.isChecked()){ // sees if player selects choicec

                    ActiveQuestion.this.listener.onSubmit(2); // messages controller about selection
                }
                else if (ActiveQuestion.this.binding.choiced.isChecked()){ // sees if player selects choiced

                    ActiveQuestion.this.listener.onSubmit(3); // messages controller about selection
                }
                else {
                    Snackbar.make(view, R.string.need_ans, Snackbar.LENGTH_LONG).show(); // player makes no selection so snackbar is made
                    return;
                }
            }
        });
    }

    public int numQuestion(){
        return this.listener.questionNumber();
    }

    public Question curQuestion() {
        return this.listener.getQuestion();
    }
}



