package com.ucr.micuenca.BaseDeDatos;

public class ASADA implements Comparable<ASADA> {
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
    public int compareTo(ASADA o) {
        return 0;
    }
}