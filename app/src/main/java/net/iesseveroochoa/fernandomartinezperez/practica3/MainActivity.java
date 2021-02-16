package net.iesseveroochoa.fernandomartinezperez.practica3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int nuevoContacto = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button nuevo = (Button) findViewById(R.id.btNuebo);
        nuevo.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, NuevoContacto.class);
                        startActivityForResult(intent, nuevoContacto);

                    }
                }
        );
        Button salir = (Button) findViewById(R.id.btSalir);
        salir.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        TextView tvAgenda = (TextView) findViewById(R.id.tvAgenda);
        String agendaTemp = tvAgenda.getText().toString();
        super.onActivityResult(requestCode, resultCode, data);
        String resultado;
        if (resultCode == Activity.RESULT_OK) {
            agendaTemp += ("\n" + data.getStringExtra("nombre") + " " +
                    data.getStringExtra("apellidos") + "-" + data.getStringExtra("telefono"));
            tvAgenda.setText(agendaTemp);
        }
    }
}
