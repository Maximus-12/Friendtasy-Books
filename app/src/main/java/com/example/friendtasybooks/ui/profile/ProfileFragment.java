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
import com.example.friendtasybooks.UserData;
import com.google.android.material.snackbar.Snackbar;

import static androidx.navigation.fragment.NavHostFragment.findNavController;

public class ProfileFragment extends Fragment {


    //private ProfileViewModel profileViewModel;
    ImageView image_Avatar;
    UserData userdata;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        NavController navCtrl = findNavController(this);
        userdata=((MainActivity)getActivity()).read_data();
        image_Avatar = root.findViewById(R.id.image_Avatar);
        ((MainActivity)getActivity()).setUsericon(userdata,image_Avatar);
        //image change
        TextView nickname =  root.findViewById(R.id.text_NicknameText);
        nickname.setText((userdata.username));
        TextView gender =  root.findViewById(R.id.text_GenderText);
        /*if(userdata.gender==1) gender.setText("男");
        else if(userdata.gender==2) gender.setText("女");
        else gender.setText("未選擇");*/
        gender.setText(userdata.gender);
        TextView area =  root.findViewById(R.id.text_AreaText);
        area.setText((userdata.city));


        image_Avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navCtrl.navigate(R.id.nav_profile_head);
            }
        });
        nickname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navCtrl.navigate(R.id.nav_profile_name);
            }
        });
        gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navCtrl.navigate(R.id.nav_profile_gender);
            }
        });
        area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navCtrl.navigate(R.id.nav_profile_area);
            }
        });
        /*Button save_profile = root.findViewById(R.id.save_profile);
        save_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "暫時拿來測試頭貼更換", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                userdata.headshot++;
                ((MainActivity)getActivity()).setUsericon(userdata,image_Avatar);
                //setUsericon();
                ((MainActivity)getActivity()).write_data(userdata);
            }
        });*/
        return root;
    }
    /*private void setUsericon(){
        if(userdata.headshot>0&&userdata.headshot<5){
            image_Avatar.setImageResource(getResources().getIdentifier("headboy"+ userdata.headshot, "drawable", getActivity().getPackageName()));
        }
        else if (userdata.headshot>4&&userdata.headshot<9){
            image_Avatar.setImageResource(getResources().getIdentifier("headgirl"+ (userdata.headshot-4), "drawable", getActivity().getPackageName()));
        }
        else {
            userdata.headshot=1;
            image_Avatar.setImageResource(getResources().getIdentifier("headboy1", "drawable", getActivity().getPackageName()));
        }
    }*/
}

