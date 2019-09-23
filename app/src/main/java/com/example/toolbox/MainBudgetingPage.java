package com.example.toolbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainBudgetingPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    public static final String NAME = "name";
    public static final String SALARY = "salary";
    public static final String ISYEARLY = "";

    public String text;
    int time;

    public int spendingAmount;
    public int savingAmount;
    public int billsAmount;

    public String salaryYearly = ISYEARLY;

    private RadioGroup radioSexGroup;
    private CheckBox radioSexButton;
    private Button btnDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_budgeting_page);

        Intent intent = getIntent();
        String myName = intent.getStringExtra(NAME);
        String mySalary = intent.getStringExtra(SALARY);
        int salaryInt = Integer.parseInt(mySalary);

        if(ISYEARLY == "Yearly")
        {
            salaryInt = salaryInt/12;
        }

        String strToDisplay = myName + "'s Budget For This Month: " + salaryInt + " Left";
        TextView str = (TextView) findViewById(R.id.mainBudgetTitle);
        str.setText(strToDisplay);


        Spinner spinner = findViewById(R.id.timeGoal);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spending_category_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {
        text =  adapterView.getItemAtPosition(i).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView)
    {

    }

    public void addSpending (View v)
    {
        EditText spending = (EditText) findViewById(R.id.savingEdit);
        String spendingStr = spending.getText().toString();
        int spendingTotal = Integer.parseInt(spendingStr);

        spendingAmount += spendingTotal;
    }
    public void addSaving (View v)
    {
        EditText savings = (EditText) findViewById(R.id.savingEdit);
        String savingStr = savings.getText().toString();
        int savingTotal = Integer.parseInt(savingStr);


        if(text == "1 Month")
        {
            time = 1;
        }
        else if (text == "6 Months")
        {
            time = 6;
        }
        else if (text == "12 Months")
        {
            time = 12;
        }
        else if (text == "24 Months")
        {
            time = 24;
        }
        else if (text == "36 Months")
        {
            time = 36;
        }

        savingAmount += savingTotal/time;
    }
    public void addBill (View v)
    {

        radioSexGroup = (RadioGroup) findViewById(R.id.radioGroup);
        btnDisplay = (Button) findViewById(R.id.button4);


        // get selected radio button from radioGroup
        int selectedId = radioSexGroup.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        radioSexButton = (CheckBox) findViewById(selectedId);

        String billTime = radioSexButton.getText().toString();

        if(billTime == "Monthly")
        {
            time = 6;
        }



        EditText bill = (EditText) findViewById(R.id.BillsEdit);
        String billStr = bill.getText().toString();
        int billTotal = Integer.parseInt(billStr);

        billsAmount += billTotal/time;
    }

    public void billReport(View v)
    {
        Intent intent = new Intent(this, BudgetReport.class);

        String billsStr =  Integer.toString(billsAmount);
        String savingStr =  Integer.toString(savingAmount);
        String spendingStr =  Integer.toString(spendingAmount);

        intent.putExtra(BudgetReport.SPENDING_TOTAL, spendingStr);
        intent.putExtra(BudgetReport.SAVING_TOTAL, savingStr);
        intent.putExtra(BudgetReport.BILL_TOTAL, billsStr);

        startActivity(intent);
    }
}
