package alisprojects.goforitonnd.HowToServiceThatStupidAzure.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;

import alisprojects.goforitonnd.HowToServiceThatStupidAzure.Tables.Task;
import alisprojects.goforitonnd.R;

/**
 * Created by Karol on 2017-07-06.
 */

public class TaskAdapter extends ArrayAdapter<Task> {

    Context mContext;
    int mLayoutResourceId;

    public TaskAdapter(Context context, int layoutResourceId){
        super(context, layoutResourceId);

        mContext=context;
        mLayoutResourceId = layoutResourceId;

    }
    /**

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        final Task currentItem = getItem(position);

        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(mLayoutResourceId, parent, false);
        }

        row.setTag(currentItem);
        final CheckBox checkBox = (CheckBox) row.findViewById(R.id.checkToDoItem);
        checkBox.setText(currentItem.getText());
        checkBox.setChecked(false);
        checkBox.setEnabled(true);

        checkBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (checkBox.isChecked()) {
                    checkBox.setEnabled(false);
                    if (mContext instanceof ToDoActivity) {
                        ToDoActivity activity = (ToDoActivity) mContext;
                        activity.checkItem(currentItem);
                    }
                }
            }
        });

        return row;
    }

*/
}
