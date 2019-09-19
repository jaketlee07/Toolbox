package com.example.toolbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {


    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    private Button btnDisplay;

    Intent intent = new Intent(this, MainBudgetingPage.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startBudgeting(View v) {
        EditText name = (EditText) findViewById(R.id.savingEdit);
        EditText salary = (EditText) findViewById(R.id.salary);

        String nameStr = name.getText().toString();
        String salaryStr = salary.getText().toString();

        intent.putExtra(MainBudgetingPage.NAME, nameStr);
        intent.putExtra(MainBudgetingPage.SALARY, salaryStr);

        radioSexGroup = (RadioGroup) findViewById(R.id.radioSex);
        btnDisplay = (Button) findViewById(R.id.button);

        btnDisplay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioSexGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioSexButton = (RadioButton) findViewById(selectedId);

                String isYearly = radioSexButton.getText().toString();

                intent.putExtra(MainBudgetingPage.ISYEARLY,isYearly);

            }

        });

        startActivity(intent);
    }
}
