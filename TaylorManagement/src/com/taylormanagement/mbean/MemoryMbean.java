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

import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

public final class MemoryMbean {

	private boolean verbose = false;
	private MemoryUsage heapMemoryUsage;
	private MemoryUsage nonHeapMemoryUsage;
	private int objectPendingFinalizationCount;

	public MemoryMbean(MemoryMXBean mxBean) {
		//Heap
		long committed = mxBean.getHeapMemoryUsage().getCommitted();
		long init = mxBean.getHeapMemoryUsage().getInit();
		long used = mxBean.getHeapMemoryUsage().getUsed();
		long max = mxBean.getHeapMemoryUsage().getMax();		
		heapMemoryUsage = new MemoryUsage(init, used, committed, max);		
		
		//NonHeap
		committed = mxBean.getHeapMemoryUsage().getCommitted();
		init = mxBean.getHeapMemoryUsage().getInit();
		used = mxBean.getHeapMemoryUsage().getUsed();
		max = mxBean.getHeapMemoryUsage().getMax();		
		nonHeapMemoryUsage = new MemoryUsage(init, used, committed, max);	
		
		//ObjectPendingFinalizationCount
		objectPendingFinalizationCount = mxBean.getObjectPendingFinalizationCount();
	}

	public boolean isVerbose() {
		return verbose;
	}

	public void setVerbose(boolean verbose) {
		this.verbose = verbose;
	}

	public int getObjectPendingFinalizationCount() {
		return objectPendingFinalizationCount;
	}

	public void setObjectPendingFinalizationCount(int objectPendingFinalizationCount) {
		this.objectPendingFinalizationCount = objectPendingFinalizationCount;
	}

	public MemoryUsage getHeapMemoryUsage() {
		return heapMemoryUsage;
	}

	public void setHeapMemoryUsage(MemoryUsage heapMemoryUsage) {
		this.heapMemoryUsage = heapMemoryUsage;
	}

	public MemoryUsage getNonHeapMemoryUsage() {
		return nonHeapMemoryUsage;
	}

	public void setNonHeapMemoryUsage(MemoryUsage nonHeapMemoryUsage) {
		this.nonHeapMemoryUsage = nonHeapMemoryUsage;
	}
	
}
