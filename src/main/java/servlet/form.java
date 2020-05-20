import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;
import java.lang.*;

@WebServlet(name = "form", urlPatterns = {"/form"})
public class form extends HttpServlet {
    
 
    
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

    //String fname = request.getParameter("fname");

    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
        response.setContentType("text/html");
        PrintWriter out = response.getWriter(); 
        String s = request.getParameter("input");
//ArrayList s = request.getParameter("input");
        String[] data = s.split(" ");

        /* examples:
         * A OR B
         * x && y
         * M and N or Q
         * today | tomorrow
         */
        String[] variables = new String[data.length];
        String[] operators = new String[data.length];
        String[] or = {"or", "OR", "|"};
        String[] and = {"and", "AND", "&&"};

        int count1 = 0;
        int count2 = 0;
        int andop;

        for (int num = 0; num < data.length; num++) {
            // if even, index (therefore variable)
            if (num % 2 == 0) 
                variables[count1++] = data[num];

            // else, operator
            else 
                operators[count2++] = data[num];
        }

        if (or.contains(operator[0]))
            andop = 0;

        else if (and.contains(operator[0]))
            andop = 1;

        else
            out.print("invalid input");
    



        out.close();
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
//        out.print("<p>Given predicate: " + fname + "</p>");

//      String Nm = request.getParameter("predicate");

        out.println("<table width=\"50%\" border=\"1\" align=\"center\">");

        for (int a : count1)
                out.println("<th> " + variables[a] + "");

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