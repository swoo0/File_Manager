package kr.co.file.util;

public class LoggerFactory {
	
	public void setLogger() {
		// .xml 이용
		System.setProperty(XmlConfigurationFactory.CONFIGURATION_FILE_PROPERTY,"xml/log4j2.xml");
		
		// .properties 이용
//		System.setProperty(PropertiesConfigurationFactory.CONFIGURATION_FILE_PROPERTY,"path/confFileName.properties");
		
		System.out.println("log4j config 세팅 완료 !");
	}
	
}
