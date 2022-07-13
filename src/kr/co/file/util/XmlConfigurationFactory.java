package kr.co.file.util;

import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.xml.XmlConfiguration;

public class XmlConfigurationFactory extends ConfigurationFactory {

	public static final String[] SUFFIXES = new String[] {".xml", "*"};
	
	
	@Override
	public Configuration getConfiguration(LoggerContext loggerContext, ConfigurationSource source) {
		return new XmlConfiguration(loggerContext, source);
	}

	@Override
	protected String[] getSupportedTypes() {
		return SUFFIXES;
	}

	
}
