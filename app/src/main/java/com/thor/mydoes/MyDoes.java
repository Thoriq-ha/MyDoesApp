package com.thor.mydoes;

public class MyDoes {
    String titledoes, datadoes, descdoes;

    public MyDoes() {
    }

    public MyDoes(String titledoes, String datadoes, String descdoes) {
        this.titledoes = titledoes;
        this.datadoes = datadoes;
        this.descdoes = descdoes;
    }

    public void setTitledoes(String titledoes) {
        this.titledoes = titledoes;
    }

    public void setDatadoes(String datadoes) {
        this.datadoes = datadoes;
    }

    public void setDescdoes(String descdoes) {
        this.descdoes = descdoes;
    }

    public String getTitledoes() {
        return titledoes;
    }

    public String getDatadoes() {
        return datadoes;
    }

    public String getDescdoes() {
        return descdoes;
    }
}
