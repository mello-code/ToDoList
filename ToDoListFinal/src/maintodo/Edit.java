package maintodo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class Edit extends javax.swing.JFrame
{
	public Edit()
	{
		setType(Type.POPUP);
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Edit an item");
		initComponents();
	}

	// Do not modify this
	private void initComponents()
	{
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		descriptionTextField = new javax.swing.JTextField();
		dueDateLabel = new javax.swing.JLabel();
		dueDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		dueDateDayTextField = new javax.swing.JTextField();
		priorityLabel = new javax.swing.JLabel();
		priorityLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		dueDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		priorityTextField = new javax.swing.JTextField();
		notStartedButton = new javax.swing.JRadioButton();
		inProgressButton = new javax.swing.JRadioButton();
		completedButton = new javax.swing.JRadioButton();

		saveButton = new javax.swing.JButton();
		saveButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseReleased(MouseEvent e)
			{
				// When Save button is hit
				if (descriptionTextField.getText().equals("") || dueDateDayTextField.getText().equals("") || priorityTextField.getText().equals("")
						|| dueDateMonthTextField.getText().equals("")
						|| (!notStartedButton.isEnabled() && !inProgressButton.isEnabled() && !completedButton.isEnabled()))
				{
					// Display error when conditions are not met
					errorLabel.setText("Some error occured idk");
				}
				else
				{
					// Save item to list and close this window
					Item item = new Item();
					item.setDescription(descriptionTextField.getText());
					item.setDueDate(dueDateDayTextField.getText() + "/" + dueDateMonthTextField.getText());
					// TODO set priority 
					if (inProgressButton.isEnabled())
						item.setOptionalDate("-"); // If "not started option is chosen, display - for Start/End"
					else
						item.setOptionalDate("Today's date; implement later"); // else date of Start/End must be the same as the date it was created
					setVisible(false);
					dispose();
				}
			}
		});
		
		cancelButton = new javax.swing.JButton();
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				setVisible(false);
				dispose();
			}
		});
		
		detailLabel = new JLabel("Details  \u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014");

		decriptionLabel = new JLabel();
		decriptionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		decriptionLabel.setText("Description:");
		
		dueDateLabel.setText("Due Date:");
		slash = new JLabel();
		slash.setText("/");
		dueDateMonthTextField = new JTextField();

		priorityLabel.setText("Priority:");

		statusLabel = new JLabel();
		statusLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		statusLabel.setText("Status:");
		
		notStartedButton.setText("Not Started");
		inProgressButton.setText("In Progress");	
		completedButton.setText("Completed");

		errorLabel = new JLabel("                                         ");
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setForeground(Color.RED);
		
		saveButton.setText("Save");
		cancelButton.setText("Cancel");
		
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup()
							.addContainerGap()
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
									.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addComponent(priorityLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(dueDateLabel, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
										.addComponent(decriptionLabel, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
										.addComponent(statusLabel, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED, 7, GroupLayout.PREFERRED_SIZE)
									.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
											.addGap(6)
											.addGroup(layout.createParallelGroup(Alignment.LEADING)
												.addGroup(layout.createSequentialGroup()
													.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
														.addComponent(priorityTextField)
														.addGroup(layout.createSequentialGroup()
															.addComponent(dueDateDayTextField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
															.addGap(6)
															.addComponent(slash)))
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(dueDateMonthTextField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
												.addComponent(descriptionTextField, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)))
										.addGroup(layout.createSequentialGroup()
											.addGap(1)
											.addGroup(layout.createParallelGroup(Alignment.LEADING)
												.addComponent(inProgressButton)
												.addComponent(errorLabel, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
												.addComponent(notStartedButton, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
												.addComponent(completedButton, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))))
									.addGap(25))
								.addGroup(layout.createSequentialGroup()
									.addComponent(detailLabel)
									.addPreferredGap(ComponentPlacement.RELATED))))
						.addGroup(layout.createSequentialGroup()
							.addGap(67)
							.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
							.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
							.addGap(42)))
					.addGap(30))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(detailLabel)
					.addGap(10)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(decriptionLabel)
						.addComponent(descriptionTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(dueDateLabel)
						.addComponent(dueDateDayTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(dueDateMonthTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(slash))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(priorityTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(priorityLabel))
					.addGap(8)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(inProgressButton)
						.addComponent(statusLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(notStartedButton)
					.addGap(6)
					.addComponent(completedButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(errorLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>//GEN-END:initComponents


	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[])
	{
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
		{
			if ("Nimbus".equals(info.getName()))
			{
				break;
			}
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				new Add().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton saveButton;
	private javax.swing.JButton cancelButton;
	private javax.swing.JLabel dueDateLabel;
	private javax.swing.JLabel priorityLabel;
	private javax.swing.JLabel errorLabel;
	private javax.swing.JRadioButton notStartedButton;
	private javax.swing.JRadioButton inProgressButton;
	private javax.swing.JRadioButton completedButton;
	private javax.swing.JTextField descriptionTextField;
	private javax.swing.JTextField dueDateDayTextField;
	private javax.swing.JTextField dueDateMonthTextField;
	private javax.swing.JTextField priorityTextField;
	private JLabel detailLabel;
	private JLabel decriptionLabel;
	private JLabel slash;
	private JLabel statusLabel;
}
