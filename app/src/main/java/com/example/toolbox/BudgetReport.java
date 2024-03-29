package com.example.toolbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class BudgetReport extends AppCompatActivity {

    public static final String SAVING_TOTAL = "";
    public static final String BILL_TOTAL = "";
    public static final String SPENDING_TOTAL = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_report);

        Intent intent = getIntent();
        String savingTotal = intent.getStringExtra(SAVING_TOTAL);
        String billTotal = intent.getStringExtra(BILL_TOTAL);
        String spendingTotal = intent.getStringExtra(SPENDING_TOTAL);

        String strToDisplay =
                "Spending:$" + spendingTotal + "\n" +
                "Bill:$" + billTotal + "\n" +
                "Savings:$" + savingTotal + "\n";

        int savingTotalInt = Integer.parseInt(savingTotal);
        int billTotalInt = Integer.parseInt(billTotal);
        int spendingTotalInt = Integer.parseInt(spendingTotal);

        int total = savingTotalInt + billTotalInt + spendingTotalInt;
       // int salary = Integer.parseInt(MainBudgetingPage.SALARY);

        int salary = 6000;

        if((salary - total) < 0)
        {
            strToDisplay += "\n Unfortunately you cannot afford all of your payments for this month";
        }
        else if((salary - total) > 0)
        {
            strToDisplay += "\n You can afford all of your payments for this month and have $" + (salary - total) + " left to spend";
        }
        else
        {
            strToDisplay += "\n You have spent exactly all of your salary for this month";
        }

        TextView str = (TextView) findViewById(R.id.budgetReport);
        str.setText(strToDisplay);
    }
}
