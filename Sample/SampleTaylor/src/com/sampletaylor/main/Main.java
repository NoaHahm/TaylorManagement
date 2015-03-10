package com.sampletaylor.main;

import java.io.IOException;

import com.taylormanagement.core.Management;
import com.taylormanagement.core.tomcat.TomcatManagement;

public class Main {

	public static void main(String[] args) {
		try {
			Management management = new TomcatManagement("localhost", 8081);
			
			System.out.print("Heap Memory Max : ");
			System.out.print(management.getMemoryMXBean().getHeapMemoryUsage().getMax() + "\n");
			System.out.print("Heap Memory Used : ");
			System.out.print(management.getMemoryMXBean().getHeapMemoryUsage().getUsed() + "\n");
			System.out.print("JVM Name : ");
			System.out.print(management.getRuntimeMXBean().getVmName() + "\n");
			System.out.print("SpecVendor : ");
			System.out.print(management.getRuntimeMXBean().getSpecVendor() + "\n");
			System.out.print("OS Name : ");
			System.out.print(management.getOperatingSystemMXBean().getName() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}
