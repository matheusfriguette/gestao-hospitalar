package app.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeMap;

import app.models.Exame;

/*
 * ExameDAO
 */
public class ExameDAO {
    private File exameFile;
    private TreeMap<String, Exame> exames;

    public ExameDAO() {
        this.exameFile = new File("exames.dat");
    }

    public Exame getExame(String id) throws FileNotFoundException, ClassNotFoundException, IOException {
        this.exames = getExames();

        return this.exames.get(id);
    }

    public TreeMap<String, Exame> getExames() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream input = null;

        if (this.exameFile.length() > 0) {
            input = new ObjectInputStream(new FileInputStream(this.exameFile));
            this.exames = (TreeMap<String, Exame>) input.readObject();
            input.close();
        } else {
            this.exames = new TreeMap<String, Exame>();
        }

        return this.exames;
    }

    public void addExame(Exame novoExame) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectOutputStream output = null;
        this.exames = getExames();
        this.exames.put(novoExame.getId(), novoExame);

        output = new ObjectOutputStream(new FileOutputStream(this.exameFile));
        output.writeObject(this.exames);
        output.flush();
        output.close();
    }

    public void editExame(String id, Exame novoExame)
            throws FileNotFoundException, ClassNotFoundException, IOException {
        ObjectOutputStream output = null;
        this.exames = getExames();
        this.exames.put(id, novoExame);

        output = new ObjectOutputStream(new FileOutputStream(this.exameFile));
        output.writeObject(this.exames);
        output.flush();
        output.close();
    }

    public void deleteExame(String id) throws FileNotFoundException, ClassNotFoundException, IOException {
        ObjectOutputStream output = null;
        this.exames = getExames();
        this.exames.remove(id);

        output = new ObjectOutputStream(new FileOutputStream(this.exameFile));
        output.writeObject(this.exames);
        output.flush();
        output.close();
    }

    public long getLastKey() throws FileNotFoundException, ClassNotFoundException, IOException {
        this.exames = getExames();
        if (this.exames.size() == 0) {
            return 0;
        }

        return Long.parseLong(exames.lastKey());
    }
}