package com.example.bayron.alu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.bayron.alu.ALU.ProcesoALU;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Segunda extends AppCompatActivity {

    @BindView(R.id.priBin)
    TextView TxtprinBi;
    @BindView(R.id.priDec)
    TextView TxtpriDec;

    @BindView(R.id.senBin)
    TextView TxtsenBin;
    @BindView(R.id.segDec)
    TextView TxtsegDec;

    @BindView(R.id.Respuesta)
    TextView TxtRespuesta;
    @BindView(R.id.Decimal)
    TextView TxtRespDec;

    String Numero1="";
    String Numero2="";
    String Respuesta="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        ButterKnife.bind(this);
        (this).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Numero1 = getIntent().getExtras().getString("Numero1");
        Numero2 = getIntent().getExtras().getString("Numero2");
        Respuesta = getIntent().getExtras().getString("Respuesta");
        AsignarRespuesta();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void AsignarRespuesta(){
        TxtprinBi.setText(Numero1);
        TxtpriDec.setText(String.valueOf(Integer.parseInt( Numero1, 2 )));
        TxtsenBin.setText(Numero2);
        TxtsegDec.setText(String.valueOf(Integer.parseInt( Numero2, 2 )));
        TxtRespuesta.setText(Respuesta);
        TxtRespDec.setText(String.valueOf(Integer.parseInt(Respuesta, 2 )));
    }

   /* public void Procesar(){

        while (Contador != 4) {
            if (esUno(Numero2)){
                R3 = SumaBinaria(Numero1, R3);
                agregarCeros(R3, 4);
                Desplazamiento();
                agregarCeros(R3, 4);
                rotarDerecha(Numero2);
            } else {
                agregarCeros(R3, 4);
                Desplazamiento();
                agregarCeros(R3, 4);
                rotarDerecha(Numero2);
            }
            Contador++;
        }
        Respuesta = R3+R4;

    }
    public Boolean esUno(String Numero){

        boolean terminaenuno=false;

        String ultimo = Numero.substring(Numero.length() - 1);

        if(ultimo.equals("1")){
            terminaenuno = true;
        }
        return  terminaenuno;
    }

    public String  SumaBinaria(String n1,String n2){

        int a = Integer.parseInt( n1, 2 );
        int b = Integer.parseInt(n2, 2);
        int c = a + b;
        R3 = Integer.toString(c, 2);
        //Toast.makeText(this, R3, Toast.LENGTH_SHORT).show();
        return  R3;
    }

    public void Desplazamiento() {

        String Concatenacion = R3 + R4;
        int numero = Integer.parseInt(Concatenacion, 2);
        int numeroRotadoDerecha = numero >> 1;
        Rotado = Integer.toBinaryString(numeroRotadoDerecha);
        CerosRotado(Rotado,8);
        R3 = String.valueOf(Rotado.charAt(0)) + String.valueOf(Rotado.charAt(1))+String.valueOf(Rotado.charAt(2))+String.valueOf(Rotado.charAt(3));
        R4 = String.valueOf(Rotado.charAt(4))+String.valueOf(Rotado.charAt(5))+String.valueOf(Rotado.charAt(6))+String.valueOf(Rotado.charAt(7));

    }

    public  String agregarCeros(String string, int largo)
    {
        String ceros = "";
        int cantidad = largo - string.length();

        if (cantidad >= 1)
        {
            for(int i=0;i<cantidad;i++)
            {
                ceros += "0";
            }
            R3 = ceros+string;
            //Toast.makeText(this, R3, Toast.LENGTH_SHORT).show();
            return (R3);
        }
        else
            return R3;
    }

    public  String CerosRotado(String string, int largo)
    {
        String ceros = "";

        int cantidad = largo - string.length();

        if (cantidad >= 1)
        {
            for(int i=0;i<cantidad;i++)
            {
                ceros += "0";
            }
            Rotado = ceros+string;
            //Toast.makeText(this, R3, Toast.LENGTH_SHORT).show();
            return (Rotado);
        }
        else
            return Rotado;
    }


    public  String rotarDerecha(String binario) {
        Numero2 = binario.charAt(binario.length() - 1) + binario.substring(0, binario.length() - 1);
        return Numero2;
    }*/
}
