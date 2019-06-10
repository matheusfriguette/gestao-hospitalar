package app.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import app.models.Secretario;

/*
 * SecretarioDAO
 */
public class SecretarioDAO {
    private File secretarioFile;
    private ArrayList<Secretario> secretarios;

    public SecretarioDAO() {
        this.secretarioFile = new File("secretarios.dat");
    }

    public ArrayList<Secretario> getSecretarios() {
        ObjectInputStream input = null;

        try {
            if (this.secretarioFile.length() > 0) {
                input = new ObjectInputStream(new FileInputStream(this.secretarioFile));
                this.secretarios = (ArrayList<Secretario>) input.readObject();
                input.close();
            } else {
                this.secretarios = new ArrayList<Secretario>();
            }
        } catch (Exception e) {
            return this.secretarios;
        }
        return this.secretarios;
    }

    public void addSecretario(Secretario novoSecretario) throws FileNotFoundException, IOException {
        ObjectOutputStream output = null;
        this.secretarios = getSecretarios();
        this.secretarios.add(novoSecretario);

        output = new ObjectOutputStream(new FileOutputStream(this.secretarioFile));
        output.writeObject(this.secretarios);
        output.flush();
        output.close();
    }
}