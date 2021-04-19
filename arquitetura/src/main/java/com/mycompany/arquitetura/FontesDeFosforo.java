package com.mycompany.arquitetura;

public enum FontesDeFosforo {
    SUPERFOSFATOSIMPLES(1),
    SUPERFOSFATOTRIPLO(2), 
    MAP(3), 
    DAP(4), 
    TERMOFOSFATOYOORIN(5), 
    FOSFATOREATARAD(6), 
    FOSFATOREATIVODEGAFSA(7),
    FOSFATOREATIVODAOUI(8),
    FOSFATONATPATOSDEMINAS(9),
    ESCORIADETHOMAS(10),
    ACIDOFOSFORICO(11),
    MULTIFOSFATOMAGNESIANO(12);
    
        private final int valor;
  
        FontesDeFosforo(int valor){
        this.valor = valor;
        }

        public int getValor(){
        return this.valor;
        }
    }
