package edu.vassar.cmpu203.triviagame.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import edu.vassar.cmpu203.triviagame.R;
import edu.vassar.cmpu203.triviagame.databinding.FragmentQuestionBinding;
import edu.vassar.cmpu203.triviagame.model.Question;


public class QuestionFragment extends Fragment implements IQuestionView{
    private FragmentQuestionBinding binding;

    private Question question;

    private Listener listener;

    public QuestionFragment(){

    }

    public QuestionFragment(Listener listener, Question question){
        this.listener = listener;
        this.question = question;
        //questionPrompt = (TextView) getView().findViewById(R.id.questiontext);
    }

    public void setQuestion(Question q){
        this.question = q;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        this.binding = FragmentQuestionBinding.inflate(inflater);
        //questionPrompt

        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){

    }


    public void setQuestionDisplay(){
        this.binding.questiontext.setText(question.getPrompt());
        RadioButton choice1 = this.binding.getRoot().findViewById(R.id.radioButton);
        choice1.setText(question.getChoice(0).toString());
        RadioButton choice2 = this.binding.getRoot().findViewById(R.id.radioButton2);
        choice2.setText(question.getChoice(1).toString());
        RadioButton choice3 = this.binding.getRoot().findViewById(R.id.radioButton3);
        choice3.setText(question.getChoice(2).toString());
        RadioButton choice4 = this.binding.getRoot().findViewById(R.id.radioButton4);
        choice4.setText(question.getChoice(3).toString());
    }
}