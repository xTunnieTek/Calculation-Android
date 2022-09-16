package com.example.caculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView result=findViewById(R.id.result);
        final EditText inputNumberA=findViewById(R.id.inputNumberA);
        final EditText inputNumberB=findViewById(R.id.inputNumberB);
        final EditText inputNumberC=findViewById(R.id.inputNumberC);


        Button btn=findViewById(R.id.btn);
        Button btnExit=findViewById(R.id.btnExit);
        Button btnClear=findViewById(R.id.btnClear);
        Button btnRead=findViewById(R.id.btnRead);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Nếu người dùng không nhập số thì sẽ báo lỗi
                if(inputNumberA.getText().toString().equals("") || inputNumberB.getText().toString().equals("") || inputNumberC.getText().toString().equals(""))
                {
                    result.setText("Bạn chưa nhập đủ số");
                }
                else
                {
                    float a = Float.parseFloat(inputNumberA.getText().toString());
                    float b = Float.parseFloat(inputNumberB.getText().toString());
                    float c = Float.parseFloat(inputNumberC.getText().toString());
                    float delta = b*b - 4*a*c;
                    String resultString = "";
                    if (delta < 0)
                    {
                        resultString = "Phương trình vô nghiệm";
                    }
                    else if(delta == 0)
                    {
                        //Lấy kết quả sau dấu . 2 chữ số
                        resultString = "Phương trình có nghiệm kép là \n x1 = x2 = " + String.format("%.2f", -b/(2*a));
                    }
                    else
                    {
                        //Lấy kết quả sau dấu . 2 chữ số
                        resultString = "Phương trình có 2 nghiệm phân biệt \nx1 = " + String.format("%.2f", (-b + Math.sqrt(delta))/(2*a)) + "\nx2 = " + String.format("%.2f", (-b - Math.sqrt(delta))/(2*a));
                    }
                    result.setText(resultString);
                }
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputNumberA.setText("");
                inputNumberB.setText("");
                inputNumberC.setText("");
                result.setText("");
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Data  = "Tuấn Đẹp Trai Quá";
                result.setText(Data);
            }
        });

    }
}
