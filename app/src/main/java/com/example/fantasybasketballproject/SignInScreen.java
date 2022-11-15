package com.example.fantasybasketballproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthEmailException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;

public class SignInScreen extends AppCompatActivity {

    Button login;
    Button signup;

    EditText username;
    EditText password;


    public static FirebaseHelper firebaseHelper;
    public final String TAG = "Kovour";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_screen);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        updateUI();
    }

    public void updateUI() {
        // if the user is already logged in, then they bypass this screen
        Log.d(TAG, "inside updateUI: " + firebaseHelper.getmAuth().getUid());
        if (firebaseHelper.getmAuth().getUid() != null) {
            firebaseHelper.attachReadDataToUser();
            Intent intent = new Intent(SignInScreen.this, ReadyToDraft.class);
            startActivity(intent);
        }
    }

    public void signUpClicked(View view) {
        Log.i(TAG, "Sign up clicked");
        if (getValues()) {      // get username and password
            // Try to create an account using auth
            firebaseHelper.getmAuth().createUserWithEmailAndPassword(username, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            // FOR SOME REASON IF THE CREATE USER IS NOT WORKING, THIS IS CRASHING
                            // NOT SURE WHY?  I TRIED WITH A DUPLICATE EMAIL ADDRESS AND THAT CRASHED IT.
                            // LOGCAT SHOWED THE MESSAGE BUT I COULDN'T GET IT TO SHOW IN A LOG STATEMENT

                            if (task.isSuccessful()){
                                // Sign up successful, update UI with the currently signed in user's info
                                firebaseHelper.updateUid(firebaseHelper.getmAuth().getUid());
                                Log.d(TAG, username + " created and logged in");

                                firebaseHelper.addUserToFirestore(username,
                                        firebaseHelper.getmAuth().getUid());
                                firebaseHelper.attachReadDataToUser();


                                Intent intent = new Intent(SignInScreen.this, SignUpScreen.class);
                                startActivity(intent);
                            }
                            else {
                                /*
                                    This prevents the app from CRASHING when the user enters bad items
                                    (duplicate email or badly formatted email most likely)

                                    https://stackoverflow.com/questions/37859582/how-to-catch-a-firebase-auth-specific-exceptions

                                */
                                try {
                                    throw task.getException();
                                } catch (FirebaseAuthInvalidCredentialsException e) {
                                    // poorly formatted email address
                                    Toast.makeText(SignInScreen.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                    Log.d(TAG, "Sign up failed for " + username + " " + password + e.getMessage());
                                } catch (FirebaseAuthEmailException e) {
                                    // duplicate email used
                                    Toast.makeText(SignInScreen.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                    Log.d(TAG, "Sign up failed for " + username + " " + password + e.getMessage());
                                } catch (Exception e) {
                                    Toast.makeText(SignInScreen.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                    Log.d(TAG, "Sign up failed for " + username + " " + password + e.getMessage());
                                }
                            }
                        }
                    });
        }
        else {
            Log.d(TAG, "Failed to pass getValues() method");
        }
    }

}