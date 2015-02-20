package com.taylormanagement.core.tomcat;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryManagerMXBean;
import java.lang.management.MemoryPoolMXBean;

import javax.management.ObjectName;

import com.sun.management.GarbageCollectorMXBean;
import com.taylormanagement.core.Management;

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
		
	
	public TomcatManagement(String host, int port) throws IOException {
		super(host, port);
	}
	
	public TomcatManagement(String host, int port, String id, String password)
			throws IOException {
		super(host, port, id, password);
	}

	private GarbageCollectorMXBean getGarbageCollectorMXBean(ObjectName objectName) throws IOException {
		GarbageCollectorMXBean mbean = ManagementFactory
				.newPlatformMXBeanProxy(connection,
						objectName.getCanonicalName(),
						GarbageCollectorMXBean.class);	
		return mbean;
	}
	
	public GarbageCollectorMXBean getGarbageMarkSweepMbean() throws IOException {
		ObjectName objectName = objectMap.get(GARBAGE_PS_MARKSWEEP_CALSS_NAME);

		return getGarbageCollectorMXBean(objectName);
	}

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




	
}
