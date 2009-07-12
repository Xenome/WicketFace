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

import java.util.Map;

import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.panel.Panel;
import org.json.JSONException;
import org.json.JSONObject;
import org.wicketface.exceptions.WicketFaceException;

public class PublishToFeedPanel extends Panel implements IHeaderContributor {
	private static final long serialVersionUID = 2741530732354836025L;

	private Map<String,String> templateData;
	private Long templateId; 
	private boolean submitToFacebook;
	private String prompt; 
	private String message;
	protected boolean showLoading;


	protected WebMarkupContainer publishToFeedLoading;


	public PublishToFeedPanel(String id, Map<String,String> templateData, Long templateId, 
			boolean submitToFacebook, String prompt, String message) {
		super(id);

		this.templateData = templateData;
		this.templateId = templateId;
		this.submitToFacebook = submitToFacebook;
		this.prompt = prompt;
		this.message = message;

		publishToFeedLoading = new WebMarkupContainer("publishToFeedLoading") {
			private static final long serialVersionUID = -4009639032323247738L;

			@Override
			public boolean isVisible() {
				return PublishToFeedPanel.this.showLoading;
			}
		};
		this.add(this.publishToFeedLoading);
		this.publishToFeedLoading.setOutputMarkupId(true);
		this.publishToFeedLoading.setOutputMarkupPlaceholderTag(true);
		this.publishToFeedLoading.add( new Image("publishToFeedLoadingSpinner", 
				new ResourceReference(PublishToFeedPanel.class, "images/wicketface-loader.gif")));
	}

	public PublishToFeedPanel(String id, Map<String,String> templateData, Long templateId,
			boolean submitToFacebook) {
		this(id, templateData, templateId, submitToFacebook, null, null);
	}

	public PublishToFeedPanel(String id, Map<String,String> templateData, Long templateId) {
		this(id, templateData, templateId, true, null, null);
	}


	public void renderHead(IHeaderResponse response) {
		if (this.submitToFacebook) {
			String jsonTemplateData = buildJSONObject(templateData).toString();
			String script;
			if (prompt!=null && message!=null) {
				script = "var template_data="+jsonTemplateData+";" +
				"FB.Connect.showFeedDialog("+templateId.toString()+",template_data);" +
				"document.getElementById('"+publishToFeedLoading.getMarkupId()+"')." +
				"style.visibility='hidden'";
			} else {
				script = "var template_data="+jsonTemplateData+";" +
				"FB.Connect.showFeedDialog("+templateId.toString()+",template_data," +
				", null, null, FB.FeedStorySize.shortStory, FB.RequireConnect.promptConnect," +
				this.prompt+","+ this.message+");" +
				"document.getElementById('"+publishToFeedLoading.getMarkupId()+"')." +
				"style.visibility='hidden'";
			}
			response.renderOnLoadJavascript(script);
		}
	}

	private JSONObject buildJSONObject(Map<String,String> data) 
	throws WicketFaceException{

		JSONObject jsonTemplateData = new JSONObject();
		if ( data != null && !data.isEmpty() ) {
			for ( String key : data.keySet() ) {
				try {
					jsonTemplateData.put(key, data.get(key));
				} catch (JSONException e) {
					throw new WicketFaceException("Error building JSON object");
				}
			}
		}
		return jsonTemplateData;
	}

	public boolean isShowLoading() {
		return this.showLoading;
	}

	public void setShowLoading(boolean showLoading) {
		this.showLoading = showLoading;
	}

}
