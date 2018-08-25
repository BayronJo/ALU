package com.example.bayron.alu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import android.view.View;
import android.widget.EditText;


import com.example.bayron.alu.ALU.ProcesoALU;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import eu.inmite.android.lib.validations.form.FormValidator;

import eu.inmite.android.lib.validations.form.annotations.NotEmpty;
import eu.inmite.android.lib.validations.form.callback.SimpleErrorPopupCallback;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edtPrimerNumero)
    @NotEmpty(messageId = R.string.Numero1)
    EditText Primero;

    @BindView(R.id.edtSegundoNumero)
    @NotEmpty(messageId = R.string.Numero1)
    EditText Segundo;
    ProcesoALU alu;
    String Num1="";
    String Num2="";
    String Respuesta="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btnProcesar,R.id.btnCancelar})
    public  void mensaje(View v){
        switch (v.getId()){
            case R.id.btnProcesar:
                if(FormValidator.validate(this,new SimpleErrorPopupCallback(this))) {
                    Num1 = agregarCeros(Primero.getText().toString(),4);
                    Num2 = agregarCeros(Segundo.getText().toString(),4);

                    alu = new ProcesoALU(Num1,Num2);
                    Primero.setText("");
                    Segundo.setText("");
                    alu.Procesar();
                    Respuesta = alu.getRespuesta();
                    Intent intent = new Intent(this,Segunda.class);
                    intent.putExtra("Numero1",Num1);
                    intent.putExtra("Numero2",Num2);
                    intent.putExtra("Respuesta",Respuesta);
                    startActivity(intent);
                }
                break;
            case R.id.btnCancelar:
                Primero.setText("");
                Segundo.setText("");
                break;
        }
    }
    public  String agregarCeros(String valor, int largo) {
        String ceros = "";
        String NuevoValor ="";
        int cantidad = largo - valor.length();
        if (cantidad >= 1) {
            for(int i=0;i<cantidad;i++) {
                ceros += "0";
            }
            NuevoValor = ceros+valor;
        } else
            NuevoValor = valor;
        return NuevoValor;
    }
}



