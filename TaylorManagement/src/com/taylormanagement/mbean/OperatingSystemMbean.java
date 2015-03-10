/*
    Java Was Management JMX Library (TaylorManagement)
    
    Copyright (c) 2014 Noah Hahm <dbgtdbz2@naver.com>
    http://globalbiz.tistory.com

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
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
