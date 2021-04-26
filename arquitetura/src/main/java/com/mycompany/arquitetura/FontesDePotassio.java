package com.mycompany.arquitetura;

public enum FontesDePotassio implements RegraPotassio{
    CLORETODEPOTASSIO{
        @Override
        public double teorDaFonteDePotassio() {
            return 58.0; 
        }

        @Override
        public String descricaoTipoDeCorrecaoDePotassio() {
            return "";
        }

        @Override
        public double quantidadeDoPrimeiroNutrienteParaCorrecaoDePotassio() {
            return 0.0;
        }

        @Override
        public double quantidadeDoSegundoNutrienteParaCorrecaoDePotassio() {
            return 0.0;
        }
    },//1
    SULFATODEPOTASSIO {
        @Override
        public double teorDaFonteDePotassio() {
            return 52.0;
        }

        @Override
        public String descricaoTipoDeCorrecaoDePotassio() {
            return "Essa correção de Potássio fornecerá também:";
        }

        @Override
        public double quantidadeDoPrimeiroNutrienteParaCorrecaoDePotassio() {
            return 0.17;
        }

        @Override
        public double quantidadeDoSegundoNutrienteParaCorrecaoDePotassio() {
            return 0.0;
        }
    },//2
    SULTAFATODEPOTASSIOEMAGNESIO {
        @Override
        public double teorDaFonteDePotassio() {
            return 22.0;
        }

        @Override
        public String descricaoTipoDeCorrecaoDePotassio() {
            return "Essa correção de Potássio fornecerá também:";
        }

        @Override
        public double quantidadeDoPrimeiroNutrienteParaCorrecaoDePotassio() {
            return 0.22;
        }

        @Override
        public double quantidadeDoSegundoNutrienteParaCorrecaoDePotassio() {
            return 0.18;
        }
    },//3
    NITRATODEPOTASSIO {
        @Override
        public double teorDaFonteDePotassio() {
            return 44.0;
        }

        @Override
        public String descricaoTipoDeCorrecaoDePotassio() {
            return "";
        }

        @Override
        public double quantidadeDoPrimeiroNutrienteParaCorrecaoDePotassio() {
            return 0.0;
        }

        @Override
        public double quantidadeDoSegundoNutrienteParaCorrecaoDePotassio() {
            return 0.0;
        }
    };//4

   
}
