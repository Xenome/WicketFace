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

import java.util.HashMap;
import java.util.Map;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.wicketface.panels.PublishToFeedPanel;
import org.wicketface.samples.wfsampleapp.web.application.WicketFaceSampleApplication;

public class PublishToFeedPage extends BasePage {
	
	public PublishToFeedPage() {

		this.add(new PublishInWallForm("publishInWalForm"));
		this.add(new WebMarkupContainer("publishingToFeed"));
	}

	protected class PublishInWallForm extends Form {
		private static final long serialVersionUID = 8831743386052700242L;

		protected TextField publishInWallTextInput;

		public PublishInWallForm(String id) {
			super(id);

			publishInWallTextInput = new TextField("publishInWallTextInput", new Model());
			publishInWallTextInput.setRequired(true);
			this.add(publishInWallTextInput);
		}

		@Override
		protected void onSubmit() {
			String sampleInput = publishInWallTextInput.getModelObjectAsString();
			Map<String, String> templateData = new HashMap<String,String>();
			templateData.put("sampleinput", sampleInput);

			this.publishInWallTextInput.clearInput();
			
			PublishToFeedPage.this.addOrReplace(new PublishToFeedPanel("publishingToFeed", templateData,
					WicketFaceSampleApplication.get().getTemplateId()));
			
		}
	}
}
