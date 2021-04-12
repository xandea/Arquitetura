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
    
    double calculoFornecimentoDoPrimeiroNutrienteParaCorrecaoDeFosforo (
            double calculaQTDKgHectareDaFonte,//B22
            int fonteDeFostoroUtilizar){//D23
        double calculoFornecimentoDoPrimeiroNutrienteParaCorrecaoDeFosforo = 0.0;
       
        switch(fonteDeFostoroUtilizar){
            case 1:
                calculoFornecimentoDoPrimeiroNutrienteParaCorrecaoDeFosforo=calculaQTDKgHectareDaFonte*0.1;
                break;
            case 5:
                calculoFornecimentoDoPrimeiroNutrienteParaCorrecaoDeFosforo=calculaQTDKgHectareDaFonte*0.15;
                break;
            case 12:
                calculoFornecimentoDoPrimeiroNutrienteParaCorrecaoDeFosforo=calculaQTDKgHectareDaFonte*0.11;
                break;
            default:   
                calculoFornecimentoDoPrimeiroNutrienteParaCorrecaoDeFosforo=0.0;
                break;
        }
        return calculoFornecimentoDoPrimeiroNutrienteParaCorrecaoDeFosforo;
    }
    
    double calculoFornecimentoDoSegundoNutrienteParaCorrecaoDeFosforo(
            double calculaKgAlqueiroDaFonteDeFosforo,//B24
            int fonteDeFostoroUtilizar//D23
            ){
        double calculoFornecimentoDoSegundoNutrienteParaCorrecaoDeFosforo = 0.0;
        switch(fonteDeFostoroUtilizar){
            case 1:
                calculoFornecimentoDoSegundoNutrienteParaCorrecaoDeFosforo = calculaKgAlqueiroDaFonteDeFosforo*0.28;
                break;
            case 2:
                calculoFornecimentoDoSegundoNutrienteParaCorrecaoDeFosforo = calculaKgAlqueiroDaFonteDeFosforo*0.2;
                break;
            case 3:
                calculoFornecimentoDoSegundoNutrienteParaCorrecaoDeFosforo = calculaKgAlqueiroDaFonteDeFosforo*0.09;
                break;
            case 4:
                calculoFornecimentoDoSegundoNutrienteParaCorrecaoDeFosforo = calculaKgAlqueiroDaFonteDeFosforo*0.16;
                break;
            case 5:
                calculoFornecimentoDoSegundoNutrienteParaCorrecaoDeFosforo = calculaKgAlqueiroDaFonteDeFosforo*0.28;
                break;
            case 6:
                calculoFornecimentoDoSegundoNutrienteParaCorrecaoDeFosforo = calculaKgAlqueiroDaFonteDeFosforo*0.52;
                break;
            case 7:
                calculoFornecimentoDoSegundoNutrienteParaCorrecaoDeFosforo = calculaKgAlqueiroDaFonteDeFosforo*0.52;
                break;
            case 8:
                calculoFornecimentoDoSegundoNutrienteParaCorrecaoDeFosforo = calculaKgAlqueiroDaFonteDeFosforo*0.45;
                break;
            case 9:
                calculoFornecimentoDoSegundoNutrienteParaCorrecaoDeFosforo = calculaKgAlqueiroDaFonteDeFosforo*0.28;
                break;
            case 10:
                calculoFornecimentoDoSegundoNutrienteParaCorrecaoDeFosforo = calculaKgAlqueiroDaFonteDeFosforo*0.44;
                break;
            case 11:
                calculoFornecimentoDoSegundoNutrienteParaCorrecaoDeFosforo = calculaKgAlqueiroDaFonteDeFosforo*0.0;
                break;
            case 12:
                calculoFornecimentoDoSegundoNutrienteParaCorrecaoDeFosforo = calculaKgAlqueiroDaFonteDeFosforo*0.18;
                break;
            default:   
                calculoFornecimentoDoSegundoNutrienteParaCorrecaoDeFosforo = 0.0;
                break;
        }
        return calculoFornecimentoDoSegundoNutrienteParaCorrecaoDeFosforo/2.42;
    }
    
    String nomeDoPrimeiroNutrienteParaCorrecaoDePotassio(int fonteDeFostoroUtilizar){
        if(fonteDeFostoroUtilizar == 1 || fonteDeFostoroUtilizar == 12){
            return "Enxofre";
        }else if(fonteDeFostoroUtilizar == 2){
            return "Magnésio";
        }else{
            return ""; 
        }
    } 

    String nomeDoSegundoNutrienteParaCorrecaoDePotassio(int fonteDeFostoroUtilizar) {
        if(fonteDeFostoroUtilizar >=5 && fonteDeFostoroUtilizar <=10 || 
                fonteDeFostoroUtilizar == 1 || 
                fonteDeFostoroUtilizar == 2 || 
                fonteDeFostoroUtilizar == 12){
            return "Cálcio";
        }else if(fonteDeFostoroUtilizar == 3 || fonteDeFostoroUtilizar== 4){
            return "Nitrogênio";
        }else{
            return "";
        }
    }
    
    double custoCorrecaoPporHa(double calculaKgAlqueiroDaFonteDeFosforo,int fonteDeFostoroUtilizar, double precoDaFonte){
        double custoCorrecaoPporHa = 0.0;
        if(fonteDeFostoroUtilizar>0 && fonteDeFostoroUtilizar<13){
            custoCorrecaoPporHa = calculaKgAlqueiroDaFonteDeFosforo/1000*precoDaFonte/2.42;
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
    
    double calculaQTDKgHectareDeFonteDePotassio(
            double eficienciaDoPotassio,//F59
            double necessidadeDePotassioAdicionar,//F51
            int fontedePotassioUsar //D37
            ){
        double QTDKgHectareDeFonteDePotassio = 0.0;
        double teorDaFonteDePotassio=0.0;//em %
        
        if(necessidadeDePotassioAdicionar>0.01){
           switch(fontedePotassioUsar){
               case 1:
                   teorDaFonteDePotassio=58.0;
                   break;
               case 2:
                   teorDaFonteDePotassio=52.0;
                   break;
               case 3:
                   teorDaFonteDePotassio=22.0;
                   break;
               case 4:
                   teorDaFonteDePotassio=44.0;
                   break;
               default:
                   teorDaFonteDePotassio=0.0;
                   break;
           } 
        QTDKgHectareDeFonteDePotassio = necessidadeDePotassioAdicionar*39.1*10*2*1.2*100/eficienciaDoPotassio*100/teorDaFonteDePotassio;
            
        return QTDKgHectareDeFonteDePotassio;   
        
        }else{
            return 0.0;
        }  
    }
    
    double calculaCustoPorHectareDeFonteDePotassio(
            int texturaSolo,
            int fontedePotassioUsar,
            double valorDaFontePorTonelada,
            double QTDKgHectareDeFonteDePotassio){
        double custoPorHectareDeFonteDePotassio = 0.0;
        switch(fontedePotassioUsar){
            case 1:
                custoPorHectareDeFonteDePotassio = valorDaFontePorTonelada*QTDKgHectareDeFonteDePotassio/1000;
                break;
            case 2:
                custoPorHectareDeFonteDePotassio = valorDaFontePorTonelada*QTDKgHectareDeFonteDePotassio/1000;
                break;
            case 3:
                custoPorHectareDeFonteDePotassio = valorDaFontePorTonelada*QTDKgHectareDeFonteDePotassio/1000;
                break;
            case 4:
                switch(texturaSolo){
                    case 1:
                        custoPorHectareDeFonteDePotassio = 0.7*QTDKgHectareDeFonteDePotassio/1000;
                        break;
                    case 2:
                        custoPorHectareDeFonteDePotassio = 0.5*QTDKgHectareDeFonteDePotassio/1000;
                        break;    
                }
                break;
            default:
                custoPorHectareDeFonteDePotassio = 0.0;
                break;
        }
    return custoPorHectareDeFonteDePotassio;
    }

    String descricaoTipoDeCorrecaoDePotassio(int tipoDefonteDePotassio) {
        String descricaoTipoDeCorrecaoDePotassio="";
        switch(tipoDefonteDePotassio){
            case 1:
                descricaoTipoDeCorrecaoDePotassio="";
                break;
            case 2:
                descricaoTipoDeCorrecaoDePotassio="Essa correção de Potássio fornecerá também:";
                break;
            case 3:
                descricaoTipoDeCorrecaoDePotassio="Essa correção de Potássio fornecerá também:";
                break;    
        }
        return descricaoTipoDeCorrecaoDePotassio;
    }
    
    double calculoFornecimentoDoPrimeiroNutrienteParaCorrecaoDePotassio(
            int tipoDefonteDePotassio,//D37
            double QTDKgHectareDeFonteDePotassio
            ){
        double calculoFornecimentoDoPrimeiroNutrienteParaCorrecaoDePotassio=0.0;
        switch(tipoDefonteDePotassio){
            case 1:
                calculoFornecimentoDoPrimeiroNutrienteParaCorrecaoDePotassio=0.0;
                break;
            case 2:
                calculoFornecimentoDoPrimeiroNutrienteParaCorrecaoDePotassio = QTDKgHectareDeFonteDePotassio*0.17;
                break;
            case 3:
                calculoFornecimentoDoPrimeiroNutrienteParaCorrecaoDePotassio = QTDKgHectareDeFonteDePotassio*0.22;
                break;    
        }
    return calculoFornecimentoDoPrimeiroNutrienteParaCorrecaoDePotassio;    
    }
    
    double calculoFornecimentoDoSegundoNutrienteParaCorrecaoDePotassio(
            int tipoDefonteDePotassio,//D37
            double QTDKgHectareDeFonteDePotassio
            ){
        double calculoFornecimentoDoSegundoNutrienteParaCorrecaoDePotassio=0.0;
        switch(tipoDefonteDePotassio){
            case 1:
                calculoFornecimentoDoSegundoNutrienteParaCorrecaoDePotassio=0.0;
                break;
            case 2:
                calculoFornecimentoDoSegundoNutrienteParaCorrecaoDePotassio=0.0;
                break;
            case 3:
                calculoFornecimentoDoSegundoNutrienteParaCorrecaoDePotassio = QTDKgHectareDeFonteDePotassio*0.18;
                break;    
        }
    return calculoFornecimentoDoSegundoNutrienteParaCorrecaoDePotassio;    
    }
    
}
