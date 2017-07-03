package edu.stlcc.jasonmayer.javaclass.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.stlcc.jasonmayer.javaclass.R;

public class MainActivity extends AppCompatActivity {

    private Button projectTwoButton;
    private Button projectThreeButton;
    private Button projectFourButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        projectTwoButton = (Button) findViewById(R.id.project_2_button);
        projectThreeButton = (Button) findViewById(R.id.project_3_button);
        projectFourButton = (Button) findViewById(R.id.project_4_button);
    }

    @Override
    protected void onResume() {
        super.onResume();
        wireUpClickListeners();
    }

    private void wireUpClickListeners() {
        projectTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchIntent = ProjectTwoActivity.getLaunchIntent(MainActivity.this);
                startActivity(launchIntent);
            }
        });
        projectThreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchIntent = ProjectThreeActivity.getLaunchIntent(MainActivity.this);
                startActivity(launchIntent);
            }
        });
        projectFourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchIntent = ProjectFourActivity.getLaunchIntent(MainActivity.this);
                startActivity(launchIntent);
            }
        });
    }
}
