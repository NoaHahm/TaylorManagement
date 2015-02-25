/* 
     Java Was Management JMX Library (NoahJMX)
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
package com.taylormanagement.core;

import java.io.IOException;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.CompilationMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadMXBean;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.management.MBeanServerConnection;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import com.sun.management.OperatingSystemMXBean;


public abstract class Management {
		
	private static final String PROTOCOL_NAME = "service:jmx:rmi:///jndi/rmi://";
	private static final String REMOTE_CREDENTIALS_KEY = "jmx.remote.credentials";
		
	protected HashMap<String, ObjectName> objectMap;
	protected JMXServiceURL jmxServiceURL;
	protected JMXConnector connector;
	protected MBeanServerConnection connection;
	
	public abstract Map<String, Object> getManagementMap() throws IOException;
	
	public Management(String host, int port) throws IOException {
		connect(host, port, null);
	}

	public Management(String host, int port, String id, String password) throws IOException {
		
		String[] credentials = new String[2];
		credentials[0] = id;
		credentials[1] = password;
		
		Map<String, String[]> environment = new HashMap<String, String[]>(); 
		environment.put(REMOTE_CREDENTIALS_KEY, credentials); 

        connect(host, port, environment);
	}
	
	public void connect(String host, int port, Map<String, ?> environment) throws IOException {		
		objectMap = new HashMap<String, ObjectName>();
		jmxServiceURL = new JMXServiceURL(hostBulid(host, port));
		connector = JMXConnectorFactory.connect(jmxServiceURL, environment);
		connection = connector.getMBeanServerConnection();

		initialized();
	}
	

	public static String hostBulid(String host, int port) {
		StringBuilder sb = new StringBuilder();
		sb.append(PROTOCOL_NAME);
		sb.append(host);
		sb.append(":");
		sb.append(port);
		sb.append("/jmxrmi");
		return sb.toString();
	}

	public void reConnect() throws IOException {
		connector = JMXConnectorFactory.connect(jmxServiceURL);
		connection = connector.getMBeanServerConnection();
	}

	public boolean isConnect() throws IOException {
		if (connector.getConnectionId() == null)
			return false;

		return true;
	}
	
	private void initialized() throws IOException {

		Set<ObjectInstance> instances = connection.queryMBeans(null, null);
		Iterator<ObjectInstance> iterator = instances.iterator();
		while (iterator.hasNext()) {
			ObjectInstance instance = iterator.next();
			objectMap.put(instance.getObjectName().toString(), instance.getObjectName());
		}
		
	}

	public OperatingSystemMXBean getOperatingSystemMXBean() throws IOException {
		ObjectName objectName = objectMap.get(ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME);
		
		OperatingSystemMXBean mbean = ManagementFactory.newPlatformMXBeanProxy(
				connection, objectName.toString(), OperatingSystemMXBean.class);
		return mbean;
	}

	public MemoryMXBean getMemoryMXBean() throws IOException {
		ObjectName objectName = objectMap.get(ManagementFactory.MEMORY_MXBEAN_NAME);
		
		MemoryMXBean mbean = ManagementFactory.newPlatformMXBeanProxy(connection, objectName.getCanonicalName(),
				MemoryMXBean.class);
		return mbean;
	}

	public RuntimeMXBean getRuntimeMXBean() throws IOException {
		ObjectName objectName = objectMap.get(ManagementFactory.RUNTIME_MXBEAN_NAME);
				
		RuntimeMXBean mbean = ManagementFactory.newPlatformMXBeanProxy(connection, objectName.getCanonicalName(), RuntimeMXBean.class);
		return mbean;
	}

	public ThreadMXBean getThreadingMXBean() throws IOException {
		ObjectName objectName = objectMap.get(ManagementFactory.THREAD_MXBEAN_NAME);
		
		ThreadMXBean mbean = ManagementFactory.newPlatformMXBeanProxy(connection, objectName.getCanonicalName(),
				ThreadMXBean.class);
		return mbean;
	}

	public CompilationMXBean getCompilationMXBean() throws IOException {
		ObjectName objectName = objectMap.get(ManagementFactory.COMPILATION_MXBEAN_NAME);
		
		CompilationMXBean mbean = ManagementFactory.newPlatformMXBeanProxy(connection, objectName.getCanonicalName(),
				CompilationMXBean.class);
		return mbean;
	}

	public ClassLoadingMXBean getClassLoadingMXBean() throws IOException {
		ObjectName objectName = objectMap.get(ManagementFactory.CLASS_LOADING_MXBEAN_NAME);

		ClassLoadingMXBean mbean = ManagementFactory.newPlatformMXBeanProxy(
				connection, objectName.getCanonicalName(),
				ClassLoadingMXBean.class);
		
		return mbean;
	}

}
