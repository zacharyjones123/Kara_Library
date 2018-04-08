package gui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
import javax.swing.UIManager;
import javax.swing.border.Border;

import main.Book;
import main.Library;

public class MainFrameHighDPI {
	
	static int width_main_frame = 500;
	static int length_main_frame = 1800;
	static int width_addBook_frame = 500;
	static int length_addBook_frame = 500;
	
	static int fontSize_title = 20;
	static int icon_book_height = 200;
	static int icon_book_width = 200;
	static int label_book_height = 25 * 2;
	static int label_book_width = 200 * 2;
	
	//Colors
	final static Color GREEN = new Color(154, 165, 127);
	final static Dimension GREEN_BAR = new Dimension(200, 20);
	
	static Library library = new Library();
	
	final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    
    static JLabel lbl_title = new JLabel("Title: ");
    static JTextField txt_title = new JTextField();
    static JLabel lbl_author_last_name = new JLabel("Author Last Name: ");
    static JTextField txt_author_last_name = new JTextField();
    static JLabel lbl_author_first_name = new JLabel("Author First Name: ");
    static JTextField txt_author_first_name = new JTextField();;
    static JLabel lbl_genre = new JLabel("Genre: ");
    static JTextField txt_genre = new JTextField();
    static JLabel lbl_isbn = new JLabel("ISBN: ");
    static JTextField txt_isbn = new JTextField();
    static JLabel lbl_grade_level = new JLabel("Grade Level: ");
    static JTextField txt_grade_level = new JTextField();
    static JLabel lbl_description = new JLabel("Description: ");
    static JTextArea txt_description = new JTextArea();
    static JLabel lbl_subject = new JLabel("Subject: ");
    static JTextField txt_subject = new JTextField();
    static JButton btn_update = new JButton("Update");
    
    static JButton btn_search = new JButton("Search: ");
    static JTextField txt_search = new JTextField();
    static JComboBox cmb_search = new JComboBox(new Object[] {"authorFirst", "authorLast", "genre", "ISBN"});
    
    static JFrame frame;
    static JFrame bookFrame;
    static JFrame displayBookFrame;
	
	private static void createAndShowGUI() {
		////////////////////
		/**
		try { 
		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		    e.printStackTrace();
		}
		**/
		//////////////////////////////////
		
		//Create and set up the window.
        frame = new JFrame("Kara's Library");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("images/icons/apple.png"));
        frame.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //frame.setUndecorated(true);
        
        
        //Set The MenuBar
        setMenuBar(frame, library);
 
        //Set up the content pane.
        addComponentsToPane(frame.getContentPane(), library);
 
        //Display the window.
        frame.pack();
        frame.setSize(length_main_frame, width_main_frame);
        frame.setLocationRelativeTo(null); //To make center
        frame.setVisible(true);
    }
	
	public static void setMenuBar(JFrame frame, Library library) {
		//-------------------------------------------------------------------------
				//-------------------------------------------------------------------------
		        //Create the menu bar.  Make it have a green background.
		        JMenuBar greenMenuBar = new JMenuBar();
		        greenMenuBar.setOpaque(true);
		        greenMenuBar.setBackground(GREEN);
		        greenMenuBar.setPreferredSize(GREEN_BAR);
		        
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
		            	displayBookFrame = new JFrame("Add A Book");
		            	displayBookFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		            	displayBookFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("images/icons/book.png"));
		            	displayBookFrame.setCursor(new Cursor(Cursor.HAND_CURSOR));
		                //frame.setUndecorated(true);
		                
		              //Set up the content pane.
		                addComponentsToPaneBook(displayBookFrame.getContentPane(), library);
		         
		                //Display the window.
		                displayBookFrame.pack();
		                displayBookFrame.setSize(length_addBook_frame, width_addBook_frame);
		                displayBookFrame.setLocationRelativeTo(null); //To make center
		                displayBookFrame.setVisible(true);

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
		        btn_search.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	//We need to search for a certain word
		            	//Need to see what the JComboBox is
		            	
		            	//Is the search box empty?
		            	if(txt_search.getText().equals("")) {
		            		addComponentsToPane(frame.getContentPane(), library);
		            		frame.revalidate();
		            	} else {
		            		
		            		if (((String)cmb_search.getSelectedItem()).equals("authorFirst")){
		            			System.out.println(txt_search.getText());
		            			//Then need to search for author entered
		            			addComponentsToPane(frame.getContentPane(), library, "authorFirst", txt_search.getText());
		            			frame.revalidate();
		            		
		            		} else if(((String)cmb_search.getSelectedItem()).equals("authorLast")) {
		            			addComponentsToPane(frame.getContentPane(), library, "authorLast", txt_search.getText());
		            			frame.revalidate();
		            			
		            		} else if (((String)cmb_search.getSelectedItem()).equals("genre")) {
		            			addComponentsToPane(frame.getContentPane(), library, "genre", txt_search.getText());
		            			frame.revalidate();
		            			//Then need to search by genre specified
		            		
		            		} else if (((String)cmb_search.getSelectedItem()).equals("ISBN")) {
		            			addComponentsToPane(frame.getContentPane(), library, "ISBN", txt_search.getText());
		            			frame.revalidate();
		            			//Then need to search by tags specified
		            			
		            		} else {
		            			System.out.println("No Such Button");
		            		}
		            	
		            	}

		            }
		        });
		        greenMenuBar.add(btn_search);
		        greenMenuBar.add(txt_search);
		        greenMenuBar.add(cmb_search);
		        greenMenuBar.add(Box.createHorizontalGlue());
		        greenMenuBar.add(new JMenu("About"));
		        
		        
		        frame.setJMenuBar(greenMenuBar);
		        //-------------------------------------------------------------------------
		      //-------------------------------------------------------------------------
	}
	
	public static void addBookGUI(Book book) {
		JFrame frame = new JFrame ("MyPanel");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible (true);
	}
	
	public static JPanel makeBookPanel(Book book) {
		
		JPanel panel = new JPanel();
		panel.setAlignmentX(Component.BOTTOM_ALIGNMENT);
 
        JLabel label;
        JButton button;
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setPreferredSize(new Dimension(length_main_frame, 25));
        Border blackline = BorderFactory.createLineBorder(Color.black);
        
       	button = new JButton(book.getTitle());
       	button.setMaximumSize(new Dimension(length_main_frame/5, 25));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setBorder(blackline);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {   	
            	bookFrame = new JFrame("Kara's Library");
            	bookFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            	bookFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("images/icons/book.png"));
            	bookFrame.setCursor(new Cursor(Cursor.HAND_CURSOR));
            	////////////
            	JPanel contentPane = new JPanel();
            	JPanel panel = new JPanel();
            	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            	panel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
            	panel.setPreferredSize(new Dimension(210, 267)); //different because of the border addition
            	
            	
            	//Picture
            	ImageIcon imageIcon = new ImageIcon("images/books/" + book.getISBN() + ".jpg", "hello"); // load the image to a imageIcon
            	Image image = imageIcon.getImage(); // transform it 
            	Image newimg = image.getScaledInstance(icon_book_width, icon_book_height,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            	imageIcon = new ImageIcon(newimg);  // transform it back
            	
            	JLabel imageLbl = new JLabel(imageIcon);
            	panel.add(imageLbl);
            	/////////////////
            	
            	//Title
            	JLabel tempLbl = new JLabel(book.getTitle());
            	tempLbl.setFont(new Font("Serif", Font.PLAIN, fontSize_title));
            	tempLbl.setOpaque(true);
            	tempLbl.setBackground(Color.LIGHT_GRAY);
            	tempLbl.setForeground(Color.BLACK);
            	tempLbl.setBorder(BorderFactory.createLineBorder(Color.black));
            	tempLbl.setMaximumSize(new Dimension(label_book_width, label_book_height));
            	
            	panel.add(tempLbl);
            	//////////////////
            	
            	//Author
            	tempLbl = new JLabel(book.getAuthorFirst() + " " + book.getAuthorLast());
            	tempLbl.setFont(new Font("Serif", Font.PLAIN, fontSize_title));
            	tempLbl.setOpaque(true);
            	tempLbl.setBackground(Color.LIGHT_GRAY);
            	tempLbl.setForeground(Color.BLACK);
            	tempLbl.setBorder(BorderFactory.createLineBorder(Color.black));
            	tempLbl.setMaximumSize(new Dimension(label_book_width, label_book_height));
            	
            	panel.add(tempLbl);
            	/////////////////////
            	
            	contentPane.add(panel);
            	
            	bookFrame.getContentPane().add(contentPane);
        		
        		//Display the window.
                bookFrame.pack();
                bookFrame.setSize(length_addBook_frame, width_addBook_frame);
                bookFrame.setLocationRelativeTo(null); //To make center
                bookFrame.setVisible(true);
            }
        });
        panel.add(button);
    
        label = new JLabel(book.getAuthorFirst() + " " + book.getAuthorLast());
        label.setMaximumSize(new Dimension(length_main_frame/5, 25));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setBorder(blackline);
        panel.add(label);
    
        label = new JLabel(book.getGenre());
        label.setMaximumSize(new Dimension(length_main_frame/5, 25));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setBorder(blackline);
        panel.add(label);
    
        label = new JLabel(book.getGrade());
        label.setMaximumSize(new Dimension(length_main_frame/5, 25));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setBorder(blackline);
        panel.add(label);
		
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
	
	public static void addComponentsToPane(Container pane, Library library, String col, String search) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		//Add Columns
		JPanel bookPanelCol = null;
		bookPanelCol = makeBookPanel(new Book("ISBN", "Title", "Author First", "-Last", "Genre", "Grade", "Description", "Subject"));
		panel.add(bookPanelCol);
		
		
		if(col.equals("authorLast")) {
			for(Book book : library.getBooks()) {
				if(book.getAuthorLast().equals(search)) {
					JPanel bookPanel = null;
					bookPanel = makeBookPanel(book);
					panel.add(bookPanel);
				}
			}
		
		} else if(col.equals("authorFirst")) {
			for(Book book : library.getBooks()) {
				if(book.getAuthorFirst().equals(search)) {
					JPanel bookPanel = null;
					bookPanel = makeBookPanel(book);
					panel.add(bookPanel);
				}
			}
			
		} else if(col.equals("genre")) {
			for(Book book : library.getBooks()) {
				if(book.getGenre().equals(search)) {
					JPanel bookPanel = null;
					bookPanel = makeBookPanel(book);
					panel.add(bookPanel);
				}
			}
			
		} else if(col.equals("ISBN")) {
			for(Book book : library.getBooks()) {
				if(book.getISBN().equals(search)) {
					JPanel bookPanel = null;
					bookPanel = makeBookPanel(book);
					panel.add(bookPanel);
				}
			}
			
		} else {
			System.out.println("No such search");
		}
    
		JScrollPane scrollPane = new JScrollPane(panel);
    
		pane.add(scrollPane);
	}
	
	public static void addComponentsToPaneBook(Container pane, Library library) {
		btn_update = new JButton("Update");
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel.add(makeNewField("Name", lbl_title, txt_title));
		panel.add(makeNewField("Author Name Name", lbl_author_first_name, txt_author_first_name));
		panel.add(makeNewField("Author Last Name", lbl_author_last_name, txt_author_last_name));
		panel.add(makeNewField("Genre", lbl_genre, txt_genre));
		panel.add(makeNewField("ISBN", lbl_isbn, txt_isbn));
		panel.add(makeNewField("Grade Level", lbl_grade_level, txt_grade_level));
		panel.add(makeNewField("Subject", lbl_subject, txt_subject));
		panel.add(makeNewField("Description", lbl_description, txt_description));
		btn_update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//Check to see if correct book
            	//TODO: Check the book
            	
            	//Add the book
            	library.addBook(new Book(txt_isbn.getText(), txt_title.getText(), txt_author_last_name.getText(),
            					txt_author_first_name.getText(), txt_genre.getText(),
            					txt_grade_level.getText(), txt_description.getText(), txt_subject.getText()));
            	
            	
            	//addComponentsToPane(frame.getContentPane(), library);
            	frame.dispose();
            	frame = null;
            	displayBookFrame.dispose();
            	displayBookFrame.revalidate();
            	//bookFrame = null;
            	createAndShowGUI();
            	txt_title.setText("");
            	txt_author_last_name.setText("");
            	txt_author_first_name.setText("");
            	txt_genre.setText("");
            	txt_isbn.setText("");
            	txt_grade_level.setText("");
            	txt_description.setText("");
            	txt_subject.setText("");
            	
            	//Need to rewrite the txt file
            	File fold=new File("src/main/isbn.txt");

            	try {
            	    FileWriter f2 = new FileWriter(fold, true);
            	    f2.write(library.getBooks().get(library.getBooks().size()-1).toString());
            	    f2.close();
            	} catch (IOException f) {
            	    f.printStackTrace();
            	}    
            	

            }
        });
		panel.add(btn_update);
		pane.add(panel);
		
		
	}
	
	public static JPanel makeNewField(String s, JLabel label, JTextField txt) {
		JPanel temp = new JPanel();
		temp.add(label);
		if(s.equals("Description")) {
			txt.setColumns(200);
		} else {
			txt.setColumns(10);
		}
		temp.add(txt);
		return temp;
	}
	
	public static JPanel makeNewField(String s, JLabel label, JTextArea txt) {
		JPanel temp = new JPanel();
		temp.add(label);
		txt.setLineWrap(true);
		txt.setWrapStyleWord(true);
		JScrollPane areaScrollPane = new JScrollPane(txt);
		areaScrollPane.setVerticalScrollBarPolicy(
		                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setPreferredSize(new Dimension(250, 250));
		temp.add(areaScrollPane);
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
