package alisprojects.goforitonnd;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

import alisprojects.goforitonnd.HowToServiceThatStupidAzure.Tables.Task;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddaTask extends Fragment {
    private String Radio="Easy";
    private EditText StartDate;
    private int y,m,d;

    public AddaTask() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.adda_task, container, false);
        final Button AddTask=(Button) view.findViewById(R.id.AddTaskButton);
        final EditText TaskName= (EditText) view.findViewById(R.id.taskName);
        final EditText info= (EditText) view.findViewById(R.id.Informations);

        AddTask.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                FirebaseAuth firebaseAuth= FirebaseAuth.getInstance();
                DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("Tasks");
                FirebaseUser user = firebaseAuth.getCurrentUser();
                Task task = new Task(TaskName.getText().toString(),info.getText().toString(),new java.util.Date(System.currentTimeMillis()),Radio.toString());
                databaseReference.child(user.getUid()).child(Integer.toString(task.id)).setValue(task);
            }
        });






        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected

                switch(checkedId) {
                    case R.id.EasyRadio:
                        Radio="Easy";
                        break;
                    case R.id.MediumRadio:
                        Radio="Medium";
                        break;
                    case R.id.HardRadio:
                        Radio="Hard";
                        break;
                }
            }
        });


        return view;
    }


}

