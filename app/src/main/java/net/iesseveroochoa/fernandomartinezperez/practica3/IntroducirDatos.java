package net.iesseveroochoa.fernandomartinezperez.practica3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IntroducirDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introducir_datos);

        Button ok = (Button) findViewById(R.id.btidOK);
        ok.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText editText = (EditText) findViewById(R.id.etInValor);
                        String resultado = editText.getText().toString();

                        Intent intent = new Intent();
                        intent.putExtra("valor", resultado);
                        setResult(Activity.RESULT_OK, intent);
                        finish();


                    }
                }
        );

        Button cancel = (Button) findViewById(R.id.btidCancel);
        cancel.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );
    }
}