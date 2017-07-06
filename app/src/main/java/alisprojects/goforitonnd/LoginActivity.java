package alisprojects.goforitonnd;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends Activity {

    private Button submit;
    private EditText Email;
    private EditText Password;
    private TextView Register;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);



         submit = (Button) findViewById(R.id.submit);
         Email = (EditText) findViewById(R.id.email);
         Password = (EditText) findViewById(R.id.password);
        Register=(TextView) findViewById(R.id.clickToRegister);
        progressDialog=new ProgressDialog(LoginActivity.this);

        firebaseAuth=FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()!=null){
            finish();
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        }

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                String email = Email.getText().toString().trim();
                String password = Password.getText().toString().trim();

                if(TextUtils.isEmpty(email))
                {
                    Toast.makeText(LoginActivity.this,"please enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password))
                {
                    Toast.makeText(LoginActivity.this,"please enter password", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressDialog.setMessage("Checking...");
                progressDialog.show();

                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        }
                    }
                });


            }
        });


        Register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
           Intent intent=new Intent(LoginActivity.this,Register.class);
                startActivity(intent);

            }
        });

    }




}
