package com.example.apputn_calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView txtResultado;
    EditText campoNumero1, campoNumero2;
    Button bntSuma, btnResta, btnMultiplicacion, btnDivision, btnLimpiar;

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

        campoNumero1 = findViewById(R.id.campoNumero1);
        campoNumero2 = findViewById(R.id.campoNumero2);
        txtResultado = findViewById(R.id.txtResultado);
        bntSuma = findViewById(R.id.btnSuma);
        btnResta = findViewById(R.id.btnResta);
        btnMultiplicacion = findViewById(R.id.btnMultiplicacion);
        btnDivision = findViewById(R.id.btnDivision);
        btnLimpiar = findViewById(R.id.btnLimpiar);
    }
    public void sumaOnClick(View v) {
        String strNumero1 = campoNumero1.getText().toString();
        String strNumero2 = campoNumero2.getText().toString();

        if (esNumeroValido(strNumero1) && esNumeroValido(strNumero2)) {
            float numero1 = Float.parseFloat(strNumero1);
            float numero2 = Float.parseFloat(strNumero2);
            float resultado = numero1 + numero2;
            txtResultado.setText("Resultado: " + resultado);
        } else {
            Toast.makeText(this, "Operación inválida", Toast.LENGTH_SHORT).show();
        }
    }

    public void restaOnClick(View v) {
        String strNumero1 = campoNumero1.getText().toString();
        String strNumero2 = campoNumero2.getText().toString();

        if (esNumeroValido(strNumero1) && esNumeroValido(strNumero2)) {
            float numero1 = Float.parseFloat(strNumero1);
            float numero2 = Float.parseFloat(strNumero2);
            float resultado = numero1 - numero2;
            txtResultado.setText("Resultado: " + resultado);
        } else {
            Toast.makeText(this, "Operación inválida", Toast.LENGTH_SHORT).show();
        }
    }

    public void divisionOnClick(View v) {
        String strNumero1 = campoNumero1.getText().toString();
        String strNumero2 = campoNumero2.getText().toString();

        if (esNumeroValido(strNumero1) && esNumeroValido(strNumero2)) {
            float numero1 = Float.parseFloat(strNumero1);
            float numero2 = Float.parseFloat(strNumero2);

            if (numero2 != 0) {
                float resultado = numero1 / numero2;
                txtResultado.setText("Resultado: " + resultado);
            } else {
                txtResultado.setText("División por cero es infinito, no es posible");
            }
        } else {
            Toast.makeText(this, "Operación inválida", Toast.LENGTH_SHORT).show();
        }
    }

    public void multiplicacionOnClick(View v) {
        String strNumero1 = campoNumero1.getText().toString();
        String strNumero2 = campoNumero2.getText().toString();

        if (esNumeroValido(strNumero1) && esNumeroValido(strNumero2)) {
            float numero1 = Float.parseFloat(strNumero1);
            float numero2 = Float.parseFloat(strNumero2);
            float resultado = numero1 * numero2;
            txtResultado.setText("Resultado: " + resultado);
        } else {
            Toast.makeText(this, "Operación inválida", Toast.LENGTH_SHORT).show();
        }
    }

    public void limpiarcampos(View v) {
        campoNumero1.setText("");
        campoNumero2.setText("");
        txtResultado.setText("");
    }

    private boolean esNumeroValido(String numero) {
        try {
            Float.parseFloat(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
