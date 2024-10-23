package com.example.implement_custom_dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class CustomDialog extends Dialog {
    private TextView txtView;
    private RadioGroup radioGroup;
    private Button okBtn;
    private double amount;

    //created reference for interface
    private OnDialogActionListener onDialogActionListener;

    //create constructor

    public void setOnDialogActionListener(OnDialogActionListener onDialogActionListener){
        this.onDialogActionListener= onDialogActionListener;
    }

    public CustomDialog(Context context,double amount){
        super(context);
        this.amount=amount;
        setContentView(R.layout.dialog_box);
        initViews();
        initListeners();
    }

    private void initViews(){
        txtView=findViewById(R.id.txtView);
        radioGroup=findViewById(R.id.radioGroup);
        okBtn=findViewById(R.id.okBtn);

        txtView.setText("Amount:"+amount);
    }


    private void initListeners(){

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                double total=0;
                String currencyText="";


                if (checkedId==R.id.radio_can){
                    total = amount * 0.016; // Conversion rate for Canada
                    currencyText = "CANADA=";

                } else if (checkedId==R.id.radio_usa) {
                    total = amount * 0.012; // Conversion rate for usa
                    currencyText = "USA=";

                } else if (checkedId==R.id.radio_uk) {
                    total = amount * 0.0091 ; // Conversion rate for uk
                    currencyText = "UK=";

                } else if (checkedId==R.id.radio_chi) {
                    total = amount * 0.085; // Conversion rate for China
                    currencyText = "CHINA=";

                }

                txtView.setText(currencyText+total);
            }
        });

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(), "Back to Home Screen", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
    }
}
