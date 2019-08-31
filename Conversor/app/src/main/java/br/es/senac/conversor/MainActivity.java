package br.es.senac.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

//Declarando uma class...Erdando uma class/ herança...
public class MainActivity extends AppCompatActivity {

    // Variavel
    int alturaEmCentimetros = 0;
    int v1 = 2;
    int v2 = 10;
    int v3 = 5;

    private void onCreate(){

        int resultado = somaValor(v1, v2, v3);
    }




    private int somaValor(int v1, int v2, int v3){
        return (v1 +v2 +v3) /3;



    }

         private String formatarValorComdoisDigitos(double valor){
         String retorno = String.format(Locale.FRANCE,"%.2f", valor);
         return retorno;
    }
    //Metodo que declara o ciclo de criação da tela...
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // metodo que liga a MainActivity.JAVA no activity_main.xlm (TELA)
        super.onCreate(savedInstanceState);

        //Metodo que liga a activity.java
        setContentView(R.layout.activity_main);

        final TextView txtMedia = (TextView) findViewById(R.id.txtMedia);

        // INSTANCIA DE UM ELEMENTO TEXTO DO ANDROID
        final TextView txtMetros = (TextView) findViewById(R.id.txtMetros);

        //EXERCICIO CONVENCIONAL DE INSTANCIAR OBJETO NO JAVA
        // FINAL TextView txtMetros = new TextView();

        txtMetros.setText(String.valueOf(alturaEmCentimetros));
        final TextView txtPes = (TextView) findViewById(R.id.txtPes);

        // barra de rolagem
        final SeekBar seekBar = (SeekBar) findViewById(R.id.skbMetros);

        final Button button = (Button) findViewById(R.id.btnConverter);

        seekBar.setMax(230);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                alturaEmCentimetros = progress;
                txtMetros.setText(progress + "centimetros");

                String texto = formatarValorComdoisDigitos(progress / 100.0);

                //Stringo recebe ela mesmo
                texto += "m.";
                txtMetros.setText(texto);
            }

            @Override
            //Metodo
            public void onStartTrackingTouch(SeekBar seekBar) {
                txtPes.setText("Toque em Converter");

            }

            public void onStartTrackingTouch(TextView textView) {
                txtMedia.setText("Toque em Converter");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        final Button button1 = (Button)findViewById(R.id.btnConverter);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // alturaemcentimetros vai ta o valor do seekbar
                double alturaEmPes = alturaEmCentimetros / 30.48;
                String texto = formatarValorComdoisDigitos(alturaEmPes);
                texto += " pé(s)";
                txtPes.setText(texto);
            }
        });

    }

    private String formataValorComDoisDigitos(double valor) {
        return String.format(Locale.FRANCE, "%.2f" , valor);
    }


    }

