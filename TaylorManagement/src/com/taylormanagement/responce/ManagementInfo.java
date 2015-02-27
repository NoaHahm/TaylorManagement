package com.taylormanagement.responce;

import com.taylormanagement.mbean.MemoryMbean;
import com.taylormanagement.mbean.OperatingSystemMbean;
import com.taylormanagement.mbean.RuntimeMbean;

public final class ManagementInfo {
	private MemoryMbean memory;
	private OperatingSystemMbean operatingSystem;
	private RuntimeMbean runtime;

	public MemoryMbean getMemory() {
		return memory;
	}

	public void setMemory(MemoryMbean memory) {
		this.memory = memory;
	}

	public OperatingSystemMbean getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(OperatingSystemMbean operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public RuntimeMbean getRuntime() {
		return runtime;
	}

	public void setRuntime(RuntimeMbean runtime) {
		this.runtime = runtime;
	}

}
