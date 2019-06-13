package app.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeMap;

import app.models.Medico;

/*
 * MedicoDAO
 */
public class MedicoDAO {
    private File medicoFile;
    private TreeMap<String, Medico> medicos;

    public MedicoDAO() {
        this.medicoFile = new File("medicos.dat");
    }

    public Medico getMedico(String id) throws FileNotFoundException, ClassNotFoundException, IOException {
        this.medicos = getMedicos();

        return this.medicos.get(id);
    }

    public TreeMap<String, Medico> getMedicos() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream input = null;

        if (this.medicoFile.length() > 0) {
            input = new ObjectInputStream(new FileInputStream(this.medicoFile));
            this.medicos = (TreeMap<String, Medico>) input.readObject();
            input.close();
        } else {
            this.medicos = new TreeMap<String, Medico>();
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

    public long getLastKey() throws FileNotFoundException, ClassNotFoundException, IOException {
        this.medicos = getMedicos();
        if (this.medicos.size() == 0) {
            return 0;
        }

        return Long.parseLong(medicos.lastKey());
    }
}