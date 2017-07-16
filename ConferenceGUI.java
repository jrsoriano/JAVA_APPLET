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

public class ConferenceGUI extends JPanel
{
   /**
    * fields 
    */
    //storage variables for objects used to create the GUI
   protected JPanel titlePanel;
   protected RegPanel regPanel;
   protected WorkshopPanel workshopPanel;
   protected JPanel buttonPanel;
   protected JButton calculateButton;
   protected JButton clearButton;
   protected JTextArea textArea;
   protected JScrollPane scrollArea;
   protected JLabel title;
   protected Font titleFont;
   protected ConferenceHandler handler;

   protected JPanel conferencePanel;

   //string literals for text used in the GUI elements
   private final String TITLE = "Select Registration Options";
   private final String CALCULATE_CHARGES = "Calculate Charges";
   private final String CLEAR = "Clear";
   
   /**
    * constructor
    */
   public ConferenceGUI()
   {
       //instantiates required objects from other classes
       conferencePanel = new JPanel();
       regPanel = new RegPanel();
       workshopPanel = new WorkshopPanel();
       handler = new ConferenceHandler(this);
     
       //sets the gui layout to a border layout
       conferencePanel.setLayout(new BorderLayout());
     
       //builds the title panel and adds it to the north part of the GUI
       titlePanel = buildTitlePanel();
       conferencePanel.add(titlePanel, BorderLayout.NORTH);
     
       //adds the reg panel to the west part of the GUI
       conferencePanel.add(regPanel, BorderLayout.WEST);
     
       //adds the required listeners to the GUI using the handler
       regPanel.registrantName.addFocusListener(handler);
       regPanel.typesBox.addItemListener(handler);
       regPanel.checkKeynote.addItemListener(handler);
     
       //adds the workshop panel to the east part of the GUI
       conferencePanel.add(workshopPanel, BorderLayout.EAST);
     
       //builds a button panel and then adds to to the southern part of the GUI
       buttonPanel = buildButtonPanel();
       conferencePanel.add(buttonPanel, BorderLayout.SOUTH);
       add(conferencePanel);
   }
   
   private JPanel buildTitlePanel()
   {
       //variable for holding a temporary JPanel that will be returned
       JPanel titlePanel;
     
       //instantiate the titlePlanel
       titlePanel = new JPanel();
     
       //instantiate a JLabel for the title panel
       title = new JLabel(TITLE);
     
       //creates a font object
       titleFont = new Font("SansSerif", Font.BOLD, 18);
     
       //sets the font of the title text to the font that was created
       title.setFont(titleFont);
     
       //adds the title to the titlePanel
       titlePanel.add(title);
     
       //returns the title panel to the constructor
       return titlePanel;
   }
   
   private JPanel buildButtonPanel()
   {
       //variable for a temporary JPanel that will be returned.
       JPanel buttonPanel;
     
       //instantiates the buttonPanel
       buttonPanel = new JPanel();
     
       //sets its layout to a flow layout
       setLayout(new FlowLayout());
      
       //creates the calculate button and adds its Action Listener
       calculateButton = new JButton(CALCULATE_CHARGES);
       calculateButton.addActionListener(handler);
    
       //creates the clear button and adds its Action Listener
       clearButton = new JButton(CLEAR);
       clearButton.addActionListener(handler);
     
       //creates a text area that is 5 lines high and 30 chars wide
       textArea = new JTextArea(5, 30);
     
       //turns on line wrap for the text area
       textArea.setLineWrap(true);
       textArea.setWrapStyleWord(true);
     
       //creates a scroll area and places the textArea object inside it
       scrollArea = new JScrollPane(textArea);     
     
       //adds the calculate button to the button panel
       buttonPanel.add(calculateButton);
     
       //adds the clear button to the button panel
       buttonPanel.add(clearButton);
     
       //adds the scroll area to the button panel
       buttonPanel.add(scrollArea);
     
       //returns the buttonPanel to the constructor
       return buttonPanel;
   }
}