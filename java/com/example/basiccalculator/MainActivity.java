package com.example.basiccalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText et1, et2;
    TextView result;
    Button b1, b2, b3, b4;

    boolean isSecondValActive = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.firstVal);
        et2 = findViewById(R.id.secondVal);
        b1 = findViewById(R.id.add);
        b2 = findViewById(R.id.sub);
        b3 = findViewById(R.id.div);
        b4 = findViewById(R.id.mul);
        result = findViewById(R.id.result);

        // Set number button click listeners
        setNumberButtonListeners();
    }

    private void setNumberButtonListeners() {
        int[] buttonIds = {
                R.id.button0, R.id.button1, R.id.button2, R.id.button3,
                R.id.button4, R.id.button5, R.id.button6, R.id.button7,
                R.id.button8, R.id.button9
        };

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                String currentValue = button.getText().toString();
                if (isSecondValActive) {
                    et2.append(currentValue);
                } else {
                    et1.append(currentValue);
                }
            }
        };

        for (int id : buttonIds) {
            findViewById(id).setOnClickListener(listener);
        }

        et1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                isSecondValActive = !hasFocus;
            }
        });

        et2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                isSecondValActive = hasFocus;
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void add(View view) {
        String firstVal = et1.getText().toString();
        String secondVal = et2.getText().toString();

        double x = Double.parseDouble(firstVal);
        double y = Double.parseDouble(secondVal);

        double resultValue = x + y;
        result.setText(String.valueOf(resultValue));
    }

    @SuppressLint("SetTextI18n")
    public void subtract(View view) {
        String firstVal = et1.getText().toString();
        String secondVal = et2.getText().toString();

        double x = Double.parseDouble(firstVal);
        double y = Double.parseDouble(secondVal);

        double resultValue = x - y;
        result.setText(String.valueOf(resultValue));
    }

    @SuppressLint("SetTextI18n")
    public void divide(View view) {
        String firstVal = et1.getText().toString();
        String secondVal = et2.getText().toString();

        double x = Double.parseDouble(firstVal);
        double y = Double.parseDouble(secondVal);

        if (y == 0) {
            result.setText("Cannot divide by zero");
        } else {
            double resultValue = x / y;
            result.setText(String.valueOf(resultValue));
        }
    }

    @SuppressLint("SetTextI18n")
    public void multiply(View view) {
        String firstVal = et1.getText().toString();
        String secondVal = et2.getText().toString();

        double x = Double.parseDouble(firstVal);
        double y = Double.parseDouble(secondVal);

        double resultValue = x * y;
        result.setText(String.valueOf(resultValue));
    }

    public void reset(View view) {
        et1.setText(null);
        et2.setText(null);
        result.setText("Result");
    }
}
