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

        ImageView headboy1 = root.findViewById(R.id.headboy1);
        headboy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userdata.headshot=1;
                ((MainActivity)getActivity()).setUsericon(userdata,image_Avatar);
                ((MainActivity)getActivity()).write_data(userdata);
            }
        });
        ImageView headboy2 = root.findViewById(R.id.headboy2);
        headboy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userdata.headshot=2;
                ((MainActivity)getActivity()).setUsericon(userdata,image_Avatar);
                ((MainActivity)getActivity()).write_data(userdata);
            }
        });
        ImageView headboy3 = root.findViewById(R.id.headboy3);
        headboy3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userdata.headshot=3;
                ((MainActivity)getActivity()).setUsericon(userdata,image_Avatar);
                ((MainActivity)getActivity()).write_data(userdata);
            }
        });
        ImageView headboy4 = root.findViewById(R.id.headboy4);
        headboy4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userdata.headshot=4;
                ((MainActivity)getActivity()).setUsericon(userdata,image_Avatar);
                ((MainActivity)getActivity()).write_data(userdata);
            }
        });

        ImageView headgirl1 = root.findViewById(R.id.headgirl1);
        headgirl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userdata.headshot=5;
                ((MainActivity)getActivity()).setUsericon(userdata,image_Avatar);
                ((MainActivity)getActivity()).write_data(userdata);
            }
        });
        ImageView headgirl2 = root.findViewById(R.id.headgirl2);
        headgirl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userdata.headshot=6;
                ((MainActivity)getActivity()).setUsericon(userdata,image_Avatar);
                ((MainActivity)getActivity()).write_data(userdata);
            }
        });
        ImageView headgirl3 = root.findViewById(R.id.headgirl3);
        headgirl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userdata.headshot=7;
                ((MainActivity)getActivity()).setUsericon(userdata,image_Avatar);
                ((MainActivity)getActivity()).write_data(userdata);
            }
        });
        ImageView headgirl4 = root.findViewById(R.id.headgirl4);
        headgirl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userdata.headshot=8;
                ((MainActivity)getActivity()).setUsericon(userdata,image_Avatar);
                ((MainActivity)getActivity()).write_data(userdata);
            }
        });
        return root;
    }
}
