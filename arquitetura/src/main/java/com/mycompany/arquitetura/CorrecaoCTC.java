package com.mycompany.arquitetura;

/**
 *
 * @author xande
 */
public class CorrecaoCTC {
    double calculaSCMOL(double potassio,double calcio,double magnesio){
        return potassio+calcio+magnesio;    
    };

    double calculaCTCMOL(double calculoSCMOL,double hidrogenio) {
        return calculoSCMOL+hidrogenio;    
    }

    double calculaVPorcentagem(double calculaCTCMOL, double calculaSCMOL) {
        return 100*calculaSCMOL/calculaCTCMOL;
    }
}
