package app.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import app.models.Paciente;

/*
 * PacienteDAO
 */
public class PacienteDAO {
    private File pacienteFile;
    private ArrayList<Paciente> pacientes;

    public PacienteDAO() {
        this.pacienteFile = new File("pacientes.dat");
    }

    public ArrayList<Paciente> getPacientes() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream input = null;

        if (this.pacienteFile.length() > 0) {
            input = new ObjectInputStream(new FileInputStream(this.pacienteFile));
            this.pacientes = (ArrayList<Paciente>) input.readObject();
            input.close();
        } else {
            this.pacientes = new ArrayList<Paciente>();
        }

        return this.pacientes;
    }

    public void addPaciente(Paciente novoPaciente) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectOutputStream output = null;
        this.pacientes = getPacientes();
        this.pacientes.add(novoPaciente);

        output = new ObjectOutputStream(new FileOutputStream(this.pacienteFile));
        output.writeObject(this.pacientes);
        output.flush();
        output.close();
    }
}