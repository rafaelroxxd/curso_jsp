package servico;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.Funcionario;

public interface Servico<T> 
{
  
    ArrayList<T> listar() throws SQLException, ClassNotFoundException;

    //T porId(Long id) throws SQLException;

   // void excluir(Long id) throws SQLException;

	boolean salvar(T t) throws SQLException,ClassNotFoundException;
	boolean autenticar(String login,String senha) throws ClassNotFoundException;
	
}
