package com.tyfone.springdatasolr.scheduler;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.solr.client.solrj.request.AbstractUpdateRequest.ACTION;
import org.apache.solr.client.solrj.request.ContentStreamUpdateRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@EnableScheduling
public class ScheduleSolrIndexer {

	@Autowired
	private SolrTemplate solrTemplate;
	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleSolrIndexer.class); 
	
	private static final SimpleDateFormat SIMPLE_DATE_FORMAT= new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate=5000)
	public void scheduledIndexing(){
		LOGGER.info("The time is now {}"+SIMPLE_DATE_FORMAT.format(new Date()));
		System.out.println("The time is now {}"+SIMPLE_DATE_FORMAT.format(new Date())+solrTemplate.toString());
//		File file = new File("F:\\java-dist\\solr-6.6.0\\example\\exampledocs\\books.json");
//		try {
//	 		solrTemplate.setSolrCore("testSolr");
//			indexDocs(solrTemplate,file);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	 static void indexDocs(SolrTemplate solrTemplate, File file)
			    throws Exception {
			    // do not try to index files that cannot be read
			    if (file.canRead()) {
			      if (file.isDirectory()) {
			        String[] files = file.list();
			        // an IO error could occur
			        if (files != null) {
			          for (int i = 0; i < files.length; i++) {
			            indexDocs(solrTemplate, new File(file, files[i]));
			          }
			        }
			      } else {
			        System.out.println("adding " + file);
			        try {
			        	ContentStreamUpdateRequest req = new ContentStreamUpdateRequest("/testSolr/update");
			        	String parts[] = file.getName().split("\\.");
			        	String type = "text";
			        	if (parts.length>1) {
			        		type = parts[1];
			        	}
			        	req.addFile(file,"application/json");
			    		req.setParam("literal.id", file.getAbsolutePath());
			    		req.setParam("literal.name", file.getName());
			    		req.setParam("literal.content_type", type);
			    		req.setAction(ACTION.COMMIT, true, true);
			        	solrTemplate.getSolrClient().request(req);
			        	
			        }
			        catch (FileNotFoundException fnfe) {
			          fnfe.printStackTrace();
			        }
			      }
			    }
			  }
}
