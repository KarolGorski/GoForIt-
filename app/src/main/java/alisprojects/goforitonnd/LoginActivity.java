package alisprojects.goforitonnd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Karol on 2017-07-06.
 */

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button submit=(Button) findViewById(R.id.submit);
        final EditText Email=(EditText) findViewById(R.id.email);
        final EditText Password=(EditText) findViewById(R.id.password);





        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DBLoginChecker check=new DBLoginChecker();
                String log,pass;
                log=Email.getText().toString();
                pass=Email.getText().toString();
                boolean a=true;
                //check.tryToLogin(log, pass);
                if(!a)
                Snackbar.make(v, "Incorrect email or password.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                else {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
