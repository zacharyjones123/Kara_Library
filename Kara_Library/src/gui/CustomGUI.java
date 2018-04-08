package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Book;
import main.Library;

public class CustomGUI extends JFrame {
	
	static int width_main_frame = 500;
	static int length_main_frame = 1800;
	static int width_addBook_frame = 500;
	static int length_addBook_frame = 500;
	
	static int fontSize_title = 20;
	static int icon_book_height = 200;
	static int icon_book_width = 200;
	static int label_book_height = 25;
	static int label_book_width = 200;
	


public static void main(String[] args) {
	Library library = new Library();
	
	Book book = library.getBooks().get(2);
	JFrame bookFrame = new JFrame("Kara's Library");
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
	
	ImageIcon imageIcon = new ImageIcon("images/books/9780590411455.jpg", "hello"); // load the image to a imageIcon
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
	
	panel = new JPanel();
	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	panel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
	panel.setPreferredSize(new Dimension(210, 267));
	book = library.getBooks().get(6);
	//Picture
	
	imageIcon = new ImageIcon("images/books/9780152015404.jpg", "hello"); // load the image to a imageIcon
	image = imageIcon.getImage(); // transform it 
	newimg = image.getScaledInstance(icon_book_width, icon_book_height,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	imageIcon = new ImageIcon(newimg);  // transform it back
	
	imageLbl = new JLabel(imageIcon);
	panel.add(imageLbl);
	/////////////////
	
	//Title
	tempLbl = new JLabel(book.getTitle());
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
	
	contentPane.add(panel);
	/////////////////////
	bookFrame.getContentPane().add(contentPane);
	
	//Display the window.
    bookFrame.pack();
    bookFrame.setSize(length_addBook_frame, width_addBook_frame);
    bookFrame.setLocationRelativeTo(null); //To make center
    bookFrame.setVisible(true);
}

}