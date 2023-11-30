package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumber1;
    private EditText editTextNumber2;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        textViewResult = findViewById(R.id.textViewResult);
    }

    public void onAddClick(View view) {
        performOperation('+');
    }

    public void onSubtractClick(View view) {
        performOperation('-');
    }

    public void onMultiplyClick(View view) {
        performOperation('*');
    }

    public void onDivideClick(View view) {
        performOperation('/');
    }

    private void performOperation(char operator) {
        try {
            double number1 = Double.parseDouble(editTextNumber1.getText().toString());
            double number2 = Double.parseDouble(editTextNumber2.getText().toString());
            double result = 0;

            switch (operator) {
                case '+':
                    result = number1 + number2;
                    break;
                case '-':
                    result = number1 - number2;
                    break;
                case '*':
                    result = number1 * number2;
                    break;
                case '/':
                    if (number2 != 0) {
                        result = number1 / number2;
                    } else {
                        textViewResult.setText("Cannot divide by zero");
                        return;
                    }
                    break;
            }

            textViewResult.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            textViewResult.setText("Invalid input");
        }
    }
}