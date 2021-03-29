/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquitetura;

/**
 *
 * @author xande
 */
public class Solo {
    
    private double fosforo;
    private double potassio;
    private double calcio;
    private double magnesio;
    private double enxofre;
    private double aluminio;
    private double hal;
    private double materiaOrganica;
    private double carbono;
  
    public Solo Valor_Solo(int valor_textura){
        Solo s = new Solo();
        switch (valor_textura) {
            case 1:
                setFosforo(9.0);
                setPotassio(0.35);
                setCalcio(6);
                setMagnesio(1.5);
                setEnxofre(9);
                setAluminio(0);
                break;
            case 2:
                setFosforo(12);
                setPotassio(0.25);
                setCalcio(4);
                setMagnesio(1);
                setEnxofre(6);
                setAluminio(0);
                break;
            default:   
                System.out.println("ERRO: Tipo de textura de solo");
                break;
        }
        return s;
    }

    public double getFosforo() {
        return fosforo;
    }

    public void setFosforo(double fosforo) {
        this.fosforo = fosforo;
    }

    public double getPotassio() {
        return potassio;
    }

    public void setPotassio(double potassio) {
        this.potassio = potassio;
    }

    public double getCalcio() {
        return calcio;
    }

    public void setCalcio(double calcio) {
        this.calcio = calcio;
    }

    public double getMagnesio() {
        return magnesio;
    }

    public void setMagnesio(double magnesio) {
        this.magnesio = magnesio;
    }

    public double getEnxofre() {
        return enxofre;
    }

    public void setEnxofre(double enxofre) {
        this.enxofre = enxofre;
    }

    public double getAluminio() {
        return aluminio;
    }

    public void setAluminio(double aluminio) {
        this.aluminio = aluminio;
    }

    public double getHal() {
        return hal;
    }

    public void setHal(double hal) {
        this.hal = hal;
    }

    void setMateriaOrganica(double materiaOrganica) {
        if(materiaOrganica>0.01){
            this.materiaOrganica = materiaOrganica/10;
        }else{
            this.materiaOrganica = 0;
        }  
    }

    double getMateriaOrganica() {
        return materiaOrganica; 
    }

    void setCarbono(double carbono) {
        if(carbono>0.01){
            this.carbono = carbono/1.72*10;
        }else{
            this.carbono = 0;
        }
    }

    double getCarbono() {
        return carbono;
    }


  

}
