package com.openwebinars.movieadvisor.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//esto escaneará todos los beans que estén dentro de esos paquetes
@ComponentScan(basePackages = "com.openwebinars.movieadvisor")
@PropertySource("classpath:/movieadvisor.properties")
public class AppCongif {
	
	@Value("${file.path}")
	private String file;
	
	@Value("${file.csv.separator}")
	private String separator;
	
	@Value("${file.csv.list_separator}")
	private String listSeparator;

	public String getFile() {
		return file;
	}

	public String getSeparator() {
		return separator;
	}

	public String getListSeparator() {
		return listSeparator;
	}

	

}
