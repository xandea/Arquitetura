package com.mycompany.arquitetura;

/**
 *
 * @author xande
 */
public class MemoriadeCalculo {
    
    double calculaQTDKgHectareDaFonte(//B22 da memoria de calculo
            double teorFosforoAtingir,//D22
            double fosforo,//B11
            int fonteDeFostoroUtilizar,//D23
            double eficienciaDoFosforo){//D25
        double teordeP2O5 = 0;
        switch(fonteDeFostoroUtilizar){
            case 1:
                teordeP2O5=18.0;
                break;
            case 2:
                teordeP2O5=41.0;
                break;
            case 3:
                teordeP2O5=48.0;
                break;
            case 4:
                teordeP2O5=45.0;
                break;
            case 5:
                teordeP2O5=18.0;
                break;
            case 6:
                teordeP2O5=33.0;
                break;
            case 7:
                teordeP2O5=29.0;
                break;
            case 8:
                teordeP2O5=32.0;
                break;
            case 9:
                teordeP2O5=24.0;
                break;
            case 10:
                teordeP2O5=18.5;
                break;
            case 11:
                teordeP2O5=52.0;
                break;
            case 12:
                teordeP2O5=18.0;
                break;
            default:   
                System.out.println("ERRO: na inserção da Fonte de Fosforo a utilizar");
                break;
        }
        double calculaQTDKgHectareDaFonte = 100/teordeP2O5*((teorFosforoAtingir-fosforo)*2*2.29*100/eficienciaDoFosforo/100); 
        return calculaQTDKgHectareDaFonte;
    }
    
    double calculaKgAlqueiroDaFonte(//B24
            double teorFosforoAtingir,//D22
            double fosforo,//B11
            int fonteDeFostoroUtilizar,//D23
            double eficienciaDoFosforo){
        double calculaKgAlqueiroDaFonte=0.0;
        
        calculaKgAlqueiroDaFonte = calculaQTDKgHectareDaFonte(
            teorFosforoAtingir,//D22
            fosforo,//B11
            fonteDeFostoroUtilizar,//D23
            eficienciaDoFosforo)*2.42;
        
        return calculaKgAlqueiroDaFonte;
    }
    
    double necessidadeDePotassioAdicionar(//F51
            double participacaoPotassioNaCTCDesejada,//F35 o valor em % está certo, não precisa converter
            double participacaoAtualdoPotassionaCTC,//F34
            double potassio//D11
            ){
        return ((potassio*participacaoPotassioNaCTCDesejada/participacaoAtualdoPotassionaCTC)-potassio);
    }  
     
}
