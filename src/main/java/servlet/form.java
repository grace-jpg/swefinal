import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.*;
import java.util.*;
import java.lang.*;

@WebServlet(name = "form", urlPatterns = {"/form"})
public class form extends HttpServlet {
    
    String fname = request.getParameter("fname");
    
   /* A recursive algorithm to print a truth table of 1s and 0s.
    * N is the number of clauses, or columns, in the truth table.
    * index should be zero on the first call
    * truthVals starts as an empty array of integers of size N
    */
    // public void printTruthTable(int N, int index, int[] truthVals) {
        
    //     if (index == N) {
    //        for (i = 0; i < N; i++)
    //           print(truthVals[i] + " ");
    //        print(newline);
    //     } 
    //     else {
    //        for (i = 0; i < 2; i++) {
    //           truthVals[index] = i;
    //           printTruthTable(N, index + 1, truthVals);
    //        }
    //     }
    // } 

    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
        // response.setContentType("text/html");
        // PrintWriter out = response.getWriter(); 
    
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // prints <head>
        out.print("<html>\n<head>\n\n");
        out.print("<title>Truth Table</title>\n");
        out.print("</head>\n");

        out.print("<body>\n");
        out.print("<form method=\"post\"");

        out.print("<center><h2>Truth Table</h2></center>\n");
        out.print("<p>Given predicate: " + fname + "</p>");

//      String Nm = request.getParameter("predicate");

        out.println("<table border=\"1\" align=\"center\">");
        out.println("  <th>variables <th>true");

        // Enumeration headerNames = request.getHeaderNames();
        // while (headerNames.hasMoreElements()) {
        //     String headerName = (String) headerNames.nextElement();
        //     out.println(" <tr><td>" + headerName);
        //     out.println("     <td>" + request.getHeader (headerName) + "</tr>");
        // }
   
   
        out.println ("</table>");
        out.print("</body>\n");
        out.print("</html>\n");
        out.close ();

    }

}