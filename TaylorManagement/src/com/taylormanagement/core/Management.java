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
import com.taylormanagement.data.ManagementInfo;


public abstract class Management {
		
	private static final String PROTOCOL_NAME = "service:jmx:rmi:///jndi/rmi://";
	private static final String REMOTE_CREDENTIALS_KEY = "jmx.remote.credentials";
		
	protected HashMap<String, ObjectName> objectMap;
	protected JMXServiceURL jmxServiceURL;
	protected JMXConnector connector;
	protected MBeanServerConnection connection;
	
	
	
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

	
	/**
	 * Java Remote Web ApplicationServer Connect  
	 * 
	 * @param host
	 * @param port
	 * @param environment
	 * @throws IOException
	 */
	private void connect(String host, int port, Map<String, ?> environment) throws IOException {		
		objectMap = new HashMap<String, ObjectName>();
		jmxServiceURL = new JMXServiceURL(hostBulid(host, port));
		connector = JMXConnectorFactory.connect(jmxServiceURL, environment);
		connection = connector.getMBeanServerConnection();

		initialized();
	}

	
	/**
	 * MBean get objectName
	 * 
	 * @throws IOException
	 */
	private void initialized() throws IOException {

		Set<ObjectInstance> instances = connection.queryMBeans(null, null);
		Iterator<ObjectInstance> iterator = instances.iterator();
		while (iterator.hasNext()) {
			ObjectInstance instance = iterator.next();
			objectMap.put(instance.getObjectName().toString(), instance.getObjectName());
		}
		
	}
	
	/**
	 * 
	 * @param host
	 * @param port
	 * @return
	 */
	public static String hostBulid(String host, int port) {
		StringBuilder sb = new StringBuilder();
		sb.append(PROTOCOL_NAME);
		sb.append(host);
		sb.append(":");
		sb.append(port);
		sb.append("/jmxrmi");
		return sb.toString();
	}

	/**
	 * 
	 * @throws IOException
	 */
	public void reConnect() throws IOException {
		connector = JMXConnectorFactory.connect(jmxServiceURL);
		connection = connector.getMBeanServerConnection();
	}

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean isConnect() throws IOException {
		if (connector.getConnectionId() == null)
			return false;

		return true;
	}

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public OperatingSystemMXBean getOperatingSystemMXBean() throws IOException {
		ObjectName objectName = objectMap.get(ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME);
		
		OperatingSystemMXBean mbean = ManagementFactory.newPlatformMXBeanProxy(
				connection, objectName.toString(), OperatingSystemMXBean.class);
		return mbean;
	}

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public MemoryMXBean getMemoryMXBean() throws IOException {
		ObjectName objectName = objectMap.get(ManagementFactory.MEMORY_MXBEAN_NAME);
		
		MemoryMXBean mbean = ManagementFactory.newPlatformMXBeanProxy(connection, objectName.getCanonicalName(),
				MemoryMXBean.class);
		return mbean;
	}

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public RuntimeMXBean getRuntimeMXBean() throws IOException {
		ObjectName objectName = objectMap.get(ManagementFactory.RUNTIME_MXBEAN_NAME);
				
		RuntimeMXBean mbean = ManagementFactory.newPlatformMXBeanProxy(connection, objectName.getCanonicalName(), RuntimeMXBean.class);
		return mbean;
	}

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public ThreadMXBean getThreadingMXBean() throws IOException {
		ObjectName objectName = objectMap.get(ManagementFactory.THREAD_MXBEAN_NAME);
		
		ThreadMXBean mbean = ManagementFactory.newPlatformMXBeanProxy(connection, objectName.getCanonicalName(),
				ThreadMXBean.class);
		return mbean;
	}

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public CompilationMXBean getCompilationMXBean() throws IOException {
		ObjectName objectName = objectMap.get(ManagementFactory.COMPILATION_MXBEAN_NAME);
		
		CompilationMXBean mbean = ManagementFactory.newPlatformMXBeanProxy(connection, objectName.getCanonicalName(),
				CompilationMXBean.class);
		return mbean;
	}

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public ClassLoadingMXBean getClassLoadingMXBean() throws IOException {
		ObjectName objectName = objectMap.get(ManagementFactory.CLASS_LOADING_MXBEAN_NAME);

		ClassLoadingMXBean mbean = ManagementFactory.newPlatformMXBeanProxy(
				connection, objectName.getCanonicalName(),
				ClassLoadingMXBean.class);
		
		return mbean;
	}

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public abstract ManagementInfo getManagementInfo() throws IOException;
}
