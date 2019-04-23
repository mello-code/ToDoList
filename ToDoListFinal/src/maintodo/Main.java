package maintodo;

import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends javax.swing.JFrame {

	private JFrame frame;
	private JTable table;
	private ArrayList<Item> list;

	public Main() {
		list = new ArrayList<Item>();
		initComponents();
	}

	public void addToList(Item item) {
		list.add(item);
		String[][] data = new String[list.size()][5];
		for (int i=0; i < list.size(); i++)
		{
			data[i][0] =  list.get(i).getStatus().name();
			data[i][1] =  String.valueOf(i + 1);
			data[i][2] =  list.get(i).getDescription();
			data[i][3] =  list.get(i).getDueDate();
			data[i][4] =  list.get(i).getOptionalDate();
		}
		// display data to table
	}

	// Do Not modify this
	private void initComponents() {

		addButton = new javax.swing.JButton();
		editButton = new javax.swing.JButton();
		deleteButton = new javax.swing.JButton();
		restoreButton = new javax.swing.JButton();
		saveButton = new javax.swing.JButton();
		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		listTable = new javax.swing.JTable();
		printButton = new javax.swing.JButton();
		printButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		addButton.setText("Add");
		addButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				onAddClicked(evt);
			}
		});

		editButton.setText("Edit");
		editButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				onEditClicked(evt);
			}
		});

		deleteButton.setText("Delete");
		deleteButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				onDeleteClicked(evt);
			}
		});

		restoreButton.setText("Restore");
		restoreButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				onRestoreClicked(evt);
			}
		});

		saveButton.setText("Save");
		saveButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				onSaveClicked(evt);
			}
		});
		
		printButton.setText("Print");
		printButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				onPrintClicked(evt);
			}
		});

		listTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null } },
				new String[] { "Status", "Priority", "Description", "Due", "Start/End" }));
		jScrollPane1.setViewportView(listTable);
		if (listTable.getColumnModel().getColumnCount() > 0) {
			listTable.getColumnModel().getColumn(2).setMinWidth(300);
			listTable.getColumnModel().getColumn(2).setMaxWidth(300);
		}

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1,
						javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(addButton).addGap(18, 18, 18)
						.addComponent(editButton).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(deleteButton).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(restoreButton).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(saveButton).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(printButton).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))

				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap(12, Short.MAX_VALUE)
								.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(14, 14, 14)));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout.createSequentialGroup().addContainerGap()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(addButton).addComponent(editButton).addComponent(deleteButton)
												.addComponent(restoreButton).addComponent(saveButton).addComponent(printButton))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addContainerGap()));


		pack();
	}

	private void onAddClicked(java.awt.event.ActionEvent evt) {
		System.out.println("Add");
		Add addWindow = new Add();
		addWindow.show();
	}

	private void onEditClicked(java.awt.event.ActionEvent evt) {
		System.out.println("Edit");
	}

	private void onDeleteClicked(java.awt.event.ActionEvent evt) {
		System.out.println("Delete");
	}

	private void onRestoreClicked(java.awt.event.ActionEvent evt) {
		System.out.println("Restore");
	}

	private void onSaveClicked(java.awt.event.ActionEvent evt) {
		System.out.println("Save");
	}

	private void onPrintClicked(java.awt.event.ActionEvent evt) {
		System.out.println("Print");
	}

	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					new Main().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	private void initialize() {
		frame = new JFrame("To Do List");
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// Pop up a Are you Sure dialog
				int test1 = JOptionPane.showConfirmDialog(frame, "Do you wish to save first?", "Remove Dialog",
						JOptionPane.YES_NO_OPTION);
				if (test1 == JOptionPane.YES_OPTION) {
					// Save current data into file
				}
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JButton addButton;
	private javax.swing.JButton editButton;
	private javax.swing.JButton deleteButton;
	private javax.swing.JButton restoreButton;
	private javax.swing.JButton saveButton;
	private javax.swing.JButton printButton;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable listTable;
	// End of variables declaration
}
