package com.example.friendtasybooks.ui.friends;

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

public class FriendFragmentMailpaperWrite extends Fragment {


    //private ProfileViewModel profileViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_mailpaper_write, container, false);
        NavController navCtrl = findNavController(this);
        Button sendbutton = root.findViewById(R.id.sendbutton);
        sendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navCtrl.navigate(R.id.action_nav_mailpaper_write_to_nav_friends);
            }
        });
        return root;
    }
}
