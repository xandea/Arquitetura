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
    
    double correcaoCalcio(
            double calculaSulfatoSimplesKGAlqueiro,//B24
            int fonteDeFostoroUtilizar//D23
            ){
        double correcaoCalcio = 0.0;
        switch(fonteDeFostoroUtilizar){
            case 1:
                correcaoCalcio = calculaSulfatoSimplesKGAlqueiro*0.28;
                break;
            case 2:
                correcaoCalcio = calculaSulfatoSimplesKGAlqueiro*0.2;
                break;
            case 3:
                correcaoCalcio = calculaSulfatoSimplesKGAlqueiro*0.09;
                break;
            case 4:
                correcaoCalcio = calculaSulfatoSimplesKGAlqueiro*0.16;
                break;
            case 5:
                correcaoCalcio = calculaSulfatoSimplesKGAlqueiro*0.28;
                break;
            case 6:
                correcaoCalcio = calculaSulfatoSimplesKGAlqueiro*0.52;
                break;
            case 7:
                correcaoCalcio = calculaSulfatoSimplesKGAlqueiro*0.52;
                break;
            case 8:
                correcaoCalcio = calculaSulfatoSimplesKGAlqueiro*0.45;
                break;
            case 9:
                correcaoCalcio = calculaSulfatoSimplesKGAlqueiro*0.28;
                break;
            case 10:
                correcaoCalcio = calculaSulfatoSimplesKGAlqueiro*0.44;
                break;
            case 11:
                correcaoCalcio = calculaSulfatoSimplesKGAlqueiro*0.0;
                break;
            case 12:
                correcaoCalcio = calculaSulfatoSimplesKGAlqueiro*0.18;
                break;
        }
        return correcaoCalcio/2.42;
    }
}
