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
