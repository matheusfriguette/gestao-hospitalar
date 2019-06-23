package app.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import app.models.Gerente;

/*
 * GerenteDAO
 */
public class GerenteDAO {
    private File gerenteFile;
    private HashMap<String, Gerente> gerentes;

    public GerenteDAO() {
        this.gerenteFile = new File("data/gerentes.dat");
    }

    public Gerente getGerente(String id) throws FileNotFoundException, ClassNotFoundException, IOException {
        this.gerentes = getGerentes();

        return this.gerentes.get(id);
    }

    public HashMap<String, Gerente> getGerentes() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream input = null;

        if (this.gerenteFile.length() > 0) {
            input = new ObjectInputStream(new FileInputStream(this.gerenteFile));
            this.gerentes = (HashMap<String, Gerente>) input.readObject();
            input.close();
        } else {
            this.gerentes = new HashMap<String, Gerente>();
        }

        return this.gerentes;
    }

    public void addGerente(Gerente novoGerente) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectOutputStream output = null;
        this.gerentes = getGerentes();
        this.gerentes.put(novoGerente.getId(), novoGerente);

        output = new ObjectOutputStream(new FileOutputStream(this.gerenteFile));
        output.writeObject(this.gerentes);
        output.close();
    }

    public void editGerente(String id, Gerente novoGerente)
            throws FileNotFoundException, ClassNotFoundException, IOException {
        ObjectOutputStream output = null;
        this.gerentes = getGerentes();
        this.gerentes.put(id, novoGerente);

        output = new ObjectOutputStream(new FileOutputStream(this.gerenteFile));
        output.writeObject(this.gerentes);
        output.close();
    }

    public void deleteGerente(String id) throws FileNotFoundException, ClassNotFoundException, IOException {
        ObjectOutputStream output = null;
        this.gerentes = getGerentes();
        this.gerentes.remove(id);

        output = new ObjectOutputStream(new FileOutputStream(this.gerenteFile));
        output.writeObject(this.gerentes);
        output.close();
    }
}