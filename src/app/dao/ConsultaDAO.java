package app.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import app.models.Consulta;

/*
 * ConsultaDAO
 */
public class ConsultaDAO {
    private File consultaFile;
    private ArrayList<Consulta> consultas;

    public ConsultaDAO() {
        this.consultaFile = new File("consultas.dat");
    }

    public ArrayList<Consulta> getConsultas() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream input = null;

        if (this.consultaFile.length() > 0) {
            input = new ObjectInputStream(new FileInputStream(this.consultaFile));
            this.consultas = (ArrayList<Consulta>) input.readObject();
            input.close();
        } else {
            this.consultas = new ArrayList<Consulta>();
        }

        return this.consultas;
    }

    public void addConsulta(Consulta novoConsulta) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectOutputStream output = null;
        this.consultas = getConsultas();
        this.consultas.add(novoConsulta);

        output = new ObjectOutputStream(new FileOutputStream(this.consultaFile));
        output.writeObject(this.consultas);
        output.flush();
        output.close();
    }
}