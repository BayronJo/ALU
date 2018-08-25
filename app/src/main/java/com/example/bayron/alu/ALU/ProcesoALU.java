package com.example.bayron.alu.ALU;
public class ProcesoALU {
    private String R1="0000";
    private String R2="0000";
    private String R3 ="0000";
    private String R4 ="0000";
    private String Rotado ="00000000";
    private  String Respuesta ="";
    private  int Contador =0;

    public String getRespuesta() {
        return Respuesta;
    }
    public ProcesoALU(String r1, String r2) {
        R1 = r1;
        R2 = r2;
    }

    //Desde aqui Empieza el Proceso de la ALU//
    public String  SumaBinaria(int a, int b){
        R3 = agregarCeros(Integer.toString(a+b, 2),4);
        return  R3;
    }

    public void Desplazamiento() {
        int numero = Integer.parseInt(R3+R4, 2);
        int numeroRotadoDerecha = numero >> 1;
        Rotado = agregarCeros(Integer.toBinaryString(numeroRotadoDerecha),8);
        R3 = String.valueOf(Rotado.charAt(0)) + String.valueOf(Rotado.charAt(1))+String.valueOf(Rotado.charAt(2))+String.valueOf(Rotado.charAt(3));
        R4 = String.valueOf(Rotado.charAt(4))+String.valueOf(Rotado.charAt(5))+String.valueOf(Rotado.charAt(6))+String.valueOf(Rotado.charAt(7));
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

    public void Procesar(){
        while (Contador != 4) {
            if (R2.substring(R2.length()-1).equals("1")){//si R2 termina en 1
                R3 = SumaBinaria(Integer.parseInt(R1,2),Integer.parseInt(R3,2));
                Desplazamiento();
                R2 = R2.charAt(R2.length() - 1) + R2.substring(0, R2.length()- 1);//Rotacion Derecha
            } else{
                Desplazamiento();
                R2 = R2.charAt(R2.length() - 1) + R2.substring(0, R2.length() - 1);//Rotacion Derecha
            }
            Contador++;
        }
        Respuesta = R3+R4;
    }
}
