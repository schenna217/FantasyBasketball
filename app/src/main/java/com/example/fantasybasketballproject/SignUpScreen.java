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

public class SignUpScreen extends AppCompatActivity {

    Button signup;

    EditText emailET;
    EditText usernameET;
    EditText passwordET;

    String username;
    String password;
    String email;

    public static FirebaseHelper firebaseHelper;
    public final String TAG = "Kovour";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_screen);

        emailET = findViewById(R.id.SUemail);
        usernameET = findViewById(R.id.SUusername);
        passwordET = findViewById(R.id.SUpassword);

        signup = findViewById(R.id.SUsignup);
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


                                Intent intent = new Intent(SignUpScreen.this, ReadyToDraft.class);
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
                                    Toast.makeText(SignUpScreen.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                    Log.d(TAG, "Sign up failed for " + username + " " + password + e.getMessage());
                                } catch (FirebaseAuthEmailException e) {
                                    // duplicate email used
                                    Toast.makeText(SignUpScreen.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                    Log.d(TAG, "Sign up failed for " + username + " " + password + e.getMessage());
                                } catch (Exception e) {
                                    Toast.makeText(SignUpScreen.this, e.getMessage(), Toast.LENGTH_SHORT).show();
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

    private boolean getValues() {
        username = usernameET.getText().toString();
        password = passwordET.getText().toString();
        email = emailET.getText().toString();

        // verify all user data is entered
        if (username.length() == 0 || password.length() == 0 || email.length() == 0) {
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

    /**
     * This method accepts the email the user wants to submit for FirebaseAuth
     * and removes an extra spaces that may have accidentally been added at the end by
     * the auto-correct keyboard.  This typically happens when the email is used all
     * the time and shows up as a suggestion for the user.
     *
     * @param email
     * @return a String without trailing spaces
     */
    private String removeTrailingSpaces(String email) {
        String lastChar = email.substring(email.length() -1);
        if (lastChar.equals(" "))
            email = email.substring(0, email.length()-1);
        return email;
    }


}