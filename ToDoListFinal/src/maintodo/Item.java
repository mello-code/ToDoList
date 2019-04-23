package maintodo;

import maintodo.Status;

public class Item
{
	private Status status;
//	private int priority;
	private String description;
	private String dueDate;
	private String optionalDate;

	public Item()
	{
		status = Status.NOT_STARTED;
//		priority = -1;
		description = "unspecified";
		dueDate = "unspecified";
		optionalDate = "-";
	}

	public Item(String b, String c)
	{
		status = Status.NOT_STARTED;
		description = b;
		dueDate = c;
		optionalDate = "-";
	}

	public Status getStatus()
	{
		return status;
	}

//	public int getPriority()
//	{
//		return priority;
//	}

	public String getDescription()
	{
		return description;
	}

	public String getDueDate()
	{
		return dueDate;
	}

	public String getOptionalDate()
	{
		return optionalDate;
	}

//	public void setPriority(int input)
//	{
//		
//	}

	public void setDescription(String input)
	{
		description = input;
	}

	public void setDueDate(String input)
	{
		dueDate = input;
	}

	public void setOptionalDate(String input)
	{
		optionalDate = input;
	}
}
