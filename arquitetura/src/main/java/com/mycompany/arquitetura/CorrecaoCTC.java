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
        return switch (fonteDeFostoroUtilizar) {
            case SUPERFOSFATOSIMPLES -> calculaQTDKgHectareDaFonte*0.1;
            case TERMOFOSFATOYOORIN -> calculaQTDKgHectareDaFonte*0.15;
            case MULTIFOSFATOMAGNESIANO -> calculaQTDKgHectareDaFonte*0.11;
            default -> 0.0;
        };
    }
    
    double calculoFornecimentoDoSegundoNutrienteParaCorrecaoDeFosforo(
            double calculaQTDKgHectareDaFonteDeFosforo,//B24
            FontesDeFosforo fonteDeFostoroUtilizar//D23
            ){
        double quantidadeDeNutriente = switch (fonteDeFostoroUtilizar) {
            case SUPERFOSFATOSIMPLES,TERMOFOSFATOYOORIN,FOSFATONATPATOSDEMINAS -> 0.28;
            case SUPERFOSFATOTRIPLO -> 0.2;
            case MAP -> 0.09;
            case DAP -> 0.16;
            case FOSFATOREATARAD,FOSFATOREATIVODEGAFSA -> 0.52;
            case FOSFATOREATIVODAOUI -> 0.45;
            case ESCORIADETHOMAS -> 0.44;
            case MULTIFOSFATOMAGNESIANO -> 0.18;
            default -> 0.0;
        };
        return quantidadeDeNutriente*calculaQTDKgHectareDaFonteDeFosforo;
    }
    
    String nomeDoPrimeiroNutrienteParaCorrecaoDeFosforo(FontesDeFosforo fonteDeFostoroUtilizar){
        return switch (fonteDeFostoroUtilizar) {
            case SUPERFOSFATOSIMPLES, MULTIFOSFATOMAGNESIANO -> "Enxofre";
            case SUPERFOSFATOTRIPLO -> "Magnésio";
            default -> "";
        };
    } 

    String nomeDoSegundoNutrienteParaCorrecaoDeFosforo(FontesDeFosforo fonteDeFostoroUtilizar) {
        return switch(fonteDeFostoroUtilizar){
            case SUPERFOSFATOSIMPLES,
                SUPERFOSFATOTRIPLO,
                TERMOFOSFATOYOORIN,
                FOSFATOREATARAD,
                FOSFATOREATIVODEGAFSA,
                FOSFATOREATIVODAOUI,
                FOSFATONATPATOSDEMINAS,
                ESCORIADETHOMAS,
                MULTIFOSFATOMAGNESIANO -> "Cálcio";
            case MAP,DAP -> "Nitrogênio";
            default -> "";
        };
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
        double teorDaFonteDePotassio = switch (fontedePotassioUsar) {//em %
            case CLORETODEPOTASSIO -> 58.0;
            case SULFATODEPOTASSIO -> 52.0;
            case SULTAFATODEPOTASSIOEMAGNESIO -> 22.0;
            case NITRATODEPOTASSIO -> 44.0;
            default -> 0.0;
            }; 
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
        return switch(tipoDefonteDePotassio){
            case SULFATODEPOTASSIO -> "Essa correção de Potássio fornecerá também:";
            case SULTAFATODEPOTASSIOEMAGNESIO -> "Essa correção de Potássio fornecerá também:";
            default -> "";   
        };
    }
    
    double calculoFornecimentoDoPrimeiroNutrienteParaCorrecaoDePotassio(
            FontesDePotassio tipoDefonteDePotassio,//D37
            double QTDKgHectareDeFonteDePotassio
            ){
        return switch(tipoDefonteDePotassio){
            case SULFATODEPOTASSIO -> QTDKgHectareDeFonteDePotassio*0.17;
            case SULTAFATODEPOTASSIOEMAGNESIO -> QTDKgHectareDeFonteDePotassio*0.22;
            default -> 0.0;
        };   
    }
    
    double calculoFornecimentoDoSegundoNutrienteParaCorrecaoDePotassio(
            FontesDePotassio tipoDefonteDePotassio,//D37
            double QTDKgHectareDeFonteDePotassio
            ){
        return switch(tipoDefonteDePotassio){
            case SULTAFATODEPOTASSIOEMAGNESIO -> QTDKgHectareDeFonteDePotassio*0.18;
            default -> 0.0;
        };
    }
    
}
