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

public class Longitud extends AppCompatActivity implements View.OnClickListener {

    RadioGroup radioGroup;

    Button Boton_Convertir_L,Tornar_Longitud;

    TextView Resultat_L;

    EditText Numero_Convertir_L;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_longitud);
        radioGroup = findViewById(R.id.radioGroup);
        Resultat_L = findViewById(R.id.Resultat_L);
        Boton_Convertir_L = findViewById(R.id.Boton_Convertir_L);
        Boton_Convertir_L.setOnClickListener(this);
        Numero_Convertir_L = findViewById(R.id.Numero_Convertir_L);
        Tornar_Longitud = findViewById(R.id.Tornar_Longitud);
        Tornar_Longitud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Longitud.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        // Obtener el valor ingresado por el usuario
        String inputText = Numero_Convertir_L.getText().toString();
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
                        case "Kilometre":
                            result = inputValue; // La conversión de km a km no cambia el valor
                            break;
                        case "Milla":
                            result = inputValue * 0.000621371; // 1 km ≈ 0.000621371 mi
                            break;
                        case "Iarda":
                            result = inputValue * 1093.61; // 1 km ≈ 1093.61 yd
                            break;
                        case "Polzades":
                            result = inputValue * 39370.1; // 1 km ≈ 39370.1 in
                            break;
                    }
                }

                // Mostrar el resultado en el TextView
                String resultText = String.valueOf(result);
                Resultat_L.setText(resultText);
            } catch (NumberFormatException e) {
                // Manejo de errores si la entrada no es un numero valido
                Resultat_L.setText("pon el numero");
            }
        } else {
            // Mensaje si no se ingreso ningun valor
            Resultat_L.setText("pon el numero");
        }
    }
}
