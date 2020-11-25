package com.swg.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import(com.swg.common.config.database.DataSourceConfiguration.class)
public class WebConfiguration {

}
