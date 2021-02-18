package com.sgw.web.config;

import com.sgw.common.config.database.DataSourceConfiguration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import(DataSourceConfiguration.class)
public class WebConfiguration {

}
