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
import java.awt.event.*;
import javax.swing.*;

public class RegPanel extends JPanel
{
    /**
     * fields
     */
    //final variables containing the cost of each registration type
    private final double BUSINESS_REG = 895.00;
    private final double STUDENT_REG = 495.00;
    private final double COMPLEMENT_REG = 0.00;
  
    //final variable containing the cost of the dinner keynote speech
    private final double DINNER_KEYNOTE_SPEECH = 30.00;
  
    //registrant costs assembled as an array.
    private final double[] REGISTRANT_COSTS = {BUSINESS_REG,
                                               STUDENT_REG,
                                               COMPLEMENT_REG};
  
    //string array used in the creation of the JComboBox
    private final String[] REGISTRANT_TYPES = {"Please select a type",
                                               "Business",
                                               "Student",
                                               "Complimentary"};
  
    //storage variables for objects used to create the registrant panel object
    protected JPanel registrantPanel;
    protected JPanel dinnerKeynotePanel;
    protected JTextField registrantName;
    protected JComboBox<String> typesBox;
    protected JCheckBox checkKeynote;
  
    //string literals for text used in the GUI elements
    private final String DINNER_CHECK = "Dinner and Keynote Speech";
    private final String BORDER = "Registrant's Name & Type";
    
    /**
     * constructor
     */
  
    public RegPanel()
    {
        //sets the layout to a 2x1 grid layout
        this.setLayout(new GridLayout(2,1));
      
        //builds the registrantPanel and then adds it to the RegPanel
        registrantPanel = buildRegistrantPanel();
        add(registrantPanel);
      
        //builds the dinnerKeynotePanel and then adds it to the Regpanel
        dinnerKeynotePanel = buildDinnerKeynotePanel();
        add(dinnerKeynotePanel);      
    }
  
    private JPanel buildRegistrantPanel()
    {
        //variable for temporary registrantJPanel that will be returned
        JPanel registrantPanel;
      
        //instantiates the registrantPanel
        registrantPanel = new JPanel();
      
        //sets its layout to a flow layout
        registrantPanel.setLayout(new FlowLayout());
      
        //adds a border around it
        registrantPanel.setBorder(BorderFactory.createTitledBorder(BORDER));
      
        //creates the JTextField used for the registrants name
        registrantName = new JTextField(20);
      
        //creates the JComboBox for registrant types
        typesBox = new JComboBox<String>(REGISTRANT_TYPES);
       
        //adds the name box and registrant types to the registrant panel
        registrantPanel.add(registrantName);
        registrantPanel.add(typesBox);
      
        //returns the registrantPanel
        return registrantPanel;
    }
  
    private JPanel buildDinnerKeynotePanel()
    {
        //variable for temporary dinnerKeynotePanel that will be returned
        JPanel dinnerKeynotePanel;
      
        //instantiates the dinnerKeynotePanel
        dinnerKeynotePanel = new JPanel();
      
        //sets its layout to a flow layout
        dinnerKeynotePanel.setLayout(new FlowLayout());
      
        //creates the chkKeynote JCheckBox
        checkKeynote = new JCheckBox(DINNER_CHECK);
      
        //adds the chkKeynote JCheckBox to the dinnerKeynotePanel
        dinnerKeynotePanel.add(checkKeynote);
      
        //returns the dinnerKeynotePanel
        return dinnerKeynotePanel;
    }
    
    /**
     * methods 
     */
    public double getRegistrantionCost()
    {
        //storage variable for the registrantCost
        double registrantCost = 0;
      
        //storage variable for the index, had to be defaulted to 0
        int index = 0;
      
        switch (typesBox.getSelectedIndex())
        {
            case 1: index = 0;
                    break;
                  
            case 2: index = 1;
                    break;
                  
            case 3: index = 2;
                    break;
                  
        }
      
        //Finds the value of the selected index from the REGISTRANT_COSTS array and places it into
        //the registrantCost variable
        registrantCost = REGISTRANT_COSTS[index];
      
        //returns the registrantCost
        return registrantCost;      
    }
  
    public double getKeyNoteCost()
    {
        //storage variable for the keynoteCost. Defaulted to zero and is only modified when the if
        //statment is entered.
        double keynoteCost = 0;
      
        if (checkKeynote.isSelected())
        {
            //sets the keynoteCost to the value in DINNER_KEYNOTE_SPEECH if the chkKeynote
            //JCheckBox is selected
            keynoteCost = DINNER_KEYNOTE_SPEECH;
        }
      
        //returns the keynoteCost
        return keynoteCost;      
    }
  
    public String getRegType()
    {
        //storage variable for the string returned by the .toString call
        String selection;
      
        //sets selection to the value returned by calling the typesBox .toString method
        selection = typesBox.getSelectedItem().toString();
      
        //returns selection
        return selection;
    }
}

