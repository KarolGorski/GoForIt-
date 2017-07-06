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

/**
 * Created by Karol on 2017-07-06.
 */

public class Register extends Activity {

    private EditText EMAIL;
    private EditText PASSWORD;
    private Button Submit;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        EMAIL=(EditText) findViewById(R.id.emailregister);
        PASSWORD=(EditText) findViewById(R.id.passwordregister);
        Submit=(Button) findViewById(R.id.REGISTER);
        progressDialog=new ProgressDialog(Register.this);
        firebaseAuth=FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()!=null){
            finish();
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        }

        Submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                String email = EMAIL.getText().toString().trim();
                String password = PASSWORD.getText().toString().trim();

                if(TextUtils.isEmpty(email))
                {
                    Toast.makeText(Register.this,"please enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password))
                {
                    Toast.makeText(Register.this,"please enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressDialog.setMessage("Registering...");
                progressDialog.show();
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressDialog.dismiss();
                                if(task.isSuccessful()){
                                    Toast.makeText(Register.this,"Registered succesfully", Toast.LENGTH_SHORT).show();
                                    Register.this.finish();

                                    startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                                }
                                else{
                                    Toast.makeText(Register.this,"Could not register, please try again", Toast.LENGTH_SHORT).show();
                                }


                            }
                        });

            }
        });



    }

}
