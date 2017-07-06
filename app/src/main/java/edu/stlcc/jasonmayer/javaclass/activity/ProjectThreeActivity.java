package edu.stlcc.jasonmayer.javaclass.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

import edu.stlcc.jasonmayer.javaclass.R;
import edu.stlcc.jasonmayer.javaclass.chapterThree.Bin2Dec;
import edu.stlcc.jasonmayer.javaclass.chapterThree.Conversion;

public class ProjectThreeActivity extends AppCompatActivity {

    private static final String TAG = "ProjectThreeActivity";
    private RadioButton decimalToHex;
    private RadioButton decimalToBinary;
    private RadioButton binaryToDecimal;
    private EditText valueInput;
    private Button convertButton;
    private TextView processedOutput;
    private TextView resultOutput;
    private Button clearButton;
    private Conversion conversion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_three);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        binaryToDecimal = (RadioButton) findViewById(R.id.binary_to_decimal);
        decimalToBinary = (RadioButton) findViewById(R.id.decimal_to_binary);
        decimalToHex = (RadioButton) findViewById(R.id.decimal_to_hex);
        valueInput = (EditText) findViewById(R.id.value_input);
        convertButton = (Button) findViewById(R.id.convert_button);
        processedOutput = (TextView) findViewById(R.id.processed_output);
        resultOutput = (TextView) findViewById(R.id.result_output);
        clearButton = (Button) findViewById(R.id.clear_button);
    }

    @Override
    protected void onResume() {
        super.onResume();
        binaryToDecimal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.e(TAG, "onCheckedChanged: ");
                if (isChecked) {
                    String input = valueInput.getText().toString();
                    conversion = new Bin2Dec(input);
                }
            }
        });
        binaryToDecimal.setChecked(false);
        binaryToDecimal.setChecked(true);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (conversion.isValid()) {
                    List<String> processLog = conversion.getProcessLog();
                    String join = TextUtils.join("\n", processLog);
                    resultOutput.setText(join);
                }
            }
        });
    }

    public static Intent getLaunchIntent(Activity activity) {
        Intent intent = new Intent(activity, ProjectThreeActivity.class);
        return intent;
    }
}
