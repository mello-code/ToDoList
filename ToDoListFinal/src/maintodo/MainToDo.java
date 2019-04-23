package maintodo;

import java.util.ArrayList;

public class MainToDo
{
	public static void main(String[] args)
	{
		MainToDoList m = new MainToDoList();

		ArrayList<Item> list = new ArrayList<Item>();
		m.show();
	}
}