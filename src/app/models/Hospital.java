package app.models;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;

/**
 * Hospital
 */
public class Hospital {
    private static Funcionario usuarioLogado;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Paciente> pacientes;
    private ArrayList<Consulta> consultas;
    private ArrayList<Exame> exames;
    private ArrayList<Remedio> remedios;
    private ArrayList<Plano> planos;
    private File arquivoFuncionarios;
    private File arquivoPacientes;
    private File arquivoConsultas;
    private File arquivoExames;
    private File arquivoRemedios;
    private File arquivoPlanos;

    /*
     * Construtores
     */
    public Hospital() {
        this.arquivoFuncionarios = new File("data/funcionarios.dat");
        this.arquivoPacientes = new File("data/pacientes.dat");
        this.arquivoConsultas = new File("data/consultas.dat");
        this.arquivoExames = new File("data/exames.dat");
        this.arquivoRemedios = new File("data/remedios.dat");
        this.arquivoPlanos = new File("data/planos.dat");

        try {
            if (!this.arquivoFuncionarios.exists()) {
                this.arquivoFuncionarios.createNewFile();
            }
            if (!this.arquivoPacientes.exists()) {
                this.arquivoPacientes.createNewFile();
            }
            if (!this.arquivoConsultas.exists()) {
                this.arquivoConsultas.createNewFile();
            }
            if (!this.arquivoConsultas.exists()) {
                this.arquivoConsultas.createNewFile();
            }

            if (!this.arquivoExames.exists()) {
                this.arquivoExames.createNewFile();
            }
            if (!this.arquivoRemedios.exists()) {
                this.arquivoRemedios.createNewFile();
            }
            if (!this.arquivoPlanos.exists()) {
                this.arquivoPlanos.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * Métodos
     */
    public void setUsuarioLogado(Funcionario usuarioLogado) {
        Hospital.usuarioLogado = usuarioLogado;
    }

    public Funcionario getUsuarioLogado() {
        return usuarioLogado;
    }

    public Funcionario logar(String login, String senha) {
        funcionarios = getFuncionarios();

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getLogin().equals(login) && funcionario.getSenha().equals(senha)) {
                setUsuarioLogado(funcionario);
                return funcionario;
            }
        }

        return null;
    }

    public boolean existeLogin(String login) {
        funcionarios = getFuncionarios();

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getLogin().equals(login)) {
                return true;
            }
        }

        return false;
    }

    public ArrayList<Gerente> getGerentes() {
        funcionarios = getFuncionarios();
        ArrayList<Gerente> gerentes = new ArrayList<Gerente>();

        for (Funcionario funcionario : funcionarios) {
            if (funcionario instanceof Gerente) {
                gerentes.add((Gerente) funcionario);
            }
        }

        return gerentes;
    }

    public ArrayList<Secretario> getSecretarios() {
        funcionarios = getFuncionarios();
        ArrayList<Secretario> secretarios = new ArrayList<Secretario>();

        for (Funcionario funcionario : funcionarios) {
            if (funcionario instanceof Secretario) {
                secretarios.add((Secretario) funcionario);
            }
        }

        return secretarios;
    }

    public ArrayList<Medico> getMedicos() {
        funcionarios = getFuncionarios();
        ArrayList<Medico> medicos = new ArrayList<Medico>();

        for (Funcionario funcionario : funcionarios) {
            if (funcionario instanceof Medico) {
                medicos.add((Medico) funcionario);
            }
        }

        return medicos;
    }

    public ArrayList<Farmaceutico> getFarmaceuticos() {
        funcionarios = getFuncionarios();
        ArrayList<Farmaceutico> farmaceuticos = new ArrayList<Farmaceutico>();

        for (Funcionario funcionario : funcionarios) {
            if (funcionario instanceof Farmaceutico) {
                farmaceuticos.add((Farmaceutico) funcionario);
            }
        }

        return farmaceuticos;
    }

    /*
     * Operações CRUD
     */
    public void addFuncionario(Funcionario novoFuncionario) {
        funcionarios = getFuncionarios();

        funcionarios.add(novoFuncionario);

        Arquivos.set(arquivoFuncionarios, funcionarios);
    }

    public Funcionario getFuncionario(String id) {
        funcionarios = getFuncionarios();

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId().equals(id)) {
                return funcionario;
            }
        }

        return null;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        funcionarios = (ArrayList<Funcionario>) Arquivos.get(arquivoFuncionarios);
        if (funcionarios == null) {
            funcionarios = new ArrayList<Funcionario>();
        }

        return funcionarios;
    }

    public void editFuncionario(String id, Funcionario novoFuncionario) {
        funcionarios = getFuncionarios();

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId().equals(id)) {
                deleteFuncionario(funcionario.getId());
                break;
            }
        }
        funcionarios.add(novoFuncionario);

        Arquivos.set(arquivoFuncionarios, funcionarios);
    }

    public void deleteFuncionario(String id) {
        funcionarios = getFuncionarios();

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId().equals(id)) {
                funcionarios.remove(funcionario);
                break;
            }
        }

        Arquivos.set(arquivoFuncionarios, funcionarios);
    }

    public void addPaciente(Paciente novoPaciente) {
        pacientes = getPacientes();

        pacientes.add(novoPaciente);

        Arquivos.set(arquivoPacientes, pacientes);
    }

    public Paciente getPaciente(String id) {
        pacientes = getPacientes();

        for (Paciente paciente : pacientes) {
            if (paciente.getId().equals(id)) {
                return paciente;
            }
        }

        return null;
    }

    public ArrayList<Paciente> getPacientes() {
        pacientes = (ArrayList<Paciente>) Arquivos.get(arquivoPacientes);
        if (pacientes == null) {
            pacientes = new ArrayList<Paciente>();
        }

        return pacientes;
    }

    public void editPaciente(String id, Paciente novoPaciente) {
        pacientes = getPacientes();

        for (Paciente paciente : pacientes) {
            if (paciente.getId().equals(id)) {
                deletePaciente(paciente.getId());
                break;
            }
        }
        pacientes.add(novoPaciente);

        Arquivos.set(arquivoPacientes, pacientes);
    }

    public void deletePaciente(String id) {
        pacientes = getPacientes();

        for (Paciente paciente : pacientes) {
            if (paciente.getId().equals(id)) {
                pacientes.remove(paciente);
                break;
            }
        }

        Arquivos.set(arquivoPacientes, pacientes);
    }

    public void addConsulta(Consulta novoConsulta) {
        consultas = getConsultas();

        consultas.add(novoConsulta);

        Arquivos.set(arquivoConsultas, consultas);
    }

    public Consulta getConsulta(String id) {
        consultas = getConsultas();

        for (Consulta consulta : consultas) {
            if (consulta.getId().equals(id)) {
                return consulta;
            }
        }

        return null;
    }

    public ArrayList<Consulta> getConsultas() {
        consultas = (ArrayList<Consulta>) Arquivos.get(arquivoConsultas);
        if (consultas == null) {
            consultas = new ArrayList<Consulta>();
        }

        return consultas;
    }

    public void editConsulta(String id, Consulta novoConsulta) {
        consultas = getConsultas();

        for (Consulta consulta : consultas) {
            if (consulta.getId().equals(id)) {
                deleteConsulta(consulta.getId());
                break;
            }
        }
        consultas.add(novoConsulta);

        Arquivos.set(arquivoConsultas, consultas);
    }

    public void deleteConsulta(String id) {
        consultas = getConsultas();

        for (Consulta consulta : consultas) {
            if (consulta.getId().equals(id)) {
                consultas.remove(consulta);
                break;
            }
        }

        Arquivos.set(arquivoConsultas, consultas);
    }

    public void addExame(Exame novoExame) {
        exames = getExames();

        exames.add(novoExame);

        Arquivos.set(arquivoExames, exames);
    }

    public Exame getExame(String id) {
        exames = getExames();

        for (Exame exame : exames) {
            if (exame.getId().equals(id)) {
                return exame;
            }
        }

        return null;
    }

    public ArrayList<Exame> getExames() {
        exames = (ArrayList<Exame>) Arquivos.get(arquivoExames);
        if (exames == null) {
            exames = new ArrayList<Exame>();
        }

        return exames;
    }

    public void editExame(String id, Exame novoExame) {
        exames = getExames();

        for (Exame exame : exames) {
            if (exame.getId().equals(id)) {
                deleteExame(exame.getId());
                break;
            }
        }
        exames.add(novoExame);

        Arquivos.set(arquivoExames, exames);
    }

    public void deleteExame(String id) {
        exames = getExames();

        for (Exame exame : exames) {
            if (exame.getId().equals(id)) {
                exames.remove(exame);
                break;
            }
        }

        Arquivos.set(arquivoExames, exames);
    }

    public void addRemedio(Remedio novoRemedio) {
        remedios = getRemedios();

        remedios.add(novoRemedio);

        Arquivos.set(arquivoRemedios, remedios);
    }

    public Remedio getRemedio(String id) {
        remedios = getRemedios();

        for (Remedio remedio : remedios) {
            if (remedio.getId().equals(id)) {
                return remedio;
            }
        }

        return null;
    }

    public ArrayList<Remedio> getRemedios() {
        remedios = (ArrayList<Remedio>) Arquivos.get(arquivoRemedios);
        if (remedios == null) {
            remedios = new ArrayList<Remedio>();
        }

        return remedios;
    }

    public void editRemedio(String id, Remedio novoRemedio) {
        remedios = getRemedios();

        for (Remedio remedio : remedios) {
            if (remedio.getId().equals(id)) {
                deleteRemedio(remedio.getId());
                break;
            }
        }
        remedios.add(novoRemedio);

        Arquivos.set(arquivoRemedios, remedios);
    }

    public void deleteRemedio(String id) {
        remedios = getRemedios();

        for (Remedio remedio : remedios) {
            if (remedio.getId().equals(id)) {
                remedios.remove(remedio);
                break;
            }
        }

        Arquivos.set(arquivoRemedios, remedios);
    }

    public void addPlano(Plano novoPlano) {
        planos = getPlanos();

        planos.add(novoPlano);

        Arquivos.set(arquivoPlanos, planos);
    }

    public Plano getPlano(String id) {
        planos = getPlanos();

        for (Plano plano : planos) {
            if (plano.getId().equals(id)) {
                return plano;
            }
        }

        return null;
    }

    public ArrayList<Plano> getPlanos() {
        planos = (ArrayList<Plano>) Arquivos.get(arquivoPlanos);
        if (planos == null) {
            planos = new ArrayList<Plano>();
        }

        return planos;
    }

    public void editPlano(String id, Plano novoPlano) {
        planos = getPlanos();

        for (Plano plano : planos) {
            if (plano.getId().equals(id)) {
                deletePlano(plano.getId());
                break;
            }
        }
        planos.add(novoPlano);

        Arquivos.set(arquivoPlanos, planos);
    }

    public void deletePlano(String id) {
        planos = getPlanos();

        for (Plano plano : planos) {
            if (plano.getId().equals(id)) {
                planos.remove(plano);
                break;
            }
        }

        Arquivos.set(arquivoPlanos, planos);
    }
}