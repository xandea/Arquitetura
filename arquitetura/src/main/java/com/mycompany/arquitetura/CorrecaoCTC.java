package com.mycompany.arquitetura;

/**
 *
 * @author xande
 */
public class CorrecaoCTC {
    double calculaSCMOL(double potassio,double calcio,double magnesio){
        return potassio+calcio+magnesio;    
    }

    double calculaCTCMOL(double calculoSCMOL,double hidrogenio) {
        return calculoSCMOL+hidrogenio;    
    }

    double calculaVPorcentagem(double calculaCTCMOL, double calculaSCMOL) {
        return 100*calculaSCMOL/calculaCTCMOL;
    }
    
    double correcaoEnxofre(
            double calculaSulfatoSimplesKGHectare,//B22
            int fonteDeFostoroUtilizar){//D23
        
        double calculaSulfatoSimplesKGAlqueiro = 0.0;//B24
        double correcaoEnxofre = 0.0;
        calculaSulfatoSimplesKGAlqueiro = calculaSulfatoSimplesKGHectare*2.42;
        
        switch(fonteDeFostoroUtilizar){
            case 1:
                correcaoEnxofre=calculaSulfatoSimplesKGAlqueiro*0.1/2.42;
                break;
            case 5:
                correcaoEnxofre=calculaSulfatoSimplesKGHectare*0.15;
                break;
            case 12:
                correcaoEnxofre=calculaSulfatoSimplesKGAlqueiro*0.11/2.42;
                break;
            default:   
                System.out.println("ERRO: Tipo de textura de solo");
                break;
        }
        return correcaoEnxofre;
    }
}
