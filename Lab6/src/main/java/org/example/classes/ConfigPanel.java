package org.example.classes;

import javax.swing.*;

import javax.swing.JLabel;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner sidesField;
    JComboBox colorCombo;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //create the label and the spinner
        label = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6); //default number of sides
        //create the colorCombo, containing the values: Random and Black
        String colors[] = {"Random", "Black"};
        colorCombo = new JComboBox(colors);
        add(label); //JPanel uses FlowLayout by default
        add(sidesField);
        add(colorCombo);

    }

}
