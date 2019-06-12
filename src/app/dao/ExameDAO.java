package app.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import app.models.Exame;

/*
 * ExameDAO
 */
public class ExameDAO {
    private File exameFile;
    private ArrayList<Exame> exames;

    public ExameDAO() {
        this.exameFile = new File("exames.dat");
    }

    public ArrayList<Exame> getExames() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream input = null;

        if (this.exameFile.length() > 0) {
            input = new ObjectInputStream(new FileInputStream(this.exameFile));
            this.exames = (ArrayList<Exame>) input.readObject();
            input.close();
        } else {
            this.exames = new ArrayList<Exame>();
        }

        return this.exames;
    }

    public void addExame(Exame novoExame) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectOutputStream output = null;
        this.exames = getExames();
        this.exames.add(novoExame);

        output = new ObjectOutputStream(new FileOutputStream(this.exameFile));
        output.writeObject(this.exames);
        output.flush();
        output.close();
    }
}