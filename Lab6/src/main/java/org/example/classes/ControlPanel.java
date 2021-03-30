package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;

    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton clearBtn = new JButton("Delete last shape");
    JButton exitBtn = new JButton("Exit");
    //create all buttons (Load, Reset, Exit)
 //TODO
    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    private void init() {
        //change the default layout manager (just for fun)
        //frame.setLayout(new GridLayout(8, 4));

        //add all buttons ...TODO
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(clearBtn);
        add(exitBtn);

        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        saveBtn.addActionListener(this::clear);
        exitBtn.addActionListener(this::exit);

    }
    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("D:\\_ user ecaaa\\Pictures\\test.png"));
       } catch (IOException ex) { System.err.println(ex); }
    }

    private void load(ActionEvent e) {
        try {
            BufferedImage image = ImageIO.read(new File("D:\\_ user ecaaa\\Pictures\\peisaj.jpg"));
            frame.canvas.image = image;
        } catch (IOException ex) { System.err.println(ex); }
    }

    private void reset(ActionEvent e) {
        frame.canvas.image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        frame.canvas.image.createGraphics();
        frame.canvas.graphics.setColor(Color.WHITE); //fill the image with white
        frame.canvas.graphics.fillRect(0, 0, 800, 600);
    }
    private void clear(ActionEvent e) {
        frame.canvas.image.createGraphics();
        frame.canvas.graphics.setColor(Color.WHITE);

    }

    private void exit(ActionEvent e) {
        System.exit(0);
    }

}
//}
