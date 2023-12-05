package cristian.checa.pt2_cristian_checa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button Boton_Cambio_Logitud;

    Button Boton_Cambio_Pes;

    Button Boton_Cambio_Temperatura;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Boton_Cambio_Logitud = findViewById(R.id.Boton_Cambio_Logitud);
        Boton_Cambio_Logitud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_1 = new Intent(MainActivity.this,Longitud.class);
                startActivity(intent_1);
            }
        });
        Boton_Cambio_Pes = findViewById(R.id.Boton_Cambio_Pes);
        Boton_Cambio_Pes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenet_2 = new Intent(MainActivity.this,Pes.class);
                startActivity(intenet_2);
            }
        });
        Boton_Cambio_Temperatura = findViewById(R.id.Boton_Cambio_Temperatura);
        Boton_Cambio_Temperatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_3 = new Intent(MainActivity.this,Temperatura.class);
                startActivity(intent_3);
            }
        });
    }




}
