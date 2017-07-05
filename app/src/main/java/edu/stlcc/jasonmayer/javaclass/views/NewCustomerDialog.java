package edu.stlcc.jasonmayer.javaclass.views;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.stlcc.jasonmayer.javaclass.R;


public class NewCustomerDialog extends DialogFragment {
    private static final String TAG = "NewCustomerDialog";
    private EditText first;
    private EditText email;
    private EditText last;
    private EditText customerNumber;
    private AlertDialog alertDialog;
    private DialogInterface.OnClickListener onClickListener;

    TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            validateForm();
        }
    };

    private void validateForm() {
        Button button = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
        if (TextUtils.isEmpty(first.getText()) ||
                TextUtils.isEmpty(last.getText()) ||
                TextUtils.isEmpty(email.getText()) ||
                TextUtils.isEmpty(customerNumber.getText())) {
            button.setEnabled(false);
        } else {
            button.setEnabled(true);
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        onClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.e(TAG, "onClick: ");
            }
        };

        alertDialog = new AlertDialog.Builder(getContext())
                .setMessage(R.string.create_new_customer_title)
                .setPositiveButton("Add", onClickListener)
                .setView(getFormView())
                .create();
        return alertDialog;
    }

    @Override
    public void onResume() {
        super.onResume();
        validateForm();
    }

    private View getFormView() {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View inflate = layoutInflater.inflate(R.layout.new_customer_dialog, null);
        first = (EditText) inflate.findViewById(R.id.firstName);
        email = (EditText) inflate.findViewById(R.id.email);
        last = (EditText) inflate.findViewById(R.id.lastName);
        customerNumber = (EditText) inflate.findViewById(R.id.customer_num);

        first.addTextChangedListener(watcher);
        last.addTextChangedListener(watcher);
        email.addTextChangedListener(watcher);
        customerNumber.addTextChangedListener(watcher);

        return inflate;
    }

}
