package mx.amper.c3sem2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Datos extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvFecNac;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        tToast("onCreate.Datos");

        //REcuerar pará,etros
        Bundle parametro = getIntent().getExtras();
        String nombre = parametro.getString(getResources().getString(R.string.pnombre));
        String fecNac = parametro.getString(getResources().getString(R.string.pfecnac));
        String telefono = parametro.getString(getResources().getString(R.string.ptelefono));
        String email = parametro.getString(getResources().getString(R.string.pemail));
        String desc = parametro.getString(getResources().getString(R.string.pdesc));

        //Mostrar datos en los views
        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvFecNac = (TextView) findViewById(R.id.tvFecNac);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDesc = (TextView) findViewById(R.id.tvDesc);

        tvNombre.setText(nombre);
        tvFecNac.setText(fecNac);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDesc.setText(desc);


        Button btnEditar = (Button) findViewById(R.id.btEditar);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Datos.this, MainActivity.class);
                intent.putExtra("nombreR", tvNombre.getText().toString());
                //intent.putExtra("fecNacR", tvFecNac);
                intent.putExtra("telefonoR", tvTelefono.getText().toString());
                intent.putExtra("emailR", tvEmail.getText().toString());
                intent.putExtra("descR", tvDesc.getText().toString());
                startActivity(intent);
                finish();
            }
        });


    }

    public void onRestart() {
        super.onRestart();
        tToast("onRestart.Datos");
    }

    public void onResume() {
        super.onResume();
        tToast("onResume.Datos");
    }

    public void onPause() {
        super.onPause();
        tToast("onPause.Datos: bye bye!");

    }

    public void onStop() {
        super.onStop();
        tToast("onStop.Datos");
    }

    public void onDestroy() {
        super.onStop();
        tToast("onDestroy.Datos");
    }

    private void tToast(String s) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, s, duration);
        toast.show();
    }
}
