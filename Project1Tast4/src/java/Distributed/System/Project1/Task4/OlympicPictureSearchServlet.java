/*
 * @author: Xiaodan Lan
 * Last Modified: September 21, 2012
 * 
 * This program simulates the Olympic.org picture search engine, returning a picture of the athletes playing the sports
 * The input is taken into a form which contains the player's name from user
 * The input also contains a choice of sports type that user what to search from.
 * The form and the value is sent to the server asynchronously.
 * The program then search the Olympic.org for the picture of the athletes playing the sports
 * The result is sent to a jsp page with the picture or the error message of not finding the picture.
 */

package Distributed.System.Project1.Task4;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class searches picture of an athlete playing a sport on Olympic.org
 * @author Lancy
 */

@WebServlet(name = "OlympicPictureSearchServlet", urlPatterns = {"/OlympicPictureSearchServlet"})
public class OlympicPictureSearchServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
   
    OlympicPictureSearchModel ops = null;

    /**
     * Override init method to create an instance of OlympicPictureSearchModel object
     */
    @Override
    public void init() {
        ops = new OlympicPictureSearchModel();
    }
    
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
        String sportsAthlete = request.getParameter("search");
        String sports = request.getParameter("sportsCategory");
        
        //Determine whether user hasn't select any sports, if yes, do nothing; if no, then search the Olympic.org for picture and return picture
        if (sports == null || sports.equals("noSelection")) {

            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        }
        else {
            //Search for the picture of the (sportsAthlete) playing the (sports) and get the relevant data
            ops.doOlympicPictureSearch(sportsAthlete, sports);
            request.setAttribute("pictureURL", ops.getPictureURL());
            request.setAttribute("sportName", ops.getSportsName(ops.getPictureTag()));
            request.setAttribute("isConnected", ops.getIsConnected());
            //Dispatch the result picture and data to result.jsp
            RequestDispatcher view = request.getRequestDispatcher("result.jsp");
            view.forward(request, response);
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
