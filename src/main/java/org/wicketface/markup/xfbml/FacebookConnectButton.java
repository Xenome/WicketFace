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

public class FacebookConnectButton extends WebMarkupContainer {
	private static final long serialVersionUID = -7829078749283362022L;
	
	public static final String SIZE_SMALL = "small";
	public static final String SIZE_MEDIUM = "medium";
	public static final String SIZE_LARGE = "large";

	public static final String LENGTH_SHORT = "short";
	public static final String LENGTH_LONG = "long";
	
    private String size;
    private String length;
    private Boolean autologout;
    
    public FacebookConnectButton(String id) {
        this(id, "medium", "long", new Boolean(false));
    }
    
    public FacebookConnectButton(String id, String size, String length) {
    	this(id, size, length, new Boolean(false));
    }
    
    public FacebookConnectButton(String id, String size, String length, Boolean autologout) {
        super(id);
        this.size = size;
        this.length = length;
        this.autologout = autologout;
        this.setOutputMarkupId(true);
    }
    
    @Override
    protected final void onComponentTag(final ComponentTag tag){
        checkComponentTag(tag, "login-button");
        tag.put("size",this.size);
        tag.put("length",this.length);
        tag.put("autologoutlink",this.autologout.toString());
    }
    
    public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getLength() {
		return this.length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public Boolean getAutologout() {
		return this.autologout;
	}

	public void setAutologout(Boolean autologout) {
		this.autologout = autologout;
	}
}

