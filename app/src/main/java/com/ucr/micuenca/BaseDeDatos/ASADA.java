package com.ucr.micuenca.BaseDeDatos;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ASADA extends DatoGeneral implements Comparable<ASADA> {
    String nombre;
    int aguaConsumida;
    int constante;
    int anoInfraestructura;
    int anoCreacion;
    int cantidadTomas;
    int cantidadTuberias;
    int cantidadTanques;
    int cantidadBeneficiados;
    String nombreSubcuenca;


    public ASADA(String nombre, int aguaConsumida, int constante, int anoInfraestructura, int anoCreacion, int cantidadTomas, int cantidadTuberias, int cantidadTanques, int cantidadBeneficiados, String nombreSubcuenca) {
        this.nombre = nombre;
        this.aguaConsumida = aguaConsumida;
        this.constante = constante;
        this.anoInfraestructura = anoInfraestructura;
        this.anoCreacion = anoCreacion;
        this.cantidadTomas = cantidadTomas;
        this.cantidadTuberias = cantidadTuberias;
        this.cantidadTanques = cantidadTanques;
        this.cantidadBeneficiados = cantidadBeneficiados;
        this.nombreSubcuenca = nombreSubcuenca;
    }

    public ASADA() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAguaConsumida() {
        return aguaConsumida;
    }

    public void setAguaConsumida(int aguaConsumida) {
        this.aguaConsumida = aguaConsumida;
    }

    public int getConstante() {
        return constante;
    }

    public void setConstante(int constante) {
        this.constante = constante;
    }

    public int getAnoInfraestructura() {
        return anoInfraestructura;
    }

    public void setAnoInfraestructura(int anoInfraestructura) {
        this.anoInfraestructura = anoInfraestructura;
    }

    public int getAnoCreacion() {
        return anoCreacion;
    }

    public void setAnoCreacion(int anoCreacion) {
        this.anoCreacion = anoCreacion;
    }

    public int getCantidadTomas() {
        return cantidadTomas;
    }

    public void setCantidadTomas(int cantidadTomas) {
        this.cantidadTomas = cantidadTomas;
    }

    public int getCantidadTuberias() {
        return cantidadTuberias;
    }

    public void setCantidadTuberias(int cantidadTuberias) {
        this.cantidadTuberias = cantidadTuberias;
    }

    public int getCantidadTanques() {
        return cantidadTanques;
    }

    public void setCantidadTanques(int cantidadTanques) {
        this.cantidadTanques = cantidadTanques;
    }

    public int getCantidadBeneficiados() {
        return cantidadBeneficiados;
    }

    public void setCantidadBeneficiados(int cantidadBeneficiados) {
        this.cantidadBeneficiados = cantidadBeneficiados;
    }

    public String getNombreSubcuenca() {
        return nombreSubcuenca;
    }

    public void setNombreSubcuenca(String nombreSubcuenca) {
        this.nombreSubcuenca = nombreSubcuenca;
    }

    @Override
    public String getTitulo() {
        return nombre;
    }

    @Override
    public String getDescripcion() {
        String myDescription = "Agua consumida: " + Integer.toString(this.aguaConsumida) + " l/hab/día, Año infraestructura: "
                + Integer.toString(this.anoInfraestructura) + ", Cantidad de personas beneficiadas: "
                + Integer.toString(this.cantidadBeneficiados) + ", Cantidad de Tanques: " + Integer.toString(this.cantidadTanques) +
                ", Cantidad de tuberías: " + Integer.toString(this.cantidadTuberias);
        return myDescription;
    }

    @Override
    public int compareTo(ASADA o) {
        return 0;
    }

    public List<ASADA> getListaASADA(Context context){
        List<ASADA> lista = new ArrayList<>();
        AccesoDatos accesoDatos = AccesoDatos.getInstance(context);
        accesoDatos.open();
        Cursor cursor = accesoDatos.obtenerLista("ASADA");
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            lista.add(new ASADA(cursor.getString(0), cursor.getInt(1), cursor.getInt(2)
                    , cursor.getInt(3), cursor.getInt(4), cursor.getInt(5)
                    , cursor.getInt(6), cursor.getInt(7), cursor.getInt(8)
                    , cursor.getString(9)
            ));
            cursor.moveToNext();
        }
        cursor.close();
        accesoDatos.close();
        Collections.sort(lista);
        return lista;
    }
}
