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
package com.taylormanagement.core.tomcat;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryManagerMXBean;
import java.lang.management.MemoryPoolMXBean;

import javax.management.ObjectName;

import com.sun.management.GarbageCollectorMXBean;
import com.taylormanagement.core.Management;
import com.taylormanagement.mbean.MemoryMbean;
import com.taylormanagement.mbean.OperatingSystemMbean;
import com.taylormanagement.mbean.RuntimeMbean;
import com.taylormanagement.responce.ManagementInfo;

public class TomcatManagement extends Management {

	public final static String GARBAGE_PS_MARKSWEEP_CALSS_NAME = "java.lang:type=GarbageCollector,name=PS MarkSweep";
	public final static String GARBAGE_PS_SCAVENGE_CALSS_NAME = "java.lang:type=GarbageCollector,name=PS Scavenge";
	public final static String MEMORY_MANAGER_CODE_CACHE_CALSS_NAME = "java.lang:type=MemoryManager,name=CodeCacheManager";
	public final static String MEMORY_MANAGER_METASPACE_CALSS_NAME = "java.lang:type=MemoryManager,name=Metaspace Manager";
	public final static String MEMORYPOOL_CODE_CACHE_CALSS_NAME = "java.lang:type=MemoryPool,name=Code Cache";
	public final static String MEMORYPOOL_EDEN_SPACE_CALSS_NAME = "java.lang:type=MemoryPool,name=PS Eden Space";
	public final static String MEMORYPOOL_OLD_GEN_CALSS_NAME = "java.lang:type=MemoryPool,name=PS Old Gen";
	public final static String MEMORYPOOL_PERM_GEN_CALSS_NAME = "java.lang:type=MemoryPool,name=PS Perm Gen";
	public final static String MEMORYPOOL_SURVIVOR_SPACE_CALSS_NAME = "java.lang:type=MemoryPool,name=PS Survivor Space";
	
	
	/**
	 * Java Remote Web ApplicationServer Connect (Non Secure Mode)
	 * 
	 * @param host
	 * @param port
	 * @throws IOException
	 */
	public TomcatManagement(String host, int port) throws IOException {
		super(host, port);
	}
	
	/**
	 * Java Remote Web ApplicationServer Connect (Secure Mode)
	 * 
	 * @param host
	 * @param port
	 * @param id
	 * @param password
	 * @throws IOException
	 */
	public TomcatManagement(String host, int port, String id, String password)
			throws IOException {
		super(host, port, id, password);
	}

	/**
	 * Get MBean (GarbageCollector)
	 * 
	 * @param objectName
	 * @throws IOException
	 * @return GarbageCollectorMXBean (Interface)
	 */
	private GarbageCollectorMXBean getGarbageCollectorMXBean(ObjectName objectName) throws IOException {
		GarbageCollectorMXBean mbean = ManagementFactory
				.newPlatformMXBeanProxy(connection,
						objectName.getCanonicalName(),
						GarbageCollectorMXBean.class);	
		return mbean;
	}
	
	/**
	 * Get MBean (GarbageMarkSweep)
	 * 
	 * @throws IOException
	 * @return
	 */
	public GarbageCollectorMXBean getGarbageMarkSweepMbean() throws IOException {
		ObjectName objectName = objectMap.get(GARBAGE_PS_MARKSWEEP_CALSS_NAME);

		return getGarbageCollectorMXBean(objectName);
	}

	/**
	 * Get MBean (GarbageScavenge)
	 * 
	 * @throws IOException
	 * @return
	 */
	public GarbageCollectorMXBean getGarbageScavengeMbean() throws IOException {
		ObjectName objectName = objectMap.get(GARBAGE_PS_SCAVENGE_CALSS_NAME);
		
		return getGarbageCollectorMXBean(objectName);
	}

	private MemoryManagerMXBean getMemoryManagerMXBean(ObjectName objectName) throws IOException {
		MemoryManagerMXBean mbean = ManagementFactory
				.newPlatformMXBeanProxy(connection,
						objectName.getCanonicalName(),
						MemoryManagerMXBean.class);	
		return mbean;
	}
	
	public MemoryManagerMXBean getMemoryCodeCacheManagerMbean() throws IOException {
		ObjectName objectName = objectMap.get(MEMORY_MANAGER_CODE_CACHE_CALSS_NAME);
		
		return getMemoryManagerMXBean(objectName);
	}

	public MemoryManagerMXBean getMemoryMetaSpaceManagerMbean() throws IOException {
		ObjectName objectName = objectMap.get(MEMORY_MANAGER_METASPACE_CALSS_NAME);
		
		return getMemoryManagerMXBean(objectName);
	}

	private MemoryPoolMXBean getMemoryPoolMXBean(ObjectName objectName) throws IOException {
		MemoryPoolMXBean mbean = ManagementFactory
				.newPlatformMXBeanProxy(connection,
						objectName.getCanonicalName(),
						MemoryPoolMXBean.class);	
		return mbean;
	}

	public MemoryPoolMXBean getMemoryPoolCodeCacheMbean() throws IOException {
		ObjectName objectName = objectMap.get(MEMORYPOOL_CODE_CACHE_CALSS_NAME);
		
		return getMemoryPoolMXBean(objectName);
	}

	public MemoryPoolMXBean getMemoryPoolEdenSpaceMbean() throws IOException {
		ObjectName objectName = objectMap.get(MEMORYPOOL_EDEN_SPACE_CALSS_NAME);
		
		return getMemoryPoolMXBean(objectName);
	}

	public MemoryPoolMXBean getMemoryPoolOldGenMbean() throws IOException {
		ObjectName objectName = objectMap.get(MEMORYPOOL_OLD_GEN_CALSS_NAME);
		
		return getMemoryPoolMXBean(objectName);
	}

	public MemoryPoolMXBean getMemoryPoolPermGenMbean() throws IOException {
		ObjectName objectName = objectMap.get(MEMORYPOOL_PERM_GEN_CALSS_NAME);

		return getMemoryPoolMXBean(objectName);
	}

	public MemoryPoolMXBean getMemoryPoolSurvivorSpaceMbean() throws IOException {
		ObjectName objectName = objectMap.get(MEMORYPOOL_SURVIVOR_SPACE_CALSS_NAME);
		
		return getMemoryPoolMXBean(objectName);
	}
	
	public MemoryMbean getMemoryMbean() throws IOException {
		MemoryMbean mbean = new MemoryMbean(getMemoryMXBean());				
		
		return mbean;
	}
	
	public OperatingSystemMbean getOperatingSystemMBean() throws IOException {
		OperatingSystemMbean mbean = new OperatingSystemMbean(getOperatingSystemMXBean());
		
		return mbean;
	}
	
	public RuntimeMbean getRuntimeMBean() throws IOException {
		RuntimeMbean mbean = new RuntimeMbean(getRuntimeMXBean());
		return mbean;
	}
	
	public Integer getProcessId() {
		String[] names = null;
		Integer result = null;
		try {
			String runtimeName = getRuntimeMXBean().getName();
			if (runtimeName.indexOf("@") != -1) {
				names = runtimeName.split("@");
			}
			result = names[0] != null ? Integer.parseInt(names[0]) : null;
		} catch (IOException e) {
			return null;
		} catch (NumberFormatException e) {
			return null;		
		}
		return result;
	}
	
	@Override
	public ManagementInfo getManagementInfo() throws IOException {
		ManagementInfo info = new ManagementInfo();
		info.setMemory(getMemoryMbean());
		info.setOperatingSystem(getOperatingSystemMBean());
		info.setRuntime(getRuntimeMBean());
		return info;
	}
}
