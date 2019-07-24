package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialSlider;

public class tan extends Composite{

	private static tanUiBinder uiBinder = GWT.create(tanUiBinder.class);

	interface tanUiBinder extends UiBinder<Widget, tan> {
	}

	public tan() {
		initWidget(uiBinder.createAndBindUi(this));
	}


	public tan(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		//button.setText(firstName);
	}	
	@UiField
	MaterialLink login,home,registration,gall,feed;
	@UiField
	MaterialContainer aa;
	
@UiField
MaterialSlider ss;
	
	@UiHandler("home")
	
	void onClick(ClickEvent e) {
		aa.clear();
		
			aa.add(ss);
				 
	}
	

	@UiHandler("registration")
	void onClick2(ClickEvent e) {
		
		aa.clear();
		regis rr=new regis();
		aa.add(rr);
	}

	@UiHandler("login")
	void onClick0(ClickEvent e) {
		
		aa.clear();
	login rr=new login();
	aa.add(rr);
	}
	
	@UiHandler("gall")
	void onClick3(ClickEvent e) {
		
		aa.clear();
	gall g=new gall();
	aa.add(g);
	}

	@UiHandler("feed")
	void onClick4(ClickEvent e) {
		
		aa.clear();
	feed f=new feed();
	aa.add(f);
	}
}
	
	
		 
