package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    int tmp_num;
    char operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        operator='1';
        tmp_num=0;
        txt=findViewById(R.id.editTextNumber);
        Button eq=findViewById(R.id.button24);
        eq.setOnClickListener(v -> {
Toast.makeText(this,"Ok",Toast.LENGTH_SHORT).show();
            switch (operator){
                case '+':
                    tmp_num=tmp_num+Integer.parseInt(txt.getText().toString());
                    txt.setText(String.valueOf(tmp_num));
                    break;
                case '-':
                    tmp_num=tmp_num-Integer.parseInt(txt.getText().toString());
                    txt.setText(String.valueOf(tmp_num));
                    break;
                case '*':
                    tmp_num=tmp_num*Integer.parseInt(txt.getText().toString());
                    txt.setText(String.valueOf(tmp_num));
                    break;
                case '/':
                    tmp_num=tmp_num/Integer.parseInt(txt.getText().toString());
                    txt.setText(String.valueOf(tmp_num));
                    break;
                case '%':
                    tmp_num=tmp_num-(tmp_num*(Integer.parseInt(txt.getText().toString())))/100;
                    txt.setText(String.valueOf(tmp_num));
                    break;
            }
        });

        findViewById(R.id.button2).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    ((TextView)findViewById(R.id.editTextNumber)).setText(" ");
                }
                return false;
            }
        });



    }

    public void testClickButton(View v){
        Button b=(Button) v;
        txt.setText(txt.getText().toString()+b.getText().toString());
    }

    public void calc(View v){
        Button b=(Button)v;
        tmp_num=Integer.parseInt(txt.getText().toString());
        operator=b.getText().charAt(0);
        txt.setText("");
    }


}






















