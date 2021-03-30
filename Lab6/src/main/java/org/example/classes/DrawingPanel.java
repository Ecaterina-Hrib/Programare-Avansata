package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;


public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;


    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the "tools" needed to draw in the image

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(0, 0, W, H);
    }

    //...NEXT SLIDE
    private void init() {
        setPreferredSize(new Dimension(W, H)); //don’t use setSize. Why?
        setBorder(BorderFactory.createEtchedBorder()); //for fun
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            }//Can’t use lambdas, JavaFX does a better job in these cases
        });
        repaint();
        paintComponent(graphics);

    }

    private void drawShape(int x, int y) {
        int radius = new Random().nextInt(20);
        int sides = (int) frame.configPanel.sidesField.getValue();//TODO; //get the value from UI (in ConfigPanel)
        Random rnd = new Random();
        int r = rnd.nextInt(128) + 128;
        int g = rnd.nextInt(128) + 128;
        int b = rnd.nextInt(128) + 128;
        Color color = new Color(r, g, b, 128); //create a transparent random Color.
        graphics.setColor(color);
        graphics.draw(new RegularPolygon(x, y, radius, sides));
        graphics.fill(new RegularPolygon(x, y, radius, sides));
        update(graphics);

    }

    @Override
    public void update(Graphics g) {
        repaint();
    } //Why did I do that?

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
        frame.setVisible(true);
    }
    public void deleteShape(Graphics g)
    {

    }
}
