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
            int fonteDeFostoroUtilizar){ //D23
        double calculoFornecimentoDoPrimeiroNutrienteParaCorrecaoDeFosforo;
        calculoFornecimentoDoPrimeiroNutrienteParaCorrecaoDeFosforo = switch (fonteDeFostoroUtilizar) {
            case 1 -> calculaQTDKgHectareDaFonte*0.1;
            case 5 -> calculaQTDKgHectareDaFonte*0.15;
            case 12 -> calculaQTDKgHectareDaFonte*0.11;
            default -> 0.0;
        };
        return calculoFornecimentoDoPrimeiroNutrienteParaCorrecaoDeFosforo;
    }
    
    double calculoFornecimentoDoSegundoNutrienteParaCorrecaoDeFosforo(
            double calculaKgAlqueiroDaFonteDeFosforo,//B24
            int fonteDeFostoroUtilizar//D23
            ){
        double calculoFornecimentoDoSegundoNutrienteParaCorrecaoDeFosforo;
        calculoFornecimentoDoSegundoNutrienteParaCorrecaoDeFosforo = switch (fonteDeFostoroUtilizar) {
            case 1 -> calculaKgAlqueiroDaFonteDeFosforo*0.28;
            case 2 -> calculaKgAlqueiroDaFonteDeFosforo*0.2;
            case 3 -> calculaKgAlqueiroDaFonteDeFosforo*0.09;
            case 4 -> calculaKgAlqueiroDaFonteDeFosforo*0.16;
            case 5 -> calculaKgAlqueiroDaFonteDeFosforo*0.28;
            case 6 -> calculaKgAlqueiroDaFonteDeFosforo*0.52;
            case 7 -> calculaKgAlqueiroDaFonteDeFosforo*0.52;
            case 8 -> calculaKgAlqueiroDaFonteDeFosforo*0.45;
            case 9 -> calculaKgAlqueiroDaFonteDeFosforo*0.28;
            case 10 -> calculaKgAlqueiroDaFonteDeFosforo*0.44;
            case 11 -> calculaKgAlqueiroDaFonteDeFosforo*0.0;
            case 12 -> calculaKgAlqueiroDaFonteDeFosforo*0.18;
            default -> 0.0;
        };
        return calculoFornecimentoDoSegundoNutrienteParaCorrecaoDeFosforo/2.42;
    }
    
    String nomeDoPrimeiroNutrienteParaCorrecaoDePotassio(int fonteDeFostoroUtilizar){
        return switch (fonteDeFostoroUtilizar) {
            case 1, 12 -> "Enxofre";
            case 2 -> "Magnésio";
            default -> "";
        };
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
        return potassio/calculaCTCMOL*100;
    }
    
    double participacaoDoPnaCTCposCorrecao(double participacaoPnaCTCDesejada){
        if(participacaoPnaCTCDesejada>0.001){
            return participacaoPnaCTCDesejada;
        }else{
            return 0.0;
        }
    }
    
    double participacaoIdealdoPnaCTC(int valorTextura){
        return switch(valorTextura){
            case 1,2 -> 3.0;
            default -> 0.0;
        };
    }
    
    double calculaQTDKgHectareDeFonteDePotassio(
            double eficienciaDoPotassio,//F59
            double necessidadeDePotassioAdicionar,//F51
            int fontedePotassioUsar //D37
            ){
        double QTDKgHectareDeFonteDePotassio = 0.0;
        double teorDaFonteDePotassio=0.0;//em %
        
        if(necessidadeDePotassioAdicionar>0.01){
            teorDaFonteDePotassio = switch (fontedePotassioUsar) {
                case 1 -> 58.0;
                case 2 -> 52.0;
                case 3 -> 22.0;
                case 4 -> 44.0;
                default -> 0.0;
            }; 
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
            case 1 -> custoPorHectareDeFonteDePotassio = valorDaFontePorTonelada*QTDKgHectareDeFonteDePotassio/1000;
            case 2 -> custoPorHectareDeFonteDePotassio = valorDaFontePorTonelada*QTDKgHectareDeFonteDePotassio/1000;
            case 3 -> custoPorHectareDeFonteDePotassio = valorDaFontePorTonelada*QTDKgHectareDeFonteDePotassio/1000;
            case 4 -> {
                switch(texturaSolo){
                    case 1 -> custoPorHectareDeFonteDePotassio = 0.7*QTDKgHectareDeFonteDePotassio/1000;
                    case 2 -> custoPorHectareDeFonteDePotassio = 0.5*QTDKgHectareDeFonteDePotassio/1000;    
                }
            }
            default -> custoPorHectareDeFonteDePotassio = 0.0;
        }
    return custoPorHectareDeFonteDePotassio;
    }

    String descricaoTipoDeCorrecaoDePotassio(int tipoDefonteDePotassio) {
        return switch(tipoDefonteDePotassio){
            case 1 -> "";
            case 2 -> "Essa correção de Potássio fornecerá também:";
            case 3 -> "Essa correção de Potássio fornecerá também:";
            default -> "";   
        };
    }
    
    double calculoFornecimentoDoPrimeiroNutrienteParaCorrecaoDePotassio(
            int tipoDefonteDePotassio,//D37
            double QTDKgHectareDeFonteDePotassio
            ){
        return switch(tipoDefonteDePotassio){
            case 1 -> 0.0;
            case 2 -> QTDKgHectareDeFonteDePotassio*0.17;
            case 3 -> QTDKgHectareDeFonteDePotassio*0.22;
            default -> 0.0;
        };   
    }
    
    double calculoFornecimentoDoSegundoNutrienteParaCorrecaoDePotassio(
            int tipoDefonteDePotassio,//D37
            double QTDKgHectareDeFonteDePotassio
            ){
        return switch(tipoDefonteDePotassio){
            case 1,2 -> 0.0;
            case 3 -> QTDKgHectareDeFonteDePotassio*0.18;
            default -> 0.0;
        };
    }
    
}
