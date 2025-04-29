/**
 * @author Sinclair DeYoung
 * @version 1.1.01
 * @since 2025-04-08
 * This is the main class that runs the calculator application.
 */

// Importing necessary classes for GUI components
import java.awt.*;
import javax.swing.*;

public class CalcRun {
    /**
     * This class represents a simple calculator application.
     * It sets up the GUI components, including buttons and display.
     * This is the main method that initializes and runs the calculator application.
     * It uses GridBagLayout for flexible layout management and adds buttons for digits and operations.
     * The main method creates a JFrame, sets its properties, and adds components to it.
     * It also handles button clicks to perform calculations and update the display.
     * The calculator supports basic operations like addition, subtraction, multiplication, and division.
     * The display shows the current input and result of calculations.
     * The calculator can handle multiple operations and updates the display accordingly.
     */
    final private JPanel buttonPanel, specialButtonPanel; // Panel to hold calculator buttons
    final private JPanel mainPanel; // Main panel for the calculator
    final private JTextField display1, display2, display3; // Text field for displaying pressed buttons & calculations 
    private JTextField activeDisplay; // Variable to keep track of the active display
    private JLabel displayLabelOne; // Label for in between display1 and display 2
    final private JLabel diplayLabelTwo; // Label for in between display 2 and display 3
    private String operator; // Variable to store the current operator method picked
    private JComboBox<String> formulaSelector; // ComboBox for selecting operators (e.g., +, -, *, /)
    private static final int MAX_HIGHT = 800; // Constant for maximum height of the JFrame
    private static final int MAX_WIDTH = 600; // Constant for maximum width of the JFrame
    
    //private JButton[] numberButtons; // Array to hold number buttons (0-9)
    //private double result; // Variable to store the result of calculations
    //private boolean calculating; // Flag to indicate if a calculation is in progress
    
    /**
     * Constructor for CalcRun class that initializes the GUI components and sets up the calculator.
     * This constructor sets up the JFrame, initializes the display, creates buttons for digits and operations,
     * and adds action listeners to handle button clicks for performing calculations.
     * It also configures the layout of the GUI components and adds them to the JFrame.
     */
    public CalcRun(){

        // initualize and set up the JFrame for calculator

        // running the calc application
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(MAX_WIDTH, MAX_HIGHT);
        frame.setLayout(new BorderLayout()); // Set the layout manager for the frame

        // initualize the displays

        // initualize the display for display1 which will be used as num1 in the Calculator class call
        display1 = new JTextField(); // Create a text field for displaying calculations
        display1.setEditable(false); // Make the display non-editable
        display1.setFont(new Font("Arial", Font.PLAIN, 15)); // Set font for the display
        display1.setHorizontalAlignment(SwingConstants.RIGHT); // Align text to the right
        // initualize the display for display2 which will be used as num1 in the Calculator class call
        display2 = new JTextField(); // Create a text field for displaying calculations
        display2.setEditable(false); // Make the display non-editable
        display2.setFont(new Font("Arial", Font.PLAIN, 15)); // Set font for the display
        display2.setHorizontalAlignment(SwingConstants.RIGHT); // Align text to the right
        // initualize the display for display3 which will be used as num1 in the Calculator class call
        display3 = new JTextField(); // Create a text field for displaying calculations
        display3.setEditable(false); // Make the display non-editable
        display3.setFont(new Font("Arial", Font.PLAIN, 15)); // Set font for the display
        display3.setHorizontalAlignment(SwingConstants.RIGHT); // Align text to the right

        // setting the display to be focused on display1
        activeDisplay = display1; // Set the active display to display1
        display2.setBackground(Color.LIGHT_GRAY); // Set background color to light gray
        display3.setBackground(Color.LIGHT_GRAY); // Set background color to light gray

        // initialize the forula panel
        mainPanel = new JPanel(); 
        mainPanel.setLayout(new BorderLayout()); // Set the layout manager for the formula panel
        mainPanel.setBorder(BorderFactory.createTitledBorder("Formula's")); // Add a border with title

        // Initialize the label for displayLabelOne
        displayLabelOne = new JLabel("+"); // Default operator label
        // Create a JComboBox for selecting formulas
        
        String[] formulas = {
            // Array of formulas for the JComboBox
            "Addition (+)",
            "Subtraction (-)",
            "Multiplication (*)",
            "Division (/)",
            "Modulus (%)"
        }; // Array of formulas for the JComboBox
        formulaSelector = new JComboBox<>(formulas); // Create a JComboBox for selecting formulas
        formulaSelector.addActionListener(e -> {

            display1.setText(""); // Clear the display when a new formula is selected
            display2.setText(""); // Clear the display when a new formula is selected
            display3.setText(""); // Clear the display when a new formula is selected
            
            // Get the selected operator to add a JLabel in between the displays
            try {
                // get the selected operator from the JComboBox
                String labelSelectedFormula = (String) formulaSelector.getSelectedItem();

                // Set the operator based on the selected formula
                operator = switch (labelSelectedFormula) {
                    case "Addition (+)" -> "+";
                    case "Subtraction (-)" -> "-";
                    case "Multiplication (*)" -> "*";
                    case "Division (/)" -> "/";
                    case "Modulus (%)" -> "%";
                    default -> throw new IllegalArgumentException("Invalid operator selected");
                };
                displayLabelOne.setText(operator); // Set the label for display1

                // reaclidate and repaint based on the operator selected
                mainPanel.revalidate();
                mainPanel.repaint();
            } catch (NullPointerException ex) {
                operator = "+"; // Default to addition if no selection is made
                displayLabelOne.setText(operator);
            }
        });

        mainPanel.add(formulaSelector, BorderLayout.NORTH); // Add the JComboBox to the main panel

        // Add displays to the main panel

        diplayLabelTwo = new JLabel("="); // Create a label for display2
        
/** 
        // Add displays to the main panel using a gridlayout
        JPanel displayPanel = new JPanel(new GridLayout(1, 3, 5, 5)); // Create a panel for the displays
        displayPanel.add(display1); // Add display1 to the display panel
        displayPanel.add(displayLabelOne); // Add label between display1 and display2
        displayPanel.add(display2); // Add display2 to the display panel
        displayPanel.add(diplayLabelTwo); // Add label between display2 and display3
        displayPanel.add(display3); // Add display3 to the display panel
        mainPanel.add(displayPanel, BorderLayout.CENTER); // Add the display panel to the main panel
*/
/**
        // Add displays to the main panel using a gridbaglayout
        // Create a panel for the displays using GridBagLayout
        JPanel displayPanel = new JPanel(new GridBagLayout()); // Create a panel for the displays
        GridBagConstraints gbc = new GridBagConstraints(); // Create a GridBagConstraints object for layout management
        gbc.fill = GridBagConstraints.HORIZONTAL; // Fill horizontally
        gbc.insets = new Insets(5,5,5,5); // Set insets for spacing between components
        gbc.anchor = GridBagConstraints.CENTER; // Center the components in the grid cell
        gbc.weightx = 1.0; // Set weight for horizontal resizing
        gbc.weighty = 0.0; // Set weight for vertical resizing
        gbc.gridheight = 1; // Set grid height to 1 for each component

        // Visual Debugging
        display1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        displayLabelOne.setBorder(BorderFactory.createLineBorder(Color.RED));
        display2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        diplayLabelTwo.setBorder(BorderFactory.createLineBorder(Color.RED));
        display3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        // add display 1
        gbc.gridwidth = 3; // Set grid width to 1 for each component
        gbc.gridx = 0; // Set the grid x position for display1
        gbc.gridy = 0; // Set the grid y position for display1
        displayPanel.add(display1, gbc); // Add display1 to the display panel
        
        // add display label one
        gbc.gridwidth = 1; // Reset grid width to 1 for the next components
        gbc.gridx = 3; // Set the grid x position for displayLabelOne
        gbc.gridy = 0; // Set the grid y position for displayLabelOne
        displayPanel.add(displayLabelOne, gbc); // Add label between display1 and display2
        
        // add display 2
        gbc.gridwidth = 3; // Reset grid width to 1 for the next components
        gbc.gridx = 4; // Set the grid x position for display2
        gbc.gridy = 0; // Set the grid y position for display2
        displayPanel.add(display2, gbc); // Add display2 to the display panel
        
        // add display label two
        gbc.gridwidth = 1; // Reset grid width to 1 for the next components
        gbc.gridx = 7; // Set the grid x position for diplayLabelTwo
        gbc.gridy = 0; // Set the grid y position for diplayLabelTwo
        displayPanel.add(diplayLabelTwo, gbc); // Add label between display2 and display3
        
        // add display 3
        gbc.gridwidth = 3; // Reset grid width to 1 for the next components
        gbc.gridx = 8; // Set the grid x position for display3
        gbc.gridy = 0; // Set the grid y position for display3
        displayPanel.add(display3, gbc); // Add display3 to the display panel
        mainPanel.add(displayPanel, BorderLayout.CENTER); // Add the display panel to the main panel
        */

        // Add displays to the main panel using a FlowLayout
        JPanel displayPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Create a panel for the displays
        displayPanel.setBorder(BorderFactory.createEmptyBorder(2, 10, 2, 10)); // Add empty border for spacing

        // Visual Debugging
        display1.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Set border for display1
        displayLabelOne.setBorder(BorderFactory.createLineBorder(Color.RED)); // Set border for displayLabelOne
        display2.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Set border for display2
        diplayLabelTwo.setBorder(BorderFactory.createLineBorder(Color.RED)); // Set border for diplayLabelTwo
        display3.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Set border for display3

        // Component stretching
        display1.setPreferredSize(new Dimension(150, 30)); // Set a fixed size for display1
        display2.setPreferredSize(new Dimension(150, 30)); // Set a fixed size for display2
        display3.setPreferredSize(new Dimension(150, 30)); // Set a fixed size for display3

        // Add display1 to the display panel
        displayPanel.add(display1); // Add display1 to the display panel
        displayPanel.add(displayLabelOne); // Add label between display1 and display2
        displayPanel.add(display2); // Add display2 to the display panel
        displayPanel.add(diplayLabelTwo); // Add label between display2 and display3
        displayPanel.add(display3); // Add display3 to the display panel

        // Add the display panel to the main panel
        mainPanel.add(displayPanel, BorderLayout.CENTER); // Add the display panel to the main panel
        

        // initualize the button panels

        // Create button panel's for the calculator buttons
        buttonPanel = new JPanel(new GridLayout(4, 4, 8, 10)); // Create a panel for the calculator buttons
        specialButtonPanel = new JPanel(new GridLayout(4, 4, 8, 10)); // Create a panel for special buttons

        // Create buttons for digits and special buttons
        
        JButton[] numberButtons = new JButton[10]; // Array to hold number buttons (0-9)
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i)); // Create buttons for digits 0-9
            int finalI = i; // Final variable for lambda expression
            numberButtons[i].addActionListener(e -> {
                // Append the digit to the active display
                activeDisplay.setText(activeDisplay.getText() + finalI); // Append digit to display1
            });
            buttonPanel.add(numberButtons[i]); // Add button to the panel
        }

        JButton dotButton = new JButton("."); // Create a dot button
        dotButton.addActionListener(e -> {
            // Append the dot to the active display
            if (!activeDisplay.getText().contains(".")) { // Check if dot is already present
                activeDisplay.setText(activeDisplay.getText() + "."); // Append dot to active display
            }
        });
        buttonPanel.add(dotButton); // Add dot button to the panel

        JButton equalsButton = new JButton("="); // Create an equals button
        equalsButton.addActionListener(e -> {
            equalsButton.setBackground(Color.LIGHT_GRAY);// Set background color to light grey
            // equalsButton.setOpaque(true); // Make the button opaque allowing the color to show
            // equalsButton.setBorderPainted(false); // Remove border from the button
            
            // preform calculation (basic implementation)
            try {
                // get the numbers from the display
                float num1 = Float.parseFloat(display1.getText()); // Parse the first number
                float num2 = Float.parseFloat(display2.getText()); // Parse the second number

                // Get the selected operator
                String selectedFormula = (String) formulaSelector.getSelectedItem();
                operator = switch (selectedFormula) {
                    case "Addition (+)" -> "+";
                    case "Subtraction (-)" -> "-";
                    case "Multiplication (*)" -> "*";
                    case "Division (/)" -> "/";
                    case "Modulus (%)" -> "%";
                    default -> throw new IllegalArgumentException("Invalid operator selected");
                };
                // get the operator from the formulaSelector
                double result = switch (operator) { // Perform calculation based on the operator
                    case "+" -> Calculator.add(num1, num2); // Addition
                    case "-" -> Calculator.subtract(num1, num2); // Subtraction
                    case "/" -> Calculator.divide(num1, num2); // Division with check for zero
                    case "*" -> Calculator.multiply(num1, num2); // Multiplication
                    case "%" -> num1 % num2; // Modulus
                    default -> 0; // Default case
                };

                // format the result to 2 decimal places
                String formattedResult = String.format("%.6f", result); // Format the result to 2 decimal places
                // set the result to display3
                display3.setText(String.valueOf(formattedResult)); // Set the display to the result of the calculation
                display3.setBackground(Color.WHITE); // Set background color to white
                
            } catch (NumberFormatException | NullPointerException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid Input Error: " + ex); // Display error if calculation fails
            } catch (ArithmeticException ex) {
                JOptionPane.showMessageDialog(frame, "Math Error: " + ex); // Display error if calculation fails
            }
        });
        buttonPanel.add(equalsButton); // Add equals button to the panel

        // add a clear button to reset the calculator
        JButton clearButton = new JButton("C"); // Create a clear button
        clearButton.addActionListener(e -> {
            display1.setText(""); // Clear the display when the button is clicked
            display2.setText(""); // Clear the display when the button is clicked
            display3.setText(""); // Clear the display when the button is clicked
            display3.setBackground(Color.LIGHT_GRAY); // Set background color to light gray
        });
        specialButtonPanel.add(clearButton); // Add clear button to the panel

        // add a button to switch between displays
        JButton switchButton = new JButton("<--->"); // Create a switch button
        switchButton.addActionListener(e -> {
            // Switch the active display between display1 and display2
            if (activeDisplay == display1) {
                activeDisplay = display2; // Switch to display2
                display2.setBackground(Color.WHITE); // Set background color to white
                display1.setBackground(Color.LIGHT_GRAY); // Set background color to yellow
            } else {
                activeDisplay = display1; // Switch to display1
                display1.setBackground(Color.WHITE); // Set background color to white
                display2.setBackground(Color.LIGHT_GRAY); // Set background color to yellow
            }
        });
        specialButtonPanel.add(switchButton); // Add switch button to the panel

        // customization of buttons, labels, and panels

        // add the panels to the frame

        // add panel to the frame
        frame.add(mainPanel, BorderLayout.NORTH); // Add the main panel to the frame
        frame.add(buttonPanel, BorderLayout.CENTER); // Add the button panel to the frame
        frame.add(specialButtonPanel, BorderLayout.EAST); // Add the button panel to the frame

        // revalidate and repaint the frame
        frame.revalidate(); // Revalidate the frame to update the layout
        frame.repaint(); // Repaint the frame to update the display

        //finalize and display the frame
        frame.pack(); // Pack the frame to fit the components
        frame.setVisible(true); // Make the frame visible
        frame.setLocationRelativeTo(null); // Center the frame on the screen
    } // End of constructor

    public static void main(String[] args) {
        /**
         * This is the entry point for the calculator application.
         * It creates an instance of the CalcRun class to initialize and display the calculator GUI.
         */
        SwingUtilities.invokeLater(() -> new CalcRun());// Create an instance of CalcRun to initialize the GUI
    }
}