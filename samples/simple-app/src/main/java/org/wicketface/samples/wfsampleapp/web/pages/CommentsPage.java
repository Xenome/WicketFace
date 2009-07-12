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
package org.wicketface.samples.wfsampleapp.web.pages;

import org.apache.wicket.model.StringResourceModel;
import org.wicketface.markup.xfbml.FacebookCommentsBox;

public class CommentsPage extends BasePage {
	
	public CommentsPage() {
		super();
		
		FacebookCommentsBox photoComments = new FacebookCommentsBox("photoComments");
		photoComments.setTitle(new StringResourceModel("comments.title", CommentsPage.this, null).
				getString());
		photoComments.setWidth("510px");
		this.add(photoComments);
	}

}
