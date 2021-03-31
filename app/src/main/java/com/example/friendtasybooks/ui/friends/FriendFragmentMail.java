package com.example.friendtasybooks.ui.friends;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import com.example.friendtasybooks.R;
import com.google.android.material.snackbar.Snackbar;

import static androidx.navigation.fragment.NavHostFragment.findNavController;

public class FriendFragmentMail extends Fragment {


    //private ProfileViewModel profileViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_mail, container, false);
        NavController navCtrl = findNavController(this);

        TextView mail1 = root.findViewById(R.id.mail1);
        mail1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navCtrl.navigate(R.id.nav_mailpaper_read);
            }
        });

        TextView mail2 = root.findViewById(R.id.mail2);
        mail2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "測試用", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                navCtrl.navigate(R.id.nav_friends);
            }
        });

        return root;
    }
}
