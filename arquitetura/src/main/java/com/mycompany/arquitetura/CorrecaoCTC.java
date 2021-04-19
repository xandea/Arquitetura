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
            double calculaQTDKgHectareDaFonteDeFosforo,//B24
            int fonteDeFostoroUtilizar//D23
            ){
        double quantidadeDeNutriente = switch (fonteDeFostoroUtilizar) {
            case 1,5,9 -> 0.28;
            case 2 -> 0.2;
            case 3 -> 0.09;
            case 4 -> 0.16;
            case 6,7 -> 0.52;
            case 8 -> 0.45;
            case 10 -> 0.44;
            case 12 -> 0.18;
            default -> 0.0;
        };
        return quantidadeDeNutriente*calculaQTDKgHectareDaFonteDeFosforo;
    }
    
    String nomeDoPrimeiroNutrienteParaCorrecaoDePotassio(int fonteDeFostoroUtilizar){
        return switch (fonteDeFostoroUtilizar) {
            case 1, 12 -> "Enxofre";
            case 2 -> "Magnésio";
            default -> "";
        };
    } 

    String nomeDoSegundoNutrienteParaCorrecaoDePotassio(int fonteDeFostoroUtilizar) {
        return switch(fonteDeFostoroUtilizar){
            case 1,2,5,6,7,8,9,10,12 -> "Cálcio";
            case 3,4 -> "Nitrogênio";
            default -> "";
        };
    }
    
    double custoCorrecaoPporHa(double calculaQTDKgHectareDaFonteDeFosforo,int fonteDeFostoroUtilizar, double precoDaFonte){
        if(fonteDeFostoroUtilizar<=0 || fonteDeFostoroUtilizar>=13) return 0.0;
            return calculaQTDKgHectareDaFonteDeFosforo/1000*precoDaFonte;
    }
    
    double participacaoAtualdoPnaCTC(double calculaCTCMOL,double potassio){
        return potassio/calculaCTCMOL*100;
    }
    
    double participacaoDoPnaCTCposCorrecao(double participacaoPnaCTCDesejada){
        if(participacaoPnaCTCDesejada<0.001) return 0.0;
        return participacaoPnaCTCDesejada;
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
        if(necessidadeDePotassioAdicionar<0.01 || fontedePotassioUsar==0) return 0.0;
        double teorDaFonteDePotassio = switch (fontedePotassioUsar) {//em %
            case 1 -> 58.0;
            case 2 -> 52.0;
            case 3 -> 22.0;
            case 4 -> 44.0;
            default -> 0.0;
            }; 
        return necessidadeDePotassioAdicionar*39.1*10*2*1.2*100/eficienciaDoPotassio*100/teorDaFonteDePotassio; 
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
