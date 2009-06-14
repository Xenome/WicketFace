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

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.wicketface.markup.xfbml.FacebookConnectButton;

public class HomePage extends BasePage {

	public HomePage() {
		super();
		
		/*
		 * Facebook connect button
		 */
		FacebookConnectButton facebookConnectButton = new FacebookConnectButton("facebookConnectButton"){
			private static final long serialVersionUID = -2199948587128000067L;

			@Override
        	public boolean isVisible() {
        		return !HomePage.this.isFacebookConnected();
        	}
        };
        this.add(facebookConnectButton);
        
        /*
         * Demo list where the demo links are displayed when Facebook is connected
         */
        WebMarkupContainer demoList = new WebMarkupContainer("demoList"){
			private static final long serialVersionUID = -404354905730943623L;

			@Override
        	public boolean isVisible() {
        		return HomePage.this.isFacebookConnected();
        	}
        };
        demoList.setOutputMarkupPlaceholderTag(true);
        demoList.setOutputMarkupId(true);
        this.add(demoList);
        
        demoList.add(new BookmarkablePageLink("publishToFeedLink", PublishToFeedPage.class));
        
	}
}
