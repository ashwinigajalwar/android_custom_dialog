package com.example.implement_custom_dialog;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements OnDialogActionListener {

    private Button convertBtn;
    private EditText editTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        convertBtn= findViewById(R.id.convertBtn);
        editTxt= findViewById(R.id.editTxt);

        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showCustomDialog();
            }
        });
    }

    private void showCustomDialog(){
        String text=editTxt.getText().toString();

        if (text.isEmpty()){
            Toast.makeText(this, "Please Enter an Amount", Toast.LENGTH_LONG).show();
            return;
        }

        double amount=Double.parseDouble(text);

        CustomDialog customDialog=new CustomDialog(this,amount);
        customDialog.setOnDialogActionListener(this);
        customDialog.show();
        customDialog.setCancelable(false);
    }

    @Override
    public void onCurrencyConverted(double Amount) {

        Toast.makeText(this, "Amount"+Amount, Toast.LENGTH_SHORT).show();

    }
}