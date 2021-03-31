package com.example.friendtasybooks.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import com.example.friendtasybooks.R;

import static androidx.navigation.fragment.NavHostFragment.findNavController;

public class MybookFragmentSelectClassify extends Fragment {


    //private ProfileViewModel profileViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_mybook_select_classify, container, false);
        NavController navCtrl = findNavController(this);
        Button yesbutton = root.findViewById(R.id.yesbutton);
        yesbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navCtrl.navigate(R.id.nav_mybook_select);
            }
        });
        return root;
    }
}
