package com.example.friendtasybooks;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.protobuf.StringValue;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public UserData userdata;
    private AppBarConfiguration mAppBarConfiguration;
    // Firebase instance variables
    private SharedPreferences mSharedPreferences;
    private GoogleSignInClient mSignInClient;
    private FirebaseAuth mFirebaseAuth;
    //private FirebaseDatabase mDatabase;
    //private FirebaseRecyclerAdapter<FriendlyMessage, MessageViewHolder>
    //        mFirebaseAdapter;
    // [START declare_database_ref]
    private DatabaseReference mDatabase;
    // [END declare_database_ref]
    private TextView username;
    private ImageView usericon;
    public String UserUid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        // Initialize Firebase Auth and check if the user is signed in
        mFirebaseAuth = FirebaseAuth.getInstance();
        if (mFirebaseAuth.getCurrentUser() == null) {
            // Not signed in, launch the Sign In activity
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                //.requestIdToken("1089553635421-er8ge4knu880ea63m24f9c9ffac2bu2u.apps.googleusercontent.com")
                .requestEmail()
                .build();
        mSignInClient = GoogleSignIn.getClient(this, gso);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home,  R.id.nav_profile, R.id.nav_mybook, R.id.nav_badge, R.id.nav_friends)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        View headerView = navigationView.getHeaderView(0);
        username = (TextView) headerView.findViewById(R.id.username);
        usericon = (ImageView) headerView.findViewById(R.id.usericon);
        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();
            String email = user.getEmail();
            Uri photoUrl = user.getPhotoUrl();
            // Check if user's email is verified
            boolean emailVerified = user.isEmailVerified();

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getIdToken() instead.
            String uid = user.getUid();
            UserUid=uid;
            Log.w(TAG, "UserID = "+uid);
            //UserID = ni7bz29bmUaQGZJidV2c9rVCCzn2
        }
        Button logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });
        // [START initialize_database_ref]
        mDatabase = FirebaseDatabase.getInstance().getReference();
        // [END initialize_database_ref]

        //userdata = new UserData(1,"Test Name",1,"Taipei");
        // headshot 1.2.3.4=m.1234 5678=f.1234 0=null, gender 1=male 2=female 0=null
        //mDatabase.child("users").child(user.getUid()).setValue(userdata);
        //mDatabase.child("users").child(user.getUid()).child("username").setValue(name);

        mDatabase.child("users").child(user.getUid()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    HashMap post = (HashMap) task.getResult().getValue();
                    if(post==null){
                        Log.d("firebase data", String.valueOf(post));
                        userdata = new UserData(5,user.getDisplayName(),0,"未選擇");
                        username.setText(userdata.username);
                        mDatabase.child("users").child(user.getUid()).setValue(userdata);
                    }
                    else{
                        //Log.d("firebase", String.valueOf(task.getResult().getValue()));
                        Log.d("firebase", String.valueOf(post));
                        //post.getClass();
                        //post.get(3);
                        //Log.d("headshot", String.valueOf(post.getClass()));
                        /*Log.d("headshot", String.valueOf(post.get("headshot")));
                        Log.d("gender", String.valueOf(post.get("gender")));
                        Log.d("username", String.valueOf(post.get("username")));
                        Log.d("city", String.valueOf(post.get("city")));*/
                        userdata = new UserData(0,user.getDisplayName(),0,"未選擇");
                        long hs=(long)post.get("headshot");
                        userdata.headshot=(int)hs;
                        long gd=(long)post.get("gender");
                        userdata.gender=(int)gd;
                        userdata.username=(String)post.get("username");
                        userdata.city=(String)post.get("city");
                        Log.d("headshot", String.valueOf(userdata.headshot));
                        Log.d("gender", String.valueOf(userdata.gender));
                        Log.d("username", String.valueOf(userdata.username));
                        Log.d("city", String.valueOf(userdata.city));
                        username.setText(userdata.username);
                        setUsericon(userdata,usericon);
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.onNavDestinationSelected(item, navController)
                || super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    private void signOut() {
        mFirebaseAuth.signOut();
        mSignInClient.signOut();
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
    public String getUserName() {
        FirebaseUser user = mFirebaseAuth.getCurrentUser();
        if (user != null) {
            return user.getDisplayName();
        }

        return "anonymous";
    }
    public UserData read_data(){
        return userdata;
    }
    public void write_data(UserData temp){
        userdata=temp;
        username.setText(userdata.username);
        setUsericon(userdata,usericon);
        mDatabase.child("users").child(UserUid).setValue(userdata);
    }
    public void setUsericon(UserData temp,ImageView img){
        if(temp.headshot>0&&temp.headshot<5){
            img.setImageResource(getResources().getIdentifier("headboy"+ temp.headshot, "drawable", getPackageName()));
        }
        else if (temp.headshot>4&&temp.headshot<9){
            img.setImageResource(getResources().getIdentifier("headgirl"+ (temp.headshot-4), "drawable", getPackageName()));
        }
        else {
            userdata.headshot=1;
            img.setImageResource(getResources().getIdentifier("headboy1", "drawable", getPackageName()));
        }
    }
}