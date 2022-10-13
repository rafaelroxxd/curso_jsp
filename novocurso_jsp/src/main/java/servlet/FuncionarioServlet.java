package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;


import servico.FuncionarioServico;

/**
 * Servlet implementation class ControleCliente
 */
//Servlet 3.0 aceita tanto com anotação quanto pelo web.xml.
@WebServlet({"/FuncionarioServlet", "/jsp/cadcliente.html", 
		"/jsp/consultarcliente.html", "/jsp/altcliente.html", "/jsp/listarclientes.html",
		"/jsp/listarclientesAjax.html"})
public class FuncionarioServlet extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FuncionarioServico funcionarioServico;
	
    public FuncionarioServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response); /* incluído na aula em substituição a: 
		response.getWriter().append("Served at: ").append(request.getContextPath());*/
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		execute(request, response); 
	}
	

	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String url = request.getServletPath();
			System.out.println(url);
	        if(url.equalsIgnoreCase("/FuncionarioServlet"))  		
	        {
	        	autenticar(request, response);
	        }
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}

protected void autenticar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
		
			funcionarioServico =  new FuncionarioServico();
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			if (funcionarioServico.autenticar(login,DigestUtils.md5(senha).toString()))
			{
				RequestDispatcher rd = request.getRequestDispatcher("acessoliberado.html");
				rd.forward(request, response);
				
			}else 
			{
				RequestDispatcher rd = request.getRequestDispatcher("acessonegado.html");
				rd.forward(request, response);
				
			}
			
			
			
		
}



	
}
