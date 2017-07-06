package alisprojects.goforitonnd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * Created by Karol on 2017-07-06.
 */

public class ProfileActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private TextView EmailTextView;
    private Button logout;

    private DatabaseReference databaseReference;

    private EditText editTextFullName;
    private Button save;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        firebaseAuth= FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()==null){
            startActivity(new Intent(ProfileActivity.this, LoginActivity.class));
        }

        EmailTextView=(TextView) findViewById(R.id.emailTextView);
        EmailTextView.setText("Welcome "+firebaseAuth.getCurrentUser().getEmail()+"!");

        logout=(Button) findViewById(R.id.logoutButton);

    logout.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(ProfileActivity.this, LoginActivity.class));

        }});


        databaseReference= FirebaseDatabase.getInstance().getReference();
        editTextFullName=(EditText) findViewById(R.id.FullNameEditText);
        save=(Button) findViewById(R.id.GoInButton);

        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }});
    }
}
