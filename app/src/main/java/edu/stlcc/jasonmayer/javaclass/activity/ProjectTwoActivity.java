package edu.stlcc.jasonmayer.javaclass.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;

import java.util.ArrayList;
import java.util.List;

import edu.stlcc.jasonmayer.javaclass.R;
import edu.stlcc.jasonmayer.javaclass.models.Customer;
import edu.stlcc.jasonmayer.javaclass.models.Employee;
import edu.stlcc.jasonmayer.javaclass.models.Person;
import edu.stlcc.jasonmayer.javaclass.views.DividerItemDecoration;
import edu.stlcc.jasonmayer.javaclass.views.NewCustomerDialog;
import edu.stlcc.jasonmayer.javaclass.views.NewEmployeeDialog;
import edu.stlcc.jasonmayer.javaclass.views.PersonAdapter;

public class ProjectTwoActivity extends AppCompatActivity {

    private SwitchCompat newUserTypeToggle;
    private RecyclerView recyclerView;
    private List<Person> customers = new ArrayList<>();
    private List<Person> employees = new ArrayList<>();
    private PersonAdapter personAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_two);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        newUserTypeToggle = (SwitchCompat) findViewById(R.id.customer_employee_toggle);
        setupListView();

        newUserTypeToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                personAdapter.setPersons((isChecked) ? customers : employees);
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                if (newUserTypeToggle.isChecked()) {
                    final NewCustomerDialog newCustomerDialog = new NewCustomerDialog();
                    newCustomerDialog.setOnClickListener(new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Customer customer = newCustomerDialog.getCustomer();
                            customers.add(customer);
                            personAdapter.setPersons(customers);
                        }
                    });
                    newCustomerDialog.show(fm, "new_customer_dialog");
                } else {
                    final NewEmployeeDialog newEmployeeDialog = new NewEmployeeDialog();
                    newEmployeeDialog.setOnClickListener(new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Employee employee = newEmployeeDialog.getEmployee();
                            employees.add(employee);
                            personAdapter.setPersons(employees);
                        }
                    });
                    newEmployeeDialog.show(fm, "new_employee_dialog");
                }
            }
        });
    }

    private void setupListView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        Drawable dividerDrawable = ContextCompat.getDrawable(this, R.drawable.black_line_divider);
        recyclerView.addItemDecoration(new DividerItemDecoration(dividerDrawable));

        personAdapter = new PersonAdapter(getLayoutInflater());
        recyclerView.setAdapter(personAdapter);
    }

    public static Intent getLaunchIntent(Activity context) {
        Intent intent = new Intent(context, ProjectTwoActivity.class);
        return intent;
    }
}
