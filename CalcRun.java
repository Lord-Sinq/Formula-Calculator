/**
 * @author Sinclair DeYoung
 * @version 1.0
 * @since 2023-10-01
 * This is the main class that runs the calculator application.
 */

// Importing necessary classes for GUI components
import java.awt.*;
import javax.swing.*;

public class CalcRun {
    /**
     * This class represents a simple calculator application.
     * This is the main method that initializes and runs the calculator application.
     * It sets up the GUI components, including buttons and display.
     * It uses GridBagLayout for flexible layout management and adds buttons for digits and operations.
     * The main method creates a JFrame, sets its properties, and adds components to it.
     * It also handles button clicks to perform calculations and update the display.
     * The calculator supports basic operations like addition, subtraction, multiplication, and division.
     * The display shows the current input and result of calculations.
     * The calculator can handle multiple operations and updates the display accordingly.
     */
    private JPanel buttonPanel; // Panel to hold calculator buttons
    private JPanel mainPanel; // Main panel for the calculator
    private JButton[] numberButtons; // Array to hold number buttons (0-9)
    private JTextField display1, display2, display3; // Text field for displaying calculations
    private JTextField activeDisplay; // Variable to keep track of the active display
    private double result; // Variable to store the result of calculations
    private String operator; // Variable to store the current operator
    private boolean calculating; // Flag to indicate if a calculation is in progress
    private JComboBox<String> formulaSelector; // ComboBox for selecting operators (e.g., +, -, *, /)
    private static final int MAX_HIGHT = 600; // Constant for maximum height of the JFrame
    private static final int MAX_WIDTH = 375; // Constant for maximum width of the JFrame
    
    /**
     * Constructor for CalcRun class that initializes the GUI components and sets up the calculator.
     * This constructor sets up the JFrame, initializes the display, creates buttons for digits and operations,
     * and adds action listeners to handle button clicks for performing calculations.
     * It also configures the layout of the GUI components and adds them to the JFrame.
     */
    public CalcRun(){
        // running the calc application
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(MAX_WIDTH, MAX_HIGHT);
        frame.setLayout(new BorderLayout()); // Set the layout manager for the frame

        // initualize the display for display1 which will be used as num1 in the Calculator class call
        display1 = new JTextField(); // Create a text field for displaying calculations
        display1.setEditable(true); // Make the display non-editable
        display1.setFont(new Font("Arial", Font.PLAIN, 19)); // Set font for the display
        display1.setHorizontalAlignment(SwingConstants.RIGHT); // Align text to the right
        // initualize the display for display2 which will be used as num1 in the Calculator class call
        display2 = new JTextField(); // Create a text field for displaying calculations
        display2.setEditable(true); // Make the display non-editable
        display2.setFont(new Font("Arial", Font.PLAIN, 19)); // Set font for the display
        display2.setHorizontalAlignment(SwingConstants.RIGHT); // Align text to the right
        // initualize the display for display3 which will be used as num1 in the Calculator class call
        display3 = new JTextField(); // Create a text field for displaying calculations
        display3.setEditable(false); // Make the display non-editable
        display3.setFont(new Font("Arial", Font.PLAIN, 19)); // Set font for the display
        display3.setHorizontalAlignment(SwingConstants.RIGHT); // Align text to the right\

        // setting the display to be focused on display1
        activeDisplay = display1; // Set the active display to display1
        display2.setBackground(Color.LIGHT_GRAY); // Set background color to light gray

        // initialize the forula panel
        mainPanel = new JPanel(); 
        mainPanel.setLayout(new BorderLayout()); // Set the layout manager for the formula panel
        mainPanel.setBorder(BorderFactory.createTitledBorder("Formula's")); // Add a border with title
        
        String[] formulas = {
            // Array of formulas for the JComboBox
            "Addition (+)",
            "Subtraction (-)",
            "Multiplication (*)",
            "Division (/)"
        }; // Array of formulas for the JComboBox
        formulaSelector = new JComboBox<>(formulas); // Create a JComboBox for selecting formulas
        formulaSelector.addActionListener(e -> {
            display1.setText(""); // Clear the display when a new formula is selected
            display2.setText(""); // Clear the display when a new formula is selected
            display3.setText(""); // Clear the display when a new formula is selected
        });
        mainPanel.add(formulaSelector, BorderLayout.NORTH); // Add the JComboBox to the main panel

        // Add displays to the main panel using a gridlayout
        JPanel dispayPanel = new JPanel(new GridLayout(1, 3, 5, 5)); // Create a panel for the displays
        dispayPanel.add(display1); // Add display1 to the display panel
        dispayPanel.add(display2); // Add display2 to the display panel
        dispayPanel.add(display3); // Add display3 to the display panel
        mainPanel.add(dispayPanel, BorderLayout.CENTER); // Add the display panel to the main panel

        buttonPanel = new JPanel(new GridLayout(4, 4, 8, 10)); // Create a panel for the calculator buttons
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Buttons")); // Add a border with title
        
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

        // add a button to switch between displays
        JButton switchButton = new JButton("Switch"); // Create a switch button
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
        buttonPanel.add(switchButton); // Add switch button to the panel

        JButton equalsButton = new JButton("="); // Create an equals button
        equalsButton.addActionListener(e -> {
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
                    default -> throw new IllegalArgumentException("Invalid operator selected");
                };
                // get the operator from the formulaSelector
                double result = switch (operator) { // Perform calculation based on the operator
                    case "+" -> Calculator.add(num1, num2); // Addition
                    case "-" -> Calculator.subtract(num1, num2); // Subtraction
                    case "/" -> Calculator.divide(num1, num2); // Division with check for zero
                    case "*" -> Calculator.multiply(num1, num2); // Multiplication
                    default -> 0; // Default case
                };
                // set the result to display3
                display3.setText(String.valueOf(result)); // Set the display to the result of the calculation
                
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid Input Error: " + ex); // Display error if calculation fails
            } catch (ArithmeticException ex) {
                JOptionPane.showMessageDialog(frame, "Math Error: " + ex); // Display error if calculation fails
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex); // Display error if calculation fails
            }
        });
        buttonPanel.add(equalsButton); // Add equals button to the panel

        // add a clear button to reset the calculator
        JButton clearButton = new JButton("C"); // Create a clear button
        clearButton.addActionListener(e -> {
            display1.setText(""); // Clear the display when the button is clicked
            display2.setText(""); // Clear the display when the button is clicked
            display3.setText(""); // Clear the display when the button is clicked
        });

        buttonPanel.add(clearButton); // Add clear button to the panel

        // add panel to the frame
        frame.add(mainPanel, BorderLayout.NORTH); // Add the main panel to the frame
        frame.add(buttonPanel, BorderLayout.CENTER); // Add the button panel to the frame

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