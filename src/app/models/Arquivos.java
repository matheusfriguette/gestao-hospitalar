package app.models;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

/*
 * Arquivos
 */
public class Arquivos {
    public static Object get(File arquivo) {
        Object list = null;
        ObjectInputStream input = null;

        try {
            if (arquivo.length() > 0) {
                input = new ObjectInputStream(new FileInputStream(arquivo));
                list = input.readObject();
                input.close();
            } else {
                return list;
            }
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro de arquivos", "Erro!", JOptionPane.ERROR_MESSAGE);
        }

        return list;
    }

    public static void set(File arquivo, Object list) {
        ObjectOutputStream output = null;

        try {
            output = new ObjectOutputStream(new FileOutputStream(arquivo));
            output.writeObject(list);
            output.flush();
            output.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro de arquivos", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }
}