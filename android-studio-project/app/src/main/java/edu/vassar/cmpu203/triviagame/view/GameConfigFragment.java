package edu.vassar.cmpu203.triviagame.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.vassar.cmpu203.triviagame.R;
import edu.vassar.cmpu203.triviagame.databinding.FragmentGameConfigBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GameConfigFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GameConfigFragment extends Fragment implements IGameConfigView {

    private FragmentGameConfigBinding binding;
    private Listener listener;

    public GameConfigFragment() {
        // Required empty public constructor
    }

    public GameConfigFragment(Listener listener){
        this.listener = listener;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.binding = FragmentGameConfigBinding.inflate(inflater);
        return this.binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        this.binding.wwmbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        })
        return inflater.inflate(R.layout.fragment_game__config, container, false);
    }
}