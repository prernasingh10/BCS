package com.client;

import javax.servlet.AsyncEvent;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.shared.sevent;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialTextBox;

public class seve extends Composite {

	private static seveUiBinder uiBinder = GWT.create(seveUiBinder.class);

	interface seveUiBinder extends UiBinder<Widget, seve> {
	}

	public seve() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiField
	MaterialTextBox name,loc,date;
	@UiField
	MaterialButton back,show;
	@UiField
	MaterialContainer cc;

	public seve(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		//button.setText(firstName);
	}
	
	@UiHandler("back")
	void onClick(ClickEvent e)
	{
		cc.clear();
		flist f=new flist();
		cc.add(f);
	}
	private final GreetingServiceAsync a2 = GWT.create(GreetingService.class);
	@UiHandler("show")
	void onClick1(ClickEvent e)
	{
		sevent k = new sevent();
		a2.evnt(k, new AsyncCallback<sevent>() {
			
			@Override
			public void onSuccess(sevent result) {
				// TODO Auto-generated method stub
				String s1 =result.getName();
				String s2=result.getDate();
				String s3=result.getLocation();
				name.setText(s1);
				date.setText(s2);
				loc.setText(s3);
				
				Window.alert("welcome");
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert(caught.getMessage());
			}
		});
	}
	}

