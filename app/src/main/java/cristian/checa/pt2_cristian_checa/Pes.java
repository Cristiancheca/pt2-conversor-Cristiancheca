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

public class Pes extends AppCompatActivity implements View.OnClickListener {


    Button Boton_Convertir_P;

    Button Tornar_Pes;

    RadioGroup radioGroup;

    EditText Numero_convertir_P;

    TextView Resultat_P;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pes);
        radioGroup = findViewById(R.id.radioGroup);
        Boton_Convertir_P = findViewById(R.id.Boton_Convertir_P);
        Boton_Convertir_P.setOnClickListener(this);
        Tornar_Pes = findViewById(R.id.Tornar_Pes);
        Tornar_Pes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Pes.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Numero_convertir_P = findViewById(R.id.Numero_convertir_P);
        Resultat_P = findViewById(R.id.Resultat_P);
    }

    @Override
    public void onClick(View view) {
        // Obtener el valor ingresado por el usuario
        String inputText = Numero_convertir_P.getText().toString();
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
                        case "Kilogram":
                            result = inputValue; // la conversión de Kg a Kg no cambia el valor
                            break;
                        case "Lliura":
                            result = inputValue * 2.20462; // 1 Kg ≈ 2.20462 lb
                            break;
                        case "Unça":
                            result = inputValue * 35.27396; // 1 Kg ≈ 35.27396 oz
                            break;
                        case "Stone":
                            result = inputValue * 0.157473; // 1 Kg ≈ 0.157473 st
                            break;
                    }
                }

                // Mostrar el resultado en el TextView
                String resultText = ""+result;
                Resultat_P.setText(resultText);
            } catch (NumberFormatException e) {
                // Manejo de errores si la entrada no es un numero valido
                Resultat_P.setText("pon el numero");
            }
        } else {
            // Mensaje si no se ingreso ningun valor
            Resultat_P.setText("pon el numero");
        }
    }
}

