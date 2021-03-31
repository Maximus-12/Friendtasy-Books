package com.example.friendtasybooks.ui.mail;

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

public class MailFragmentRead extends Fragment {


    //private ProfileViewModel profileViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_mailpaper_read, container, false);
        NavController navCtrl = findNavController(this);
        Button readbutton = root.findViewById(R.id.readbutton);
        readbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navCtrl.navigate(R.id.action_nav_mailpaper_read_to_nav_mail);
            }
        });
        return root;
    }
}
