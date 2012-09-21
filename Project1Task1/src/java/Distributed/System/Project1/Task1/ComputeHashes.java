/*
 * Author: Xiaodan Lan
 * Last Modified: September 21, 2012
 * 
 * This program computes the hexadecimal and base64 representation of the user input text.
 * The input is taken into a form which contains a string entered from user
 * The input also contains a choice of has function that user what to perform.
 * The form and the value is sent to the server asynchronously.
 * The program then transform the string into hexadecimal and base64 notation based on the has function the user chose.
 * The result is sent back to the browser with transformed text.
 */
package Distributed.System.Project1.Task1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
//imports required for hexadecimal text transform
import sun.misc.BASE64Encoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * This class is used to perform hexadecimal transformation of input text
 * @author Lancy
 */
public class ComputeHashes extends HttpServlet {

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
            out.println("<title>Servlet ComputeHashes</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ComputeHashes at " + request.getContextPath() + "</h1>");
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
        
        String inputText = request.getParameter("stringText");
        String hashFunction = request.getParameter("hashFunction");
        
        try {
            //Create a MessageDigest object that implements the hash function user choose
            MessageDigest messageDigest = MessageDigest.getInstance(hashFunction);
            //Transform the user input text into byte array
            byte[] hashBytes = messageDigest.digest(inputText.getBytes());
            //Get hexadecimal text and base64Encode from the byte array
            String hexadecimalText = getHexString(hashBytes);
            String base64EncodedText = new BASE64Encoder().encode(hashBytes);

            response.setContentType("text/html");

            PrintWriter out = response.getWriter();

            String docType = "<!DOCTYPE HTML PUBLIC \"//W3C//DTD HTML 4.0 ";
            docType += "Transitional//EN\">\n";

            //Generate html to browser
            out.println(docType
                    + "<HTML>\n"
                    + "<HEAD><TITLE>" + inputText + "</TITLE></HEAD>\n"
                    + "<BODY>\n"
                    + "<H1> Hashes of string \"" + inputText + "\": </H1>\n"
                    + "<P>" + hashFunction + " (HEX): " + hexadecimalText + "</P>\n"
                    + "<P>" + hashFunction + " (Base 64): " + base64EncodedText + "</P>\n"
                    + "</BODY></HTML>");
        } catch (Exception ex) {
            Logger.getLogger(ComputeHashes.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    /**
     * Transform bytes into hexadecimal text
     * @param b the bytes of input text by user
     * @return the string of hexadecimal value
     * @throws Exception 
     */
    private String getHexString(byte[] b) throws Exception {
        String result = "";
        for (int i = 0; i < b.length; i++) {
            result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
        }
        return result;
    }
}
