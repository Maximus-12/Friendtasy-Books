package com.example.friendtasybooks.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import com.example.friendtasybooks.MainActivity;
import com.example.friendtasybooks.R;
import com.example.friendtasybooks.UserData;
import com.google.android.material.snackbar.Snackbar;

import static androidx.navigation.fragment.NavHostFragment.findNavController;

public class ProfileFragmentName extends Fragment {


    //private ProfileViewModel profileViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile_name, container, false);
        NavController navCtrl = findNavController(this);
        UserData userdata=((MainActivity)getActivity()).read_data();

        EditText profile_name=root.findViewById(R.id.profile_name); //profile_name.getText().toString()
        Button profile_name_button = root.findViewById(R.id.profile_name_button);
        profile_name_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userdata.username=profile_name.getText().toString();
                ((MainActivity)getActivity()).write_data(userdata);
                navCtrl.navigate(R.id.nav_profile);
            }
        });
        return root;
    }
}
