package servico;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.codec.digest.DigestUtils;

import domain.Funcionario;
import repositorio.Repositorio;
import util.ConexaoBaseDados;
import repositorio.FuncionarioRepositorioImpl;

public class FuncionarioServico implements Servico<Funcionario>
{
    private Repositorio<Funcionario> funcionarioRepositorio;
 

    public FuncionarioServico() {
        this.funcionarioRepositorio = new FuncionarioRepositorioImpl();
     
    }

    @Override
    public ArrayList<Funcionario> listar() throws SQLException, ClassNotFoundException {
        try (Connection conn = ConexaoBaseDados.getConnection()) {
            funcionarioRepositorio.setConn(conn);
            return funcionarioRepositorio.listar();
        }

    }

 

    @Override
	public  boolean salvar(Funcionario funcionario) throws SQLException, ClassNotFoundException 
    {
    	funcionario.setSenha(DigestUtils.md5Hex(funcionario.getSenha().toString()));
    		
    	try (Connection conn = ConexaoBaseDados.getConnection())
        {
            funcionarioRepositorio.setConn(conn);
            if (conn.getAutoCommit()) {
                conn.setAutoCommit(false);
            }
            
            try {
            	funcionarioRepositorio.salvar(funcionario);
            	conn.commit();
            	return true;
                
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }
            return false;
        }
    }

	@Override
	public boolean autenticar(String login, String senha) throws ClassNotFoundException
	{
		
		  try (Connection conn = ConexaoBaseDados.getConnection()) 
		  {
	            funcionarioRepositorio.setConn(conn);
	            return funcionarioRepositorio.autenticar(login, senha);
	      }catch(Exception ex) 
		  {		ex.printStackTrace();
	    	  	return false;
		  }

		
		
		
	}

	 



}
