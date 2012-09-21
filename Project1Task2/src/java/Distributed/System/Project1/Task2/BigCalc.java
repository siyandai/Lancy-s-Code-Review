/*
 * @author: Xiaodan Lan
 * Last Modified: September 21, 2012
 * 
 * This program creates a calculator conducting several math operations for big integers.
 * The input is taken into a form which contains two integers X and Y entered from user
 * The input also contains a choice of operation that user what to calculate.
 * The form and the value is sent to the server asynchronously.
 * The program then calculate the result based on X and Y and the math operation type.
 * The result is sent back to the browser with numerical value or error messages if the inputs are not correct.
 */

package Distributed.System.Project1.Task2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import required for calculating big integers
import java.math.BigInteger;

/**
 * This class performs calculation on Big Integer with several math operations 
 * @author Lancy
 */
public class BigCalc extends HttpServlet {

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

        PrintWriter out = response.getWriter();

        try {
            String inputX = request.getParameter("integerX");
            String inputY = request.getParameter("integerY");
            String operationType = request.getParameter("operationType");
            
            //Create BigInteger object based on the input value
            BigInteger x = new BigInteger(inputX);
            BigInteger y = new BigInteger(inputY);

            BigInteger result = null;
            String responseHtml = null;
            
            //Determine the type of math operation and calculate accordingly
            if (operationType.equals("relativePrime")) {
                result = x.gcd(y);
                //Determine whether X and Y have common divisor or not
                if (result.equals(BigInteger.ONE)) {
                    String component = String.format("%s and %s is relatively prime", x.toString(), y.toString());
                    responseHtml = getResponseHtml(component);
                } else {
                    String component = String.format("%s and %s is not relatively prime", x.toString(), y.toString());
                    //Parse the calculation result to generate html
                    responseHtml = getResponseHtml(component);
                }
            } else {
                if (operationType.equals("add")) {
                    result = x.add(y);
                } else if (operationType.equals("multiply")) {
                    result = x.multiply(y);
                } else if (operationType.equals("mod")) {
                    result = x.mod(y);
                } else if (operationType.equals("modInverse")) {
                    result = x.modInverse(y);
                } else if (operationType.equals("power")) {
                    result = x.pow(y.intValue());
                }
                //Parse the calculation result to generate html
                responseHtml = getResponseHtml(result.toString());
            }
            out.println(responseHtml);
        } catch (NumberFormatException e) {
            //Catch the exception and show the error that non-numeric X and Y are entered
            String responses = "Error: please input numeric value.";
            out.println(responses);
        } catch (ArithmeticException e) {
            //Catch the exception and show the error that mathmatical errors occur
            String responses = "Error: " + e.getMessage();
            out.println(responses);
        }

    }

    /**
     * Generate html based on the calculation result
     * @param result
     * @return a string format of html code
     */
    private String getResponseHtml(String result) {

        String docType = "<!DOCTYPE HTML PUBLIC \"//W3C//DTD HTML 4.0 ";
        docType += "Transitional//EN\">\n";

        return (docType
                + "<HTML>\n"
                + "<HEAD><TITLE>Calculator Result</TITLE></HEAD>\n"
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
