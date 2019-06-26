package app.models;

import java.io.Serializable;

/*
 * PlanoPaciente
 */
public class PlanoPaciente implements Serializable {
    private static final long serialVersionUID = 1L;
    private Plano plano;
    private int consultasRestantes;

    /*
     * Construtores
     */
    public PlanoPaciente() {
        setPlano(null);
        setConsultasRestantes(0);
    }

    public PlanoPaciente(Plano plano) {
        setPlano(plano);
        setConsultasRestantes(plano.getConsultasDisponiveis());
    }

    /*
     * Gets e sets
     */
    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public int getConsultasRestantes() {
        return consultasRestantes;
    }

    public void setConsultasRestantes(int consultasRestantes) {
        this.consultasRestantes = consultasRestantes;
    }

    /*
     * Métodos
     */
    public void diminuiConsultasRestantes() {
        this.consultasRestantes--;
    }
}