/* 
     Java Was Management JMX Library (TaylorManagement)
     
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

import java.lang.management.RuntimeMXBean;

public final class RuntimeMbean {
	private String runtimeName;
	private String classPath;
	private long startTime;
	private String managementSpecVersion;
	private String specName;
	private String specVendor;
	private String specVersion;
	private String bootClassPath;
	private String libraryPath;
	private long uptime;
	private String vmName;
	private String vmVendor;
	private String vmVersion;
	private boolean isBootClassPathSupported;
	
	public RuntimeMbean(RuntimeMXBean mxbean) {
		runtimeName = mxbean.getName();
		classPath = mxbean.getClassPath();
		startTime = mxbean.getStartTime();
		managementSpecVersion = mxbean.getManagementSpecVersion();
		specName = mxbean.getSpecName();
		specVendor = mxbean.getSpecVendor();
		specVersion = mxbean.getSpecVersion();
		bootClassPath = mxbean.getBootClassPath();
		libraryPath = mxbean.getLibraryPath();
		uptime = mxbean.getUptime();
		vmName = mxbean.getVmName();
		vmVendor = mxbean.getVmVendor();
		vmVersion = mxbean.getVmVersion();
		isBootClassPathSupported = mxbean.isBootClassPathSupported();
	}

	public String getRuntimeName() {
		return runtimeName;
	}

	public void setRuntimeName(String runtimeName) {
		this.runtimeName = runtimeName;
	}

	public String getClassPath() {
		return classPath;
	}

	public void setClassPath(String classPath) {
		this.classPath = classPath;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public String getManagementSpecVersion() {
		return managementSpecVersion;
	}

	public void setManagementSpecVersion(String managementSpecVersion) {
		this.managementSpecVersion = managementSpecVersion;
	}

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}

	public String getSpecVendor() {
		return specVendor;
	}

	public void setSpecVendor(String specVendor) {
		this.specVendor = specVendor;
	}

	public String getSpecVersion() {
		return specVersion;
	}

	public void setSpecVersion(String specVersion) {
		this.specVersion = specVersion;
	}

	public String getBootClassPath() {
		return bootClassPath;
	}

	public void setBootClassPath(String bootClassPath) {
		this.bootClassPath = bootClassPath;
	}

	public String getLibraryPath() {
		return libraryPath;
	}

	public void setLibraryPath(String libraryPath) {
		this.libraryPath = libraryPath;
	}

	public long getUptime() {
		return uptime;
	}

	public void setUptime(long uptime) {
		this.uptime = uptime;
	}

	public String getVmName() {
		return vmName;
	}

	public void setVmName(String vmName) {
		this.vmName = vmName;
	}

	public String getVmVendor() {
		return vmVendor;
	}

	public void setVmVendor(String vmVendor) {
		this.vmVendor = vmVendor;
	}

	public String getVmVersion() {
		return vmVersion;
	}

	public void setVmVersion(String vmVersion) {
		this.vmVersion = vmVersion;
	}

	public boolean isBootClassPathSupported() {
		return isBootClassPathSupported;
	}

	public void isBootClassPathSupported(boolean isBootClassPathSupported) {
		this.isBootClassPathSupported = isBootClassPathSupported;
	}

}
