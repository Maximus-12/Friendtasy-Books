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

public class ProfileFragmentArea extends Fragment {


    //private ProfileViewModel profileViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile_area, container, false);
        NavController navCtrl = findNavController(this);
        UserData userdata=((MainActivity)getActivity()).read_data();
        ImageView image_Avatar = root.findViewById(R.id.image_Avatar);
        ((MainActivity)getActivity()).setUsericon(userdata,image_Avatar);

        EditText profile_area=root.findViewById(R.id.profile_area); //profile_name.getText().toString()
        Button profile_area_button = root.findViewById(R.id.profile_area_button);
        profile_area_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userdata.city=profile_area.getText().toString();
                if(userdata.city.isEmpty()) userdata.city="未輸入";
                ((MainActivity)getActivity()).write_data(userdata);
                navCtrl.navigate(R.id.action_nav_profile_area_to_nav_profile);
            }
        });
        return root;
    }
}
