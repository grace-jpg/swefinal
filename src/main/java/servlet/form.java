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
      
        
        String input = request.getParameter("input");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter(); 
        printhead(out);

        //ArrayList s = request.getParameter("input");
        String[] data = input.split(" ");

        /* examples:
         * A OR B
         * x && y
         * M and N or Q
         * today | tomorrow
         */

        ArrayList <String> variables;
        ArrayList <String> operators;
        // String[] variables = new String[data.length];
        // String[] operators = new String[data.length];
        String[] or = {"or", "OR", "|"};
        String[] and = {"and", "AND", "&&"};

        int count1 = 0;
        int count2 = 0;

        for (int num = 0; num < data.length; num++) {
            // if even, index (therefore variable)
            if (num % 2 == 0) 
                variables.set(count1++, data[num]);

            // else, operator
            else 
                operators.set(count2++, data[num]);
        }

        // if (or.contains(operator[0]))
        //     andop = 0;

        // else if (and.contains(operator[0]))
        //     andop = 1;

        // else
        //     out.print("invalid input");
    
        printtable(variables, operators);

        out.print("</html>");
        out.close();
    }




    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        printhead(out);
        
        out.print("<p>please enter a boolean predicate that has boolean variables </p>");
        out.print("<p> and logical operators: </p>");

        String input = request.getParameter("input");

        // prints <head>
    
        printhead(out);
        out.print("<body>\n");
        out.print("<form method=\"post\"");

        out.print("<center><h2>Truth Table</h2></center>\n");
//      out.print("<p>Given predicate: " + fname + "</p>");

        out.println("<table width=\"50%\" border=\"1\" align=\"center\">");

        for (int a : count1)
                out.println("<th> " + variables[a] + "");   
   
        out.println ("</table>");
        out.print("</body>\n");

 
        out.print("</html>");
        out.close ();
    }

    public void printtable (ArrayList <String> variables, ArrayList <String> operators) {

    }

    public void printhead (Printwriter out) {
        out.print("<html>\n<head>\n\n");
        out.print("<title>Truth Table</title>\n");
        out.print("</head>\n");
    }


}