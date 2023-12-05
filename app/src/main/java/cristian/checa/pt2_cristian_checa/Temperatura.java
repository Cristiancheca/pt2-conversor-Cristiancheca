package cristian.checa.pt2_cristian_checa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Temperatura extends AppCompatActivity implements View.OnClickListener {
    RadioGroup radioGroup;

    Button Boton_Covertir_T,Volver_Temperatura;

    EditText Numero_Convertir_T;

    TextView Resultat_T;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura);
        radioGroup = findViewById(R.id.radioGroup);
        Resultat_T = findViewById(R.id.Resultat_T);
        Boton_Covertir_T = findViewById(R.id.Boton_Convertir_T);
        Boton_Covertir_T.setOnClickListener(this);
        Numero_Convertir_T = findViewById(R.id.Numero_Convertir_T);
        Volver_Temperatura = findViewById(R.id.Volver_Temperatura);
        Volver_Temperatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Temperatura.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        // Obtener el valor ingresado por el usuario
        String inputText = Numero_Convertir_T.getText().toString();
        if (!inputText.isEmpty()) {
            try {
                // Convertir el valor a un numero decimal
                double inputValue = Double.parseDouble(inputText);
                double result = 0.0;

                // Realizar la conversion de peso segun la opcion seleccionada
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedId);

                if (selectedRadioButton != null) {
                    String selectedOption = selectedRadioButton.getText().toString();
                    switch (selectedOption) {
                        case "Kelvin":
                            result = inputValue; // la conversión de °C a °C no cambia el valor
                            break;
                        case "Celsius":
                            result = (inputValue * 9/5) + 32; // Fórmula de conversión de °F a °C
                            break;
                        case "Fahrenheit":
                            result = inputValue + 273.15; // Fórmula de conversión de K a °C
                            break;
                        case "Rankine":
                            result = (inputValue + 273.15) * 9/5; // Fórmula de conversión de R a °C
                    }
                }

                // Mostrar el resultado en el TextView
                String resultText ="" + result;
                Resultat_T.setText(resultText);
            } catch (NumberFormatException e) {
                // Manejo de errores si la entrada no es un numero valido
                Resultat_T.setText("pon el numero");
            }
        } else {
            // Mensaje si no se ingreso ningun valor
            Resultat_T.setText("pon el numero");
        }
    }
}