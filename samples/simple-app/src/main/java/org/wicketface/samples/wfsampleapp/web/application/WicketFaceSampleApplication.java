/*
 * ============================================================================= 
 * Copyright 2009 WicketFace team
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at 
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License. 
 * 
 * =============================================================================
 */
package org.wicketface.samples.wfsampleapp.web.application;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.apache.wicket.Application;
import org.apache.wicket.markup.html.WebPage;
import org.wicketface.application.FacebookApplication;
import org.wicketface.samples.wfsampleapp.web.pages.HomePage;
import org.wicketface.samples.wfsampleapp.web.pages.PublishToFeedPage;


public class WicketFaceSampleApplication extends FacebookApplication {
	
	private Long templateId;

	@Override
	protected void init() {
		super.init();

		/*
		 * Set facebook api key and secret
		 */
		this.setFacebookApiKey(getAppProperties().getProperty("facebook.apikey"));
		this.setFacebookAppSecret(getAppProperties().getProperty("facebook.appsecret"));
		
		this.templateId = new Long(getAppProperties().getProperty("publish.template.id"));
		
        /*
         * Mount bookmarkeable pages for prettyfied URLs
         */
        mountBookmarkablePage("/home", HomePage.class);
        mountBookmarkablePage("/publish", PublishToFeedPage.class);
       
        /*
         * Remove wicket tags from result HTML
         */
        getMarkupSettings().setStripWicketTags(true);
	}


	@Override
	public Class<? extends WebPage>  getHomePage() {
		return HomePage.class;
	}
	
    public static WicketFaceSampleApplication get() {
        return (WicketFaceSampleApplication) Application.get();
    }

	private static Properties getAppProperties(){
		ClassLoader loader = WicketFaceSampleApplication.class.getClassLoader();  
		URL url = loader.getResource("webapp.properties");  
		InputStream in;
		Properties properties = new Properties(); 
		try {
			in = url.openStream();
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
	
	public Long getTemplateId() {
		return this.templateId;
	}


	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}
}
