package app.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import app.models.Medico;

/*
 * MedicoDAO
 */
public class MedicoDAO {
    private File medicoFile;
    private ArrayList<Medico> medicos;

    public MedicoDAO() {
        this.medicoFile = new File("medicos.dat");
    }

    public ArrayList<Medico> getMedicos() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream input = null;

        if (this.medicoFile.length() > 0) {
            input = new ObjectInputStream(new FileInputStream(this.medicoFile));
            this.medicos = (ArrayList<Medico>) input.readObject();
            input.close();
        } else {
            this.medicos = new ArrayList<Medico>();
        }

        return this.medicos;
    }

    public void addMedico(Medico novoMedico) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectOutputStream output = null;
        this.medicos = getMedicos();
        this.medicos.add(novoMedico);

        output = new ObjectOutputStream(new FileOutputStream(this.medicoFile));
        output.writeObject(this.medicos);
        output.flush();
        output.close();
    }
}