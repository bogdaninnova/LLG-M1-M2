package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Launcher {

	public static void main(String... strings) {
		CalcM1M2 c = new CalcM1M2();
		int size = 10000;
		ArrayList<Double> listM1 = new ArrayList<Double>(size);
		ArrayList<Double> listM2 = new ArrayList<Double>(size);
		
		int k = 100000;
		while (k --> 0)
			c.iteration();
		
		for (int i = 0; i < size; i++) {
			c.iteration();
			listM1.add(c.m1);
			listM2.add(c.m2);
		}
		
		writeDoubleList(listM1, "listM1");
		writeDoubleList(listM2, "listM2");
		
	}
	
	public static void writeDoubleList(List<Double> averrageList, String name) {
		ListIterator<Double> iter = averrageList.listIterator();
		File file = new File(name + ".txt");
		try {
			@SuppressWarnings("resource")
			FileWriter writer = new FileWriter(file);
			while (iter.hasNext()) writer.append(iter.next() + "\r\n");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
