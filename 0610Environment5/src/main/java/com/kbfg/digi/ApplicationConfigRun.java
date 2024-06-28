package com.kbfg.digi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("run")
public class ApplicationConfigRun {
	
	@Bean
	public ServerInfo serverInfo() {
		ServerInfo serverInfo = new ServerInfo();
		serverInfo.setIpNum("213.186.229.29");
		serverInfo.setPortNum("80");
		return serverInfo;
	}
}
