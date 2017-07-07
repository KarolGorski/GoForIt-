package alisprojects.goforitonnd;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.List;

import alisprojects.goforitonnd.HowToServiceThatStupidAzure.Tables.Task;


/**
 * A simple {@link Fragment} subclass.
 */
public class YourProfile extends Fragment {
    private int i=0;
    private int LEV=1;

    private ListView LV;
    private FirebaseListAdapter<Task> mAdapter;
    private Task[] tasks;
    private String[] tasksNames= new String[10];


    public YourProfile() {
        // Required empty public constructor
    }

    FirebaseAuth firebaseAuth= FirebaseAuth.getInstance();
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference myRef=database.getReference("Users").child(firebaseAuth.getCurrentUser().getUid());
    final DatabaseReference myRefTask=database.getReference("Tasks").child(firebaseAuth.getCurrentUser().getUid());
    final FirebaseUser user = firebaseAuth.getCurrentUser();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         final View view= inflater.inflate(R.layout.fragment_your_profile, container, false);

        final TextView row=(TextView) view.findViewById(R.layout.singletaskview);

        LV= (ListView) view.findViewById(R.id.listOfTasks);
        mAdapter = new FirebaseListAdapter<Task>(this.getActivity(), Task.class, R.id.listOfTasks, myRefTask) {
            @Override
            protected void populateView(View v, Task model, int position) {
                row.setText(model.text.toString().trim()+"\n"+model.info.toString().trim());
            }




        };
        LV.setAdapter(mAdapter);
/*
        LV=(ListView) view.findViewById(R.id.listOfTasks);
        initResources();
        initListView();

        LV.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

                builder.setTitle("Task done");
                builder.setMessage("Are you sure?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                        myRefTask.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                myRefTask.child("Users").child(user.getUid()).child("Level").setValue(LEV+1);
                                myRefTask.child("Tasks").child(user.getUid()).child((Integer.toString(position+1))).removeValue();
                                initResources();
                                initListView();

                            }

                            @Override
                            public void onCancelled(DatabaseError error) {
// Failed to read value
                                String TAG="lol";
                                Log.w(TAG, "Failed to read value.", error.toException());
                            }
                        });


                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // Do nothing
                        dialog.dismiss();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });
*/
        final ProgressBar progressBar=(ProgressBar) view.findViewById(R.id.LevelBar);
        progressBar.getProgressDrawable().setColorFilter(
                Color.BLACK, android.graphics.PorterDuff.Mode.SRC_IN);



        final TextView level=(TextView) view.findViewById(R.id.userLevel);
        final TextView exp=(TextView) view.findViewById(R.id.userExp);
        final TextView form=(TextView) view.findViewById(R.id.dayFormText);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
// This method is called once with the initial value and again
// whenever data at this location is updated.

                level.setText("Your level: "+dataSnapshot.child("Level").getValue(Integer.class));
                LEV=dataSnapshot.child("Level").getValue(Integer.class);
                exp.setText("Your experience: "+dataSnapshot.child("Experience").getValue(Integer.class)+"/100");
                progressBar.setProgress(dataSnapshot.child("Experience").getValue(Integer.class));
                form.setText("Your today's form: \n"+dataSnapshot.child("TodaysForm").getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError error) {
// Failed to read value
                String TAG="lol";
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        return view;
    }

    private void initResources(){
        FirebaseAuth firebaseAuth= FirebaseAuth.getInstance();
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        DatabaseReference myRef=database.getReference("Tasks").child(user.getUid());

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                    for( DataSnapshot ds : dataSnapshot.getChildren())
                    {
                        tasksNames[i]=ds.child("id").child("text").getValue(String.class)+"\n"+ds.child("id").child("info").getValue(String.class);
                        i++;
                    }


/**
                level.setText("Your level: "+dataSnapshot.child("Level").getValue(Integer.class));
                exp.setText("Your experience: "+dataSnapshot.child("Experience").getValue(Integer.class)+"/100");
                progressBar.setProgress(dataSnapshot.child("Experience").getValue(Integer.class));
                form.setText("Your today's form: \n"+dataSnapshot.child("TodaysForm").getValue(String.class));
 */
            }

            @Override
            public void onCancelled(DatabaseError error) {
// Failed to read value
                String TAG="lol";
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }
    private void initListView(){
        LV.setAdapter(new ArrayAdapter<String>(this.getContext(),android.R.layout.simple_list_item_1,tasksNames));
    }

}

