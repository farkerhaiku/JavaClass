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
import edu.stlcc.jasonmayer.javaclass.models.Employee;

public class NewEmployeeDialog extends DialogFragment {
    private static final String TAG = "NewEmployeeDialog";
    private AlertDialog alertDialog;
    private DialogInterface.OnClickListener onClickListener;

    private EditText first;
    private EditText email;
    private EditText last;
    private EditText social;

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

    public void setOnClickListener(DialogInterface.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View employeeView = getEmployeeView();
        alertDialog = new AlertDialog.Builder(getContext())
                .setMessage(R.string.create_new_employee_title)
                .setView(employeeView)
                .setPositiveButton("Add", onClickListener)
                .setCancelable(true)
                .create();
        return alertDialog;
    }

    private View getEmployeeView() {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View inflate = layoutInflater.inflate(R.layout.new_employee_dialog, null);
        first = (EditText) inflate.findViewById(R.id.firstName);
        email = (EditText) inflate.findViewById(R.id.email);
        last = (EditText) inflate.findViewById(R.id.lastName);
        social = (EditText) inflate.findViewById(R.id.social);

        first.addTextChangedListener(watcher);
        last.addTextChangedListener(watcher);
        email.addTextChangedListener(watcher);
        social.addTextChangedListener(watcher);

        return inflate;
    }

    @Override
    public void onResume() {
        super.onResume();
        validateForm();
    }

    public void validateForm() {
        Button button = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
        if (TextUtils.isEmpty(first.getText()) ||
                TextUtils.isEmpty(last.getText()) ||
                TextUtils.isEmpty(email.getText()) ||
                TextUtils.isEmpty(social.getText())) {
            button.setEnabled(false);
        } else {
            button.setEnabled(true);
        }
    }

    public Employee getEmployee() {
        Employee employee = new Employee();
        employee.setSocial(social.getText().toString());
        employee.setLastName(last.getText().toString());
        employee.setFirstName(first.getText().toString());
        employee.setEmailAddress(email.getText().toString());
        return employee;
    }
}
