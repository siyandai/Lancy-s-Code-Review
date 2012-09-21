/*
 * @author: Xiaodan Lan
 * Last Modified: September 21, 2012
 * 
 * This program determine if the input string is palindrome or not and perform the result to user. 
 * The input is taken into a form which contains a string entered from user
 * The form is sent to the server asynchronously.
 * The program then evaluate the text to see if it is a palindrome, only consider letters.
 * The result is sent back to the browser with judgement.
 */

package Distributed.System.Project1.Task3;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class performs palindrome evaluation on an entered string 
 * @author Lancy
 */
public class Palin extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Palin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Palin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String input = request.getParameter("stringText");
        boolean isPalindrome = true;

        //Change the input string to lower case and replace all non-letter character to be null character
        input = input.toLowerCase();
        input = input.replaceAll("[^\\p{Alpha}]", "");

        //loop over each character in the string, if they don't satisfy the requirment of palindrome, return false to isPalindrome
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
                isPalindrome = false;
                break;
            }
        }

        PrintWriter out = response.getWriter();
        
        // determine what type of device our user is, provide different DOCType for Android user
        String ua = request.getHeader("User-Agent");

        boolean mobile;
        String docType;
        
        // prepare the appropriate DOCTYPE for the view pages
        if (ua != null && ua.indexOf("Android") != -1) {
            mobile = true;
            docType = "<!DOCTYPE html PUBLIC \"-//WAPFORUM//DTD XHTML Mobile 1.0//EN\" \"http://www.wapforum.org/DTD/xhtml-mobile10.dtd\">";            
        } else {
            mobile = false;
            docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">";
        }

        String result;
        if (isPalindrome) {
            result = "It is a palindrome string!";
        } else {
            result = "It is not a palindrome string!";
        }

        out.println(
                docType
                + "<HTML>\n"
                + "<HEAD><TITLE>Palindrome string Result</TITLE></HEAD>\n"
                + "<BODY>\n"
                + "<P>Result: " + result + "</P>\n"
                + "</BODY></HTML>");
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
