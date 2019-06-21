package app.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import app.models.Secretario;

/*
 * SecretarioDAO
 */
public class SecretarioDAO {
    private File secretarioFile;
    private HashMap<String, Secretario> secretarios;

    public SecretarioDAO() {
        this.secretarioFile = new File("secretarios.dat");
    }

    public Secretario getSecretario(String id) throws FileNotFoundException, ClassNotFoundException, IOException {
        this.secretarios = getSecretarios();

        return this.secretarios.get(id);
    }

    public HashMap<String, Secretario> getSecretarios() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream input = null;

        if (this.secretarioFile.length() > 0) {
            input = new ObjectInputStream(new FileInputStream(this.secretarioFile));
            this.secretarios = (HashMap<String, Secretario>) input.readObject();
            input.close();
        } else {
            this.secretarios = new HashMap<String, Secretario>();
        }

        return this.secretarios;
    }

    public void addSecretario(Secretario novoSecretario) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectOutputStream output = null;
        this.secretarios = getSecretarios();
        this.secretarios.put(novoSecretario.getId(), novoSecretario);

        output = new ObjectOutputStream(new FileOutputStream(this.secretarioFile));
        output.writeObject(this.secretarios);
        output.flush();
        output.close();
    }

    public void editSecretario(String id, Secretario novoSecretario)
            throws FileNotFoundException, ClassNotFoundException, IOException {
        ObjectOutputStream output = null;
        this.secretarios = getSecretarios();
        this.secretarios.put(id, novoSecretario);

        output = new ObjectOutputStream(new FileOutputStream(this.secretarioFile));
        output.writeObject(this.secretarios);
        output.flush();
        output.close();
    }

    public void deleteSecretario(String id) throws FileNotFoundException, ClassNotFoundException, IOException {
        ObjectOutputStream output = null;
        this.secretarios = getSecretarios();
        this.secretarios.remove(id);

        output = new ObjectOutputStream(new FileOutputStream(this.secretarioFile));
        output.writeObject(this.secretarios);
        output.flush();
        output.close();
    }
}