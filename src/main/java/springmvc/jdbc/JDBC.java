package springmvc.jdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/JDBCServlet")
public class JDBC extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String Driver = "org.postgresql.Driver";
        String url="jdbc:postgresql://localhost:5432/postgres";
        String name="postgres";
        String password="Gagan@0220";


        try
        {
            PrintWriter out=response.getWriter();
            out.println("connecting to jdbc");
            Class.forName(Driver);
            Connection mycon = DriverManager.getConnection(url, name, password);
            out.println("connection successfull");
            mycon.close();

        }
        catch(Exception exc)
        {
            exc.printStackTrace();
            throw new ServletException(exc);


        }
    }
}
