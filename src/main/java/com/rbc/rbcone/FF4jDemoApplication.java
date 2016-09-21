/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

package com.rbc.rbcone;

import org.ff4j.web.embedded.ConsoleServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

/**
 * Main Application to work with SpringBoot
 *
 * @author Cedrick Lunven (@clunven)</a>
 */
@SpringBootApplication
public class FF4jDemoApplication extends SpringBootServletInitializer
{

	@Autowired
	private ConsoleServlet ff4jServlet;

//	public static void main(String[] args)
//	{
//		SpringApplication.run(FF4jDemoApplication.class, args);
//	}

	public static void main(String[] args)
	{
		SpringApplicationBuilder builder = new SpringApplicationBuilder(FF4jDemoApplication.class);
		new FF4jDemoApplication().configure(builder).run(args);
	}

	/** {@inheritDoc} */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
	{
		return application.sources(FF4jDemoApplication.class);
	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean()
	{
		return new ServletRegistrationBean(ff4jServlet, "/ff4j-console/*");
	}

}
