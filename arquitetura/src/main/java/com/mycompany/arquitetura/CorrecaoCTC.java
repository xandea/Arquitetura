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
            FontesDeFosforo fonteDeFostoroUtilizar){ //D23
        return fonteDeFostoroUtilizar.quantidadeDoPrimeiroNutrienteParaCorrecaoDeFosforo()*calculaQTDKgHectareDaFonte;
    }
    
    double calculoFornecimentoDoSegundoNutrienteParaCorrecaoDeFosforo(
            double calculaQTDKgHectareDaFonteDeFosforo,//B24
            FontesDeFosforo fonteDeFostoroUtilizar//D23
            ){
        return fonteDeFostoroUtilizar.quantidadeDoSegundoNutrienteParaCorrecaoDeFosforo()*calculaQTDKgHectareDaFonteDeFosforo;
    }
    
    String nomeDoPrimeiroNutrienteParaCorrecaoDeFosforo(FontesDeFosforo fonteDeFostoroUtilizar){
        return fonteDeFostoroUtilizar.nomeDoPrimeiroNutrienteParaCorrecaoDeFosforo();
    } 

    String nomeDoSegundoNutrienteParaCorrecaoDeFosforo(FontesDeFosforo fonteDeFostoroUtilizar) {
        return fonteDeFostoroUtilizar.nomeDoSegundoNutrienteParaCorrecaoDeFosforo();
    }
    
    double custoCorrecaoPporHa(double calculaQTDKgHectareDaFonteDeFosforo,FontesDeFosforo fonteDeFostoroUtilizar, double precoDaFonte){
        if(fonteDeFostoroUtilizar==null) return 0.0;
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
            FontesDePotassio fontedePotassioUsar //D37
            ){
        if(necessidadeDePotassioAdicionar<0.01 || fontedePotassioUsar==null) return 0.0;
        double teorDaFonteDePotassio = fontedePotassioUsar.teorDaFonteDePotassio();
        return necessidadeDePotassioAdicionar*39.1*10*2*1.2*100/eficienciaDoPotassio*100/teorDaFonteDePotassio; 
    }
    
    double calculaCustoPorHectareDeFonteDePotassio(
            int texturaSolo,
            FontesDePotassio fontedePotassioUsar,
            double valorDaFontePorTonelada,
            double QTDKgHectareDeFonteDePotassio){
        switch(fontedePotassioUsar){
            case CLORETODEPOTASSIO,SULFATODEPOTASSIO,SULTAFATODEPOTASSIOEMAGNESIO -> {return valorDaFontePorTonelada*QTDKgHectareDeFonteDePotassio/1000;}
            case NITRATODEPOTASSIO -> {
                switch(texturaSolo){
                    case 1 -> {return 0.7*QTDKgHectareDeFonteDePotassio/1000;}
                    case 2 -> {return 0.5*QTDKgHectareDeFonteDePotassio/1000;}
                }
            }
        }
        return 0.0;
    }

    String descricaoTipoDeCorrecaoDePotassio(FontesDePotassio tipoDefonteDePotassio) {
        return tipoDefonteDePotassio.descricaoTipoDeCorrecaoDePotassio();
        
    }
    
    double calculoFornecimentoDoPrimeiroNutrienteParaCorrecaoDePotassio(
            FontesDePotassio tipoDefonteDePotassio,//D37
            double QTDKgHectareDeFonteDePotassio
            ){
        return QTDKgHectareDeFonteDePotassio*tipoDefonteDePotassio.quantidadeDoPrimeiroNutrienteParaCorrecaoDePotassio();
    }
    
    double calculoFornecimentoDoSegundoNutrienteParaCorrecaoDePotassio(
            FontesDePotassio tipoDefonteDePotassio,//D37
            double QTDKgHectareDeFonteDePotassio
            ){
        return QTDKgHectareDeFonteDePotassio*tipoDefonteDePotassio.quantidadeDoSegundoNutrienteParaCorrecaoDePotassio();
    }
    
}
