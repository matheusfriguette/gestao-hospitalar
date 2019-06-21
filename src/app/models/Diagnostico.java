package app.models;

import java.util.ArrayList;

/*
 * Diagnostico
 */
public class Diagnostico {
    private String sintomas;
    private String observacoes;
    private ArrayList<Exame> exames;
    private ArrayList<Remedio> remedios;

    /*
     * Construtores
     */
    public Diagnostico() {
        setSintomas(null);
        setObservacoes(null);
        setExames(null);
        setRemedios(null);
    }

    public Diagnostico(String sintomas, String observacoes, ArrayList<Exame> exames, ArrayList<Remedio> remedios) {
        setSintomas(sintomas);
        setObservacoes(observacoes);
        setExames(exames);
        setRemedios(remedios);
    }

    /*
     * Gets e sets
     */
    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public ArrayList<Exame> getExames() {
        return exames;
    }

    public void setExames(ArrayList<Exame> exames) {
        this.exames = exames;
    }

    public ArrayList<Remedio> getRemedios() {
        return remedios;
    }

    public void setRemedios(ArrayList<Remedio> remedios) {
        this.remedios = remedios;
    }
}