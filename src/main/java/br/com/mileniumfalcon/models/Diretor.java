package br.com.mileniumfalcon.models;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author erick
 */
public class Diretor extends Funcionario {
    
    public Diretor(String email, String senha,
                   int id, String nome, String endereco, String cpf,
                   Date dataNascimento, Timestamp dataInclusao) {
        
        super(email, senha, id, nome, endereco, cpf, dataNascimento, dataInclusao);
    }
    
    public Diretor(String email, String senha,
                   String nome, String endereco, String cpf,
                   Date dataNascimento, Timestamp dataInclusao) {
        
        super(email, senha, nome, endereco, cpf, dataNascimento, dataInclusao);
    }
    
}
