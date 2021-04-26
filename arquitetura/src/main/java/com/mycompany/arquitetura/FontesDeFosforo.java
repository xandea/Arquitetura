package com.mycompany.arquitetura;

public enum FontesDeFosforo implements RegrasFosforo{
    SUPERFOSFATOSIMPLES{
        @Override
        public double calculaTeordeP2O5() {
            return 18.0;
        }

        @Override
        public double quantidadeDoPrimeiroNutrienteParaCorrecaoDeFosforo() {
            return 0.1;
        }

        @Override
        public double quantidadeDoSegundoNutrienteParaCorrecaoDeFosforo() {
            return 0.28;
        }

        @Override
        public String nomeDoPrimeiroNutrienteParaCorrecaoDeFosforo() {
            return "Enxofre";
        }

        @Override
        public String nomeDoSegundoNutrienteParaCorrecaoDeFosforo() {
            return "Cálcio";
        }
    },//1
    SUPERFOSFATOTRIPLO {
        @Override
        public double calculaTeordeP2O5() {
            return 41.0;
        }

        @Override
        public double quantidadeDoPrimeiroNutrienteParaCorrecaoDeFosforo() {
            return 0.0;
        }

        @Override
        public double quantidadeDoSegundoNutrienteParaCorrecaoDeFosforo() {
            return 0.2;
        }

        @Override
        public String nomeDoPrimeiroNutrienteParaCorrecaoDeFosforo() {
            return "Magnésio";
        }

        @Override
        public String nomeDoSegundoNutrienteParaCorrecaoDeFosforo() {
            return "Cálcio";
        }
    }, //2
    MAP {
        @Override
        public double calculaTeordeP2O5() {
            return 48.0;
        }

        @Override
        public double quantidadeDoPrimeiroNutrienteParaCorrecaoDeFosforo() {
            return 0.0;
        }

        @Override
        public double quantidadeDoSegundoNutrienteParaCorrecaoDeFosforo() {
            return 0.09;
        }

        @Override
        public String nomeDoPrimeiroNutrienteParaCorrecaoDeFosforo() {
            return "";
        }

        @Override
        public String nomeDoSegundoNutrienteParaCorrecaoDeFosforo() {
            return "Nitrogênio";
        }
    }, //3
    DAP {
        @Override
        public double calculaTeordeP2O5() {
            return 45.0;
        }

        @Override
        public double quantidadeDoPrimeiroNutrienteParaCorrecaoDeFosforo() {
            return 0.0;
        }

        @Override
        public double quantidadeDoSegundoNutrienteParaCorrecaoDeFosforo() {
            return 0.16;
        }

        @Override
        public String nomeDoPrimeiroNutrienteParaCorrecaoDeFosforo() {
            return "";
        }

        @Override
        public String nomeDoSegundoNutrienteParaCorrecaoDeFosforo() {
            return "Nitrogênio";
        }
    }, //4
    TERMOFOSFATOYOORIN {
        @Override
        public double calculaTeordeP2O5() {
            return 18.0;
        }
        
        public double calculaNutrienteParaCorrecaoDeFosforo(double calculaQTDKgHectareDaFonte){
            return calculaQTDKgHectareDaFonte*0.15;
        }

        @Override
        public double quantidadeDoPrimeiroNutrienteParaCorrecaoDeFosforo() {
            return 0.0;
        }

        @Override
        public double quantidadeDoSegundoNutrienteParaCorrecaoDeFosforo() {
            return 0.28;
        }

        @Override
        public String nomeDoPrimeiroNutrienteParaCorrecaoDeFosforo() {
            return "";
        }

        @Override
        public String nomeDoSegundoNutrienteParaCorrecaoDeFosforo() {
            return "Cálcio";
        }
        
    }, //5
    FOSFATOREATARAD {
        @Override
        public double calculaTeordeP2O5() {
            return 33.0;
        }

        @Override
        public double quantidadeDoPrimeiroNutrienteParaCorrecaoDeFosforo() {
            return 0.0;
        }

        @Override
        public double quantidadeDoSegundoNutrienteParaCorrecaoDeFosforo() {
            return 0.52;
        }

        @Override
        public String nomeDoPrimeiroNutrienteParaCorrecaoDeFosforo() {
            return "";
        }

        @Override
        public String nomeDoSegundoNutrienteParaCorrecaoDeFosforo() {
            return "Cálcio";
        }
    }, //6
    FOSFATOREATIVODEGAFSA {
        @Override
        public double calculaTeordeP2O5() {
            return 29.0;
        }

        @Override
        public double quantidadeDoPrimeiroNutrienteParaCorrecaoDeFosforo() {
            return 0.0;
        }

        @Override
        public double quantidadeDoSegundoNutrienteParaCorrecaoDeFosforo() {
            return 0.52;
        }

        @Override
        public String nomeDoPrimeiroNutrienteParaCorrecaoDeFosforo() {
            return "";
        }

        @Override
        public String nomeDoSegundoNutrienteParaCorrecaoDeFosforo() {
            return "Cálcio";
        }
    },//7
    FOSFATOREATIVODAOUI {
        @Override
        public double calculaTeordeP2O5() {
            return 32.0;
        }

        @Override
        public double quantidadeDoPrimeiroNutrienteParaCorrecaoDeFosforo() {
            return 0.0;
        }

        @Override
        public double quantidadeDoSegundoNutrienteParaCorrecaoDeFosforo() {
            return 0.45;
        }

        @Override
        public String nomeDoPrimeiroNutrienteParaCorrecaoDeFosforo() {
            return "";
        }

        @Override
        public String nomeDoSegundoNutrienteParaCorrecaoDeFosforo() {
            return "Cálcio";
        }
    },//8
    FOSFATONATPATOSDEMINAS {
        @Override
        public double calculaTeordeP2O5() {
            return 24.0;
        }

        @Override
        public double quantidadeDoPrimeiroNutrienteParaCorrecaoDeFosforo() {
            return 0.0;
        }

        @Override
        public double quantidadeDoSegundoNutrienteParaCorrecaoDeFosforo() {
            return 0.28;
        }

        @Override
        public String nomeDoPrimeiroNutrienteParaCorrecaoDeFosforo() {
            return "";
        }

        @Override
        public String nomeDoSegundoNutrienteParaCorrecaoDeFosforo() {
            return "Cálcio";
        }
    },//9
    ESCORIADETHOMAS {
        @Override
        public double calculaTeordeP2O5() {
            return 18.5;
        }

        @Override
        public double quantidadeDoPrimeiroNutrienteParaCorrecaoDeFosforo() {
            return 0.0;
        }

        @Override
        public double quantidadeDoSegundoNutrienteParaCorrecaoDeFosforo() {
            return 0.44;
        }

        @Override
        public String nomeDoPrimeiroNutrienteParaCorrecaoDeFosforo() {
            return "";
        }

        @Override
        public String nomeDoSegundoNutrienteParaCorrecaoDeFosforo() {
            return "Cálcio";
        }
    },//10
    ACIDOFOSFORICO {
        @Override
        public double calculaTeordeP2O5() {
            return 52.0;
        }

        @Override
        public double quantidadeDoPrimeiroNutrienteParaCorrecaoDeFosforo() {
            return 0.0;
        }

        @Override
        public double quantidadeDoSegundoNutrienteParaCorrecaoDeFosforo() {
            return 0.0;
        }

        @Override
        public String nomeDoPrimeiroNutrienteParaCorrecaoDeFosforo() {
            return "";
        }

        @Override
        public String nomeDoSegundoNutrienteParaCorrecaoDeFosforo() {
            return "";
        }
    },//11
    MULTIFOSFATOMAGNESIANO {
        @Override
        public double calculaTeordeP2O5() {
            return 18.0;
        }
        @Override
        public double quantidadeDoPrimeiroNutrienteParaCorrecaoDeFosforo(){
            return 0.11;
        }

        @Override
        public double quantidadeDoSegundoNutrienteParaCorrecaoDeFosforo() {
            return 0.18;
        }

        @Override
        public String nomeDoPrimeiroNutrienteParaCorrecaoDeFosforo() {
            return "Enxofre";
        }

        @Override
        public String nomeDoSegundoNutrienteParaCorrecaoDeFosforo() {
            return "Cálcio";
        }
        
    };//12
    }