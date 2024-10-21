package com.example.implement_custom_dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dismiss();
            }
        });
    }
}
