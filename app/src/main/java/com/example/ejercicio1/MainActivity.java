package com.example.ejercicio1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre;
    private EditText etApellidoPaterno;
    private EditText etApellidoMaterno;
    private EditText etFechaNacimiento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void validarNombre(String nombre) throws ExceptionNombreInvalido{
        if(nombre.contains("0")||nombre.contains("1")||nombre.contains("2")||nombre.contains("3")||nombre.contains("4")||nombre.contains("5")||nombre.contains("6")||nombre.contains("7")||nombre.contains("8")||nombre.contains("9")||nombre.length()==0)
            throw new ExceptionNombreInvalido(getResources().getString(R.string.NombreInvaido));
    }

    public void validarFecha(String fechaNacimiento) throws ExceptionFechaInvalida{
        if(fechaNacimiento.length()!=10)
            throw new ExceptionFechaInvalida(getResources().getString(R.string.FechaInvalida));
    }


    public long calcularEdad(LocalDate fechaNacimiento){
        LocalDate hoy = LocalDate.now();
        ChronoUnit.YEARS.between(fechaNacimiento, hoy);
        return ChronoUnit.YEARS.between(fechaNacimiento, hoy);
    }

    public String obtenerHoroscopo(LocalDate fechaNacimiento){
        int dia = fechaNacimiento.getDayOfMonth();
        String signo = "";
        switch (fechaNacimiento.getMonth()){
            case JANUARY:
                if(dia>=21){
                    signo = getResources().getString(R.string.acuario);
                } else{
                    signo = getResources().getString(R.string.capricornio);
                }
                break;

            case FEBRUARY:
                if(dia>=19) {
                    signo = getResources().getString(R.string.piscis);
                }
                else{
                    signo=getResources().getString(R.string.acuario);
                }
                break;

            case MARCH:
                if(dia>=20) {
                    signo = getResources().getString(R.string.aries);
                }
                else {
                    signo = getResources().getString(R.string.piscis);
                }
                break;

            case APRIL:
                if(dia>=20) {
                    signo = getResources().getString(R.string.tauro);
                }
                else {
                    signo = getResources().getString(R.string.aries);
                }
                break;

            case MAY:
                if(dia>=21) {
                    signo = getResources().getString(R.string.geminis);
                }
                else {
                    signo = getResources().getString(R.string.tauro);
                }
                break;

            case JUNE:
                if(dia>=20) {
                    signo = getResources().getString(R.string.cancer);
                }
                else {
                    signo = getResources().getString(R.string.geminis);
                }
                break;

            case JULY:
                if(dia>=22) {
                    signo = getResources().getString(R.string.leo);
                }
                else {
                    signo = getResources().getString(R.string.cancer);
                }
                break;

            case AUGUST:
                if(dia>=21) {
                    signo = getResources().getString(R.string.virgo);
                }
                else {
                    signo = getResources().getString(R.string.leo);
                }
                break;

            case SEPTEMBER:
                if(dia>=22) {
                    signo = getResources().getString(R.string.libra);
                }
                else {
                    signo = getResources().getString(R.string.virgo);
                }
                break;

            case OCTOBER:
                if(dia>=22) {
                    signo = getResources().getString(R.string.escorpion);
                }
                else {
                    signo = getResources().getString(R.string.libra);
                }
                break;

            case NOVEMBER:
                if(dia>=21) {
                    signo = getResources().getString(R.string.sagitario);
                }
                else {
                    signo = getResources().getString(R.string.escorpion);
                }
                break;

            case DECEMBER:
                if(dia>=21) {
                    signo = getResources().getString(R.string.capricornio);
                }
                else {
                    signo = getResources().getString(R.string.sagitario);
                }
                break;
        }

        return signo;
    }

    public String obtenerRFC(String nombre, String apellidoPaterno, String apellidoMaterno, LocalDate fechaNacimiento){
        String rfc = "";
        int año = fechaNacimiento.getYear();
        String apPat=apellidoPaterno.substring(0,2).toUpperCase();
        String apMat=apellidoMaterno.substring(0,1).toUpperCase();
        String nom=nombre.substring(0,1).toUpperCase();
        String year=Integer.toString(año).substring(2);
        String month;
        if(fechaNacimiento.getMonthValue()<10){
            month = "0"+fechaNacimiento.getMonthValue();
        } else{
            month = Integer.toString(fechaNacimiento.getMonthValue());
        }
        String day;
        if(fechaNacimiento.getDayOfMonth()<10){
            day = "0"+fechaNacimiento.getDayOfMonth();
        } else{
            day = Integer.toString(fechaNacimiento.getDayOfMonth());
        }
        rfc = apPat+apMat+nom+year+month+day;
        return rfc;
    }


    public void Siguiente(View view){
        try{
            etNombre = (EditText)findViewById(R.id.etNombre);
            etApellidoPaterno = (EditText)findViewById(R.id.etApellidoPaterno);
            etApellidoMaterno = (EditText)findViewById(R.id.etApellidoMaterno);
            etFechaNacimiento = (EditText)findViewById(R.id.etFechaNacimiento);
            String nombre2="";
            int indice=0;
            String nombre = etNombre.getText().toString();
            validarNombre(nombre);
            if(nombre.contains(" ")){
                for(int i = 0; i < nombre.length(); i++){
                    if(nombre.charAt(i)==' '){
                        indice = i+1;
                        break;
                    }
                }
                nombre2 = nombre.substring(indice,indice+1).toUpperCase()+nombre.substring(indice+1).toLowerCase();
                nombre = nombre.substring(0,1).toUpperCase()+nombre.substring(0,indice).toLowerCase()+" "+nombre2;
            }

            String apPat = etApellidoPaterno.getText().toString();
            validarNombre(apPat);
            String apMat = etApellidoMaterno.getText().toString();
            validarNombre(apMat);
            String fecha = etFechaNacimiento.getText().toString();
            String nombreCompleto = nombre.substring(0,1).toUpperCase()+nombre.substring(1)+" "
                    +" "+apPat.substring(0,1).toUpperCase()+apPat.substring(1).toLowerCase()+" "
                    +apMat.substring(0,1).toUpperCase()+apMat.substring(1).toLowerCase();

            validarFecha(fecha);

            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaNacimiento = LocalDate.parse(fecha, formato);

            String edad = Long.toString(calcularEdad(fechaNacimiento));
            String signo = obtenerHoroscopo(fechaNacimiento);
            String rfc = obtenerRFC(nombre, apPat, apMat, fechaNacimiento);
            Intent siguiente = new Intent(this, SegundoAvtivity.class);
            siguiente.putExtra("nombre", nombreCompleto);
            siguiente.putExtra("edad", edad);
            siguiente.putExtra("signo", signo);
            siguiente.putExtra("rfc", rfc);
            startActivity(siguiente);
        }catch (ExceptionFechaInvalida ex){
            Toast toast1 = Toast.makeText(getApplicationContext(),ex.getMessage(), Toast.LENGTH_SHORT);
            toast1.show();
        }catch (ExceptionNombreInvalido ex){
            Toast toast1 = Toast.makeText(getApplicationContext(),ex.getMessage(), Toast.LENGTH_SHORT);
            toast1.show();
        }catch(DateTimeException ex){
            Toast toast1 = Toast.makeText(getApplicationContext(),R.string.FechaInexistente, Toast.LENGTH_SHORT);
            toast1.show();
        }
    }
}
