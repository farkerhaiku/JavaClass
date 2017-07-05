package edu.stlcc.jasonmayer.javaclass.views;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.util.Log;

import edu.stlcc.jasonmayer.javaclass.R;

public class NewCustomerDialog extends DialogFragment {
    private static final String TAG = "NewCustomerDialog";

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //set view requires api level 21 (see your build.gradle)
        return new AlertDialog.Builder(getContext())
                .setMessage(R.string.create_new_customer_title)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.e(TAG, "onClick: ");
                    }
                })
                .setView(R.layout.new_customer_dialog)
                .create();
    }

}
