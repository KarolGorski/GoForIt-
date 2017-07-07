package alisprojects.goforitonnd;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class YourProfile extends Fragment {


    public YourProfile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_your_profile, container, false);
        final ProgressBar progressBar=(ProgressBar) view.findViewById(R.id.LevelBar);
        progressBar.getProgressDrawable().setColorFilter(
                Color.BLACK, android.graphics.PorterDuff.Mode.SRC_IN);

        FirebaseAuth firebaseAuth= FirebaseAuth.getInstance();
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference myRef=database.getReference("Users").child(firebaseAuth.getCurrentUser().getUid());
        FirebaseUser user = firebaseAuth.getCurrentUser();

        final TextView level=(TextView) view.findViewById(R.id.userLevel);
        final TextView exp=(TextView) view.findViewById(R.id.userExp);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
// This method is called once with the initial value and again
// whenever data at this location is updated.

                level.setText("Your level:"+dataSnapshot.child("Level").getValue(Integer.class));
                exp.setText("Your experience: "+dataSnapshot.child("Exp").getValue(Integer.class)+"/100");
                progressBar.setProgress(dataSnapshot.child("Exp").getValue(Integer.class));
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

}
/**
 FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
 FirebaseDatabase database=FirebaseDatabase.getInstance();
 DatabaseReference myRef=database.getReference("Users").child(firebaseAuth.getCurrentUser().getUid());

 myRef.addValueEventListener(new ValueEventListener() {
@Override
public void onDataChange(DataSnapshot dataSnapshot) {
// This method is called once with the initial value and again
// whenever data at this location is updated.

email.setText(dataSnapshot.child("Email").getValue(String.class));
name.setText(dataSnapshot.child("Name").getValue(String.class));
}

@Override
public void onCancelled(DatabaseError error) {
// Failed to read value
String TAG="lol";
Log.w(TAG, "Failed to read value.", error.toException());
}
});

 */