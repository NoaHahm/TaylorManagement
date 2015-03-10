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
package com.taylormanagement.data;

import java.util.Date;

import com.taylormanagement.mbean.MemoryMbean;
import com.taylormanagement.mbean.OperatingSystemMbean;
import com.taylormanagement.mbean.RuntimeMbean;

public final class ManagementInfo {
	private MemoryMbean memory;
	private OperatingSystemMbean operatingSystem;
	private RuntimeMbean runtime;
	private Date currentDate;

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

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

}
