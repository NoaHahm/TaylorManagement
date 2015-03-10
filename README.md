# TaylorManagement
Was Management JMX Library
WAS ���� ������ ���� �ý��� �� JVM �� ���� ������ ȹ�� �� �� �ֽ��ϴ�.
�������� �������̽��� �����ϹǷ�, ������ ���� ��� �� �� �ֽ��ϴ�.

�����
---------
WAS ������ �ݵ�� JVM�ɼǿ� �Ʒ� �ɼ��� �߰� �� �� (No Secure Mode ���)
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
TaylorManagement ���� 1.0 ���� ������

License
---------
Apache License 2.0
