package com.example.practicalfive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MUNICIPALITY = "com.example.practicalfive.MUNICIPALITY";

    private EditText etMunicipality;
    private TextProcessor textProcessor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMunicipality = findViewById(R.id.etMunicipality);
        textProcessor = new TextProcessor();

        etMunicipality.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_GO || actionId == EditorInfo.IME_ACTION_DONE) {
                    handleInput();
                    return true;
                }
                return false;
            }
        });
    }

    private void handleInput() {
        String input = etMunicipality.getText().toString();

        if (input.trim().isEmpty()) {
            etMunicipality.setError(getString(R.string.error_empty));
            return;
        }

        String result = textProcessor.processMunicipality(input);

        if (result == null) {
            etMunicipality.setError(getString(R.string.error_invalid));
            Toast.makeText(this, R.string.error_invalid, Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(MainActivity.this, Municipality.class);
        intent.putExtra(EXTRA_MUNICIPALITY, result);
        startActivity(intent);
    }
}
