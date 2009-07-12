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
package org.wicketface.markup.xfbml;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;

public class FacebookProfilePic extends WebMarkupContainer {
	private static final long serialVersionUID = -3007664904412907940L;

	public final static String SIZE_THUMB = "thumb";
	public final static String SIZE_SMALL = "small";
	public final static String SIZE_NORMAL = "normal";
	public final static String SIZE_SQUARE = "square";
	
	private String size;
	private Boolean linked;
	private Boolean facebookLogo;
	private Integer uid;
	
	public FacebookProfilePic(String id) {
		super(id);
	}
	
	public FacebookProfilePic(String id, Integer uid) {
		super(id);
		this.uid = uid;
	}
	

	@Override
	protected final void onComponentTag(final ComponentTag tag){
		checkComponentTag(tag, "profile-pic");
		
		if ( this.uid != null ) {
			tag.put("uid", this.uid.toString());
		} else  {
			tag.put("uid","loggedinuser");
		}
		
		if ( this.size != null ) {
			tag.put("size", this.size);
		}
		
		if ( this.linked != null) {
			tag.put("linked", this.linked.toString());
		}
		
		if ( this.facebookLogo != null ) {
			tag.put("facebook-logo", this.facebookLogo.booleanValue());
		}
	}
	
	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Boolean getLinked() {
		return this.linked;
	}

	public void setLinked(Boolean linked) {
		this.linked = linked;
	}

	public Boolean getFacebookLogo() {
		return this.facebookLogo;
	}

	public void setFacebookLogo(Boolean facebookLogo) {
		this.facebookLogo = facebookLogo;
	}
}
