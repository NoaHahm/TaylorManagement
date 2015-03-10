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
