package app.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import app.dao.GerenteDAO;
import app.dao.SecretarioDAO;
import app.models.Gerente;
import app.models.Secretario;

/*
 * LoginController
 */
public class LoginController {

    public Gerente logarGerente(String login, String senha) {
        GerenteDAO gerenteDAO = new GerenteDAO();
        TreeMap<String, Gerente> gerentes = new TreeMap<String, Gerente>();

        try {
            gerentes = gerenteDAO.getGerentes();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Gerente gerente : gerentes.values()) {
            if (gerente.getLogin().equals(login) && gerente.getSenha().equals(senha)) {
                return gerente;
            }
        }

        return null;
    }

    public Secretario logarSecretario(String login, String senha) {
        SecretarioDAO secretarioDAO = new SecretarioDAO();
        HashMap<String, Secretario> secretarios = new HashMap<String, Secretario>();

        try {
            secretarios = secretarioDAO.getSecretarios();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Secretario secretario : secretarios.values()) {
            if (secretario.getLogin().equals(login) && secretario.getSenha().equals(senha)) {
                return secretario;
            }
        }

        return null;
    }
}