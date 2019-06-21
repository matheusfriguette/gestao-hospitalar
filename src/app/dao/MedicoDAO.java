package app.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import app.models.Medico;

/*
 * MedicoDAO
 */
public class MedicoDAO {
    private File medicoFile;
    private HashMap<String, Medico> medicos;

    public MedicoDAO() {
        this.medicoFile = new File("medicos.dat");
    }

    public Medico getMedico(String id) throws FileNotFoundException, ClassNotFoundException, IOException {
        this.medicos = getMedicos();

        return this.medicos.get(id);
    }

    public HashMap<String, Medico> getMedicos() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream input = null;

        if (this.medicoFile.length() > 0) {
            input = new ObjectInputStream(new FileInputStream(this.medicoFile));
            this.medicos = (HashMap<String, Medico>) input.readObject();
            input.close();
        } else {
            this.medicos = new HashMap<String, Medico>();
        }

        return this.medicos;
    }

    public void addMedico(Medico novoMedico) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectOutputStream output = null;
        this.medicos = getMedicos();
        this.medicos.put(novoMedico.getId(), novoMedico);

        output = new ObjectOutputStream(new FileOutputStream(this.medicoFile));
        output.writeObject(this.medicos);
        output.flush();
        output.close();
    }

    public void editMedico(String id, Medico novoMedico)
            throws FileNotFoundException, ClassNotFoundException, IOException {
        ObjectOutputStream output = null;
        this.medicos = getMedicos();
        this.medicos.put(id, novoMedico);

        output = new ObjectOutputStream(new FileOutputStream(this.medicoFile));
        output.writeObject(this.medicos);
        output.flush();
        output.close();
    }

    public void deleteMedico(String id) throws FileNotFoundException, ClassNotFoundException, IOException {
        ObjectOutputStream output = null;
        this.medicos = getMedicos();
        this.medicos.remove(id);

        output = new ObjectOutputStream(new FileOutputStream(this.medicoFile));
        output.writeObject(this.medicos);
        output.flush();
        output.close();
    }
}