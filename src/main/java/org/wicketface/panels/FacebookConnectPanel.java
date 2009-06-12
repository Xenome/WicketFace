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
package org.wicketface.panels;

import org.apache.wicket.markup.html.panel.Panel;
import org.wicketface.markup.behaviors.FacebookLoginBehavior;
import org.wicketface.markup.xfbml.FacebookConnectButton;
import org.wicketface.pages.FacebookAwarePage;

public class FacebookConnectPanel extends Panel {
	private static final long serialVersionUID = -7032982481076184629L;

    private FacebookConnectButton buttonLoginFacebook;
    
    public FacebookConnectPanel(String id) {
        super(id);
        
        FacebookUserInfoPanel facebookUser = new FacebookUserInfoPanel("facebookUserPanel"){
			private static final long serialVersionUID = -1674808109694087668L;

			@Override
        	public boolean isVisible() {
        		return ((FacebookAwarePage)FacebookConnectPanel.this.getPage()).isFacebookConnected();
        	}
        };
        facebookUser.setOutputMarkupId(true);
        facebookUser.setOutputMarkupPlaceholderTag(true);
        this.add(facebookUser);
        
        buttonLoginFacebook = new FacebookConnectButton("facebookConnectButton"){
			private static final long serialVersionUID = -2199948587128000067L;

			@Override
        	public boolean isVisible() {
        		return !((FacebookAwarePage)FacebookConnectPanel.this.getPage()).isFacebookConnected();
        	}
        };
        buttonLoginFacebook.add(new FacebookLoginBehavior());
        this.add(buttonLoginFacebook);
    }
    
    public FacebookConnectButton getFacebookLoginButton() {
		return this.buttonLoginFacebook;
	}


}

