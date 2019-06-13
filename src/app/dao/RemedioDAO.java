package app.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeMap;

import app.models.Remedio;

/*
 * RemedioDAO
 */
public class RemedioDAO {
    private File remedioFile;
    private TreeMap<String, Remedio> remedios;

    public RemedioDAO() {
        this.remedioFile = new File("remedios.dat");
    }

    public Remedio getRemedio(String id) throws FileNotFoundException, ClassNotFoundException, IOException {
        this.remedios = getRemedios();

        return this.remedios.get(id);
    }

    public TreeMap<String, Remedio> getRemedios() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream input = null;

        if (this.remedioFile.length() > 0) {
            input = new ObjectInputStream(new FileInputStream(this.remedioFile));
            this.remedios = (TreeMap<String, Remedio>) input.readObject();
            input.close();
        } else {
            this.remedios = new TreeMap<String, Remedio>();
        }

        return this.remedios;
    }

    public void addRemedio(Remedio novoRemedio) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectOutputStream output = null;
        this.remedios = getRemedios();
        this.remedios.put(novoRemedio.getId(), novoRemedio);

        output = new ObjectOutputStream(new FileOutputStream(this.remedioFile));
        output.writeObject(this.remedios);
        output.flush();
        output.close();
    }

    public void editRemedio(String id, Remedio novoRemedio)
            throws FileNotFoundException, ClassNotFoundException, IOException {
        ObjectOutputStream output = null;
        this.remedios = getRemedios();
        this.remedios.put(id, novoRemedio);

        output = new ObjectOutputStream(new FileOutputStream(this.remedioFile));
        output.writeObject(this.remedios);
        output.flush();
        output.close();
    }

    public void deleteRemedio(String id) throws FileNotFoundException, ClassNotFoundException, IOException {
        ObjectOutputStream output = null;
        this.remedios = getRemedios();
        this.remedios.remove(id);

        output = new ObjectOutputStream(new FileOutputStream(this.remedioFile));
        output.writeObject(this.remedios);
        output.flush();
        output.close();
    }

    public long getLastKey() throws FileNotFoundException, ClassNotFoundException, IOException {
        this.remedios = getRemedios();
        if (this.remedios.size() == 0) {
            return 0;
        }

        return Long.parseLong(remedios.lastKey());
    }
}