package com.mycompany.arquitetura;

public class CalculoDeNutrientesAadicionar {
       
    double calculaQTDKgHectareDaFonteDeFosforo(//B22 da memoria de calculo
            double teorFosforoAtingir,//D22
            double fosforo,//B11
            FontesDeFosforo fonteDeFostoroUtilizar,//D23
            double eficienciaDoFosforo){//D25
        double teordeP2O5 = fonteDeFostoroUtilizar.calculaTeordeP2O5();
        if(teordeP2O5==0.0) return 0.0;
        return 100/teordeP2O5*((teorFosforoAtingir-fosforo)*4.58/eficienciaDoFosforo);
    }
    
    double calculaKgAlqueiroDaFonteDeFosforo(//B24
            double teorFosforoAtingir,//D22
            double fosforo,//B11
            FontesDeFosforo fonteDeFostoroUtilizar,//D23
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
