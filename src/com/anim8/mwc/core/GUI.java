package com.anim8.mwc.core;


import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GUI extends JFrame{

	public static int windowWidth = main.windowWidth, windowHeight = main.windowHeight;
    private static final Dimension size = new Dimension(windowWidth, windowHeight);
    
    private static final int selectedWidth = 2000;
    private static final int selectedHeight = 3000;
    static int mediaWallExportWidth = selectedWidth, mediaWallExportHeight = selectedHeight;
	
    private static final Dimension mediaWallSize = new Dimension(mediaWallExportWidth, mediaWallExportHeight);

    
	private static final long serialVersionUID = 1L;
	private static JFrame mainWin = new JFrame("Media Wall Creator");
    private static JFrame mediaWall = new JFrame("Media Wall | Exporting...");
    
    public static BufferedImage getScreenShot(
            Component component) {
 
            BufferedImage image = new BufferedImage(
              component.getWidth(),
              component.getHeight(),
              BufferedImage.TYPE_INT_RGB
              );
            // call the Component's paint method, using
            // the Graphics object of the image.
            component.paint( image.getGraphics() );
            return image;
            }
    
    
    	GUI(String windowName) {
	    	mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        //Title
	        //Label title = new Label("Media Wall Generator v.01");
	       
	    	
	       
	        JLabel title = new JLabel(windowName);
	        int textWidth = (int) title.getPreferredSize().getWidth();
	        System.out.println(textWidth);
	        title.setFont(new Font("SanSerif", Font.PLAIN,28));
	        title.setSize(title.getPreferredSize());
	        title.setLocation((windowWidth/2)-textWidth,0);
	        
	       
	        //Size Drop-down Box
	       
	       
	        //Generate Preview Button
	        JButton genPrevBTN = new JButton("Generate Preview");
	        Dimension genPrevBTNSize= new Dimension(200,20);
	        genPrevBTN.setLocation((windowWidth/2)-100, windowHeight - 110);
	        genPrevBTN.setSize(genPrevBTNSize);
	       
	        genPrevBTN.addActionListener(new ActionListener() {
	                        @Override
	                        public void actionPerformed(ActionEvent e) {
	                                System.out.println("Generating Preview...");
	                               
	                        }
	                });
	       
	        //Generate Export Button
	        JButton genExpBTN = new JButton("Export Media Wall");
	        Dimension genExpBTNSize= new Dimension(200,20);
	        genExpBTN.setSize(genExpBTNSize);
	        genExpBTN.setLocation((windowWidth/2)-100, windowHeight - 80);
	        genExpBTN.addActionListener(new ActionListener()
	        {
	                       
	                        @Override
	                        public void actionPerformed(ActionEvent e)
	                        {
	                                System.out.println("Exporting Media Wall...");
	                                createMediaWall();
	                                //mediaWall.setVisible(true);
	                                BufferedImage img = getScreenShot(mediaWall.getContentPane());
	                              JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(img.getScaledInstance(img.getWidth(null)/2, img.getHeight(null)/2, Image.SCALE_SMOOTH ))));
	                              try
	                              {
	                                // write the image as a PNG
	                                ImageIO.write(img,"png",new File("mediaWallExport.png"));
	                              } catch(Exception eT)
	                              {
	                                eT.printStackTrace();
	                              }
	                              //mediaWall.setVisible(false);
	                              mediaWall.dispose();
	                        }
	                });
	       
	        //Window Size
	        
	        
	        
	        mainWin.setPreferredSize(size);
	        mainWin.setResizable(false);
	       
	        mainWin.getContentPane().add(title);
	        mainWin.getContentPane().add(genPrevBTN);
	        mainWin.getContentPane().add(genExpBTN);
	        
	        //mainWin.add(new logoTemplate01());
	        
	        mainWin.getContentPane().setLayout(null);
	        mainWin.pack();
	        mainWin.setVisible(true);
    }
    	
    	private static void createMediaWall() {
    	       
    	    mediaWall.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	   
    	    //Title
    	    //Label title = new Label("Media Wall Generator v.01");
    	   
    	    JLabel Test = new JLabel("Test");
    	    Test.setFont(new Font("SanSerif", Font.PLAIN,28));
    	    Test.setLocation((mediaWallExportWidth/2)-165,0);
    	    Test.setSize(330,40);
    	   
    	    //Window Size
    	   
    	    
    	   
    	    
    	    mediaWall.setPreferredSize(new Dimension(mediaWallExportWidth,mediaWallExportHeight)); 
    	    mediaWall.setMinimumSize(new Dimension(mediaWallExportWidth,mediaWallExportHeight));    
    	  	
    	   
    	    //mediaWall.getContentPane();
    	    //mediaWall.getContentPane();
    	    //mediaWall.getContentPane();
    	    mediaWall.getContentPane().setLayout(null);
    	    
    	    mediaWall.setResizable(false);
    	    
    	     
    	    

    	    
    	    mediaWall.pack();
    	   
    	    //mediaWall.setState(Frame.ICONIFIED);
    	  	//mediaWall.setState(Frame.NORMAL);
    	    System.out.println(mediaWall.getSize());
    	   
    	         
    	}
    	
    	
}
