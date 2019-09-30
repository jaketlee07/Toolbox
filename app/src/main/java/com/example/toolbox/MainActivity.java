package com.example.toolbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;

import com.mahfa.dnswitch.DayNightSwitch;
import com.mahfa.dnswitch.DayNightSwitchListener;

public class MainActivity extends AppCompatActivity {


    DayNightSwitch dayNightSwitch;
    View background_view;

    private RadioGroup radioGroup;
    private RadioButton radioSexButton;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(MainActivity.this, MainBudgetingPage.class);

        dayNightSwitch = (DayNightSwitch)findViewById(R.id.dayNightSwitch);
        background_view = findViewById(R.id.background_view);

        dayNightSwitch.setDuration(450);
        dayNightSwitch.setListener(new DayNightSwitchListener()
        {
            @Override
            public void onSwitch(boolean isNight)
            {
                if(isNight)
                {
                    Toast.makeText(MainActivity.this, "Night mode selected", Toast.LENGTH_SHORT).show();
                    background_view.setAlpha(1f);


                }
                else
                {
                    Toast.makeText(MainActivity.this, "Day mode selected", Toast.LENGTH_SHORT).show();
                    background_view.setAlpha(0f);
                }
            }
        });

    }

    public void radioListener(View v, Intent intent) {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioSex);
        int radioButtonID = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) radioGroup.findViewById(radioButtonID);
        String isYearly = radioButton.getText().toString();
        intent.putExtra(MainBudgetingPage.ISYEARLY, isYearly);
    }



    public void startBudgeting(View v) {
        EditText name = (EditText) findViewById(R.id.savingEdit);
        EditText salary = (EditText) findViewById(R.id.salary);

        String nameStr = name.getText().toString();
        String salaryStr = salary.getText().toString();

        intent.putExtra(MainBudgetingPage.NAME, nameStr);
        intent.putExtra(MainBudgetingPage.SALARY, salaryStr);

        radioListener(v, intent);


        startActivity(intent);



        }

}
