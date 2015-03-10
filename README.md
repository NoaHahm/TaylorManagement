# TaylorManagement
Was Management JMX Library
WAS 원격 서버를 통해 시스템 및 JVM 에 대한 정보를 획득 할 수 있습니다.
직관적인 인터페이스를 제공하므로, 누구나 쉽게 사용 할 수 있습니다.

사용방법
---------
WAS 구동시 반드시 JVM옵션에 아래 옵션을 추가 할 것 (No Secure Mode 방식)
-Dcom.sun.management.jmxremote
-Dcom.sun.management.jmxremote.port=<port>
-Dcom.sun.management.jmxremote.authenticate=false
-Dcom.sun.management.jmxremote.ssl=false

```
try {
	Management management = new TomcatManagement("localhost", <port>);
	
	System.out.print("Heap Memory Max : ");
	System.out.print(management.getMemoryMXBean().getHeapMemoryUsage().getMax() + "\n");
	System.out.print("Heap Memory Used : ");
	System.out.print(management.getMemoryMXBean().getHeapMemoryUsage().getUsed() + "\n");
	System.out.print("JVM Name : ");
	System.out.print(management.getRuntimeMXBean().getVmName() + "\n");
	System.out.print("SpecVendor : ");
	System.out.print(management.getRuntimeMXBean().getSpecVendor() + "\n");
	System.out.print("OS Name : ");
	System.out.print(management.getOperatingSystemMXBean().getName() + "\n");
} catch (IOException e) {
	e.printStackTrace();
}
```

Update
---------
[2015-03-10]
TaylorManagement 최초 1.0 버전 릴리즈

License
---------
Apache License 2.0
