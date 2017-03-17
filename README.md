jasperserver-sample
====================================
Consumir un reporte sin parametros:

	Report report = new Report();
	report.setUrl("/reports/samples/Employees");
	report.setOutputFolder(outPutDir.getAbsolutePath());
	JasperserverRestClient client = JasperserverRestClient.getInstance(serverUrl, serverUser, serverPassword);
	File reportFile  = client.getReportAsFile(report);

Consumir un reporte con parametros

	Report report = new Report();
	report.setUrl("/reports/samples/Department");
	report.setOutputFolder(outPutDir.getAbsolutePath());
	report.addParameter("department", "11");
	JasperserverRestClient client = JasperserverRestClient.getInstance(serverUrl, serverUser, serverPassword);
	File reportFile = client.getReportAsFile(report);


