package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class TestClass extends JFrame{

	  public TestClass(){    
	      this.setSize(300,300);    
	  }

	public static void main(String[] args){

	    EventQueue.invokeLater(new Runnable(){

	          public void run(){          
	            TestClass f = new TestClass();
	            f.setVisible(true);     
	          }
	      }); 
	    }    
	}