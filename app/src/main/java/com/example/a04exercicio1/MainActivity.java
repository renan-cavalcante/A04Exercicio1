package com.example.a04exercicio1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private EditText inputData;
    private TextView tvResultado;


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
        inputData = findViewById(R.id.inputData);
        tvResultado = findViewById(R.id.tvResultado);

        Button btnExec = findViewById(R.id.btnExec);

        btnExec.setOnClickListener(op -> calculaData());


    }

    private void calculaData() {
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNasc = LocalDate.parse(inputData.getText().toString(), formatters);

        LocalDate dataAtual = LocalDate.now();
        Period period = Period.between(dataNasc, dataAtual);

        tvResultado.setText(period.getDays()+" Dias, "+period.getMonths()+" Meses e "+period.getYears()+" Anos");















    }
}