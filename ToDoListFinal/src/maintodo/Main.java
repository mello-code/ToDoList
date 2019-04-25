package maintodo;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.RowSorter;
import javax.swing.SortOrder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * NOTE: Design tab will only work when variable listTable isn't static.
 * However, program won't run if it isn't static. When messing with desgin tab,
 * remove static modifier and add it back before running it
 */

public class Main extends javax.swing.JFrame
{

	private JFrame frame;
	private JTable table;
	private static int selectedItem;
	private static ArrayList<Item> list;
	private static ArrayList<Item> session;

	public Main()
	{
		setTitle("To Do List");
		list = new ArrayList<Item>();
		session = new ArrayList<Item>();
		initComponents();

		// preset for testing purposes
		Item test = new Item(Status.IN_PROGRESS, "This is a preset", "04/16");
		Item test2 = new Item(Status.IN_PROGRESS, "as a placeholder so you don't have to add new items", "07/18");
		Item test3 = new Item(Status.IN_PROGRESS, "every single time we test some component of the program", "09/01");
		Item test4 = new Item(Status.IN_PROGRESS, "If you wish to start the program without these preadded items", "09/01");
		Item test5 = new Item(Status.IN_PROGRESS, "comment out line 65 to 78", "09/23");
		Item blank = new Item(Status.IN_PROGRESS, "", "--/--");
		Item test6 = new Item(Status.IN_PROGRESS, "Actual To-Do:", "10/04");
		Item test7 = new Item(Status.IN_PROGRESS, "replace buttons with images", "11/18");
		Item test8 = new Item(Status.IN_PROGRESS, "work on default sorting based on status", "11/18");
		Item test9 = new Item(Status.NOT_STARTED, "priority insertion and status tooltip", "12/31");
		Item test10 = new Item(Status.NOT_STARTED, "highlight boxes with red when encountering errors", "12/31");
		Item test11 = new Item(Status.NOT_STARTED, "description dynamic tabbing for report", "12/31");
		Item test12 = new Item(Status.NOT_STARTED, "this is a completed item", "06/27");
		Item test13 = new Item(Status.NOT_STARTED, "this is a deleted item", "06/05");
		test.setOptionalDate("04/12");
		test2.setOptionalDate("04/14");
		test3.setOptionalDate("04/14");
		test4.setOptionalDate("04/25");
		test5.setOptionalDate("05/01");
		test6.setOptionalDate("05/01");
		test7.setOptionalDate("05/01");
		test8.setOptionalDate("05/07");
		test12.setStatus(Status.COMPLETED);
		test12.setOptionalDate("06/05");
		test13.setStatus(Status.DELETED);
		test13.setOptionalDate("06/05");

		// Comment this out to disable preset.
		// Currently, updating the list overwrites the tableModel and therefore
		// disregards table formats set by WindowBuilder (till I update it)

		list.add(test);
		list.add(test2);
		list.add(test3);
		list.add(test4);
		list.add(test5);
		list.add(blank);
		list.add(blank);
		list.add(test6);
		list.add(blank);
		list.add(test7);
		list.add(test8);
		list.add(test9);
		list.add(test10);
		list.add(test11);
		list.add(test12);
		addToList(test13, -1);

	}

	public static void addToList(Item item, int priority)
	{
		// add item to list
		switch (priority)
		{
			case -1: // add a completed item
				int index = 0;
				for (Item i : list)
				{
					if (i.getStatus() == Status.DELETED)
						break;
					index++;
				}
				list.add(index, item);
				break;
			default:
				if (priority < list.size()
						&& (list.get(priority).getStatus() == Status.NOT_STARTED || list.get(priority).getStatus() == Status.IN_PROGRESS))
					list.add(priority - 1, item);
				else
				{
					int newPriority = priority - 1;
//					while (list.get(newPriority).getStatus())
//					{
//						
//					}
				}
				break;
		}

		refreshTable();
	}

	public static void editItem(Item item, int priority)
	{
		list.remove(selectedItem);
		list.add(priority, item);
	}

	public static Item fetchItem()
	{
		return list.get(selectedItem);
	}

	public static ArrayList<Item> fetchItems()
	{
		return list;
	}

	public static int fetchIndex()
	{
		return selectedItem;
	}

	public static void refreshTable()
	{
		// set up data[][] for refreshing the table
		tableModel newModel = new tableModel();
		for (int i = 0; i < list.size(); i++)
		{
			newModel.setValueAt(statusToSymbol(list.get(i).getStatus()), i, 0);
			newModel.setValueAt(i + 1, i, 1);
			newModel.setValueAt("  " + list.get(i).getDescription(), i, 2);
			newModel.setValueAt(list.get(i).getDueDate(), i, 3);
			newModel.setValueAt(list.get(i).getOptionalDate(), i, 4);
		}
		for (int i = list.size(); i < 26; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				newModel.setValueAt(null, i, j);
			}
		}
		// display data to table
		listTable.setModel(newModel);
		veryElegantFormattingForJTable();
	}

	public static void veryElegantFormattingForJTable()
	{
		// cover your eyes
		DefaultTableCellRenderer leftRenderer = new customTableCellRenderer();
		DefaultTableCellRenderer centerRenderer = new customTableCellRenderer();
		DefaultTableCellRenderer rightRenderer = new customTableCellRenderer();

		leftRenderer.setHorizontalAlignment(JLabel.LEFT);
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);

		listTable.getColumnModel().getColumn(0).setResizable(false);
		listTable.getColumnModel().getColumn(1).setResizable(false);
		listTable.getColumnModel().getColumn(2).setResizable(false);
		listTable.getColumnModel().getColumn(3).setResizable(false);
		listTable.getColumnModel().getColumn(4).setResizable(false);

		listTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		listTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		listTable.getColumnModel().getColumn(2).setCellRenderer(leftRenderer);
		listTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		listTable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

		listTable.getColumnModel().getColumn(0).setMaxWidth(50);
		listTable.getColumnModel().getColumn(1).setMaxWidth(50);
		listTable.getColumnModel().getColumn(2).setPreferredWidth(320);
		listTable.getColumnModel().getColumn(3).setMaxWidth(60);
		listTable.getColumnModel().getColumn(4).setMaxWidth(60);
	}

	private static String statusToSymbol(Status s)
	{
		switch (s)
		{
			case NOT_STARTED:
				return "\u2013";
			case IN_PROGRESS:
				return "\u2053";
			case COMPLETED:
				return "\u2713";
			default:
				return "\u2613";
		}
	}

	// Do Not modify this
	private void initComponents()
	{

		addButton = new javax.swing.JButton();
		editButton = new javax.swing.JButton();
		deleteButton = new javax.swing.JButton();
		saveButton = new javax.swing.JButton();
		restoreButton = new javax.swing.JButton();
		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		listTable = new javax.swing.JTable();
		printButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE); // config to save

		addButton.setText("Add");
		addButton.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				onAddClicked(evt);
			}
		});

		editButton.setText("Edit");
		editButton.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				onEditClicked(evt);
			}
		});

		deleteButton.setText("Delete");
		deleteButton.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				onDeleteClicked(evt);
			}
		});

		saveButton.setText("Save");
		saveButton.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				onSaveClicked(evt);
			}
		});

		restoreButton.setText("Restore");
		restoreButton.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				onRestoreClicked(evt);
			}
		});

		printButton.setText("Print");
		printButton.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				try
				{
					onPrintClicked(evt);
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		listTable.setAutoCreateRowSorter(true);
		listTable.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null }, },
				new String[] { "Status", "Priority", "Description", "Due", "Start/End" }));

		TableRowSorter<TableModel> sorter = new TableRowSorter<>(listTable.getModel());
		listTable.setRowSorter(sorter);

		ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>();
		int columnIndexToSort = 1;
		sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
		sorter.setSortKeys(sortKeys);
		sorter.sort();

		listTable.getColumnModel().getColumn(0).setResizable(false);
		listTable.getColumnModel().getColumn(0).setPreferredWidth(40);
		listTable.getColumnModel().getColumn(1).setResizable(false);
		listTable.getColumnModel().getColumn(1).setPreferredWidth(40);
		listTable.getColumnModel().getColumn(2).setResizable(false);
		listTable.getColumnModel().getColumn(2).setPreferredWidth(320);
		listTable.getColumnModel().getColumn(3).setResizable(false);
		listTable.getColumnModel().getColumn(3).setPreferredWidth(70);
		listTable.getColumnModel().getColumn(4).setResizable(false);
		listTable.getColumnModel().getColumn(4).setPreferredWidth(70);
		jScrollPane1.setViewportView(listTable);
		if (listTable.getColumnModel().getColumnCount() > 0)
		{
			listTable.getColumnModel().getColumn(2).setMinWidth(300);
			listTable.getColumnModel().getColumn(2).setMaxWidth(300);
		}

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane1,
				javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout
				.createSequentialGroup().addContainerGap().addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)));

		JLabel lblToDoList = new JLabel(" To Do List");
		lblToDoList.setFont(new Font("Dialog", Font.PLAIN, 20));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.TRAILING).addGroup(layout.createSequentialGroup()
				.addContainerGap(12, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(layout.createSequentialGroup()
								.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(14))
						.addGroup(layout.createSequentialGroup()
								.addComponent(lblToDoList, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(addButton)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(editButton).addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(deleteButton).addPreferredGap(ComponentPlacement.RELATED).addComponent(saveButton)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(restoreButton).addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(printButton).addContainerGap()))));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(11)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(editButton).addComponent(deleteButton)
								.addComponent(saveButton).addComponent(restoreButton).addComponent(printButton).addComponent(addButton)
								.addComponent(lblToDoList, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addContainerGap()));
		getContentPane().setLayout(layout);

		pack();
	}

	static class customTableCellRenderer extends DefaultTableCellRenderer
	{
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
		{
			Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			if (row < list.size())
			{
				switch (list.get(row).getStatus())
				{
					case IN_PROGRESS:
						c.setForeground(Color.DARK_GRAY);
						break;
					case COMPLETED:
						c.setForeground(new Color(77, 189, 144));
						break;
					case DELETED:
						c.setForeground(new Color(255, 16, 83));
						break;
					default:
						c.setForeground(new Color(125, 125, 125));
				}
			}
			return c;
		}
	}

	static class tableModel extends AbstractTableModel
	{
		private String[] columnNames = { "Status", "Priority", "Description", "Due", "Start/End" };
		private Object[][] data = new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null }, };

		public int getColumnCount()
		{
			return columnNames.length;
		}

		public int getRowCount()
		{
			return data.length;
		}

		public String getColumnName(int col)
		{
			return columnNames[col];
		}

		public Object getValueAt(int row, int col)
		{
			return data[row][col];
		}

		public Class getColumnClass(int c)
		{
			return getValueAt(0, c).getClass();
		}

		public boolean isCellEditable(int row, int col)
		{
			if (col < 2)
			{
				return false;
			}
			else
			{
				return true;
			}
		}

		public void setValueAt(Object value, int row, int col)
		{
			data[row][col] = value;
			fireTableCellUpdated(row, col);
		}
	}

	private void onAddClicked(java.awt.event.ActionEvent evt)
	{
		Add addWindow = new Add();
		addWindow.show();
	}

	private void onEditClicked(java.awt.event.ActionEvent evt)
	{
		int selectedRow = listTable.getSelectedRow();
		if (selectedRow >= 0 && selectedRow < list.size() && list.get(selectedRow).getStatus() != Status.DELETED)
		{
			selectedItem = listTable.getSelectedRow();

			Edit editWindow = new Edit();
			editWindow.show();
		}
	}

	private void onDeleteClicked(java.awt.event.ActionEvent evt)
	{
		if (listTable.getSelectedRow() < list.size())
		{
			list.remove(listTable.getSelectedRow());
			refreshTable();
		}

	}

	private void onSaveClicked(java.awt.event.ActionEvent evt)
	{
		System.out.println("Save");
		App.setSession(list);
	}

	private void onRestoreClicked(java.awt.event.ActionEvent evt)
	{
		System.out.println("Restore");
		session = new ArrayList<Item>();
		session = App.getSession();
		for (Item i : session) { // ERROR: nullptr on session
			list.add(i);
		}
	}

	private void onPrintClicked(java.awt.event.ActionEvent evt) throws IOException
	{
		System.out.println("Print");
		writePrintFile();
		try
		{
			Runtime.getRuntime().exec("notepad ToDoList.txt");
		} catch (IOException e)
		{
		}
	}

	public void writePrintFile() throws IOException
	{
		FileWriter write = new FileWriter("ToDoList.txt", false);
		PrintWriter print = new PrintWriter(write);
		print.printf("%s" + "\t", "Priority:");
		print.printf("%s", padRight("Description:", 70));
		print.printf("%s", padRight("Status:", 18));
		print.printf("%s", padRight("Due Date:", 18));
		print.printf("%s", padRight("Date Started/Finished:", 20));
		print.printf("%n");
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i).getStatus().name() != "DELETED")
			{
				print.printf("%d" + "\t\t", i + 1);
				print.printf("%s", padRight(list.get(i).getDescription(), 70));
				print.printf("%s", padRight(list.get(i).getStatus().name(), 18));
				print.printf("%s", padRight(list.get(i).getDueDate(), 18));
				print.printf("%s", padRight(list.get(i).getOptionalDate(), 20));
				print.printf("%n");
			}
		}
		print.printf("%n" + "%s" + "%n", "Deleted Items:");
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i).getStatus().name() == "DELETED")
			{
				print.printf("%s" + "\t\t", "-");
				print.printf("%s", padRight(list.get(i).getDescription(), 70));
				print.printf("%s", padRight(list.get(i).getStatus().name(), 18));
				print.printf("%s", padRight(list.get(i).getDueDate(), 18));
				print.printf("%s", padRight(list.get(i).getOptionalDate(), 20));
				print.printf("%n");
			}
		}
		print.close();
	}

	public static String padRight(String s, int n)
	{
		return String.format("%-" + n + "s", s);
	}

	public static void main(String args[])
	{
		try
		{
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Main window = new Main();
					new Main().setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});

	}

	private void initialize()
	{
		frame = new JFrame("To Do List");
		frame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				// Pop up a Are you Sure dialog
				int test1 = JOptionPane.showConfirmDialog(frame, "Do you wish to save first?", "Remove Dialog", JOptionPane.YES_NO_OPTION);
				if (test1 == JOptionPane.YES_OPTION)
				{
					// Save current data into file
				}
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JButton addButton;
	private javax.swing.JButton editButton;
	private javax.swing.JButton deleteButton;
	private javax.swing.JButton saveButton;
	private javax.swing.JButton restoreButton;
	private javax.swing.JButton printButton;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private static javax.swing.JTable listTable; // Design tab only works when listTable isn't static
}
