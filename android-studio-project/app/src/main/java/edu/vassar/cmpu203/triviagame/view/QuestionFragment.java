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


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        this.binding = FragmentQuestionBinding.inflate(inflater);
        //questionPrompt
        TextView questionPrompt = this.binding.getRoot().findViewById(R.id.questiontext);
        questionPrompt.setText("This has changed");
        RadioButton choice1 = this.binding.getRoot().findViewById(R.id.radioButton);
        choice1.setText("choice1");
        RadioButton choice2 = this.binding.getRoot().findViewById(R.id.radioButton2);
        choice2.setText("choice2");
        RadioButton choice3 = this.binding.getRoot().findViewById(R.id.radioButton3);
        choice3.setText("choice3");
        RadioButton choice4 = this.binding.getRoot().findViewById(R.id.radioButton4);
        choice4.setText("choice4");
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){

    }
}