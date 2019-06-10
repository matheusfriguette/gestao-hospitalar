package app.controllers;

import java.util.ArrayList;

import app.dao.GerenteDAO;
import app.dao.SecretarioDAO;
import app.models.Gerente;
import app.models.Secretario;

/**
 * LoginController
 */
public class LoginController {

    public Gerente logarGerente(String login, String senha) {
        GerenteDAO gerenteDAO = new GerenteDAO();
        ArrayList<Gerente> gerentes = gerenteDAO.getGerentes();

        for (Gerente gerente : gerentes) {
            if (gerente.getLogin().equals(login) && gerente.getSenha().equals(senha)) {
                return gerente;
            }
        }

        return null;
    }

    public Secretario logarSecretario(String login, String senha) {
        SecretarioDAO secretarioDAO = new SecretarioDAO();
        ArrayList<Secretario> secretarios = secretarioDAO.getSecretarios();

        for (Secretario secretario : secretarios) {
            if (secretario.getLogin().equals(login) && secretario.getSenha().equals(senha)) {
                return secretario;
            }
        }

        return null;
    }
}