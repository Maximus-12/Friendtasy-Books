package com.example.friendtasybooks.ui.friends;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import com.example.friendtasybooks.R;

import static androidx.navigation.fragment.NavHostFragment.findNavController;

public class FriendFragmentMailpaperChoose extends Fragment {


    //private ProfileViewModel profileViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_mailpaper_choose, container, false);
        NavController navCtrl = findNavController(this);
        Button yesbutton = root.findViewById(R.id.yesbutton);
        yesbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navCtrl.navigate(R.id.nav_mailpaper_write);
            }
        });
        return root;
    }
}
