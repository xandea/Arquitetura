package com.mycompany.arquitetura;

public enum FontesDeFosforo implements Regras{
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
        
    };//12
    }