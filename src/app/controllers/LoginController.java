package app.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

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
        ArrayList<Gerente> gerentes = new ArrayList<Gerente>();

        try {
            gerentes = gerenteDAO.getGerentes();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Gerente gerente : gerentes) {
            if (gerente.getLogin().equals(login) && gerente.getSenha().equals(senha)) {
                return gerente;
            }
        }

        return null;
    }

    public Secretario logarSecretario(String login, String senha) {
        SecretarioDAO secretarioDAO = new SecretarioDAO();
        ArrayList<Secretario> secretarios = new ArrayList<Secretario>();

        try {
            secretarios = secretarioDAO.getSecretarios();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Secretario secretario : secretarios) {
            if (secretario.getLogin().equals(login) && secretario.getSenha().equals(senha)) {
                return secretario;
            }
        }

        return null;
    }
}