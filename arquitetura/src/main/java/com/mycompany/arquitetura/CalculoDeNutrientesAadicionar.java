package com.mycompany.arquitetura;

public class CalculoDeNutrientesAadicionar {
       
    double calculaQTDKgHectareDaFonteDeFosforo(//B22 da memoria de calculo
            double teorFosforoAtingir,//D22
            double fosforo,//B11
            int fonteDeFostoroUtilizar,//D23
            double eficienciaDoFosforo){//D25
        double teordeP2O5 = switch(fonteDeFostoroUtilizar){
            case 1-> 18.0;
            case 2-> 41.0;
            case 3-> 48.0;
            case 4-> 45.0;
            case 5-> 18.0;
            case 6-> 33.0;
            case 7-> 29.0;
            case 8-> 32.0;
            case 9-> 24.0;
            case 10-> 18.5;
            case 11-> 52.0;
            case 12-> 18.0;
            default-> 0.0;
        };
        return 100/teordeP2O5*((teorFosforoAtingir-fosforo)*4.58/eficienciaDoFosforo);
    }
    
    double calculaKgAlqueiroDaFonteDeFosforo(//B24
            double teorFosforoAtingir,//D22
            double fosforo,//B11
            int fonteDeFostoroUtilizar,//D23
            double eficienciaDoFosforo){
        return calculaQTDKgHectareDaFonteDeFosforo(
            teorFosforoAtingir,//D22
            fosforo,//B11
            fonteDeFostoroUtilizar,//D23
            eficienciaDoFosforo)*2.42;
    }
    
    double necessidadeDePotassioAdicionar(//F51
            double participacaoPotassioNaCTCDesejada,//F35 o valor em % está certo, não precisa converter
            double participacaoAtualdoPotassionaCTC,//F34
            double potassio//D11
            ){
        return ((potassio*participacaoPotassioNaCTCDesejada/participacaoAtualdoPotassionaCTC)-potassio);
    }  
     
}
