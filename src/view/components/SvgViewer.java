/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.components;

import com.kitfox.svg.SVGDiagram;
import com.kitfox.svg.SVGException;
import com.kitfox.svg.SVGUniverse;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class SvgViewer extends JPanel{
    
    private SVGDiagram diagram;

    public SvgViewer(String filePath) {
        SVGUniverse universe = new SVGUniverse();
        try {
            URI uri = new File(filePath).toURI();
            diagram = universe.getDiagram(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (diagram != null) {
            Graphics2D g2 = (Graphics2D) g;
            try {
                diagram.render(g2);  // Menggambar SVG di panel
            } catch (SVGException ex) {
                Logger.getLogger(SvgViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SVG Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        SvgViewer viewer = new SvgViewer("src/assets/icon/home-1-svgrepo-com.svg"); // Ganti dengan path SVG kamu
        frame.add(viewer);

        frame.setVisible(true);
    }

    
}
