package maintodo;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;

public class App {

	private JFrame frame;
	private static ArrayList<Item> list;
	private static ArrayList<Item> session;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new Main(); // show main to do list
	}
	
	public static void setSession(ArrayList<Item> list)
	{
		System.out.println("Save List in App");
		for (int i = 0; i < list.size(); i++) {
			session.add(i, list.get(i)); // BROKEN: nullptr error
		}
	}
	
	public static ArrayList<Item> getSession()
	{
		return session;
	}

}
