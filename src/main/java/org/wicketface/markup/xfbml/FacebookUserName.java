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


public class FacebookUserName extends WebMarkupContainer {
	private static final long serialVersionUID = 9105017812909850326L;

	private Integer uid;
	private Boolean firstnameonly;
	private Boolean linked;
	private Boolean lastnameonly;
	private Boolean possessive;
	private Boolean reflexive;
	private Boolean shownetwork;
	private Boolean useyou ;
	private Boolean capitalize;
	private String ifcantsee;
	private Integer subjectid;
	
	public FacebookUserName(String id) {
		super(id);
	}

	public FacebookUserName(String id, Integer uid) {
		super(id);
		this.uid = uid;
	}
	
	@Override
	protected final void onComponentTag(final ComponentTag tag){
		checkComponentTag(tag, "name");
		
		if ( this.uid != null ) {
			tag.put("uid", this.uid.toString());
		} else  {
			tag.put("uid","loggedinuser");
		}
		
		if ( this.firstnameonly != null) {
			tag.put("firstnameonly", this.firstnameonly.toString());
		}
		
		if ( this.linked != null ) {
			tag.put("linked", this.linked.toString());
		}
		
		if ( this.lastnameonly != null ) {
			tag.put("lastnameonly", this.lastnameonly.toString());
		}
		
		if ( this.possessive != null ) {
			tag.put("possessive", this.possessive.toString());
		}
		 
		if ( this.reflexive != null ) {
			tag.put("reflexive", this.reflexive.toString());
		}
		
		if ( this.shownetwork != null ) {
			tag.put("shownetwork", this.shownetwork.toString());
		}
		
		if ( this.useyou != null ) {
			tag.put("useyou", this.useyou.toString());
		}
		
		if ( this.capitalize != null ) {
			tag.put("capitalize", this.capitalize.toString());
		}

		if ( this.subjectid != null ) {
			tag.put("subjectid", this.subjectid.toString());
		}
		
		if ( this.ifcantsee != null ) {
			tag.put("ifcantsee", this.ifcantsee);
		}
	}
	
	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Boolean isFirstnameonly() {
		return this.firstnameonly;
	}

	public void setFirstnameonly(Boolean firstnameonly) {
		this.firstnameonly = firstnameonly;
	}

	public Boolean isLinked() {
		return this.linked;
	}

	public void setLinked(Boolean linked) {
		this.linked = linked;
	}

	public Boolean isLastnameonly() {
		return this.lastnameonly;
	}

	public void setLastnameonly(Boolean lastnameonly) {
		this.lastnameonly = lastnameonly;
	}

	public Boolean isPossessive() {
		return this.possessive;
	}

	public void setPossessive(Boolean possessive) {
		this.possessive = possessive;
	}

	public Boolean isReflexive() {
		return this.reflexive;
	}

	public void setReflexive(Boolean reflexive) {
		this.reflexive = reflexive;
	}

	public Boolean isShownetwork() {
		return this.shownetwork;
	}

	public void setShownetwork(Boolean shownetwork) {
		this.shownetwork = shownetwork;
	}

	public Boolean isUseyou() {
		return this.useyou;
	}

	public void setUseyou(Boolean useyou) {
		this.useyou = useyou;
	}

	public Boolean isCapitalize() {
		return this.capitalize;
	}

	public void setCapitalize(Boolean capitalize) {
		this.capitalize = capitalize;
	}

	public String getIfcantsee() {
		return this.ifcantsee;
	}

	public void setIfcantsee(String ifcantsee) {
		this.ifcantsee = ifcantsee;
	}

	public Integer getSubjectid() {
		return this.subjectid;
	}

	public void setSubjectid(Integer subjectid) {
		this.subjectid = subjectid;
	}
	
}
