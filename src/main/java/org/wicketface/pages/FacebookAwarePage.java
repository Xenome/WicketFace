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
package org.wicketface.pages;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.Cookie;

import org.apache.wicket.PageParameters;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.behavior.HeaderContributor;
import org.apache.wicket.markup.html.WebPage;
import org.wicketface.application.FacebookApplication;
import org.wicketface.markup.util.FacebookInitScript;

public abstract class FacebookAwarePage extends WebPage {

	private static final String COOKIE_USER = "user";
	private static final String COOKIE_SESSION_EXPIRES = "expires";
	private static final String COOKIE_SESSION_KEY = "session_key";
	private static final String COOKIE_SESSION_SECRET = "ss";

	private static final String STYLE_URL = "css/styles.wicketface.css";

	private String signature;

	public FacebookAwarePage() {
		this(null);
	}

	public FacebookAwarePage(PageParameters parameters) {
		super(parameters);

		this.add(HeaderContributor.forCss(new ResourceReference(FacebookAwarePage.class,
				STYLE_URL)));

		this.add(new FacebookInitScript("facebookInitScript", getFacebookApiKey()));
	}

	public boolean isFacebookConnected() {
		String facebookUser = getFacebookUser();
		if (facebookUser!=null) {
			return validateSignature();
		}
		return false;
	}

	public String getFacebookApiKey() {
		return  ((FacebookApplication)this.getApplication()).getFacebookApiKey();
	}

	public String getFacebookAppSecret() {
		return  ((FacebookApplication)this.getApplication()).getFacebookAppSecret();
	}
	
	public boolean validateSignature() {
		try {
			// Checks if this was calculated before to avoid several calculations per page build cycle
			if (this.signature!=null && this.signature.equals(getFacebookSignature())) {
				return true;
			}
			
			this.signature = buildSignature();
			return getFacebookSignature().equals(this.signature);
		} catch (Exception e) {
			return false;
		}
	}

	private String buildSignature() throws NoSuchAlgorithmException {
		// Build the source string
		String message = COOKIE_SESSION_EXPIRES+"="+getFacebookSessionExpires()+
		COOKIE_SESSION_KEY+"="+getFacebookSessionKey()+
		COOKIE_SESSION_SECRET+"="+getFacebookSessionSecret()+
		COOKIE_USER+"="+getFacebookUser()+
		getFacebookAppSecret();

		// calculate its md5 hash
		MessageDigest digest =MessageDigest.getInstance("MD5");
		digest.update(message.getBytes(),0,message.length());
		return new BigInteger(1,digest.digest()).toString(16);
	}


	public String getFacebookUser() {
		Cookie cookie =  getWebRequestCycle().getWebRequest().getCookie(getFacebookApiKey()+"_"+COOKIE_USER);
		if (cookie!=null) {
			return cookie.getValue();
		}
		return null;
	}

	public String getFacebookSessionExpires() {
		Cookie cookie = getWebRequestCycle().getWebRequest().getCookie(getFacebookApiKey()+"_"+COOKIE_SESSION_EXPIRES);
		if (cookie!=null) {
			return cookie.getValue();
		}
		return null;
	}

	public String getFacebookSessionKey() {
		Cookie cookie =  getWebRequestCycle().getWebRequest().getCookie(getFacebookApiKey()+"_"+COOKIE_SESSION_KEY);
		if (cookie!=null) {
			return cookie.getValue();
		}
		return null;
	}

	public String getFacebookSessionSecret() {
		Cookie cookie =  getWebRequestCycle().getWebRequest().getCookie(getFacebookApiKey()+"_"+COOKIE_SESSION_SECRET);
		if (cookie!=null) {
			return cookie.getValue();
		}
		return null;
	}

	public String getFacebookSignature() {
		Cookie cookie =  getWebRequestCycle().getWebRequest().getCookie(getFacebookApiKey());
		if (cookie!=null) {
			return cookie.getValue();
		}
		return null;
	}

}
