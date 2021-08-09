package com.example.dessertordersystem;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.*;


public class MainActivity extends Activity {

    //Declarations
    final double CAKE_PRICE = 4.99;
    final double MILKSHAKE_PRICE = 5.99;
    final double CUPCAKE_PRICE = 3.99;
    final double DUTCH_PIE_PRICE = 4.99;

    int cakeQty = 0;
    int milkshakeQty = 0;
    int cupcakeQty = 0;
    int dutchPieQty = 0;

    Button cakeMinus;
    Button cakeAdd;
    Button milkshakeMinus;
    Button milkshakeAdd;
    Button cupcakeMinus;
    Button cupcakeAdd;
    Button dutchPieMinus;
    Button dutchPieAdd;
    Button placeOrder;

    TextView cakeQtyText;
    TextView milkshakeQtyText;
    TextView cupcakeQtyText;
    TextView dutchPieQtyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connect XML components
        cakeMinus = (Button) findViewById(R.id.cake_minus);
        cakeAdd = (Button) findViewById(R.id.cake_add);
        milkshakeMinus = (Button) findViewById(R.id.milkshake_minus);
        milkshakeAdd = (Button) findViewById(R.id.milkshake_add);
        cupcakeMinus = (Button) findViewById(R.id.cupcake_minus);
        cupcakeAdd = (Button) findViewById(R.id.cupcake_add);
        dutchPieMinus = (Button) findViewById(R.id.dutch_pie_minus);
        dutchPieAdd = (Button) findViewById(R.id.dutch_pie_add);
        placeOrder = (Button) findViewById(R.id.place_order);

        cakeQtyText = (TextView) findViewById(R.id.cake_qty);
        milkshakeQtyText = (TextView) findViewById(R.id.milkshake_qty);
        cupcakeQtyText = (TextView) findViewById(R.id.cupcake_qty);
        dutchPieQtyText = (TextView) findViewById(R.id.dutch_pie_qty);
    }

    //button functions for add/minus quantity
    public void cakeQtyMinus(View v)
    {
        if(cakeQty>0)
        {
            cakeQty--;
        }
        else
        {
            cakeQty = 0;
        }
        cakeQtyText.setText(String.valueOf(cakeQty));
    }

    public void cakeQtyAdd(View v)
    {
        if(cakeQty<9)
        {
            cakeQty++;
        }
        else
        {
            cakeQty = 9;
        }
        cakeQtyText.setText(String.valueOf(cakeQty));
    }

    public void milkshakeQtyMinus(View v)
    {
        if(milkshakeQty>0)
        {
            milkshakeQty--;
        }
        else
        {
            milkshakeQty = 0;
        }
        milkshakeQtyText.setText(String.valueOf(milkshakeQty));
    }

    public void milkshakeQtyAdd(View v)
    {
        if(milkshakeQty<9)
        {
            milkshakeQty++;
        }
        else
        {
            milkshakeQty = 9;
        }
        milkshakeQtyText.setText(String.valueOf(milkshakeQty));
    }

    public void cupcakeQtyMinus(View v)
    {
        if(cupcakeQty > 0)
        {
            cupcakeQty--;
        }
        else
        {
            cupcakeQty = 0;
        }
        cupcakeQtyText.setText(String.valueOf(cupcakeQty));
    }

    public void cupcakeQtyAdd(View v)
    {
        if(cupcakeQty<9)
        {
            cupcakeQty++;
        }
        else
        {
            cupcakeQty = 9;
        }
        cupcakeQtyText.setText(String.valueOf(cupcakeQty));
    }

    public void dutchPieQtyMinus(View v)
    {
        if(dutchPieQty>0)
        {
            dutchPieQty--;
        }
        else
        {
            dutchPieQty = 0;
        }
        dutchPieQtyText.setText(String.valueOf(dutchPieQty));
    }

    public void dutchPieQtyAdd(View v)
    {
        if(dutchPieQty<9)
        {
            dutchPieQty++;
        }
        else
        {
            dutchPieQty = 9;
        }
        dutchPieQtyText.setText(String.valueOf(dutchPieQty));
    }

    //"PLACE ORDER" button function
    public void placeOrder(View v)
    {
        if(cakeQty == 0 && milkshakeQty == 0 && cupcakeQty == 0 && dutchPieQty == 0)
        {
            Toast empty_order = Toast.makeText(getApplicationContext(),"You didn't order anything",Toast.LENGTH_SHORT);
            empty_order.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,250);
            empty_order.show();
        }
        else
        {
            AlertDialog.Builder order_review = new AlertDialog.Builder(this);

            //"Send" button function
            DialogInterface.OnClickListener positive = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast send_order = Toast.makeText(getApplicationContext(),"Your order has been sent",Toast.LENGTH_SHORT);
                    send_order.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,250);
                    send_order.show();
                }
            };

            //"Cancel" button function
            DialogInterface.OnClickListener negative = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ;
                }
            };

            String order_content ="";
            double total_price = 0;
            if(cakeQty>0)
            {
                order_content += String.format("%d Cake $%.2f%n",cakeQty,cakeQty*CAKE_PRICE);
                total_price += cakeQty*CAKE_PRICE;
            }
            if(milkshakeQty>0)
            {
                order_content += String.format("%d Milkshake $%.2f%n",milkshakeQty,milkshakeQty*MILKSHAKE_PRICE);
                total_price += milkshakeQty*MILKSHAKE_PRICE;
            }
            if(cupcakeQty>0)
            {
                order_content += String.format("%d Cupcake $%.2f%n",cupcakeQty,cupcakeQty*CUPCAKE_PRICE);
                total_price += cupcakeQty*CUPCAKE_PRICE;
            }
            if(dutchPieQty>0)
            {
                order_content += String.format("%d Dutch Pie $%.2f%n",dutchPieQty,dutchPieQty*DUTCH_PIE_PRICE);
                total_price += dutchPieQty*DUTCH_PIE_PRICE;
            }
            order_content += String.format("Total price $%.2f",total_price);
            order_review.setTitle("Your Order:");
            order_review.setMessage(order_content);
            order_review.setPositiveButton("Send",positive);
            order_review.setNegativeButton("Cancel",negative);
            order_review.show();
        }

    }
}
