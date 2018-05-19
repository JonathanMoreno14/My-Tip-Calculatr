package com.example.jonathanmoreno.mytipcalculatr;

import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {



    //EditText
    @BindView(R.id.totalEditText)
    EditText totalAmount;
    @BindView(R.id.tipamountEditText)
    EditText tipAmount;
    @BindView(R.id.numOfPeopleEditText)
    EditText numofPeople;

    //TextView
    @BindView(R.id.totalBillResults)
    TextView totalBill;
    @BindView(R.id.tipTotalResults)
    TextView tipTotal;
    @BindView(R.id.billPerPersonResults)
    TextView billPerPerson;
    @BindView(R.id.tipPerPersonResults)
    TextView tipPerPerson;

    @BindView(R.id.floatingActionButton)
    FloatingActionButton floatingActionButton;


    double userInputTotal;
    double userInputTip;
    double percentTip;
    double userInputNumPeople;
    double tipDispersebyPerson;
    double totalBillWithTip;
    double splitBill;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }


    @OnClick(R.id.floatingActionButton)
    public void tipReesults(View view){
        try{
            resultsComputed ();
            InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                    Snackbar snackbar = Snackbar.make(view, "Would you like to Clr the input", Snackbar.LENGTH_INDEFINITE)
                            .setAction("CLR", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    totalAmount.setText("");
                                    tipAmount.setText("");
                                    numofPeople.setText("");
                                    totalBill.setText("");
                                    tipTotal.setText("");
                                    billPerPerson.setText("");
                                    tipPerPerson.setText("");
                                    Snackbar snackbar1 = Snackbar.make(view, "Tip Calculator has been cleared", Snackbar.LENGTH_SHORT);
                                    snackbar1.show();
                                }
                            });
                    snackbar.setActionTextColor( Color.parseColor("#3F51B5"));
                    snackbar.show();
        }catch (Exception e){
            Snackbar snackbar = Snackbar.make(view, "Please Input the values", Snackbar.LENGTH_INDEFINITE)
                            .setAction("Retry", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    totalAmount.setText("");
                                    tipAmount.setText("");
                                    numofPeople.setText("");
                                    totalBill.setText("");
                                    tipTotal.setText("");
                                    billPerPerson.setText("");
                                    tipPerPerson.setText("");
                                    Snackbar snackbar1 = Snackbar.make(view, "Thank you", Snackbar.LENGTH_SHORT);
                                    snackbar1.show();
                                }
                            });
                    snackbar.setActionTextColor( Color.parseColor("#FF4081"));
                    snackbar.show();

        }
    }


        public void resultsComputed () {
            //Converts String to a double
            userInputTotal = Double.parseDouble(totalAmount.getText().toString());
            userInputTip = Double.parseDouble(tipAmount.getText().toString());
            userInputNumPeople = Double.parseDouble(numofPeople.getText().toString());
            //The percentage of the tip
            percentTip = (userInputTip / 100) * userInputTotal;
            //tips divided by the number of people
            tipDispersebyPerson = percentTip / userInputNumPeople;
            //Total Bill with Tips
            totalBillWithTip = percentTip + userInputTotal;
            //Split Check by each individual in the group
            splitBill = totalBillWithTip / userInputNumPeople;

            String totalWTip = totalBillWithTip + "";
            String decimalFormat1 = new DecimalFormat("0.##").format(Double.parseDouble(totalWTip));
            totalBill.setText(decimalFormat1);
            String totalTip = percentTip + "";
            String decimalFormat2 = new DecimalFormat("0.##").format(Double.parseDouble(totalTip));
            tipTotal.setText(decimalFormat2);
            String split = splitBill + "";
            String decimalFormat3 = new DecimalFormat("0.##").format(Double.parseDouble(split));
            billPerPerson.setText(decimalFormat3);
            String tipSplit = tipDispersebyPerson + "";
            String decimalFormat4 = new DecimalFormat("0.##").format(Double.parseDouble(tipSplit));
            tipPerPerson.setText(decimalFormat4);
        }



}
