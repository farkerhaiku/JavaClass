package edu.stlcc.jasonmayer.javaclass.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

import edu.stlcc.jasonmayer.javaclass.R;
import edu.stlcc.jasonmayer.javaclass.chapterThree.Bin2Dec;
import edu.stlcc.jasonmayer.javaclass.chapterThree.Conversion;
import edu.stlcc.jasonmayer.javaclass.chapterThree.Dec2Bin;
import edu.stlcc.jasonmayer.javaclass.chapterThree.Dec2Hex;

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
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Conversion conversion = null;
                String input = valueInput.getText().toString();

                if (binaryToDecimal.isChecked()) {
                    conversion = new Bin2Dec(input);
                }
                if (decimalToBinary.isChecked()) {
                    conversion = new Dec2Bin(input);
                }

                if (decimalToHex.isChecked()) {
//                    conversion = new Dec2Hex(input);
                }

                if (conversion.isValid()) {
                    List<String> processLog = conversion.getProcessLog();
                    processedOutput.setText(TextUtils.join("\n", processLog));
                    resultOutput.setText(conversion.getResult());
                } else {
                    clearData();
                }
            }
        });
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearData();
            }
        });
    }

    private void clearData() {
        resultOutput.setText("");
        processedOutput.setText("");
    }

    public static Intent getLaunchIntent(Activity activity) {
        Intent intent = new Intent(activity, ProjectThreeActivity.class);
        return intent;
    }
}
