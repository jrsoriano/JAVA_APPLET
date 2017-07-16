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
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class ConferenceHandler implements ActionListener, ItemListener, FocusListener
{
    /**
     * fields 
     */
    //storage variable containing the ConferenceGUI object
    protected ConferenceGUI gui;
  
    //string literals for text used in GUI elements
    private final String NO_NAME = "Please enter a name";
    private final String REG_ERROR1 = "Please select a registration type";
    private final String REG_ERROR2 = "Type Error";
    private final String NAME_ERROR1 = "Please enter a name";
    private final String NAME_ERROR2 = "Name Error";
    private final String REGTYPE1 = " is a ";
    private final String REGTYPE2 = " registration\n";
    private final String KEY_ATTEND = "Keynote address will be attended\n\n";
    private final String KEY_NO_ATTEND = "Keynote address will not be attended\n\n";
    private final String REGISTERED = " is registered in these workshops:\n";
    private final String TOTAL_CHARGES1 = "\nTotal charges for ";
    private final String TOTAL_CHARGES2 = " are ";
  
    //decimalFormat used to format the currency output in the JTextArea
    protected DecimalFormat currency = new DecimalFormat("$#,##0.00");
    
    /**
     * constructor
     */
    public ConferenceHandler(ConferenceGUI gui)
    {
        //sets the class level variable value to the value passed in as a parameter.
        this.gui = gui;
    }
    
    /**
     * action listener method
     */
    public void actionPerformed(ActionEvent e)
    {
        //storage variable for a string array that will contain the selected entries in the
        //workshops panel
        String[] selections;
      
        //storage variable for the running total cost
        double totalCost;
      
        //when an action is performed, this block checks to see if it was the calculate button
        if (e.getSource() == gui.calculateButton)
        {
            //this block checks to see if the selected index of the JComboBox is still 0
            //and if it is, prompts the user to select a registration type
            if (gui.regPanel.typesBox.getSelectedIndex() == 0)
            {
                JOptionPane.showMessageDialog(null,
                                              REG_ERROR1,
                                              REG_ERROR2,
                                              JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                if (gui.regPanel.checkKeynote.isSelected())
                {
                    gui.textArea.append(KEY_ATTEND);
                }
                else
                {
                    gui.textArea.append(KEY_NO_ATTEND);
                }
                gui.textArea.append(gui.regPanel.registrantName.getText() + REGISTERED);
              
                //gets the list of workshops selected and then stores them in the variable
                selections = gui.workshopPanel.getWorkshopList();
              
                //for every entry stored in the selections array
                for (int i = 0; i < selections.length; i++)
                {
                    //print the selection to the text area
                    gui.textArea.append(selections[i] + "\n");
                }
                totalCost = gui.regPanel.getKeyNoteCost() + gui.workshopPanel.getWorkshopCost()
                          + gui.regPanel.getRegistrantionCost();
              
                //prints a line presenting the total cost for the user in the text area.
                gui.textArea.append(TOTAL_CHARGES1 + gui.regPanel.registrantName.getText()
                                   + TOTAL_CHARGES2 + currency.format(totalCost));
            }
        }
      
        //when an action is performed, this block checks to see if it was the clear button
        if (e.getSource() == gui.clearButton)
        {
            //sets the registrant types back to the default
            gui.regPanel.typesBox.setSelectedIndex(0);
          
            //cleasrs all the selections on the workshop panel
            gui.workshopPanel.workshopListBox.clearSelection();
          
            //unchecks the keynote checkbox
            gui.regPanel.checkKeynote.setSelected(false);
          
            //empties the name field
            gui.regPanel.registrantName.setText("");
          
            //emptie the text area
            gui.textArea.setText("");
          
            //sets the focus to the name text field
            gui.regPanel.registrantName.requestFocus();
        }     
    }
    
    /**
     * item listener method
     */
    public void itemStateChanged(ItemEvent i)
    {
        //storage variable for the name taken from the name text field
        String name;
      
        //storage variable for the registration type string
        String selection;
        //if the user attemts to change the types box but hasn't entered a name yet
        if ( (i.getSource() == gui.regPanel.typesBox) &&
             (gui.regPanel.registrantName.getText().length() == 0) )
        {
            //sets the registrant types back to the default
            gui.regPanel.typesBox.setSelectedIndex(0);
               
            //brings the name field back into focus
            gui.regPanel.registrantName.requestFocus();
        }
            
        //checks to see if the source of the event was the typesBox and that the name has not been
        //left blank
        if ( (i.getSource() == gui.regPanel.typesBox) &&
             (gui.regPanel.registrantName.getText().length() != 0) )
        {
            //gets the name from the text field
            name = gui.regPanel.registrantName.getText();
          
            //gets the registration type selected
            selection = gui.regPanel.getRegType();
          
            //places the name and registration type into the text area
            gui.textArea.setText(name + REGTYPE1 + selection + REGTYPE2);
        }
    }
    
    /**
     * focus listener method 
     */
    public void focusLost(FocusEvent f)
    {
        //checks to make sure that the source of the event is txtName
        if (f.getSource() == gui.regPanel.registrantName)
        {
            //if the name feild is left blank, displays an error message using JOptionPane
            if (gui.regPanel.registrantName.getText().length() == 0)
            {
                JOptionPane.showMessageDialog(null,
                                              NAME_ERROR1,
                                              NAME_ERROR2,
                                              JOptionPane.ERROR_MESSAGE);
                                            
                //brings the name field back into focus after the user presses OK
                gui.regPanel.registrantName.requestFocus();
            }
        }
      
    }
    
    public void focusGained(FocusEvent f)
    {
        //checks to make sure that the source of the event is txtName
        if (f.getSource() == gui.regPanel.registrantName)
        {
            //if it is, then select all of the text.
            gui.regPanel.registrantName.selectAll();
        }
    }
  
}
