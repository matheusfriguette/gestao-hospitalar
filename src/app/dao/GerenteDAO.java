package app.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import app.models.Gerente;

/*
 * GerenteDAO
 */
public class GerenteDAO {
    private File gerenteFile;
    private ArrayList<Gerente> gerentes;

    public GerenteDAO() {
        this.gerenteFile = new File("gerentes.dat");
    }

    public ArrayList<Gerente> getGerentes() {
        ObjectInputStream input = null;

        try {
            if (this.gerenteFile.length() > 0) {
                input = new ObjectInputStream(new FileInputStream(this.gerenteFile));
                this.gerentes = (ArrayList<Gerente>) input.readObject();
                input.close();
            } else {
                this.gerentes = new ArrayList<Gerente>();
            }
        } catch (Exception e) {
            return this.gerentes;
        }
        return this.gerentes;
    }

    public void addGerente(Gerente novoGerente) throws FileNotFoundException, IOException {
        ObjectOutputStream output = null;
        this.gerentes = getGerentes();
        this.gerentes.add(novoGerente);

        output = new ObjectOutputStream(new FileOutputStream(this.gerenteFile));
        output.writeObject(this.gerentes);
        output.flush();
        output.close();
    }
}