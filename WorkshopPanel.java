/**
 * Assignment 2 GUI Applications - Business conference registration app. 
 * This application will calculate the registration fees for a business conference.
 * 
 * @author Jose R. Soriano
 * @version 1.9
 * 
 * Assignment: #2
 * Course: ADEV-1001 (OPEN) Programming (Java 2)
 * Section: Online
 * Date Created: 02.28.2016
 * Last Update: 03.11.2016
**/

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class WorkshopPanel extends JPanel
{
    /**
     * fields 
     */
    //final variables to contain cost of each workshop
    private final double COST_IT_TRENDS = 295.00;
    private final double COST_DREAM_CAREER = 295.00;
    private final double COST_ADVANCED_JAVA = 395.00;
    private final double COST_ETHICS = 395.00;
    
    //workshop cost assembled as an array
    private final double [] WORKSHOP_FEES = {COST_IT_TRENDS,
                                             COST_DREAM_CAREER,
                                             COST_ADVANCED_JAVA,
                                             COST_ETHICS};
    
    //array containing strings for use in JList
    private final String[] WORKSHOP_NAMES ={"IT Trends in Manitoba",
                                            "Creating a Dream Career",
                                            "Advanced Java Programming",
                                            "Ethics: The Challenge Continues"};
   
    //store variables for JList
    protected JList<String> workshopListBox;
    
    //String literal used in the creation of the panel
    private final String BORDER = "Workshops";
    /**
     * constructor
     */
    public WorkshopPanel()
    {
        //sets the flowlayout
        setLayout(new FlowLayout());
        
        //creates the workshopListBox JList using the WORKSHOP_NAMES array
        workshopListBox = new JList<String>(WORKSHOP_NAMES);
        
        //allows more than one item to selected
        workshopListBox.setSelectionMode(2);
        
        //puts a border around the box
        setBorder(BorderFactory.createTitledBorder(BORDER));
        
        //adds the workshopListBox to where its called
        add(workshopListBox);
    }
    
    /**
     * methods
     */
    public double getWorkshopCost()
    {
        //integer array containing all the selected idex items orm the workshopListBox
        int[] selectedIndices = workshopListBox.getSelectedIndices();
        
        //store variables for the totalWorkshopCost
        double totalWorkshopCost = 0.0;
        
        //for every value in the selectedIndicies array, use the index to retrieve
        //the cost form the WORKSHOP_FEES array, then add to the current value
        for(int i =0; i < selectedIndices.length; i++)
        {
            totalWorkshopCost += WORKSHOP_FEES[selectedIndices[i]];
        }
        
        //return the totalWorkshopCost
        return totalWorkshopCost;
    }
    
    public String[] getWorkshopList()
    {
        //integer array containing all of the slected index items from 
        //workshopListBox
        int[] selectedIndices = workshopListBox.getSelectedIndices();
        String[] selectedNames = new String[selectedIndices.length];
        
        for(int i = 0; i < selectedIndices.length; i++)
        {
            selectedNames[i] = WORKSHOP_NAMES[selectedIndices[i]];
        }
        
        //return the selectedNames
        return selectedNames;
    }
    
    
     
}
