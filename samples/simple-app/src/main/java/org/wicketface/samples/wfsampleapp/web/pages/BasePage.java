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

import org.apache.wicket.behavior.HeaderContributor;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.wicketface.pages.FacebookAwarePage;
import org.wicketface.panels.FacebookUserInfoPanel;
import org.wicketface.samples.wfsampleapp.web.application.WicketFaceSampleApplication;


public abstract class BasePage extends FacebookAwarePage {

	public BasePage() {
		super();
		
		/*
		 * Adding some styles
		 */
		this.add(HeaderContributor.forCss("css/styles.css"));
		
		
		/*
		 * A feedback panel in case we need to show some message
		 */
		FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackPanel");
		feedbackPanel.setOutputMarkupId(true);
		add(feedbackPanel);
		
		/*
		 * The header link to the home page
		 */
		this.add(new BookmarkablePageLink("homePageLink", WicketFaceSampleApplication.get().getHomePage()));
		
		/*
		 * And the facebook user info panel that will be displayed only when the user is connected
		 */
		FacebookUserInfoPanel fbUserInfo = new FacebookUserInfoPanel("fbUserInfo"){
			private static final long serialVersionUID = 3711408901110142622L;

			@Override
			public boolean isVisible() {
				return BasePage.this.isFacebookConnected();
			}
		};
		fbUserInfo.setOutputMarkupId(true);
        fbUserInfo.setOutputMarkupPlaceholderTag(true);
		this.add(fbUserInfo);
	}
}
