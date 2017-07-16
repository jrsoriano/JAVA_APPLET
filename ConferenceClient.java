/**
 * This application will calculate the registration fees for a business conference.
 * 
 * @author Jose R. Soriano
 * @version 1.9
 * 
 * Date Created: 02.28.2016
 * Last Update: 03.11.2016
**/

import java.awt.*;
import javax.swing.*;

public class ConferenceClient extends JApplet
{
    //variables containing the static height and width for the applet
    private final int WIDTH = 700;
    private final int HEIGHT = 250;
  
    //variable to store the ConferenceGUI object.
    private ConferenceGUI gui;
  
    //variable for the container
    private Container c;
  
    public void init()
    {
        //gets the container 
        getContentPane();
            
        //sets the size of the container window
        setSize(WIDTH, HEIGHT);
       
        //instantiates the ConferenceGUI object
        gui = new ConferenceGUI();
      
        //adds the ConferenceGUI object to the container
        add(gui);
      
        //makes the container visible
        setVisible(true);
    }
}