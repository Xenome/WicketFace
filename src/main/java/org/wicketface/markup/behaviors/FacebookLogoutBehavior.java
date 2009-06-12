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
package org.wicketface.markup.behaviors;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.model.Model;

public class FacebookLogoutBehavior extends AttributeModifier {
	private static final long serialVersionUID = 6316223747643689432L;

	private static final String EVENT_NAME = "onclick";
    
    public FacebookLogoutBehavior() {
        super(EVENT_NAME, true, new Model());
    }
    
    
    @Override
    public void bind(Component component) {
        super.bind(component);
    }

    
    @Override
    protected String newValue(final String currentValue, final String replacementValue) {
        return ("FB.Connect.logout(function() { refresh_page(); })");
    }
}
