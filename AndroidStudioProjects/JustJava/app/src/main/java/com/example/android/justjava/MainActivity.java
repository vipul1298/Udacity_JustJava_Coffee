package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int quantity =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void createOrderSummary(int num,boolean addWhipped,boolean addChocolate,String value){
        displayMessage("Name:" + value + "\nadded a whipped cream?"+ addWhipped + "\nadded a chocolate?"+ addChocolate + "\nQuantity:"+ quantity + "\nTotal:$" + num +"\nThankyou!");
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox checkBox = (CheckBox) findViewById(R.id.whippedCream);
        boolean hasWhipped=checkBox.isChecked();
        CheckBox chkbox = (CheckBox) findViewById(R.id.chocolate);
        boolean hasChecked=chkbox.isChecked();
        EditText text = (EditText)findViewById(R.id.name);
        String value = text.getText().toString();
        int price = calculatePrice(quantity);
        createOrderSummary(price,hasWhipped,hasChecked,value);

    }


    public void increment(View view){
        quantity = quantity +1;
        displayQuantity(quantity);
    }


    public void decrement(View view){
        if (quantity<=0){
            displayQuantity(0);
        }
        else{
            quantity = quantity-1;
            displayQuantity(quantity);
        }
        }


           /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */
//    private void displayPrice(int number) {
//        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
//        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
//    }
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
    private int calculatePrice(int quantity) {
        int price = quantity * 5;
        return price;
    }



}