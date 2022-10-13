package util;

import java.sql.SQLException;

import domain.Funcionario;
import servico.FuncionarioServico;

public class mainTest 
{

	public static void main(String[] args) throws SQLException, ClassNotFoundException 
	{
		
	FuncionarioServico f = new FuncionarioServico();
	//Funcionario fun = new Funcionario(); 
	//fun.setCpf("679.989.860-69");
	//fun.setFuncao("master admin");
	//fun.setNome("jose");
	//fun.setSenha("123456");
	
	//f.salvar(fun);
	System.out.println(f.autenticar("679.989.860-69", "12345"));
	   
	   
	}
}
