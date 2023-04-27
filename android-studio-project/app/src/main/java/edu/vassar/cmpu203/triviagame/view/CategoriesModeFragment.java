package edu.vassar.cmpu203.triviagame.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.vassar.cmpu203.triviagame.R;
import edu.vassar.cmpu203.triviagame.databinding.FragmentCategoriesModeBinding;
import edu.vassar.cmpu203.triviagame.databinding.FragmentGameModeInfoBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class CategoriesModeFragment extends Fragment implements ICategoriesModeView{

    private FragmentCategoriesModeBinding binding;
    private Listener listener;

    public CategoriesModeFragment() {
        // Required empty public constructor
    }

    public CategoriesModeFragment(Listener listener){ this.listener = listener;}


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        this.binding = FragmentCategoriesModeBinding.inflate(inflater);
        return this.binding.getRoot();
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){

        this.binding.geobutton.setOnClickListener(view1 -> CategoriesModeFragment.this.listener.onGeo()); // calls onRandom() in MainActivity
        this.binding.tvbutton.setOnClickListener(view12 -> CategoriesModeFragment.this.listener.onTV()); // calls onMoreInfo() in MainActivity
        this.binding.gbbutton.setOnClickListener(view1 -> CategoriesModeFragment.this.listener.onGoBack());
        this.binding.hobbiesbutton.setOnClickListener(view1 -> CategoriesModeFragment.this.listener.onHobbies());
        this.binding.sportsbutton.setOnClickListener(view1 -> CategoriesModeFragment.this.listener.onSports());
        //return View.inflate(R.layout.fragment_game__config, this, false);
    }


}