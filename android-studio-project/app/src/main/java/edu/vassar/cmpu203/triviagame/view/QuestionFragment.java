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

import com.google.android.material.snackbar.Snackbar;

import edu.vassar.cmpu203.triviagame.R;
import edu.vassar.cmpu203.triviagame.databinding.FragmentQuestionBinding;
import edu.vassar.cmpu203.triviagame.model.Question;
import edu.vassar.cmpu203.triviagame.model.RandMultiChoice;


public class QuestionFragment extends Fragment implements IQuestionView{
    private FragmentQuestionBinding binding;

    private Question question;

    private Listener listener;

    public QuestionFragment(){
        RandMultiChoice r = new RandMultiChoice();
        question = r.getQuestion();
    }

    public QuestionFragment(Listener listener){
        this.listener = listener;
        RandMultiChoice r = new RandMultiChoice();
        question = r.getQuestion();
        //this.question = question;
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

        this.binding.submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (QuestionFragment.this.binding.radioButton.isChecked()){
                    QuestionFragment.this.listener.checkAnswer(question, 0);
                }
                else if (QuestionFragment.this.binding.radioButton2.isChecked()){
                    QuestionFragment.this.listener.checkAnswer(question, 1);
                }
                else if (QuestionFragment.this.binding.radioButton3.isChecked()){
                    QuestionFragment.this.listener.checkAnswer(question, 2);
                }
                else if (QuestionFragment.this.binding.radioButton4.isChecked()){
                    QuestionFragment.this.listener.checkAnswer(question, 3);
                }
                else{
                    Snackbar.make(view, R.string.need_ans, Snackbar.LENGTH_LONG).show();
                    return;
                }


            }
        });
        setQuestionDisplay();
    }




    public void setQuestionDisplay(){

        this.binding.questiontext.setText(question.getPrompt());
        this.binding.radioButton.setText(question.getChoice(0).toString());
        this.binding.radioButton2.setText(question.getChoice(1).toString());
        this.binding.radioButton3.setText(question.getChoice(2).toString());
        this.binding.radioButton4.setText(question.getChoice(3).toString());
    }
}