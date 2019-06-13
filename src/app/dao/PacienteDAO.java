package app.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeMap;

import app.models.Paciente;

/*
 * PacienteDAO
 */
public class PacienteDAO {
    private File pacienteFile;
    private TreeMap<String, Paciente> pacientes;

    public PacienteDAO() {
        this.pacienteFile = new File("pacientes.dat");
    }

    public Paciente getPaciente(String id) throws FileNotFoundException, ClassNotFoundException, IOException {
        this.pacientes = getPacientes();

        return this.pacientes.get(id);
    }

    public TreeMap<String, Paciente> getPacientes() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream input = null;

        if (this.pacienteFile.length() > 0) {
            input = new ObjectInputStream(new FileInputStream(this.pacienteFile));
            this.pacientes = (TreeMap<String, Paciente>) input.readObject();
            input.close();
        } else {
            this.pacientes = new TreeMap<String, Paciente>();
        }

        return this.pacientes;
    }

    public void addPaciente(Paciente novoPaciente) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectOutputStream output = null;
        this.pacientes = getPacientes();
        this.pacientes.put(novoPaciente.getId(), novoPaciente);

        output = new ObjectOutputStream(new FileOutputStream(this.pacienteFile));
        output.writeObject(this.pacientes);
        output.flush();
        output.close();
    }

    public void editPaciente(String id, Paciente novoPaciente)
            throws FileNotFoundException, ClassNotFoundException, IOException {
        ObjectOutputStream output = null;
        this.pacientes = getPacientes();
        this.pacientes.put(id, novoPaciente);

        output = new ObjectOutputStream(new FileOutputStream(this.pacienteFile));
        output.writeObject(this.pacientes);
        output.flush();
        output.close();
    }

    public void deletePaciente(String id) throws FileNotFoundException, ClassNotFoundException, IOException {
        ObjectOutputStream output = null;
        this.pacientes = getPacientes();
        this.pacientes.remove(id);

        output = new ObjectOutputStream(new FileOutputStream(this.pacienteFile));
        output.writeObject(this.pacientes);
        output.flush();
        output.close();
    }

    public long getLastKey() throws FileNotFoundException, ClassNotFoundException, IOException {
        this.pacientes = getPacientes();
        if (this.pacientes.size() == 0) {
            return 0;
        }

        return Long.parseLong(pacientes.lastKey());
    }
}