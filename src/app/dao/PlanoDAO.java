package app.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import app.models.Plano;

/*
 * PlanoDAO
 */
public class PlanoDAO {
    private File planoFile;
    private HashMap<String, Plano> planos;

    public PlanoDAO() {
        this.planoFile = new File("data/planos.dat");
    }

    public Plano getPlano(String id) throws FileNotFoundException, ClassNotFoundException, IOException {
        this.planos = getPlanos();

        return this.planos.get(id);
    }

    public HashMap<String, Plano> getPlanos() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream input = null;

        if (this.planoFile.length() > 0) {
            input = new ObjectInputStream(new FileInputStream(this.planoFile));
            this.planos = (HashMap<String, Plano>) input.readObject();
            input.close();
        } else {
            this.planos = new HashMap<String, Plano>();
        }

        return this.planos;
    }

    public void addPlano(Plano novoPlano) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectOutputStream output = null;
        this.planos = getPlanos();
        this.planos.put(novoPlano.getId(), novoPlano);

        output = new ObjectOutputStream(new FileOutputStream(this.planoFile));
        output.writeObject(this.planos);
        output.flush();
        output.close();
    }

    public void editPlano(String id, Plano novoPlano)
            throws FileNotFoundException, ClassNotFoundException, IOException {
        ObjectOutputStream output = null;
        this.planos = getPlanos();
        this.planos.put(id, novoPlano);

        output = new ObjectOutputStream(new FileOutputStream(this.planoFile));
        output.writeObject(this.planos);
        output.flush();
        output.close();
    }

    public void deletePlano(String id) throws FileNotFoundException, ClassNotFoundException, IOException {
        ObjectOutputStream output = null;
        this.planos = getPlanos();
        this.planos.remove(id);

        output = new ObjectOutputStream(new FileOutputStream(this.planoFile));
        output.writeObject(this.planos);
        output.flush();
        output.close();
    }
}