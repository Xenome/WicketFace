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

public class FacebookCommentsBox extends WebMarkupContainer {
	private static final long serialVersionUID = -7078818990190492760L;
	
	private String xid;
	private Integer numposts;
	private String width;
	private String css;
	private String title;
	private Boolean simple;
	private Boolean reverse;
	private Boolean quiet;
	

	public FacebookCommentsBox(String id) {
		super(id);
	}

	@Override
    protected final void onComponentTag(final ComponentTag tag){
        checkComponentTag(tag, "comments");
        
        if ( this.xid != null ) {
			tag.put("xid", this.xid);
		}
        
        if ( this.numposts != null ) {
			tag.put("numposts", this.numposts.toString());
		}
        
        if ( this.width != null ) {
			tag.put("width", this.width);
		}
        
        if ( this.css != null ) {
			tag.put("css", this.css);
		}
        
        if ( this.title != null ) {
			tag.put("title", this.title);
		}
        
        if ( this.simple != null ) {
			tag.put("simple", this.simple.toString());
		}
        
        if ( this.reverse != null ) {
			tag.put("reverse", this.reverse.toString());
		}
        
        if ( this.quiet != null ) {
			tag.put("quiet", this.quiet.toString());
		}
	}
	
	public String getXid() {
		return this.xid;
	}

	public void setXid(String xid) {
		this.xid = xid;
	}

	public Integer getNumposts() {
		return this.numposts;
	}

	public void setNumposts(Integer numposts) {
		this.numposts = numposts;
	}

	public String getWidth() {
		return this.width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getCss() {
		return this.css;
	}

	public void setCss(String css) {
		this.css = css;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getSimple() {
		return this.simple;
	}

	public void setSimple(Boolean simple) {
		this.simple = simple;
	}

	public Boolean getReverse() {
		return this.reverse;
	}

	public void setReverse(Boolean reverse) {
		this.reverse = reverse;
	}

	public Boolean getQuiet() {
		return this.quiet;
	}

	public void setQuiet(Boolean quiet) {
		this.quiet = quiet;
	}
}
