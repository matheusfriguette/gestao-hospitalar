package app.models;

import java.util.ArrayList;

/*
 * Diagnostico
 */
public class Diagnostico {
    private String sintomas;
    private ArrayList<Exame> exames;
    private ArrayList<Remedio> remedios;

    /*
     * Construtores
     */
    public Diagnostico() {
        setSintomas(null);
        setExames(null);
        setRemedios(null);
    }

    public Diagnostico(String sintomas, ArrayList<Exame> exames, ArrayList<Remedio> remedios) {
        setSintomas(sintomas);
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