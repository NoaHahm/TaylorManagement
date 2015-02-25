/* 
     Java Was Management JMX Library (NoahJMX)
     Copyright (c) 2015 Noah Hahm <dbgtdbz2@naver.com> 
     http://globalbiz.tistory.com
 
     This program is free software: you can redistribute it and/or modify 
     it under the terms of the GNU Affero General Public License as published 
     by the Free Software Foundation, either version 3 of the License, or 
     (at your option) any later version. 
      
     This program is distributed in the hope that it will be useful, 
     but WITHOUT ANY WARRANTY; without even the implied warranty of 
     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the 
     GNU Affero General Public License for more details. 
     
     You should have received a copy of the GNU Affero General Public License 
     along with this program.  If not, see <http://www.gnu.org/licenses/>. 
*/ 
package com.taylormanagement.mbean;

import com.sun.management.OperatingSystemMXBean;


public final class OperatingSystemMbean {
	
	private long committedVirtualMemorySize;
	private long freePhysicalMemorySize;
	private long freeSwapSpaceSize;
	private long processCpuTime;
	private long totalPhysicalMemorySize;
	private long totalSwapSpaceSize;
	private String name;
	private String version;
	private int availableProcessors;
	private String arch;
	private double systemLoadAverage;
	
	public OperatingSystemMbean(OperatingSystemMXBean mxBean) {
		arch = mxBean.getArch();
		availableProcessors = mxBean.getAvailableProcessors();
		committedVirtualMemorySize = mxBean.getCommittedVirtualMemorySize();
		freePhysicalMemorySize = mxBean.getFreePhysicalMemorySize();
		freeSwapSpaceSize = mxBean.getFreeSwapSpaceSize();
		name = mxBean.getName();
		processCpuTime = mxBean.getProcessCpuTime();
		systemLoadAverage = mxBean.getSystemLoadAverage();
		totalPhysicalMemorySize = mxBean.getTotalPhysicalMemorySize();
		totalSwapSpaceSize = mxBean.getTotalSwapSpaceSize();
		version = mxBean.getVersion();
	}

	public long getCommittedVirtualMemorySize() {
		return committedVirtualMemorySize;
	}

	public void setCommittedVirtualMemorySize(long committedVirtualMemorySize) {
		this.committedVirtualMemorySize = committedVirtualMemorySize;
	}

	public long getFreePhysicalMemorySize() {
		return freePhysicalMemorySize;
	}

	public void setFreePhysicalMemorySize(long freePhysicalMemorySize) {
		this.freePhysicalMemorySize = freePhysicalMemorySize;
	}

	public long getFreeSwapSpaceSize() {
		return freeSwapSpaceSize;
	}

	public void setFreeSwapSpaceSize(long freeSwapSpaceSize) {
		this.freeSwapSpaceSize = freeSwapSpaceSize;
	}

	public long getProcessCpuTime() {
		return processCpuTime;
	}

	public void setProcessCpuTime(long processCpuTime) {
		this.processCpuTime = processCpuTime;
	}
	
	public long getTotalPhysicalMemorySize() {
		return totalPhysicalMemorySize;
	}

	public void setTotalPhysicalMemorySize(long totalPhysicalMemorySize) {
		this.totalPhysicalMemorySize = totalPhysicalMemorySize;
	}

	public long getTotalSwapSpaceSize() {
		return totalSwapSpaceSize;
	}

	public void setTotalSwapSpaceSize(long totalSwapSpaceSize) {
		this.totalSwapSpaceSize = totalSwapSpaceSize;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getAvailableProcessors() {
		return availableProcessors;
	}

	public void setAvailableProcessors(int availableProcessors) {
		this.availableProcessors = availableProcessors;
	}

	public String getArch() {
		return arch;
	}

	public void setArch(String arch) {
		this.arch = arch;
	}

	public double getSystemLoadAverage() {
		return systemLoadAverage;
	}

	public void setSystemLoadAverage(double systemLoadAverage) {
		this.systemLoadAverage = systemLoadAverage;
	}

}
