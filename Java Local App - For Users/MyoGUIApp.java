package local;
import java.awt.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.Timer;


import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class MyoGUIApp extends Frame implements ActionListener
{
	private Label lblCount;
	private Label rules;
	private TextField tfCount;
	private Button startButton;
	private JTextField userName;
	private JTextField passWord;
	private Button submitLogin;
	private int count = 0;
	boolean submitted = false;
	Date date = new Date();
	private Button closeRecorder;
    ActionListener listener;
    private String user;
    private  String pswd;

	public MyoGUIApp() throws Exception
	{
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

		JPanel instructionsPanel = new JPanel();
		instructionsPanel.setLayout(new FlowLayout());
		add(instructionsPanel);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(new FlowLayout());
		add(loginPanel);
		
		JPanel recordPanel = new JPanel();
		recordPanel.setLayout(new FlowLayout());
		add(recordPanel);
		
		this.setBackground(new Color(41, 171, 135));
		
		rules = new Label("LOGIN BEFORE YOU START RECORDING. ELSE DATA WILL NOT GO TO PROFILE!");
		rules.setFont(new Font("SansSerif Bold", 12, 16));
		rules.setForeground(Color.RED);
		instructionsPanel.add(rules);
		
		lblCount = new Label("Please Click on Start to start Recording and Close to stop recording/close app.");
		lblCount.setFont(new Font("SansSerif Bold", 12, 16));
		instructionsPanel.add(lblCount);
		
		userName = new JTextField("UserName");
		userName.setBackground(new Color(138,255,255));
		userName.setFont(new Font("SansSerif Bold", 12, 16));
		userName.setPreferredSize(new Dimension(200, 50));
		loginPanel.add(userName);
		
		passWord = new JTextField("Password");
		passWord.setBackground(new Color(138,255,255));
		passWord.setFont(new Font("SansSerif Bold", 12, 16));
		passWord.setPreferredSize(new Dimension(200, 50));
		loginPanel.add(passWord);
		
		submitLogin = new Button("Submit");
		submitLogin.setBackground(new Color(21,200,117));
		submitLogin.setFont(new Font("SansSerif Bold", 12, 16));
		submitLogin.setPreferredSize(new Dimension(100, 50));
		loginPanel.add(submitLogin);
				
		//startButton.addActionListener(this);
		//submitLogin.addActionListener(this);
		
		startButton = new Button("Start Recording");
		startButton.setBackground(new Color(28,145,190));
		startButton.setFont(new Font("SansSerif Bold", 12, 16));
		startButton.setPreferredSize(new Dimension(155, 50));
		recordPanel.add(startButton);
		
		closeRecorder = new Button ("Stop Recording/Close");
		closeRecorder.setBackground(new Color(0,255,127));
		closeRecorder.setFont(new Font("SansSerif Bold", 12, 16));
		closeRecorder.setPreferredSize(new Dimension(155, 50));
		recordPanel.add(closeRecorder);
		
		setTitle("MyoRecorder");
		setSize(650,500);
		
		repaint();
		
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					execute();
					System.out.println("Inside startButton");
				} catch (Exception e1) {
					System.out.println("");;
				}
			}
		});
		
		closeRecorder.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        //call another method in the same class which will close this Jframe
				System.out.println("Inside closeRecorder");
				closeTheRecorder();
		    }
		});
		
		submitLogin.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	user = userName.getText();
		    	userName.setText("");
		    	pswd = passWord.getText();
		    	passWord.setText("");
		    	submitLogin.setVisible(false);
		    	userName.setVisible(false);
		    	passWord.setVisible(false);
		    	repaint();
		    	System.out.println(user);
				System.out.println(pswd);
		    }
		});
		//user = userName.getText();
		//pswd = passWord.getText();
		setVisible(true);

		
	}
	public static void main(String[]args) throws Exception
	{
		MyoGUIApp myo = new MyoGUIApp();
	}
		public void closeTheRecorder()
		{
			this.dispose();
		}
		public void run() throws Exception{
		
			MyoAppLogicRunner myo2 = new MyoAppLogicRunner(user,pswd);
			myo2.run();

		}
		
		public void actionPerformed(ActionEvent evt)
		{
//			++count;
//			try {
//				execute();
//				pause.start();
//
//			} catch (Exception e) {
//				System.out.println("");;
//			}
	}
		
		public void execute() throws Exception
		{
			run();
//			Process pro = null;
//					//Runtime.getRuntime().exec("C:\\Users\\sanja\\eclipse-workspace\\MyoWorkspace\\MyoAppLogicRunner.java");
//					//"C:\\Sanjay\\CalHacks\\MyoLocalProgramExe.exe");
//			shutdown = pro.waitFor(30L, TimeUnit.SECONDS);
//			pro.destroy();
		}
		
		public String getUser()
		{
			return user;
		}
		
		public String getPassword()
		{
			return pswd;
		}
//		@Override
//		public void keyPressed(KeyEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//		@Override
//		public void keyReleased(KeyEvent e) {
//			if(e.getKeyCode() == KeyEvent.VK_ENTER)
//			{
//				if(userName.getText() != null)
//					user = userName.getText();
//				if(passWord.getText() != null)
//					pswd = passWord.getText();
//				repaint();
//				System.out.println(user);
//				System.out.println(pswd);
//			}
//			
//		}
//		@Override
//		public void keyTyped(KeyEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//			
//		}
}


