package ch.botta.game.test;

import java.util.HashMap;
import java.util.Map;

import ch.botta.game.objects.FieldPosition;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FieldPosition a = new FieldPosition(0, 0, "Hexagon");
		FieldPosition b = new FieldPosition(0, 1, "Hexagon");
		
		Map<FieldPosition, Object> map = new HashMap<FieldPosition, Object>();
		map.put(a, new Object());
		System.out.println(map.containsKey(b));
	}

}
