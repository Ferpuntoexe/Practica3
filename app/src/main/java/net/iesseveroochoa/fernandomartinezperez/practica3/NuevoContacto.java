package net.iesseveroochoa.fernandomartinezperez.practica3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class NuevoContacto extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_contacto);

        TextView tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvNombre.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(NuevoContacto.this, IntroducirDatos.class);
                        startActivityForResult(intent, 1);
                    }
                }
        );
        TextView tvApellidos = (TextView) findViewById(R.id.tvApellidos);
        tvApellidos.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(NuevoContacto.this, IntroducirDatos.class);
                        startActivityForResult(intent, 2);
                    }
                }
        );
        TextView tvEmpresa = (TextView) findViewById(R.id.tvEmpresa);
        tvEmpresa.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(NuevoContacto.this, IntroducirDatos.class);
                        startActivityForResult(intent, 3);
                    }
                }
        );
        EditText etTelefono = (EditText) findViewById(R.id.etTelefono);
        Button ok = (Button) findViewById(R.id.btNCOk);
        ok.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();

                        intent.putExtra("nombre", tvNombre.getText());
                        intent.putExtra("apellidos", tvApellidos.getText());
                        intent.putExtra("telefono", etTelefono.getText().toString());
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                }
        );

        Button cancel = (Button) findViewById(R.id.btNCCancel);
        cancel.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );
        ImageView ivParticularEmpresa = (ImageView) findViewById(R.id.ivParticularEmpresa);

        RadioGroup rgEmpresa = (RadioGroup) findViewById(R.id.rgEmpresa);
        rgEmpresa.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbtEmpresa:
                        ivParticularEmpresa.setVisibility(View.VISIBLE);
                        ivParticularEmpresa.setImageResource(R.mipmap.ic_empresa);
                        break;
                    case R.id.rbtParticular:
                        ivParticularEmpresa.setVisibility(View.VISIBLE);
                        ivParticularEmpresa.setImageResource(R.mipmap.ic_particular);
                }
            }
        });
        ImageView ivGenero = (ImageView) findViewById(R.id.ivGenero);
        RadioGroup rgGenero = (RadioGroup) findViewById(R.id.rgGenero);
        rgGenero.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbtMujer:
                        ivGenero.setVisibility(View.VISIBLE);
                        ivGenero.setImageResource(R.mipmap.ic_mujer);
                        break;
                    case R.id.rbtHombre:
                        ivGenero.setVisibility(View.VISIBLE);
                        ivGenero.setImageResource(R.mipmap.ic_hombre);
                }
            }
        });

        ImageView ivFavorito = (ImageView) findViewById(R.id.ivFavorito);
        Switch swfavorito = (Switch) findViewById(R.id.swFavoritos);
        swfavorito.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ivFavorito.setVisibility(View.VISIBLE);
                } else {
                    ivFavorito.setVisibility(View.INVISIBLE);
                }
            }
        });
        ImageView ivLlamar = (ImageView)findViewById(R.id.ivLlamar);
        CheckBox cbxLlamar = (CheckBox) findViewById(R.id.cbxLlamar);
        cbxLlamar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ivLlamar.setVisibility(View.VISIBLE);
                } else {
                    ivLlamar.setVisibility(View.INVISIBLE);
                }
            }
        });

        TextView tvEdad = (TextView) findViewById(R.id.tvEdad);
        int maxEdad = getResources().getInteger(R.integer.maxmaedad);
        SeekBar sbedad = (SeekBar) findViewById(R.id.sbEdad);
        sbedad.setMax(maxEdad);
        sbedad.setProgress(maxEdad / 2);
        String edadInicial = String.valueOf(maxEdad / 2);
        tvEdad.setText(edadInicial);
        sbedad.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvEdad.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        TextView tvNombre = (TextView) findViewById(R.id.tvNombre);
        TextView tvApellidos = (TextView) findViewById(R.id.tvApellidos);
        TextView tvEmpresa = (TextView) findViewById(R.id.tvEmpresa);

        super.onActivityResult(requestCode, resultCode, data);
        String resultado;
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 1) {
                resultado = data.getStringExtra("valor");
                tvNombre.setText(resultado);
            } else if (requestCode == 2) {
                resultado = data.getStringExtra("valor");
                tvApellidos.setText(resultado);
            } else if (requestCode == 3) {
                resultado = data.getStringExtra("valor");
                tvEmpresa.setText(resultado);
            }
        }
    }

}




















