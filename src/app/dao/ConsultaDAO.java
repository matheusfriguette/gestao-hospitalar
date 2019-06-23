package app.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import app.models.Consulta;

/*
 * ConsultaDAO
 */
public class ConsultaDAO {
    private File consultaFile;
    private HashMap<String, Consulta> consultas;

    public ConsultaDAO() {
        this.consultaFile = new File("data/consultas.dat");
    }

    public Consulta getConsulta(String id) throws FileNotFoundException, ClassNotFoundException, IOException {
        this.consultas = getConsultas();

        return this.consultas.get(id);
    }

    public HashMap<String, Consulta> getConsultas() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream input = null;

        if (this.consultaFile.length() > 0) {
            input = new ObjectInputStream(new FileInputStream(this.consultaFile));
            this.consultas = (HashMap<String, Consulta>) input.readObject();
            input.close();
        } else {
            this.consultas = new HashMap<String, Consulta>();
        }

        return this.consultas;
    }

    public void addConsulta(Consulta novoConsulta) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectOutputStream output = null;
        this.consultas = getConsultas();
        this.consultas.put(novoConsulta.getId(), novoConsulta);

        output = new ObjectOutputStream(new FileOutputStream(this.consultaFile));
        output.writeObject(this.consultas);
        output.flush();
        output.close();
    }

    public void editConsulta(String id, Consulta novoConsulta)
            throws FileNotFoundException, ClassNotFoundException, IOException {
        ObjectOutputStream output = null;
        this.consultas = getConsultas();
        this.consultas.put(id, novoConsulta);

        output = new ObjectOutputStream(new FileOutputStream(this.consultaFile));
        output.writeObject(this.consultas);
        output.flush();
        output.close();
    }

    public void deleteConsulta(String id) throws FileNotFoundException, ClassNotFoundException, IOException {
        ObjectOutputStream output = null;
        this.consultas = getConsultas();
        this.consultas.remove(id);

        output = new ObjectOutputStream(new FileOutputStream(this.consultaFile));
        output.writeObject(this.consultas);
        output.flush();
        output.close();
    }
}