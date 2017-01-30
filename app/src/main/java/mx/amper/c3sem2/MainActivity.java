package mx.amper.c3sem2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre;
    private DatePicker dtFecNac;
    private EditText etTelefono;
    private EditText etEmail;
    private EditText etDesc;

    //ArrayList<Contactos> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //tToast("onCreate.Main");

        //contactos = new ArrayList<Contactos>();

        Button btnSiguiente = (Button) findViewById(R.id.btSiguiente);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etNombre =(EditText) findViewById(R.id.etNombre);
                dtFecNac = (DatePicker) findViewById(R.id.dpFecha);
                String fecNac = dtFecNac.toString();
                etTelefono = (EditText) findViewById(R.id.etTelefono);
                etEmail = (EditText) findViewById(R.id.etEmail);
                etDesc = (EditText) findViewById(R.id.etDescContac);

                Intent intent = new Intent(MainActivity.this, Datos.class);
                intent.putExtra("nombre", etNombre.getText().toString());
                intent.putExtra("fecNac", fecNac);
                intent.putExtra("telefono", etTelefono.getText().toString());
                intent.putExtra("email", etEmail.getText().toString());
                intent.putExtra("desc", etDesc.getText().toString());
                startActivity(intent);
                finish();

            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //tToast("onRestart.Main");

        //REcuerar pará,etros
        Bundle parametroR = getIntent().getExtras();
        String nombreR = parametroR.getString(getResources().getString(R.string.pnombreR));
        String fecNacR = parametroR.getString(getResources().getString(R.string.pfecnacR));
        String telefonoR = parametroR.getString(getResources().getString(R.string.ptelefonoR));
        String emailR = parametroR.getString(getResources().getString(R.string.pemailR));
        String descR = parametroR.getString(getResources().getString(R.string.pdescR));

        //Mostrar datos en los views
        etNombre = (EditText) findViewById(R.id.etNombre);
        dtFecNac = (DatePicker) findViewById(R.id.dpFecha);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etDesc = (EditText) findViewById(R.id.etDescContac);

        etNombre.setText(nombreR);
        //dtFecNac.setText(fecNacR);
        etTelefono.setText(telefonoR);
        etEmail.setText(emailR);
        etDesc.setText(descR);

    }

    private void tToast(String s) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, s, duration);
        toast.show();
    }
}
