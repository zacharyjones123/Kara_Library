package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.Border;

import main.Book;
import main.Library;

public class MainFrame {
	
	static Library library = null;
	
	final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
	
	private static void createAndShowGUI() {
		Library library = null;
		try {
			library = new Library();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Create and set up the window.
        JFrame frame = new JFrame("Kara's Library");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("images/icons/apple.png"));
        frame.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //frame.setUndecorated(true);
        
        //Set The MenuBar
        setMenuBar(frame);
 
        //Set up the content pane.
        addComponentsToPane(frame.getContentPane(), library);
 
        //Display the window.
        frame.pack();
        frame.setSize(1000, 500);
        frame.setLocationRelativeTo(null); //To make center
        frame.setVisible(true);
    }
	
	public static void setMenuBar(JFrame frame) {
		//-------------------------------------------------------------------------
				//-------------------------------------------------------------------------
		        //Create the menu bar.  Make it have a green background.
		        JMenuBar greenMenuBar = new JMenuBar();
		        greenMenuBar.setOpaque(true);
		        greenMenuBar.setBackground(new Color(154, 165, 127));
		        greenMenuBar.setPreferredSize(new Dimension(200, 20));
		        
		        //The Menu
		      //Build the first menu.
		      //Create the menu bar.
		        JMenu menu = new JMenu("Books");
		        menu.setMnemonic(KeyEvent.VK_A);
		        menu.getAccessibleContext().setAccessibleDescription(
		                "Books menu");
		        greenMenuBar.add(menu);

		        //a group of JMenuItems
		        JMenuItem menuItem = new JMenuItem("Add Book",
		                                 KeyEvent.VK_T);
		        menuItem.setAccelerator(KeyStroke.getKeyStroke(
		                KeyEvent.VK_B, ActionEvent.ALT_MASK));
		        menuItem.getAccessibleContext().setAccessibleDescription(
		                "This will add a book");
		        
		        menuItem.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		        		//Create and set up the window.
		                JFrame frame = new JFrame("Add A Book");
		                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		                frame.setIconImage(Toolkit.getDefaultToolkit().getImage("images/icons/book.png"));
		                frame.setCursor(new Cursor(Cursor.HAND_CURSOR));
		                //frame.setUndecorated(true);
		                
		              //Set up the content pane.
		                addComponentsToPane(frame.getContentPane());
		         
		                //Display the window.
		                frame.pack();
		                frame.setSize(500, 500);
		                frame.setLocationRelativeTo(null); //To make center
		                frame.setVisible(true);

		            }
		        });
		        
		        menu.add(menuItem);

		        menuItem = new JMenuItem("Edit Book",
		                                 KeyEvent.VK_E);
		        menuItem.setAccelerator(KeyStroke.getKeyStroke(
		                KeyEvent.VK_E, ActionEvent.ALT_MASK));
		        menuItem.setMnemonic(KeyEvent.VK_B);
		        menu.add(menuItem);

		        menuItem = new JMenuItem("Filter",
		                KeyEvent.VK_F);
		        menuItem.setAccelerator(KeyStroke.getKeyStroke(
		                KeyEvent.VK_F, ActionEvent.ALT_MASK));
		        menuItem.setMnemonic(KeyEvent.VK_B);
		        menu.add(menuItem);
		        
		        menuItem = new JMenuItem("Lists",
		                KeyEvent.VK_L);
		        menuItem.setAccelerator(KeyStroke.getKeyStroke(
		                KeyEvent.VK_L, ActionEvent.ALT_MASK));
		        menuItem.setMnemonic(KeyEvent.VK_B);
		        menu.add(menuItem);

		        //Build second menu in the menu bar.
		        menu = new JMenu("Students");
		        menu.setMnemonic(KeyEvent.VK_N);
		        menu.getAccessibleContext().setAccessibleDescription(
		                "This menu does nothing");
		        greenMenuBar.add(menu);
		        
		        menuItem = new JMenuItem("All Students",
		                KeyEvent.VK_E);
		        menuItem.setAccelerator(KeyStroke.getKeyStroke(
		        		KeyEvent.VK_A, ActionEvent.ALT_MASK));
		        menuItem.setMnemonic(KeyEvent.VK_B);
		        menu.add(menuItem);
		        
		        menuItem = new JMenuItem("Add Student",
		                KeyEvent.VK_E);
		        menuItem.setAccelerator(KeyStroke.getKeyStroke(
		        		KeyEvent.VK_A, ActionEvent.ALT_MASK));
		        menuItem.setMnemonic(KeyEvent.VK_B);
		        menu.add(menuItem);
		        
		        menuItem = new JMenuItem("Delete Student",
		                KeyEvent.VK_E);
		        menuItem.setAccelerator(KeyStroke.getKeyStroke(
		        		KeyEvent.VK_A, ActionEvent.ALT_MASK));
		        menuItem.setMnemonic(KeyEvent.VK_B);
		        menu.add(menuItem);
		        
		        menuItem = new JMenuItem("Edit Student",
		                KeyEvent.VK_E);
		        menuItem.setAccelerator(KeyStroke.getKeyStroke(
		        		KeyEvent.VK_A, ActionEvent.ALT_MASK));
		        menuItem.setMnemonic(KeyEvent.VK_B);
		        menu.add(menuItem);
		        
		        greenMenuBar.add(new JSeparator());
		        greenMenuBar.add(new JButton("Search: "));
		        greenMenuBar.add(new JTextField("    "));
		        greenMenuBar.add(new JComboBox(new Object[] {"author", "genre", "tags"}));
		        greenMenuBar.add(Box.createHorizontalGlue());
		        greenMenuBar.add(new JMenu("About"));
		        
		        
		        frame.setJMenuBar(greenMenuBar);
		        //-------------------------------------------------------------------------
		      //-------------------------------------------------------------------------
	}
	
	public static void addBookGUI(Book book) {
		JFrame frame = new JFrame ("MyPanel");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new MyPanel());
        frame.pack();
        frame.setVisible (true);
	}
	
	public static JPanel makeBookPanel(Book book) {
		
		JPanel panel = new JPanel();
		panel.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		if (RIGHT_TO_LEFT) {
            panel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
 
        JButton button;
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setMaximumSize(new Dimension(1000, 25));
        
    button = new JButton(book.getTitle());
    button.setMaximumSize(new Dimension(250, 25));
    //c.fill = GridBagConstraints.HORIZONTAL;
    button.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(button);
    
    button = new JButton(book.getAuthorFirst() + " " + book.getAuthorLast());
    button.setMaximumSize(new Dimension(250, 25));
    panel.add(button);
    
    button = new JButton(book.getGenre());
    button.setMaximumSize(new Dimension(250, 25));
    panel.add(button);
    
    button = new JButton(book.getGrade());
    button.setMaximumSize(new Dimension(250, 25));
    panel.add(button);
		
    Border blackline = BorderFactory.createLineBorder(Color.black);
    panel.setBorder(blackline);
    panel.setAlignmentX(Component.LEFT_ALIGNMENT);
    
    return panel;
		
	}
	
	public static void addComponentsToPane(Container pane, Library library) {
 
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    
		for(Book book : library.getBooks()) {
			JPanel bookPanel = null;
			bookPanel = makeBookPanel(book);
			panel.add(bookPanel);
		}
    
		JScrollPane scrollPane = new JScrollPane(panel);
    
		pane.add(scrollPane);
    
    }
	
	public static void addComponentsToPane(Container pane) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel.add(makeNewField("Name"));
		panel.add(makeNewField("Author Name Name"));
		panel.add(makeNewField("Author Last Name"));
		panel.add(makeNewField("Genre"));
		panel.add(makeNewField("ISBN"));
		panel.add(makeNewField("Grade Level"));
		panel.add(makeNewField("Description"));
		pane.add(panel);
		
		
	}
	
	public static JPanel makeNewField(String s) {
		JPanel temp = new JPanel();
		JLabel lblName = new JLabel(s + ": ");
		temp.add(lblName);
		JTextArea txtName = new JTextArea();
		if(s.equals("Description")) {
			txtName.setColumns(200);
			txtName.setLineWrap(true);
		} else {
			txtName.setColumns(10);
		}
		temp.add(txtName);
		return temp;
	}
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}
