package com.example.friendtasybooks.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import com.example.friendtasybooks.MainActivity;
import com.example.friendtasybooks.R;
import com.example.friendtasybooks.UserData;

import static androidx.navigation.fragment.NavHostFragment.findNavController;

public class ProfileFragmentGender extends Fragment {


    //private ProfileViewModel profileViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile_gender, container, false);
        NavController navCtrl = findNavController(this);
        UserData userdata=((MainActivity)getActivity()).read_data();
        ImageView image_Avatar = root.findViewById(R.id.image_Avatar);
        ((MainActivity)getActivity()).setUsericon(userdata,image_Avatar);

        EditText profile_gender=root.findViewById(R.id.profile_gender); //profile_name.getText().toString()
        Button profile_gender_button = root.findViewById(R.id.profile_gender_button);
        profile_gender_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userdata.gender=profile_gender.getText().toString();
                if(userdata.gender.isEmpty()) userdata.gender="未輸入";
                ((MainActivity)getActivity()).write_data(userdata);
                navCtrl.navigate(R.id.action_nav_profile_gender_to_nav_profile);
            }
        });
        return root;
    }
}
