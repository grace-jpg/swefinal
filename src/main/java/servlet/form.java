package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.PrintWriter;

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;
import java.lang.*;

@WebServlet(name = "form", urlPatterns = {"/form"})
public class form extends HttpServlet {
 
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             
        String input = request.getParameter("input");
       
        response.setContentType("text/html");
        PrintWriter out = response.getWriter(); 
        printhead(out);
        printtable(out, input);
        end(out);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String input = request.getParameter("input");

        printhead(out);
        printtable(out, input);
        end(out);
    }

    public void printtable (PrintWriter out, String input) {

        out.print("<center><h2>Truth Table</h2></center>\n");
        out.print("<body>\n");
        out.print("<p>Please enter a boolean predicate that has boolean variables and logical operators: </p>");
 
        out.print("<form method = \"GET\">");
        out.println("   <td><input type=\"text\" name=\"input\" value=\"" + "\" >");
        out.println("<input type = \"submit\" value = \"submit\"");

        out.print("</form>");
        String[] data = input.split(" ");

        ArrayList <String> variables = new ArrayList <String> ();
        ArrayList <String> operators = new ArrayList <String> ();

        for (int x = 0; x < data.length; x++) {
            // if even, index (therefore variable)
            if ((x % 2) == 0) 
                variables.add(data[x]);
            // else, operator
            else 
                operators.add(data[x]);
        }


        // if (or.contains(operator[0]))
        //     andop = 0;

        // else if (and.contains(operator[0]))
        //     andop = 1;

        // else
        //     out.print("invalid input");

     

        out.println("<table width=\"50%\" border=\"1\" align=\"center\">");

        int opcount = 0;
        String[] or = {"or", "OR", "|"};
        String[] and = {"and", "AND", "&&"};


        // variable headers for each column
        out.println("<tr> ");
        for (int num = 0; num < data.length + 1; num++) {
            out.println("<th>" + variables.get(num) + "");
            if (((num % 2) == 0) && (num != 0))
                out.println("<th>" + operators.get(opcount) + "");
        }   
        
        out.println("</tr>");

//        out.println("<center>");
        out.println("<tr> ");
        out.println("<td> TRUE </td>");
        out.println("<td> TRUE </td>");
        out.println("</tr>");

        out.println("<tr> ");
        out.println("<td> TRUE </td>");
        out.println("<td> FALSE </td>");
        out.println("</tr>");

        out.println("<tr> ");
        out.println("<td> FALSE </td>");
        out.println("<td> TRUE </td>");
        out.println("</tr>");

        out.println("<tr> ");
        out.println("<td> FALSE </td>");
        out.println("<td> FALSE </td>");
        out.println("</tr>");

  //      out.println("</center>");
        out.println ("</table>");
        out.print("</body>\n");

 
    }



    public void printhead (PrintWriter out) {
        out.print("<html>\n<head>\n\n");
        out.print("<title>Truth Table</title>\n");
        out.print("</head>\n");
    }

    public void end (PrintWriter out) {
        out.print("</html>");
        out.close ();
    }

}