package com.shifatkhan.loancalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private View view;

    //Get all the result TextView objects
    private TextView textMonthlyPayment;
    private TextView textTotalPayment;
    private TextView textTotalInterest;

    private TextView req1 ;
    private TextView req2 ;
    private TextView req3 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get all the result TextView objects
        textMonthlyPayment = (TextView) findViewById(R.id.textResultMonthlyPayment);
        textTotalPayment = (TextView) findViewById(R.id.textResultTotalPayment);
        textTotalInterest = (TextView) findViewById(R.id.textResultTotalInterest);

        req1 = (TextView) findViewById(R.id.textRequired1);
        req2 = (TextView) findViewById(R.id.textRequired2);
        req3 = (TextView) findViewById(R.id.textRequired3);
    }



    public void onClick_Calculate(View view) {

        //Get all the edit fields objects
        EditText editLoanAmount = (EditText) findViewById(R.id.editLoanAmount);
        EditText editTermOfLoan = (EditText) findViewById(R.id.editTermOfLoan);
        EditText editYearlyRate = (EditText) findViewById(R.id.editYearlyRate);

        String loanAmountStr = editLoanAmount.getText().toString();
        String termOfLoanStr = editTermOfLoan.getText().toString();
        String yearlyRateStr = editYearlyRate.getText().toString();

        boolean valid = true;

        if(loanAmountStr.isEmpty())
        {
            req1.setText("Field Required");
            valid = false;
        }
        else {
            req1.setText("");
        }
        if(termOfLoanStr.isEmpty() || Integer.parseInt(termOfLoanStr) < 1
                || Integer.parseInt(termOfLoanStr) > 25)
        {
            req2.setText("between 1 - 25");
            valid = false;
        }
        else {
            req2.setText("");
        }
        if(yearlyRateStr.isEmpty() || Double.parseDouble(yearlyRateStr) > 100)
        {
            req3.setText("between 0 - 100");
            valid = false;
        }
        else {
            req3.setText("");
        }


        if(valid)
        {
            double loanAmount = Double.parseDouble(loanAmountStr);
            int termOfYLoan = Integer.parseInt(termOfLoanStr);
            double yearlyRate = Double.parseDouble(yearlyRateStr);

            LoanCalculator loan = new LoanCalculator(loanAmount, termOfYLoan, yearlyRate);

            //Display results
            textMonthlyPayment.setText(""+loan.getMonthlyPayment());
            textTotalPayment.setText(""+loan.getTotalCostOfLoan());
            textTotalInterest.setText(""+loan.getTotalInterest());
        }
    }

    public void onClick_Clear(View view) {
        //Get all the edit fields objects
        EditText editLoanAmount = (EditText) findViewById(R.id.editLoanAmount);
        EditText editTermOfLoan = (EditText) findViewById(R.id.editTermOfLoan);
        EditText editYearlyRate = (EditText) findViewById(R.id.editYearlyRate);

        editLoanAmount.setText("");
        editTermOfLoan.setText("");
        editYearlyRate.setText("");
    }
}
