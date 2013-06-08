package com.anim8.mwc.core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;



import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class paintDemo {
	public static int windowWidth = main.windowWidth, windowHeight = main.windowHeight;
    private static final Dimension size = new Dimension(windowWidth, windowHeight);
    
    private static final int selectedWidth = 2000;
    private static final int selectedHeight = 3000;
    static int mediaWallExportWidth = selectedWidth, mediaWallExportHeight = selectedHeight;
	
	private static JFrame mainWin = new JFrame("Media Wall Creator");
 
	
	
	paintDemo(String windowName) {
    	mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        mainWin.setPreferredSize(size);
        mainWin.setResizable(false);
       

        mainWin.add(new MyPanel());
        
        
        //mainWin.add(new logoTemplate01());
        
        //mainWin.getContentPane().setLayout(null);
        mainWin.pack();
        mainWin.setVisible(true);
	}
	
	class Button extends JButton {
		public Button(){
			setBorder(BorderFactory.createLineBorder(Color.black));
		}
		public Dimension getPreferredSize() {
			return new Dimension(250,250);
		}
		public void paintComponent(Graphics g) {
			super.paintComponents(g);
			
			//Draw Text
			g.drawString("This is my custom panel", 10, 20);
		}
	}
	}
	
	
	class MyPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public MyPanel(){
			setBorder(BorderFactory.createLineBorder(Color.black));
		}
		public Dimension getPreferredSize() {
			return new Dimension(250,250);
		}
		public void paintComponent(Graphics g) {
			super.paintComponents(g);
			
			//Draw Text
			g.drawString("This is my custom panel", 10, 20);
		}
	}
	
	
}
