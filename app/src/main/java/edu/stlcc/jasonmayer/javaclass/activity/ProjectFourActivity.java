package edu.stlcc.jasonmayer.javaclass.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import edu.stlcc.jasonmayer.javaclass.R;
import edu.stlcc.jasonmayer.javaclass.models.ProjectFourEmployee;

public class ProjectFourActivity extends AppCompatActivity {
    private static final String TAG = "ProjectFourActivity";
    private List<ProjectFourEmployee> empList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_four);
        InputStream inputStream = getResources().openRawResource(R.raw.employees);
        getEmployeeList(inputStream);
    }

    @Override
    protected void onResume() {
        super.onResume();
        for(ProjectFourEmployee employee : empList) {
            Log.e(TAG, "onResume: " + employee );
        }
    }

    private void getEmployeeList(InputStream inputStream) {
        try {
            CSVReader csvReader = getCsvReader(inputStream);
            List<String[]> strings = csvReader.readAll();
            for(String[] string : strings) {
                String join = TextUtils.join("|", string);
                ProjectFourEmployee employee = ProjectFourEmployee.from(string);
                empList.add(employee);
            }
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, "getEmployeeList: ", e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @NonNull
    private CSVReader getCsvReader(InputStream inputStream) throws UnsupportedEncodingException {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        return new CSVReader(br);
    }

    public static Intent getLaunchIntent(Activity activity) {
        Intent intent = new Intent(activity, ProjectFourActivity.class);
        return intent;
    }
}
