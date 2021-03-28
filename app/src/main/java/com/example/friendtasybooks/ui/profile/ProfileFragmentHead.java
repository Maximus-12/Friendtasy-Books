package com.example.friendtasybooks.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import com.example.friendtasybooks.MainActivity;
import com.example.friendtasybooks.R;
import com.example.friendtasybooks.UserData;
import com.google.android.material.snackbar.Snackbar;

import static androidx.navigation.fragment.NavHostFragment.findNavController;

public class ProfileFragmentHead extends Fragment {


    //private ProfileViewModel profileViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile_head, container, false);
        NavController navCtrl = findNavController(this);
        UserData userdata=((MainActivity)getActivity()).read_data();
        ImageView image_Avatar = root.findViewById(R.id.image_Avatar);
        ((MainActivity)getActivity()).setUsericon(userdata,image_Avatar);

        Button profile_head_button = root.findViewById(R.id.profile_head_button);
        profile_head_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navCtrl.navigate(R.id.action_nav_profile_head_to_nav_profile);
            }
        });
        return root;
    }
}
