
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class R1 implements Servlet
        
{
    ServletConfig config=null;

    @Override
    public void init(ServletConfig config) 
    {
        this.config=config;
        System.out.println("Servlet is initialised");
        
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
    {
        res.setContentType("text/html");
        
        PrintWriter out=res.getWriter();
        
        out.println("<html><body>");
        out.println("<b> hello world </b>");
        out.println("</body></html>");
        
    }

    @Override
    public String getServletInfo() {
        return("copyright 2016");
    }

    @Override
    public void destroy() {
        System.out.println("servlet is destroyed");
    }
   
}
