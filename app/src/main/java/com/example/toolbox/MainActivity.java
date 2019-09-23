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

public class MainActivity extends AppCompatActivity {


    private RadioGroup radioGroup;
    private RadioButton radioSexButton;

    private String isYearly;
    Intent intent = new Intent(MainActivity.this, MainBudgetingPage.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioSex);


    }

    public void radioListener(View v) {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {

                RadioButton rb = (RadioButton) findViewById(checkedId);
                // get selected radio button from radioGroup
                //int selectedId = radioGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                //radioSexButton = (RadioButton) findViewById(selectedId);
                isYearly = rb.getText().toString();
            }
        });
    }



    public void startBudgeting(View v) {
        EditText name = (EditText) findViewById(R.id.savingEdit);
        EditText salary = (EditText) findViewById(R.id.salary);

        String nameStr = name.getText().toString();
        String salaryStr = salary.getText().toString();

        intent.putExtra(MainBudgetingPage.NAME, nameStr);
        intent.putExtra(MainBudgetingPage.SALARY, salaryStr);

        //radioListener();

        boolean checked = ((RadioButton) v).isChecked();

        /*switch(v.getId())
        {
            case R.id.radioMale:
                if(checked)
                    isYearly = "Monthly";
                break;
            case R.id.radioFemale:
                if(checked)
                    isYearly = "Yearly";
                break;
        }
        */

        intent.putExtra(MainBudgetingPage.ISYEARLY,isYearly);


        startActivity(intent);



        }

}
