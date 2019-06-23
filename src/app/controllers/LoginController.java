package app.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import app.dao.FarmaceuticoDAO;
import app.dao.GerenteDAO;
import app.dao.MedicoDAO;
import app.dao.SecretarioDAO;
import app.models.Farmaceutico;
import app.models.Gerente;
import app.models.Medico;
import app.models.Secretario;

/*
 * LoginController
 */
public class LoginController {
    public static String usuarioLogado;

    public LoginController() {
    }

    public static void setUsuarioLogado(String usuarioLogado) {
        LoginController.usuarioLogado = usuarioLogado;
    }

    public static String getUsuarioLogado() {
        return usuarioLogado;
    }

    public Secretario getSecretarioLogado() {
        SecretarioDAO secretarioDAO = new SecretarioDAO();
        try {
            return secretarioDAO.getSecretario(usuarioLogado);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Medico getMedicoLogado() {
        MedicoDAO medicoDAO = new MedicoDAO();
        try {
            return medicoDAO.getMedico(usuarioLogado);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Farmaceutico getFarmaceuticoLogado() {
        FarmaceuticoDAO farmaceuticoDAO = new FarmaceuticoDAO();
        try {
            return farmaceuticoDAO.getFarmaceutico(usuarioLogado);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Gerente logarGerente(String login, String senha) {
        GerenteDAO gerenteDAO = new GerenteDAO();
        HashMap<String, Gerente> gerentes = new HashMap<String, Gerente>();

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
                setUsuarioLogado(gerente.getId());
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
                setUsuarioLogado(secretario.getId());
                return secretario;
            }
        }

        return null;
    }

    public Medico logarMedico(String login, String senha) {
        MedicoDAO medicoDAO = new MedicoDAO();
        HashMap<String, Medico> medicos = new HashMap<String, Medico>();

        try {
            medicos = medicoDAO.getMedicos();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Medico medico : medicos.values()) {
            if (medico.getLogin().equals(login) && medico.getSenha().equals(senha)) {
                setUsuarioLogado(medico.getId());
                return medico;
            }
        }

        return null;
    }

    public Farmaceutico logarFarmaceutico(String login, String senha) {
        FarmaceuticoDAO farmaceuticoDAO = new FarmaceuticoDAO();
        HashMap<String, Farmaceutico> farmaceuticos = new HashMap<String, Farmaceutico>();

        try {
            farmaceuticos = farmaceuticoDAO.getFarmaceuticos();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Farmaceutico farmaceutico : farmaceuticos.values()) {
            if (farmaceutico.getLogin().equals(login) && farmaceutico.getSenha().equals(senha)) {
                setUsuarioLogado(farmaceutico.getId());
                return farmaceutico;
            }
        }

        return null;
    }
}