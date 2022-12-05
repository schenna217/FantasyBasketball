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

    EditText usernameET;
    EditText passwordET;

    String username;
    String password;

    public static FirebaseHelper firebaseHelper;
    public final String TAG = "Kovour";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_screen);

        firebaseHelper = new FirebaseHelper();

//        usernameET = findViewById(R.id.username);
        passwordET = findViewById(R.id.password);

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


                                Intent intent = new Intent(SignInScreen.this, ReadyToDraft.class);
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

    public void logInClicked(View view) {
        Log.i(TAG, "Log in clicked");
        if (getValues()) {        // get username and password
            // if valid, log in user and then switch to next activity
            // Try to sign into an account using auth with given email and password
            firebaseHelper.getmAuth().signInWithEmailAndPassword(username, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                // Sign in success, update currently signed in user's info
                                firebaseHelper.updateUid(firebaseHelper.getmAuth().getUid());

                                firebaseHelper.attachReadDataToUser();

                                Log.d(TAG, username + " logged in");

                                Intent intent = new Intent(SignInScreen.this, ReadyToDraft.class);
                                startActivity(intent);
                            }
                            else {
                                // if log in fails, display a message to the user along with the exception from firebase auth
                                Log.d(TAG, "Log in failed for " + username + " " + password +
                                        " because of \n"+ task.toString());
                            }
                        }
                    });

            // if invalid - prompt message that says why signin won't go through
        }

    }

    private boolean getValues() {
        username = usernameET.getText().toString();
        password = passwordET.getText().toString();

        // verify all user data is entered
        if (username.length() == 0 || password.length() == 0) {
            Toast.makeText(getApplicationContext(), "Enter all fields", Toast.LENGTH_SHORT).show();
            return false;
        }

        // verify password is at least 6 char long (otherwise firebase will deny)
        else if (password.length() < 6) {
            Toast.makeText(getApplicationContext(), "Password must be at least 6 char long", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            Log.i(TAG, username + " " + password + " is set after getValues(), return true");
            username = removeTrailingSpaces(username);
            return true;
        }
    }

    private String removeTrailingSpaces(String email) {
        String lastChar = email.substring(email.length() -1);
        if (lastChar.equals(" "))
            email = email.substring(0, email.length()-1);
        return email;
    }

}