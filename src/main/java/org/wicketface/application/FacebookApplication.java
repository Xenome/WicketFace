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
package org.wicketface.application;

import org.apache.wicket.Application;
import org.apache.wicket.protocol.http.WebApplication;
import org.wicketface.pages.CrossDomainReceiverPage;

public abstract class FacebookApplication extends WebApplication {

	private String facebookApiKey;
	private String facebookAppSecret;
	
	@Override
	protected void init() {
		super.init();
		mountBookmarkablePage("/facebookconnect", CrossDomainReceiverPage.class);
	}
	
    public static FacebookApplication get() {
        return (FacebookApplication) Application.get();
    }

	public String getFacebookApiKey() {
		return facebookApiKey;
	}
	
	public void setFacebookApiKey(String facebookApiKey) {
		this.facebookApiKey = facebookApiKey;
	}

	public String getFacebookAppSecret() {
		return this.facebookAppSecret;
	}

	public void setFacebookAppSecret(String facebookAppSecret) {
		this.facebookAppSecret = facebookAppSecret;
	}

}
