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
		jLabel2 = new javax.swing.JLabel();
		dueDateDayTextField = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		priorityTextField = new javax.swing.JTextField();
		status1RButton = new javax.swing.JRadioButton();
		saveButton = new javax.swing.JButton();
		saveButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseReleased(MouseEvent e)
			{
				// When Save button is hit
				if (descriptionTextField.getText().equals("") || dueDateDayTextField.getText().equals("") || priorityTextField.getText().equals("")
						|| dueDateMonthTextField.getText().equals("")
						|| (!status1RButton.isEnabled() && !status2RButton.isEnabled() && !status3RButton.isEnabled()))
				{
					// Display error when conditions are not met
					errorLabel.setText("Some error occured idk");
				}
				else
				{
					// Save item to list and close this window
					Item item = new Item();
					item.setDescription(dueDateDayTextField.getText());
					item.setDueDate(priorityTextField.getText() + "/" + dueDateMonthTextField.getText());
					if (status1RButton.isEnabled())
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

		jLabel2.setText("Due Date:");

		dueDateDayTextField.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jTextField2ActionPerformed(evt);
			}
		});

		jLabel3.setText("Priority:");

		priorityTextField.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jTextField3ActionPerformed(evt);
			}
		});

		status1RButton.setText("Not Started");
		status1RButton.addActionListener(new java.awt.event.ActionListener()
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
		
		lblDetails = new JLabel("Details  \u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014");
		
		label = new JLabel();
		label.setText("Description:");
		
		dueDateMonthTextField = new JTextField();
		
		label_1 = new JLabel();
		label_1.setText("/");
		
		lblStatus = new JLabel();
		lblStatus.setText("Status:");
		
		JRadioButton status2RButton = new JRadioButton();
		status2RButton.setText("Not Started");
		
		JRadioButton Status3RButton = new JRadioButton();
		Status3RButton.setText("Not Started");
		
		label_2 = new JLabel("                                              ");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup()
							.addContainerGap()
							.addGroup(layout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2)
								.addComponent(jLabel3)
								.addGroup(layout.createSequentialGroup()
									.addGap(24)
									.addComponent(lblStatus, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)))
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
									.addGap(6)
									.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addComponent(descriptionTextField, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
										.addGroup(layout.createSequentialGroup()
											.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(priorityTextField)
												.addGroup(layout.createSequentialGroup()
													.addComponent(dueDateDayTextField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
													.addGap(6)
													.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE)))
											.addGap(6)
											.addComponent(dueDateMonthTextField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))))
								.addGroup(layout.createSequentialGroup()
									.addGap(1)
									.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addComponent(status2RButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
										.addComponent(status1RButton)
										.addComponent(Status3RButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
										.addComponent(errorLabel, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE))))
							.addGap(54))
						.addGroup(layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblDetails)
							.addGap(30))
						.addComponent(label_2)
						.addGroup(layout.createSequentialGroup()
							.addGap(67)
							.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
							.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
							.addGap(42)))
					.addGap(30))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGap(166)
							.addComponent(Status3RButton))
						.addGroup(layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblDetails)
							.addGap(10)
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(descriptionTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel2)
								.addComponent(dueDateDayTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(dueDateMonthTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(priorityTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel3))
							.addGap(8)
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblStatus)
								.addComponent(status1RButton))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(status2RButton)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(errorLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(32, Short.MAX_VALUE))
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
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel errorLabel;
	private javax.swing.JRadioButton status1RButton;
	private javax.swing.JRadioButton status2RButton;
	private javax.swing.JRadioButton status3RButton;
	private javax.swing.JTextField descriptionTextField;
	private javax.swing.JTextField dueDateDayTextField;
	private javax.swing.JTextField priorityTextField;
	private JLabel lblDetails;
	private JLabel label;
	private JTextField dueDateMonthTextField;
	private JLabel label_1;
	private JLabel lblStatus;
	private JLabel label_2;
}
