package com.example.friendtasybooks.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;

import com.example.friendtasybooks.MainActivity;
import com.example.friendtasybooks.R;
import com.example.friendtasybooks.ui.slideshow.SlideshowViewModel;

import static androidx.navigation.fragment.NavHostFragment.findNavController;

public class ProfileFragment extends Fragment {


    //private ProfileViewModel profileViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        TextView nickname =  root.findViewById(R.id.text_NicknameText);
        nickname.setText(((MainActivity)getActivity()).getUserName());

        NavController navCtrl = findNavController(this);
        ImageView image_Avatar = root.findViewById(R.id.image_Avatar);
        image_Avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navCtrl.navigate(R.id.nav_profile_head);
            }
        });
        TextView text_NicknameText = root.findViewById(R.id.text_NicknameText);
        text_NicknameText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navCtrl.navigate(R.id.nav_profile_name);
            }
        });
        Button save_profile = root.findViewById(R.id.save_profile);
        save_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navCtrl.navigate(R.id.nav_profile_name);
            }
        });
        return root;
    }
}
