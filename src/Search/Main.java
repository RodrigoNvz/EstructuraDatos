package Search;

import javax.xml.crypto.Data;

public class Main {
	
	
	public int linearSearch(Data values[], Data target) {
		int index = 0;
		while(index < values.length) {
			if(values[index] == target) {
				return index;
			}
			if(values[index] != target) {
				return -1;
			}
			index++;
	   }
	   return -1;
	}
}
