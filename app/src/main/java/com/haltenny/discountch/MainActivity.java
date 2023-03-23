package com.haltenny.discountch;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    float Palto = 70;
    byte PaltoDiscount = 77;
    float Hat = 25;
    byte HatDiscount = 37;
    float Costume = 53;
    byte CostumeDiscount = 44;
    float Soroch = 19;
    byte SorochDiscount = 0;
    float Boots = 41;
    byte BootsDiscount = 32;
    float Balance = 312;

    private float calculation() {
        float count = (Palto * (100 - PaltoDiscount) + Hat * (100 - HatDiscount) + Costume * (100 - CostumeDiscount)
                + Soroch * (100 - SorochDiscount) + Boots * (100 - BootsDiscount) / 100);
        return count;
    }

    private boolean can_i_do_this(){
        if (calculation() <= Balance){
            return true;
        }
        else {
            return false;
        }
    }

    private float money(){
        if (can_i_do_this()){
            return Balance - calculation();
        }
        else {
            return -1;
        }
    }

    private TextView i_can_do_this;
    private TextView my_balance;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        i_can_do_this = findViewById(R.id.i_can_do_this);
        my_balance = findViewById(R.id.my_balance);

        if (can_i_do_this()){
            i_can_do_this.setText("Хватит)");
            my_balance.setText("Ещё и останется " + money() + " монет");
        }
        else {
            i_can_do_this.setText("Не хватит(");
            my_balance.setText("Да ничего не останется");
        }

    }

}