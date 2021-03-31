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
import com.google.android.material.snackbar.Snackbar;

import static androidx.navigation.fragment.NavHostFragment.findNavController;

public class FriendFragment extends Fragment {


    //private ProfileViewModel profileViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_friends, container, false);
        NavController navCtrl = findNavController(this);

        ImageButton btn1 = root.findViewById(R.id.imageButton1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navCtrl.navigate(R.id.nav_mailpaper_choose);
            }
        });

        /*ImageButton btn2 = root.findViewById(R.id.imageButton2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "測試用", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                navCtrl.navigate(R.id.nav_mail);
            }
        });*/
        return root;
    }
}
