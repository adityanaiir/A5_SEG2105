//Name: Aditya Nair
//Date: July 30, 2020
//Course: SEG2105
//Student Number: 300076404

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;

public class FinalGame extends Applet implements ActionListener
{
    Panel p_card;  //to hold all of the screens
    Panel card1, card2, card3, card4, card5, card6, card7; //the seven screens
    JButton pic1, pic2, pic3, pic4;
    CardLayout cdLayout = new CardLayout ();
    int v = 7;//variable for the villains ar each level
    int move = 0;
    //grid
    int row = 11; //row for the grid
    int col = 12; //col for the grid
    //
    int x = 9; //starting x-value for the player
    int y = 1; // starting y -value for the player
    int level = 1; //setting the level to the arrays
    int choice; // using to label the characters according to their respective levels

    JLabel a[] = new JLabel [row * col];
    int b[] [] = {{2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2},  //level 1
	    {2, 2, 1, 2, 2, 2, 2, 2, 1, 1, 2, 2},
	    {1, 1, 1, 2, 2, 2, 2, 2, 2, 1, 1, 2},
	    {1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 2},
	    {1, 2, 2, 2, 2, 2, 2, 7, 2, 1, 1, 2},
	    {1, 1, 1, 11, 1, 2, 2, 7, 2, 1, 1, 2},
	    {1, 1, 1, 11, 1, 2, 2, 7, 2, 1, 1, 1},
	    {1, 1, 1, 11, 1, 1, 1, 1, 2, 2, 1, 1},
	    {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1},
	    {1, 2, 2, 2, 2, 1, 1, 2, 2, 2, 1, 1},
	    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

    int bORIG[] [] = {{2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2},  //level 1 without villain
	    {2, 2, 1, 2, 2, 2, 2, 2, 1, 1, 2, 2},
	    {1, 1, 1, 2, 2, 2, 2, 2, 2, 1, 1, 2},
	    {1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 2},
	    {1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 2},
	    {1, 1, 1, 11, 1, 2, 2, 2, 2, 1, 1, 2},
	    {1, 1, 1, 11, 1, 2, 2, 2, 2, 1, 1, 1},
	    {1, 1, 1, 11, 1, 1, 1, 1, 2, 2, 1, 1},
	    {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1},
	    {1, 2, 2, 2, 2, 1, 1, 2, 2, 2, 1, 1},
	    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

    int bWin[] [] = {{2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2},  //winning condition
	    {2, 2, 1, 2, 2, 2, 2, 2, 1, 1, 2, 2},
	    {1, 1, 1, 2, 2, 2, 2, 2, 2, 1, 1, 2},
	    {1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 2},
	    {1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 2},
	    {1, 1, 1, 7, 1, 2, 2, 2, 2, 1, 1, 2},
	    {1, 1, 1, 7, 1, 2, 2, 2, 2, 1, 1, 1},
	    {1, 1, 1, 7, 1, 1, 1, 1, 2, 2, 1, 1},
	    {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1},
	    {1, 2, 2, 2, 2, 1, 1, 2, 2, 2, 1, 1},
	    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

    int bcopy[] [] = {{2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2},  //copy of level 1
	    {2, 2, 1, 2, 2, 2, 2, 2, 1, 1, 2, 2},
	    {1, 1, 1, 2, 2, 2, 2, 2, 2, 1, 1, 2},
	    {1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 2},
	    {1, 2, 2, 2, 2, 2, 2, 7, 2, 1, 1, 2},
	    {1, 1, 1, 11, 1, 2, 2, 7, 2, 1, 1, 2},
	    {1, 1, 1, 11, 1, 2, 2, 7, 2, 1, 1, 1},
	    {1, 1, 1, 11, 1, 1, 1, 1, 2, 2, 1, 1},
	    {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1},
	    {1, 2, 2, 2, 2, 1, 1, 2, 2, 2, 1, 1},
	    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

    int d[] [] = {{2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2},  // level 2
	    {2, 2, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2},
	    {2, 2, 1, 2, 1, 1, 1, 1, 2, 1, 2, 2},
	    {2, 2, 1, 2, 1, 1, 2, 2, 2, 1, 1, 1},
	    {2, 2, 1, 2, 2, 2, 11, 11, 2, 2, 2, 1},
	    {2, 2, 1, 2, 1, 1, 1, 11, 2, 2, 2, 1},
	    {1, 1, 1, 2, 1, 1, 1, 2, 2, 1, 1, 1},
	    {1, 2, 8, 8, 8, 2, 2, 2, 2, 1, 2, 2},
	    {1, 2, 2, 2, 1, 1, 1, 2, 2, 1, 2, 2},
	    {1, 2, 2, 2, 1, 1, 1, 2, 2, 1, 2, 2},
	    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2}};

    int dORIG[] [] = {{2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2},  // level 2 without villain
	    {2, 2, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2},
	    {2, 2, 1, 2, 1, 1, 1, 1, 2, 1, 2, 2},
	    {2, 2, 1, 2, 1, 1, 2, 2, 2, 1, 1, 1},
	    {2, 2, 1, 2, 2, 2, 11, 11, 2, 2, 2, 1},
	    {2, 2, 1, 2, 1, 1, 1, 11, 2, 2, 2, 1},
	    {1, 1, 1, 2, 1, 1, 1, 2, 2, 1, 1, 1},
	    {1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2},
	    {1, 2, 2, 2, 1, 1, 1, 2, 2, 1, 2, 2},
	    {1, 2, 2, 2, 1, 1, 1, 2, 2, 1, 2, 2},
	    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2}};

    int dWin[] [] = {{2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2},  //winning condition
	    {2, 2, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2},
	    {2, 2, 1, 2, 1, 1, 1, 1, 2, 1, 2, 2},
	    {2, 2, 1, 2, 1, 1, 2, 2, 2, 1, 1, 1},
	    {2, 2, 1, 2, 2, 2, 8, 8, 2, 2, 2, 1},
	    {2, 2, 1, 2, 1, 1, 1, 8, 2, 2, 2, 1},
	    {1, 1, 1, 2, 1, 1, 1, 2, 2, 1, 1, 1},
	    {1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2},
	    {1, 2, 2, 2, 1, 1, 1, 2, 2, 1, 2, 2},
	    {1, 2, 2, 2, 1, 1, 1, 2, 2, 1, 2, 2},
	    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2}};

    int dcopy[] [] = {{2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2},  // copy of level 2
	    {2, 2, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2},
	    {2, 2, 1, 2, 1, 1, 1, 1, 2, 1, 2, 2},
	    {2, 2, 1, 2, 1, 1, 2, 2, 2, 1, 1, 1},
	    {2, 2, 1, 2, 2, 2, 11, 11, 2, 2, 2, 1},
	    {2, 2, 1, 2, 1, 1, 1, 11, 2, 2, 2, 1},
	    {1, 1, 1, 2, 1, 1, 1, 2, 2, 1, 1, 1},
	    {1, 2, 8, 8, 8, 2, 2, 2, 2, 1, 2, 2},
	    {1, 2, 2, 2, 1, 1, 1, 2, 2, 1, 2, 2},
	    {1, 2, 2, 2, 1, 1, 1, 2, 2, 1, 2, 2},
	    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2}};

    int e1[] [] = {{1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 2},  // level 3
	    {1, 2, 2, 2, 1, 1, 1, 1, 2, 2, 1, 1},
	    {1, 2, 2, 2, 2, 2, 9, 2, 2, 2, 2, 1},
	    {1, 2, 2, 2, 1, 1, 1, 1, 1, 2, 2, 1},
	    {1, 1, 1, 11, 1, 2, 2, 2, 1, 2, 2, 1},
	    {1, 1, 1, 11, 1, 2, 2, 2, 1, 2, 1, 1},
	    {1, 1, 1, 11, 1, 2, 2, 9, 1, 2, 2, 1},
	    {1, 2, 2, 2, 1, 2, 2, 9, 2, 2, 2, 1},
	    {1, 2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 1},
	    {1, 2, 2, 2, 1, 2, 2, 1, 1, 1, 2, 1},
	    {1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1}};

    int eORIG[] [] = {{1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 2},  //level 3 without villain
	    {1, 2, 2, 2, 1, 1, 1, 1, 2, 2, 1, 1},
	    {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
	    {1, 2, 2, 2, 1, 1, 1, 1, 1, 2, 2, 1},
	    {1, 1, 1, 11, 1, 2, 2, 2, 1, 2, 2, 1},
	    {1, 1, 1, 11, 1, 2, 2, 2, 1, 2, 1, 1},
	    {1, 1, 1, 11, 1, 2, 2, 2, 1, 2, 2, 1},
	    {1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1},
	    {1, 2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 1},
	    {1, 2, 2, 2, 1, 2, 2, 1, 1, 1, 2, 1},
	    {1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1}};

    int eWin[] [] = {{1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 2},  // winning condition
	    {1, 2, 2, 2, 1, 1, 1, 1, 2, 2, 1, 1},
	    {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
	    {1, 2, 2, 2, 1, 1, 1, 1, 1, 2, 2, 1},
	    {1, 1, 1, 9, 1, 2, 2, 2, 1, 2, 2, 1},
	    {1, 1, 1, 9, 1, 2, 2, 2, 1, 2, 1, 1},
	    {1, 1, 1, 9, 1, 2, 2, 2, 1, 2, 2, 1},
	    {1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1},
	    {1, 2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 1},
	    {1, 2, 2, 2, 1, 2, 2, 1, 1, 1, 2, 1},
	    {1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1}};

    int ecopy[] [] = {{1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 2},  // copy of level 3
	    {1, 2, 2, 2, 1, 1, 1, 1, 2, 2, 1, 1},
	    {1, 2, 2, 2, 2, 2, 9, 2, 2, 2, 2, 1},
	    {1, 2, 2, 2, 1, 1, 1, 1, 1, 2, 2, 1},
	    {1, 1, 1, 11, 1, 2, 2, 2, 1, 2, 2, 1},
	    {1, 1, 1, 11, 1, 2, 2, 2, 1, 2, 1, 1},
	    {1, 1, 1, 11, 1, 2, 2, 9, 1, 2, 2, 1},
	    {1, 2, 2, 2, 1, 2, 2, 9, 2, 2, 2, 1},
	    {1, 2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 1},
	    {1, 2, 2, 2, 1, 2, 2, 1, 1, 1, 2, 1},
	    {1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1}};

    int f[] [] = {{1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2},  //level 4
	    {1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2},
	    {1, 2, 1, 1, 2, 2, 1, 1, 1, 1, 1, 2},
	    {1, 2, 1, 1, 1, 2, 1, 2, 2, 2, 1, 2},
	    {1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1, 2},
	    {1, 1, 2, 1, 1, 1, 1, 2, 1, 2, 1, 2},
	    {1, 2, 2, 10, 2, 10, 2, 10, 2, 10, 1, 2},
	    {1, 11, 11, 11, 11, 11, 11, 11, 11, 11, 1, 2},
	    {1, 2, 10, 10, 10, 2, 10, 2, 10, 2, 1, 2},
	    {1, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 2},
	    {1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}};

    int fORIG[] [] = {{1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2},  // level 4 without villain
	    {1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2},
	    {1, 2, 1, 1, 2, 2, 1, 1, 1, 1, 1, 2},
	    {1, 2, 1, 1, 1, 2, 1, 2, 2, 2, 1, 2},
	    {1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1, 2},
	    {1, 1, 2, 1, 1, 1, 1, 2, 1, 2, 1, 2},
	    {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2},
	    {1, 11, 11, 11, 11, 11, 11, 11, 11, 11, 1, 2},
	    {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2},
	    {1, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 2},
	    {1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}};

    int fWin[] [] = {{1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2},  //winning condition
	    {1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2},
	    {1, 2, 1, 1, 2, 2, 1, 1, 1, 1, 1, 2},
	    {1, 2, 1, 1, 1, 2, 1, 2, 2, 2, 1, 2},
	    {1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1, 2},
	    {1, 1, 2, 1, 1, 1, 1, 2, 1, 2, 1, 2},
	    {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2},
	    {1, 10, 10, 10, 10, 10, 10, 10, 10, 10, 1, 2},
	    {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2},
	    {1, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 2},
	    {1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}};

    int fcopy[] [] = {{1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2},  //copy for level 4
	    {1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2},
	    {1, 2, 1, 1, 2, 2, 1, 1, 1, 1, 1, 2},
	    {1, 2, 1, 1, 1, 2, 1, 2, 2, 2, 1, 2},
	    {1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1, 2},
	    {1, 1, 2, 1, 1, 1, 1, 2, 1, 2, 1, 2},
	    {1, 2, 2, 10, 2, 10, 2, 10, 2, 10, 1, 2},
	    {1, 11, 11, 11, 11, 11, 11, 11, 11, 11, 1, 2},
	    {1, 2, 10, 10, 10, 2, 10, 2, 10, 2, 1, 2},
	    {1, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 2},
	    {1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}};
    public void initMenu ()
    { //Menu bar
	JMenuBar menuBar = new JMenuBar ();
	JMenu menu;
	JMenuItem menuItem;

	menu = new JMenu ("File");
	menuBar.add (menu);

	menuItem = new JMenuItem ("Close");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("Close");
	menu.add (menuItem);

	menu = new JMenu ("Navigate");
	menuBar.add (menu);

	menuItem = new JMenuItem ("Opening");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("7");
	menu.add (menuItem);

	menuItem = new JMenuItem ("Rules");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("8");
	menu.add (menuItem);

	menuItem = new JMenuItem ("Play Game");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("9");
	menu.add (menuItem);
	add ("North", menuBar);
    }


    public void init ()
    {
	//Adding screens and menu bar
	p_card = new Panel ();
	p_card.setLayout (cdLayout);
	p_card.setBackground (new Color (52, 53, 57));
	screen1 ();
	screen2 ();
	screen3 ();
	screen4 ();
	screen5 ();
	screen6 ();
	screen7 ();
	resize (960, 650);
	setLayout (new BorderLayout ());
	initMenu ();
	add ("Center", p_card);
    }


    public void screen1 ()
    { //Title Screen for the game
	card1 = new Panel ();
	JButton next = new JButton (createImageIcon ("Wallpaper.jpg")); //title cover for the game
	next.setPreferredSize (new Dimension (960, 650));
	next.setActionCommand ("s2");
	next.addActionListener (this);
	card1.add (next);
	p_card.add ("1", card1);
    }


    public void screen2 ()
    { //Introduction for the purpose of the game
	card2 = new Panel ();
	Panel p1 = new Panel ();
	Panel p2 = new Panel ();
	Panel p3 = new Panel ();
	JLabel pic = new JLabel (createImageIcon ("INS.jpg"));
	JLabel intro = new JLabel (createImageIcon ("Intro.jpg"));
	JButton next = new JButton (">>");
	next.setActionCommand ("s3");
	next.addActionListener (this);
	card2.add (pic);
	card2.add (intro);
	card2.add (next);
	p_card.add ("2", card2);
    }


    public void screen3 ()
    { //Instructions page for sokoban
	card3 = new Panel ();
	Panel p1 = new Panel ();
	JLabel title = new JLabel ("YOUR TASK");
	title.setFont (new Font ("Arial", Font.PLAIN, 40));
	title.setForeground (Color.white);
	JLabel ins = new JLabel (createImageIcon ("Instructions.jpg"));
	JLabel cover = new JLabel (createImageIcon ("CoverPage.jpg"));
	JButton next = new JButton (">>");
	next.setActionCommand ("s4");
	next.addActionListener (this);
	card3.add (title);
	card3.add (cover);
	card3.add (ins);
	card3.add (next);
	p_card.add ("3", card3);
    }


    public void screen4 ()
    { //Displaying all characters
	card4 = new Panel ();
	Panel p1 = new Panel ();
	Panel p2 = new Panel ();
	Panel g = new Panel (new GridLayout (2, 1));
	JLabel title = new JLabel ("PICK YOUR CHARACTER");
	title.setFont (new Font ("Arial", Font.PLAIN, 30));
	title.setForeground (Color.white);
	pic1 = new JButton (createImageIcon ("Aang.jpg"));
	pic1.setPreferredSize (new Dimension (200, 300));
	pic1.setActionCommand ("s5");
	pic1.addActionListener (this);
	pic2 = new JButton (createImageIcon ("Katara.jpg"));
	pic2.setPreferredSize (new Dimension (200, 300));
	pic2.setActionCommand ("s6");
	pic2.addActionListener (this);
	pic3 = new JButton (createImageIcon ("Toph.jpg"));
	pic3.setPreferredSize (new Dimension (200, 300));
	pic3.setActionCommand ("s7");
	pic3.addActionListener (this);
	pic4 = new JButton (createImageIcon ("Zuko.jpg"));
	pic4.setPreferredSize (new Dimension (200, 300));
	pic4.setActionCommand ("s8");
	pic4.addActionListener (this);
	JLabel info = new JLabel ("AANG           KATARA            TOPH                ZUKO");
	info.setFont (new Font ("Arial", Font.PLAIN, 30));
	info.setForeground (Color.white);
	p1.add (title);
	p2.add (pic1);
	p2.add (pic2);
	p2.add (pic3);
	p2.add (pic4);
	card4.add (p1);
	card4.add (p2);
	card4.add (info);
	p_card.add ("4", card4);

    }


    public void screen5 ()
    { //Game Screen
	card5 = new Panel ();
	JLabel title = new JLabel ("Sokoban");
	title.setForeground (Color.white);
	title.setFont (new Font ("Arial", Font.PLAIN, 40));
	JButton next = new JButton (createImageIcon ("Next.jpg"));
	next.setPreferredSize (new Dimension (100, 30));
	next.setBorderPainted (false);
	next.setOpaque (false);
	next.setMargin (new Insets (0, 0, 0, 0));
	next.setFocusPainted (false);
	next.setActionCommand ("s9");
	next.addActionListener (this);

	//Displays the grid
	Panel p = new Panel (new GridLayout (row, col));
	//sets up the game grid
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		a [move] = new JLabel (createImageIcon (b [i] [j] + ".jpg"));
		a [move].setPreferredSize (new Dimension (45, 45));

		p.add (a [move]);
		move++;
	    }
	}


	a [x * col + y].setIcon (createImageIcon ("3.jpg"));

	//Navigation Button
	JButton up = new JButton (createImageIcon ("up.jpg"));
	up.setPreferredSize (new Dimension (50, 50));
	up.setBorderPainted (false); // Improving the button by removing borders and margins
	up.setOpaque (false);
	up.setMargin (new Insets (0, 0, 0, 0));
	up.setFocusPainted (false);
	up.setActionCommand ("1");
	up.addActionListener (this);
	JButton left = new JButton (createImageIcon ("left.jpg"));
	left.setPreferredSize (new Dimension (50, 50));
	left.setBorderPainted (false);
	left.setOpaque (false);
	left.setMargin (new Insets (0, 0, 0, 0));
	left.setFocusPainted (false);
	left.setActionCommand ("2");
	left.addActionListener (this);
	JButton down = new JButton (createImageIcon ("down.jpg"));
	down.setPreferredSize (new Dimension (50, 50));
	down.setBorderPainted (false);
	down.setOpaque (false);
	down.setMargin (new Insets (0, 0, 0, 0));
	down.setFocusPainted (false);
	down.setActionCommand ("3");
	down.addActionListener (this);
	JButton right = new JButton (createImageIcon ("right.jpg"));
	right.setPreferredSize (new Dimension (50, 50));
	right.setBorderPainted (false);
	right.setOpaque (false);
	right.setMargin (new Insets (0, 0, 0, 0));
	right.setFocusPainted (false);
	right.setActionCommand ("4");
	right.addActionListener (this);
	JLabel right2 = new JLabel (""); // Sapcing the Panel for the navigation button
	right2.setPreferredSize (new Dimension (50, 50));
	JLabel right3 = new JLabel (""); // Sapcing the Panel for the navigation button
	right3.setPreferredSize (new Dimension (50, 50));
	JLabel right4 = new JLabel (""); // Sapcing the Panel for the navigation button
	right4.setPreferredSize (new Dimension (50, 50));
	JLabel right5 = new JLabel (""); // Sapcing the Panel for the navigation button
	right5.setPreferredSize (new Dimension (50, 50));
	JLabel right6 = new JLabel (""); // Sapcing the Panel for the navigation button
	right6.setPreferredSize (new Dimension (50, 50));
	Panel arrowGrid = new Panel (new GridLayout (3, 3)); //sets up the panel for Navigation
	arrowGrid.add (right2);
	arrowGrid.add (up);
	arrowGrid.add (right3);
	arrowGrid.add (left);
	arrowGrid.add (right4);         //These spaces help arrow buttons, visually appealing and shows it in proper order
	arrowGrid.add (right);
	arrowGrid.add (right5);
	arrowGrid.add (down);
	arrowGrid.add (right6);
	JButton reset = new JButton (createImageIcon ("reset.jpg"));
	reset.setPreferredSize (new Dimension (100, 100));
	reset.setBorderPainted (false);
	reset.setOpaque (false);
	reset.setMargin (new Insets (0, 0, 0, 0));
	reset.setFocusPainted (false);
	reset.setActionCommand ("5");
	reset.addActionListener (this);
	Panel task = new Panel (new GridLayout (2, 2));
	task.setBackground (new Color (52, 53, 57));
	Panel p1 = new Panel ();
	Panel p2 = new Panel ();
	task.add (reset); 
	task.add (next);
	task.add (arrowGrid);
	p1.add (title);
	p2.add (p);
	p2.add (task); //Adding the Game Screen Panel
	card5.add (p1);
	card5.add (p2);
	p_card.add ("5", card5);
    }


    public void screen6 ()
    { //screen 5 is set up.
	card6 = new Panel ();
	Panel p1 = new Panel ();
	Panel p2 = new Panel ();
	JLabel new1 = new JLabel (createImageIcon ("WIN.jpg"));
	JButton next = new JButton (createImageIcon ("Next.jpg"));
	next.setPreferredSize (new Dimension (150, 150));
	next.setBorderPainted (false);
	next.setOpaque (false);
	next.setMargin (new Insets (0, 0, 0, 0));
	next.setFocusPainted (false);
	next.setActionCommand ("s10");
	next.addActionListener (this);
	p1.add (new1);
	p2.add (next);
	card6.add (p1);
	card6.add (p2);
	p_card.add ("6", card6);
    }


    public void screen7 ()
    { //The End screen
	card7 = new Panel ();
	JLabel title = new JLabel ("THE END");
	title.setFont (new Font ("Arial", Font.PLAIN, 40));
	JLabel lose = new JLabel (createImageIcon ("lose.jpg"));
	JButton next = new JButton ("Back to Introduction?"); //User friendly as this button lets the user chose if they want to restart or not
	next.setForeground (Color.black);
	next.setActionCommand ("s1");
	next.addActionListener (this);
	JButton end = new JButton ("Quit?"); // Quit button for the user, if they want to quit
	end.setActionCommand ("s11");
	end.addActionListener (this);
	card7.add (title);
	card7.add (lose);
	card7.add (next);
	card7.add (end);
	p_card.add ("7", card7);
    }


    protected static ImageIcon createImageIcon (String path)
    { //change the red to your class name
	java.net.URL imgURL = FinalGame.class.getResource (path);
	if (imgURL != null)
	{
	    return new ImageIcon (imgURL);
	}
	else
	{
	    System.err.println ("Couldn't find file: " + path);
	    return null;
	}
    }


    public void redraw ()
    { // Reseting the grid
	int move = 0;
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		a [move].setIcon (createImageIcon (b [i] [j] + ".jpg"));
		move++;
	    }
	    a [x * col + y].setIcon (createImageIcon (choice + ".jpg"));
	}
    }


    public void actionPerformed (ActionEvent e)
    { //moves between the screens
	if (e.getActionCommand ().equals ("8")) // Menu bar's Navigation option for the opening of the game
	    cdLayout.show (p_card, "3");
	else if (e.getActionCommand ().equals ("9")) // Menu bar's Navigation option for the Rule of the game
	    cdLayout.show (p_card, "4");
	else if (e.getActionCommand ().equals ("7")) // Menu bar's Navigation option for the Playing the game
	    cdLayout.show (p_card, "1");
	else if (e.getActionCommand ().equals ("Close")) // Menu bar's File section to close the game
	    System.exit (0);
	else if (e.getActionCommand ().equals ("s1"))
	    cdLayout.show (p_card, "1");
	else if (e.getActionCommand ().equals ("s2"))
	    cdLayout.show (p_card, "2");
	else if (e.getActionCommand ().equals ("s3"))
	    cdLayout.show (p_card, "3");
	else if (e.getActionCommand ().equals ("s4"))
	    cdLayout.show (p_card, "4");
	//Characters selection
	else if (e.getActionCommand ().equals ("s5")) //Aang
	{
	    a [x * col + y].setIcon (createImageIcon (b [x] [y] + ".jpg"));
	    a [x * col + y].setIcon (createImageIcon ("3.jpg"));
	    choice = 3;

	    cdLayout.show (p_card, "5");
	}


	else if (e.getActionCommand ().equals ("s6")) //Katara
	{
	    a [x * col + y].setIcon (createImageIcon (b [x] [y] + ".jpg"));
	    a [x * col + y].setIcon (createImageIcon ("6.jpg"));
	    choice = 6;

	    cdLayout.show (p_card, "5");
	}


	else if (e.getActionCommand ().equals ("s7")) //Toph
	{

	    a [x * col + y].setIcon (createImageIcon (b [x] [y] + ".jpg"));
	    a [x * col + y].setIcon (createImageIcon ("5.jpg"));
	    choice = 5;

	    cdLayout.show (p_card, "5");
	}


	else if (e.getActionCommand ().equals ("s8")) //Zuko
	{
	    a [x * col + y].setIcon (createImageIcon (b [x] [y] + ".jpg"));
	    a [x * col + y].setIcon (createImageIcon ("4.jpg"));
	    choice = 4;

	    cdLayout.show (p_card, "5");
	}


	//Next level
	else if (e.getActionCommand ().equals ("s9"))
	{
	    if (win ())
		Levels ();
	    else
		JOptionPane.showMessageDialog (null, "YOU HAVE TO FINISH THIS LEVEL TO MOVE ON TO THE NEXT ONE!", "KEEP TRYING!", JOptionPane.ERROR_MESSAGE);

	}


	else if (e.getActionCommand ().equals ("s10"))
	    cdLayout.show (p_card, "7");
	else if (e.getActionCommand ().equals ("s11"))
	    System.exit (0);
	else if (e.getActionCommand ().equals ("1")) //up
	{
	    Up ();
	}


	else if (e.getActionCommand ().equals ("3")) //down
	{
	    Down ();
	}


	else if (e.getActionCommand ().equals ("2")) //left
	{
	    Left ();
	}


	else if (e.getActionCommand ().equals ("4")) //right
	{
	    Right ();
	}


	else if (e.getActionCommand ().equals ("5"))
	{
	    Reset ();
	}
    }


    public void Levels ()
    {
	level++;
	if (level == 2)
	{
	    for (int i = 0 ; i < row ; i++)
	    {
		for (int j = 0 ; j < col ; j++)
		{
		    b [i] [j] = d [i] [j];              // sets the first array to second array
		    bORIG [i] [j] = dORIG [i] [j];      //It always begin from first array as it started from there
		}
	    }
	    x = 9;
	    y = 1;
	    v = 8; // sets villain to 8.jpg (Zhao)
	    redraw (); // redrawing the array when clicked next
	}


	else if (level == 3)
	{
	    for (int i = 0 ; i < row ; i++)
	    {
		for (int j = 0 ; j < col ; j++)
		{
		    b [i] [j] = e1 [i] [j]; // starting form the first array to the desired array for this level
		    bORIG [i] [j] = eORIG [i] [j];
		}
	    }
	    v = 9; // sets villain to 9.jpg (Azula)
	    x = 9;
	    y = 1;
	    redraw (); // redrawing the array when clicked next
	}


	else if (level == 4)
	{
	    for (int i = 0 ; i < row ; i++)
	    {
		for (int j = 0 ; j < col ; j++)
		{
		    b [i] [j] = f [i] [j];
		    bORIG [i] [j] = fORIG [i] [j];
		}
	    }
	    v = 10; //sets villain to 10.jpg (Ozai)
	    x = 9;
	    y = 1;
	    redraw (); // redrawing the array when clicked next
	}
    }


    public void Up ()
    {
	if (b [x - 1] [y] == 2 || b [x - 1] [y] == 11) //blank
	{
	    a [x * col + y].setIcon (createImageIcon (b [x] [y] + ".jpg"));
	    x--; //x-- in an array is "vertical axis" in which if you go up the x values decrese thus making up x--
	    a [x * col + y].setIcon (createImageIcon (choice + ".jpg"));
	}


	else if (b [x - 1] [y] == v && (b [x - 2] [y] == 2 || b [x - 2] [y] == 11)) //villain + blank
	{
	    a [x * col + y].setIcon (createImageIcon (b [x] [y] + ".jpg"));
	    b [x - 1] [y] = bORIG [x - 1] [y]; //villain is clear
	    b [x - 2] [y] = v; //moves the villain
	    x--;
	    a [x * col + y].setIcon (createImageIcon (choice + ".jpg"));
	    a [(x - 1) * col + y].setIcon (createImageIcon (v + ".jpg"));
	}
	win ();
    }


    public void Down ()
    {
	if (b [x + 1] [y] == 2 || b [x + 1] [y] == 11) //blank
	{
	    a [x * col + y].setIcon (createImageIcon (b [x] [y] + ".jpg"));
	    x++; //x++ in an array is added because if you move down the x values increase thus making right x++
	    a [x * col + y].setIcon (createImageIcon (choice + ".jpg"));
	}


	else if (b [x + 1] [y] == v && (b [x + 2] [y] == 2 || b [x + 2] [y] == 11)) //villain + blank
	{
	    a [x * col + y].setIcon (createImageIcon (b [x] [y] + ".jpg"));
	    b [x + 1] [y] = bORIG [x + 1] [y]; //villain is clear
	    b [x + 2] [y] = v; //moves the villain
	    x++;
	    a [x * col + y].setIcon (createImageIcon (choice + ".jpg"));
	    a [(x + 1) * col + y].setIcon (createImageIcon (v + ".jpg"));
	}


	win ();
    }


    public void Left ()
    {
	if (b [x] [y - 1] == 2 || b [x] [y - 1] == 11) //blank
	{
	    a [x * col + y].setIcon (createImageIcon (b [x] [y] + ".jpg"));
	    y--; //y-- in an array is the "horizontal axis" in which as you move left the y values decrease thus making left y--
	    a [x * col + y].setIcon (createImageIcon (choice + ".jpg"));
	}


	else if (b [x] [y - 1] == v && (b [x] [y - 2] == 2 || b [x] [y - 2] == 11))
	{
	    a [x * col + y].setIcon (createImageIcon (b [x] [y] + ".jpg"));
	    b [x] [y - 1] = bORIG [x] [y - 1]; //villain is clear
	    b [x] [y - 2] = v; //moves the villain
	    y--;
	    a [x * col + y].setIcon (createImageIcon (choice + ".jpg"));
	    a [x * col + (y - 1)].setIcon (createImageIcon (v + ".jpg"));
	}


	win ();
    }


    public void Right ()
    {
	if (b [x] [y + 1] == 2 || b [x] [y + 1] == 11) //blank
	{
	    a [x * col + y].setIcon (createImageIcon (b [x] [y] + ".jpg"));
	    y++; //y++ in array is if you go right the y values increase thus y++
	    a [x * col + y].setIcon (createImageIcon (choice + ".jpg"));

	}


	else if (b [x] [y + 1] == v && (b [x] [y + 2] == 2 || b [x] [y + 2] == 11)) //zuku + blank
	{
	    a [x * col + y].setIcon (createImageIcon (b [x] [y] + ".jpg"));
	    b [x] [y + 1] = bORIG [x] [y + 1]; //clear zuku
	    b [x] [y + 2] = v; //move zuku
	    y++;
	    a [x * col + y].setIcon (createImageIcon (choice + ".jpg"));
	    a [x * col + (y + 1)].setIcon (createImageIcon (v + ".jpg"));

	}


	win ();
    }


    public void Reset ()
    {
	// sets the code for each level
	if (level == 1)
	{
	    for (int i = 0 ; i < row ; i++)
	    {
		for (int j = 0 ; j < col ; j++)
		{
		    b [i] [j] = bcopy [i] [j]; //copies the 'copy' array to the original array
		}
	    }
	    v = 7; // making the villain stay the same when reseting
	    x = 9;
	    y = 1;
	    redraw ();
	}


	if (level == 2)
	{
	    for (int i = 0 ; i < row ; i++)
	    {
		for (int j = 0 ; j < col ; j++)
		{
		    b [i] [j] = dcopy [i] [j]; // it always starts from the first array thus adding just the other level's array
		}
	    }
	    v = 8; // making the villain stay the same when reseting
	    x = 9;
	    y = 1;
	    redraw ();
	}


	if (level == 3)
	{
	    for (int i = 0 ; i < row ; i++)
	    {
		for (int j = 0 ; j < col ; j++)
		{
		    b [i] [j] = ecopy [i] [j];
		}
	    }
	    v = 9; // making the villain stay the same when reseting
	    x = 9;
	    y = 1;
	    redraw ();
	}


	if (level == 4)
	{
	    for (int i = 0 ; i < row ; i++)
	    {
		for (int j = 0 ; j < col ; j++)
		{
		    b [i] [j] = fcopy [i] [j];
		}
	    }
	    v = 10; // making the villain stay the same when reseting
	    x = 9;
	    y = 1;
	    redraw ();
	}
    }

    public boolean win ()  //boolean method
    {
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		if (level == 1)
		{
		    if (b [i] [j] != bWin [i] [j])
			return false;
		}
		if (level == 2)
		{
		    if (b [i] [j] != dWin [i] [j])
			return false;                           //if the first does not equal the winning array then return false
		}
		if (level == 3)
		{
		    if (b [i] [j] != eWin [i] [j])
			return false;
		}
		if (level == 4)
		{
		    if (b [i] [j] != fWin [i] [j])
			return false;
		}

	    }
	}

	//when it return true show dialog box indicating you pass
	JOptionPane.showMessageDialog (null, "GOOD JOB, click next", "YOU WIN!!", JOptionPane.INFORMATION_MESSAGE);
	return true;

    }
}


