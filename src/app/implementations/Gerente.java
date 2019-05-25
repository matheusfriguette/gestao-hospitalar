package app;

/**
 * Gerente
 */
public class Gerente extends Funcionario {
    
    public Gerente(String CPF, String RG, String Nome, String Telefone, String DataNascimento, String Login, String Senha, String NCTPS, String DataAdmissao){
        super(CPF, RG, Nome, Telefone, DataNascimento, Login, Senha, NCTPS, DataAdmissao);
    }

    private void registerSecretaria(String CPF, String RG, String Nome, String Telefone, String DataNascimento, String Login, String Senha, String NCTPS, String DataAdmissao){
        Secretaria novaSecretaria = new Secretaria(CPF, RG, Nome, Telefone, DataNascimento, Login, Senha, NCTPS, DataAdmissao);
    }
}