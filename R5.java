
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class R5 extends HttpServlet 
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
                
        String name = null,p = null;
        String N=request.getParameter("username");
        String P=request.getParameter("password");
        try{  
Class.forName("com.mysql.jdbc.Driver");  
  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","sagarika");  
  
Statement stmt=con.createStatement();  
  
ResultSet rs=stmt.executeQuery("select * from login ");  
  
while(rs.next())
{
     name=rs.getString("username");
    p=rs.getString("password");
}

if(N.equals(name) && P.equals(p))
{
    RequestDispatcher rd=request.getRequestDispatcher("R6");
    rd.forward(request,response);
    
}
else
{
    
    RequestDispatcher rd=request.getRequestDispatcher("/newhtml1.html");
    rd.include(request, response);
    
    out.println("wrong username or password");
}
//System.out.println(rs.getString(1)+"  "+rs.getString(2));  
  
con.close();  
  
}catch(Exception e)
{ System.out.println(e);
}  
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
