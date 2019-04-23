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
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Add extends javax.swing.JFrame
{
	public Add()
	{
		setType(Type.POPUP);
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Add a new item");
		initComponents();
	}

	// Do not modify this
	private void initComponents()
	{
		descriptionTextField = new javax.swing.JTextField();
		dueDateLabel = new javax.swing.JLabel();
		dueDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		dueDateDayTextField = new javax.swing.JTextField();
		priorityLabel = new javax.swing.JLabel();
		priorityLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		dueDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		priorityTextField = new javax.swing.JTextField();
		inProgressButton = new javax.swing.JRadioButton();
		saveButton = new javax.swing.JButton();
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		saveButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseReleased(MouseEvent e)
			{
				//String text = priorityTextField.getText();
				//System.out.println(Integer.parseInt(text));
				// When Save button is hit
				if (descriptionTextField.getText().equals("") || dueDateDayTextField.getText().equals("") || priorityTextField.getText().equals("")
						|| dueDateMonthTextField.getText().equals("")
						|| (!inProgressButton.isEnabled() && !status2RButton.isEnabled() && !status3RButton.isEnabled()))
				{
					String priorityText = priorityTextField.getText();
					//System.out.println(Integer.parseInt(priorityText));
					try{
					    int number = Integer.parseInt(priorityText);
					}catch (NumberFormatException ex) 
					{
					    errorLabel.setText("Priorty field must be an integer!");
					    
					}
					if(descriptionTextField.getText().equals(""))
					{
						errorLabel.setText("Description field cannot be empty!");
					}
					else if(dueDateDayTextField.getText().equals("")) 
					{
						errorLabel.setText("Date field cannot be empty!");
					}
					else if(dueDateMonthTextField.getText().equals(""))
					{
						errorLabel.setText("Date field cannot be empty!");
					}
					else if(priorityTextField.getText().equals(""))
					{
						errorLabel.setText("Priority field cannot be empty!");
					}
					
					else if(Integer.parseInt(priorityText) < 1)
					{
						
						errorLabel.setText("Priority must be greater than 0!");
					}
					else if(!inProgressButton.isEnabled() && !status2RButton.isEnabled() && !status3RButton.isEnabled())
					{
						errorLabel.setText("A status must be selected!");
					}
				}
				else
				{
					// Save item to list and close this window
					Item item = new Item();
					item.setDescription(dueDateDayTextField.getText());
					item.setDueDate(priorityTextField.getText() + "/" + dueDateMonthTextField.getText());
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

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		dueDateLabel.setText("Due Date:");

		dueDateDayTextField.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jTextField2ActionPerformed(evt);
			}
		});

		priorityLabel.setText("Priority:");

		priorityTextField.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jTextField3ActionPerformed(evt);
			}
		});

		inProgressButton.setText("In Progress");
		inProgressButton.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jRadioButton1ActionPerformed(evt);
			}
		});

		saveButton.setText("Save");

		cancelButton.setText("Cancel");
		cancelButton.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jButton2ActionPerformed(evt);
			}
		});
		
		errorLabel = new JLabel("                                         ");
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setForeground(Color.RED);
		
		detailLabel = new JLabel("Details —————————————————————————————");
		
		decriptionLabel = new JLabel();
		decriptionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		decriptionLabel.setText("Description:");
		
		dueDateMonthTextField = new JTextField();
		
		slash = new JLabel();
		slash.setText("/");
		
		statusLabel = new JLabel();
		statusLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		statusLabel.setText("Status:");
		
		JRadioButton notStartedButton = new JRadioButton();
		notStartedButton.setText("Not Started");
		
		JRadioButton completedButton = new JRadioButton();
		completedButton.setText("Completed");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(priorityLabel, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
								.addComponent(dueDateLabel, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
								.addComponent(decriptionLabel, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
								.addComponent(statusLabel, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 7, GroupLayout.PREFERRED_SIZE)
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
									.addGap(1)
									.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addComponent(inProgressButton)
										.addComponent(errorLabel, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
										.addComponent(notStartedButton, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
										.addComponent(completedButton, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)))
								.addGroup(layout.createSequentialGroup()
									.addGap(6)
									.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addComponent(descriptionTextField, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
										.addGroup(layout.createSequentialGroup()
											.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(priorityTextField)
												.addGroup(layout.createSequentialGroup()
													.addComponent(dueDateDayTextField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
													.addGap(6)
													.addComponent(slash)))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(dueDateMonthTextField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))))
							.addGap(25))
						.addGroup(layout.createSequentialGroup()
							.addComponent(detailLabel)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(30))
				.addGroup(layout.createSequentialGroup()
					.addGap(66)
					.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
					.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addGap(73))
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
					.addGap(18)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_jTextField2ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField2ActionPerformed

	private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_jTextField3ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField3ActionPerformed

	private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_jRadioButton1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jRadioButton1ActionPerformed

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_jButton2ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jButton2ActionPerformed

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
	private javax.swing.JRadioButton inProgressButton;
	private javax.swing.JRadioButton status2RButton;
	private javax.swing.JRadioButton status3RButton;
	private javax.swing.JTextField descriptionTextField;
	private javax.swing.JTextField dueDateDayTextField;
	private javax.swing.JTextField priorityTextField;
	private JLabel detailLabel;
	private JLabel decriptionLabel;
	private JTextField dueDateMonthTextField;
	private JLabel slash;
	private JLabel statusLabel;
}
