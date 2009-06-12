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

public class FacebookPhoto extends WebMarkupContainer {
	private static final long serialVersionUID = -3042592941879660529L;

	public final static String SIZE_THUMB = "thumb";
	public final static String SIZE_SMALL = "small";
	public final static String SIZE_NORMAL = "normal";
	
	public final static String ALIGN_RIGHT = "right";
	public final static String ALIGN_LEFT = "left";
	
	private String pid;
	private String size;
	private String align;
	
	
	public FacebookPhoto(String id, String pid) {
		super(id);
		this.pid = pid;
	}
	

	@Override
	protected final void onComponentTag(final ComponentTag tag){
		checkComponentTag(tag, "photo");
		
		tag.put("pid", this.pid);
		
		if (this.size!=null) {
			tag.put("size", this.size);
		}
		
		if (this.align!=null) {
			tag.put("align", this.align);
		}
	}
	

	public String getPid() {
		return this.pid;
	}


	public void setPid(String pid) {
		this.pid = pid;
	}


	public String getSize() {
		return this.size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public String getAlign() {
		return this.align;
	}


	public void setAlign(String align) {
		this.align = align;
	}

}
