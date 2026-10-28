package com.example.practicalfive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class Municipality extends AppCompatActivity {

    private TextView txtMunicipalityName;
    private ImageView imgMunicipality;
    private TextView txtMunicipalityInfo;
    private Button btnVisitSite;

    private TextProcessor textProcessor;
    private String municipalityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_municipality);

        txtMunicipalityName = findViewById(R.id.txtMunicipalityName);
        imgMunicipality = findViewById(R.id.imgMunicipality);
        txtMunicipalityInfo = findViewById(R.id.txtMunicipalityInfo);
        btnVisitSite = findViewById(R.id.btnVisitSite);

        textProcessor = new TextProcessor();

        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.EXTRA_MUNICIPALITY);

        municipalityName = textProcessor.processMunicipality(name);

        if (municipalityName == null) {
            Toast.makeText(this, R.string.error_invalid, Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        displayMunicipality();

        btnVisitSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebsite();
            }
        });
    }

    private void displayMunicipality() {
        txtMunicipalityName.setText(municipalityName);

        int colorResId;
        int imageResId;
        int infoIndex;

        switch (municipalityName) {
            case "Beijing":
                colorResId = R.color.municipality_beijing;
                imageResId = R.drawable.beijing;
                infoIndex = 0;
                break;
            case "Shanghai":
                colorResId = R.color.municipality_shanghai;
                imageResId = R.drawable.shanghai;
                infoIndex = 1;
                break;
            case "Chongqing":
                colorResId = R.color.municipality_chongqing;
                imageResId = R.drawable.chongqing;
                infoIndex = 2;
                break;
            case "Tianjin":
                colorResId = R.color.municipality_tianjin;
                imageResId = R.drawable.tianjin;
                infoIndex = 3;
                break;
            default:
                colorResId = R.color.color_default_background;
                imageResId = R.drawable.chinese_municipalities;
                infoIndex = 0;
                break;
        }

        int color = ContextCompat.getColor(this, colorResId);

        txtMunicipalityName.setBackgroundColor(color);
        txtMunicipalityName.setTextColor(ContextCompat.getColor(this, R.color.color_text_light));

        imgMunicipality.setImageResource(imageResId);

        txtMunicipalityInfo.setTextColor(color);

        String[] infoArray = getResources().getStringArray(R.array.municipalities_array);
        if (infoIndex < infoArray.length) {
            txtMunicipalityInfo.setText(infoArray[infoIndex]);
        }

        btnVisitSite.setBackgroundColor(color);
        btnVisitSite.setTextColor(ContextCompat.getColor(this, R.color.color_text_light));
    }

    private void openWebsite() {
        String url;

        switch (municipalityName) {
            case "Beijing":
                url = "https://english.beijing.gov.cn/";
                break;
            case "Shanghai":
                url = "https://english.shanghai.gov.cn/";
                break;
            case "Tianjin":
                url = "https://en.tj.gov.cn/";
                break;
            case "Chongqing":
                url = "https://english.cq.gov.cn/";
                break;
            default:
                url = "https://www.gov.cn/";
                break;
        }

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

        try {
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "No application available to open website", Toast.LENGTH_SHORT).show();
        }
    }
}
