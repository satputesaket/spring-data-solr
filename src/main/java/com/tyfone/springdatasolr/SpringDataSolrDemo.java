package com.tyfone.springdatasolr;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;



@SpringBootApplication
@EnableSolrRepositories
public class SpringDataSolrDemo  extends SpringBootServletInitializer{
	@Bean
	public HttpSolrClient solrClient() {
		return new HttpSolrClient("http://localhost:8983/solr/testSolr/");
	}

	@Bean
	public SolrTemplate solrTemplate(HttpSolrClient client) throws Exception {
		return new SolrTemplate(client);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringDataSolrDemo.class);
    }
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringDataSolrDemo.class);
	}
}