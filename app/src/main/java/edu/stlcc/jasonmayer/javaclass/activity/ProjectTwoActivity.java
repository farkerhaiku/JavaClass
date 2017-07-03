package edu.stlcc.jasonmayer.javaclass.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;

import edu.stlcc.jasonmayer.javaclass.R;
import edu.stlcc.jasonmayer.javaclass.models.Person;

public class ProjectTwoActivity extends AppCompatActivity {

    private SwitchCompat newUserTypeToggle;
    private ListView listView;
    private List<Person> customers = new ArrayList<>();
    private List<Person> employees = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_two);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        newUserTypeToggle = (SwitchCompat) findViewById(R.id.customer_employee_toggle);
        listView = (ListView) findViewById(R.id.listView);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    public static Intent getLaunchIntent(Activity context) {
        Intent intent = new Intent(context, ProjectTwoActivity.class);
        return intent;
    }
}
