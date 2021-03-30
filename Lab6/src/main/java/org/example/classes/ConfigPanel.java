package com.company;

import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel sidesLabel1; // we’re drawing regular polygons
    JLabel sidesLabel2;
    JSpinner sidesField;
    JSpinner sidesField2; // number of sides
    JComboBox colorCombo; // the color of the shape

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //create the label and the spinner
        sidesLabel1 = new JLabel("Number of shapes:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setToolTipText("Square"); //default number of sides

        //create the colorCombo, containing the values: Random and Black
        String Shapes[] = {"Circle","Square", "Rectangle"};
        String colors[] = {"Random", "Black"};
        colorCombo = new JComboBox(colors);

        add(sidesLabel1); //JPanel uses FlowLayout by default
        add(sidesField);
        add(colorCombo);
    }
}
