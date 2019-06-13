package app.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeMap;

import app.models.Farmaceutico;

/*
 * FarmaceuticoDAO
 */
public class FarmaceuticoDAO {
    private File farmaceuticoFile;
    private TreeMap<String, Farmaceutico> farmaceuticos;

    public FarmaceuticoDAO() {
        this.farmaceuticoFile = new File("farmaceuticos.dat");
    }

    public Farmaceutico getFarmaceutico(String id) throws FileNotFoundException, ClassNotFoundException, IOException {
        this.farmaceuticos = getFarmaceuticos();

        return this.farmaceuticos.get(id);
    }

    public TreeMap<String, Farmaceutico> getFarmaceuticos() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream input = null;

        if (this.farmaceuticoFile.length() > 0) {
            input = new ObjectInputStream(new FileInputStream(this.farmaceuticoFile));
            this.farmaceuticos = (TreeMap<String, Farmaceutico>) input.readObject();
            input.close();
        } else {
            this.farmaceuticos = new TreeMap<String, Farmaceutico>();
        }

        return this.farmaceuticos;
    }

    public void addFarmaceutico(Farmaceutico novoFarmaceutico) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectOutputStream output = null;
        this.farmaceuticos = getFarmaceuticos();
        this.farmaceuticos.put(novoFarmaceutico.getId(), novoFarmaceutico);

        output = new ObjectOutputStream(new FileOutputStream(this.farmaceuticoFile));
        output.writeObject(this.farmaceuticos);
        output.flush();
        output.close();
    }

    public void editFarmaceutico(String id, Farmaceutico novoFarmaceutico)
            throws FileNotFoundException, ClassNotFoundException, IOException {
        ObjectOutputStream output = null;
        this.farmaceuticos = getFarmaceuticos();
        this.farmaceuticos.put(id, novoFarmaceutico);

        output = new ObjectOutputStream(new FileOutputStream(this.farmaceuticoFile));
        output.writeObject(this.farmaceuticos);
        output.flush();
        output.close();
    }

    public void deleteFarmaceutico(String id) throws FileNotFoundException, ClassNotFoundException, IOException {
        ObjectOutputStream output = null;
        this.farmaceuticos = getFarmaceuticos();
        this.farmaceuticos.remove(id);

        output = new ObjectOutputStream(new FileOutputStream(this.farmaceuticoFile));
        output.writeObject(this.farmaceuticos);
        output.flush();
        output.close();
    }

    public long getLastKey() throws FileNotFoundException, ClassNotFoundException, IOException {
        this.farmaceuticos = getFarmaceuticos();
        if (this.farmaceuticos.size() == 0) {
            return 0;
        }

        return Long.parseLong(farmaceuticos.lastKey());
    }
}