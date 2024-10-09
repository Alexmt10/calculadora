package com.iescamas.calculadora;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declaramos las variables
    EditText numero1, numero2;
    TextView resultado;
    Button btnSuma, btnResta, btnMultiplicacion, btnDivision, btnBorrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enlazamos los elementos de la interfaz con el código Java
        numero1 = findViewById(R.id.numeroescrito1);
        numero2 = findViewById(R.id.numeroescrito2);
        resultado = findViewById(R.id.Resultado);

        btnSuma = findViewById(R.id.botonSuma);
        btnResta = findViewById(R.id.botonResta);
        btnMultiplicacion = findViewById(R.id.botonMultiplicacion);
        btnDivision = findViewById(R.id.botonDivision);
        btnBorrar = findViewById(R.id.button5);

        // Sumar
        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarOperacion("suma");
            }
        });

        // Restar
        btnResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarOperacion("resta");
            }
        });

        // Multiplicar
        btnMultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarOperacion("multiplicacion");
            }
        });

        // Dividir
        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarOperacion("division");
            }
        });
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Limpiar los campos de entrada y el resultado
                numero1.setText("");
                numero2.setText("");
                resultado.setText("");
            }
        });
    }

    // Método para realizar las operaciones matemáticas
    private void realizarOperacion(String  signo) {
        String strNumero1 = numero1.getText().toString();
        String strNumero2 = numero2.getText().toString();


        if (numero1 != null) {

            // Validación de que los campos no estén vacíos
            if (TextUtils.isEmpty(strNumero1) || TextUtils.isEmpty(strNumero2)) {
                Toast.makeText(this, "Introduce ambos números", Toast.LENGTH_SHORT).show();
                return;
            }

            // Convertimos los valores ingresados en números enteros
            int num1 = Integer.parseInt(strNumero1);
            int num2 = Integer.parseInt(strNumero2);
            int resultadoOperacion = 0;

            // Ejecutamos la operación según el operador seleccionado
            switch (signo) {
                case "suma":
                    resultadoOperacion = num1 + num2;
                    break;
                case "resta":
                    resultadoOperacion = num1 - num2;
                    break;
                case "multiplicacion":
                    resultadoOperacion = num1 * num2;
                    break;
                case "division":
                    if (num2 == 0) {
                        Toast.makeText(this, "No se puede dividir por 0", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    resultadoOperacion = num1 / num2;
                    break;
            }

            // Mostramos el resultado en el TextView
            resultado.setText("Resultado: " + resultadoOperacion);
        }
    }
}

