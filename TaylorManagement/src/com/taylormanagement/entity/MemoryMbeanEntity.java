/* 
     Java Was Management JMX Library
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
package com.taylormanagement.entity;

import java.util.HashMap;

public final class MemoryMbeanEntity {
	
	private boolean verbose = false;
	private HashMap<String, Object> heapMemoryUsage;
	private HashMap<String, Object> nonHeapMemoryUsage;
	private int objectPendingFinalizationCount;
	
	public boolean isVerbose() {
		return verbose;
	}
	
	public void setVerbose(boolean verbose) {
		this.verbose = verbose;
	}
	
	public HashMap<String, Object> getHeapMemoryUsage() {
		return heapMemoryUsage;
	}
	
	public void setHeapMemoryUsage(HashMap<String, Object> heapMemoryUsage) {
		this.heapMemoryUsage = heapMemoryUsage;
	}
	
	public HashMap<String, Object> getNonHeapMemoryUsage() {
		return nonHeapMemoryUsage;
	}
	
	public void setNonHeapMemoryUsage(HashMap<String, Object> nonHeapMemoryUsage) {
		this.nonHeapMemoryUsage = nonHeapMemoryUsage;
	}
	
	public int getObjectPendingFinalizationCount() {
		return objectPendingFinalizationCount;
	}
	
	public void setObjectPendingFinalizationCount(int objectPendingFinalizationCount) {
		this.objectPendingFinalizationCount = objectPendingFinalizationCount;
	}
	
	
}
