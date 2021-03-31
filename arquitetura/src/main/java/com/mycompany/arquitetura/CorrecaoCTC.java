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
    
    double calculoPrimeiroTipodeCorrecao(
            double calculaQTDKgHectareDaFonte,//B22
            int fonteDeFostoroUtilizar){//D23
        double correcaoEnxofre = 0.0;
       
        switch(fonteDeFostoroUtilizar){
            case 1:
                correcaoEnxofre=calculaQTDKgHectareDaFonte*0.1;
                break;
            case 5:
                correcaoEnxofre=calculaQTDKgHectareDaFonte*0.15;
                break;
            case 12:
                correcaoEnxofre=calculaQTDKgHectareDaFonte*0.11;
                break;
            default:   
                correcaoEnxofre=0.0;
                break;
        }
        return correcaoEnxofre;
    }
    
    double calculoSegundoTipodeCorrecao(
            double calculaKgAlqueiroDaFonte,//B24
            int fonteDeFostoroUtilizar//D23
            ){
        double correcaoCalcio = 0.0;
        switch(fonteDeFostoroUtilizar){
            case 1:
                correcaoCalcio = calculaKgAlqueiroDaFonte*0.28;
                break;
            case 2:
                correcaoCalcio = calculaKgAlqueiroDaFonte*0.2;
                break;
            case 3:
                correcaoCalcio = calculaKgAlqueiroDaFonte*0.09;
                break;
            case 4:
                correcaoCalcio = calculaKgAlqueiroDaFonte*0.16;
                break;
            case 5:
                correcaoCalcio = calculaKgAlqueiroDaFonte*0.28;
                break;
            case 6:
                correcaoCalcio = calculaKgAlqueiroDaFonte*0.52;
                break;
            case 7:
                correcaoCalcio = calculaKgAlqueiroDaFonte*0.52;
                break;
            case 8:
                correcaoCalcio = calculaKgAlqueiroDaFonte*0.45;
                break;
            case 9:
                correcaoCalcio = calculaKgAlqueiroDaFonte*0.28;
                break;
            case 10:
                correcaoCalcio = calculaKgAlqueiroDaFonte*0.44;
                break;
            case 11:
                correcaoCalcio = calculaKgAlqueiroDaFonte*0.0;
                break;
            case 12:
                correcaoCalcio = calculaKgAlqueiroDaFonte*0.18;
                break;
            default:   
                correcaoCalcio = 0.0;
                break;
        }
        return correcaoCalcio/2.42;
    }
    
    String nomePrimeiroTipodeCorrecao(int fonteDeFostoroUtilizar){
        String elemento = "";
        switch(fonteDeFostoroUtilizar){
            case 1:
                elemento="Enxofre";
                break;
            case 5:
                elemento="Magnésio";
                break;
            case 12:
                elemento="Enxofre";
                break;
            default:   
                elemento = "";
                break;   
        }
        return elemento;
    } 

    String nomeSegundoTipodeCorrecao(int fonteDeFostoroUtilizar) {
        String elemento = "";
        switch(fonteDeFostoroUtilizar){
            case 1:
                elemento="Cálcio";
                break;
            case 2:
                elemento="Cálcio";
                break;
            case 3:
                elemento="Nitrogênio";
                break;
            case 4:
                elemento="Nitrogênio";
                break;
            case 5:
                elemento="Cálcio";
                break;
            case 6:
                elemento="Cálcio";
                break;
            case 7:
                elemento="Cálcio";
                break;
            case 8:
                elemento="Cálcio";
                break;
            case 9:
                elemento="Cálcio";
                break;
            case 10:
                elemento="Cálcio";
                break;
            case 11:
                elemento="";
                break;
            case 12:
                elemento="Cálcio";
                break;
            default:   
                elemento = "";
                break;   
        }
        return elemento;
    }
    
    double custoCorrecaoPporHa(double calculaKgAlqueiroDaFonte,int fonteDeFostoroUtilizar, double precoDaFonte){
        double custoCorrecaoPporHa = 0.0;
        if(fonteDeFostoroUtilizar>0 && fonteDeFostoroUtilizar<13){
            custoCorrecaoPporHa = calculaKgAlqueiroDaFonte/1000*precoDaFonte/2.42;
        }else{
            custoCorrecaoPporHa = 0.0;
        }
        return custoCorrecaoPporHa;
    }
    
    double participacaoAtualdoPnaCTC(double calculaCTCMOL,double potassio){
        double participacaoAtualdoPnaCTC=0.0;
        participacaoAtualdoPnaCTC = potassio/calculaCTCMOL*100;
        return participacaoAtualdoPnaCTC;
    }
    
    double participacaoDoPnaCTCposCorrecao(double participacaoPnaCTCDesejada){
        if(participacaoPnaCTCDesejada>0.001){
            return participacaoPnaCTCDesejada;
        }else{
            return 0.0;
        }
    }
    
    double participacaoIdealdoPnaCTC(double valorTextura){
        if(valorTextura>0 && valorTextura<3){
            return 3;
        }else{
            return 0.0;
        }
    }
    
    double calculaQTDKgHectareDeK2O(
            double eficienciaDoPotassio,//F59
            double necessidadeDePotassioadicionar,//F51
            int fontedePotassioUsar //D37
            ){
        double QTDKgHectareDeK2O = 0.0;
        double teorDeK2OdaFonte=0.0;//em %
        
        if(necessidadeDePotassioadicionar>0.01){
           switch(fontedePotassioUsar){
               case 1:
                   teorDeK2OdaFonte=58.0;
                   break;
               case 2:
                   teorDeK2OdaFonte=52.0;
                   break;
               case 3:
                   teorDeK2OdaFonte=22.0;
                   break;
               case 4:
                   teorDeK2OdaFonte=44.0;
                   break;
               default:
                   teorDeK2OdaFonte=0.0;
                   break;
           } 
        QTDKgHectareDeK2O = necessidadeDePotassioadicionar*39.1*10*2*1.2*100/eficienciaDoPotassio*100/teorDeK2OdaFonte;
        return QTDKgHectareDeK2O;   
        
        }else{
            return 0.0;
        }  
    }
    
    
}
