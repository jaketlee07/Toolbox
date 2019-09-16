package com.example.toolbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void startBudgeting(View v)
    {
        EditText name = (EditText) findViewById(R.id.name);
        EditText salary = (EditText) findViewById(R.id.salary);

        String nameStr = name.getText().toString();
        String salaryStr = salary.getText().toString();

        Intent intent = new Intent(this, MainBudgetingPage.class);

        intent.putExtra(MainBudgetingPage.NAME, nameStr);
        intent.putExtra(MainBudgetingPage.SALARY, salaryStr);

        startActivity(intent);
    }
}
