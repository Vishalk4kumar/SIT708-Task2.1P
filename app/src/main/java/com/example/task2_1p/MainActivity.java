package com.example.task2_1p;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner sourceUnitSpinner, destinationUnitSpinner;
    private EditText valueEditText;
    private Button convertButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sourceUnitSpinner = findViewById(R.id.sourceUnitSpinner);
        destinationUnitSpinner = findViewById(R.id.destinationUnitSpinner);
        valueEditText = findViewById(R.id.valueEditText);
        convertButton = findViewById(R.id.convertButton);
        resultTextView = findViewById(R.id.resultTextView);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.units_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sourceUnitSpinner.setAdapter(adapter);
        destinationUnitSpinner.setAdapter(adapter);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get selected units and value
                String sourceUnit = sourceUnitSpinner.getSelectedItem().toString();
                String destinationUnit = destinationUnitSpinner.getSelectedItem().toString();
                String valueStr = valueEditText.getText().toString();

                // Check if value is empty
                if (valueStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a value", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Parse value to double
                double value;
                try {
                    value = Double.parseDouble(valueStr);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Please enter a valid number", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Check if source and destination units are the same
                if (sourceUnit.equals(destinationUnit)) {
                    Toast.makeText(MainActivity.this, "Source and destination units cannot be the same", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Perform conversion
                double result = Converter.convertUnits(sourceUnit, destinationUnit, value);
                if (result != -1) {
                    resultTextView.setText(String.valueOf(result));
                } else {
                    Toast.makeText(MainActivity.this, "Conversion not supported", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}