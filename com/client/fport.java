package com.client;

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

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialContainer;

public class fport extends Composite{

	private static fportUiBinder uiBinder = GWT.create(fportUiBinder.class);

	interface fportUiBinder extends UiBinder<Widget, fport> {
	}

	public fport() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	
	@UiField
	MaterialContainer d;
	
	@UiField
	MaterialButton add;
	
	@UiField
	MaterialButton req;
	
	@UiField
	MaterialButton chat;
	@UiField
	MaterialButton out,event;
	
	private final GreetingServiceAsync a2 = GWT.create(GreetingService.class);
	
	
public fport(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		//button.setText(firstName);
	}

@UiHandler("add")
void onClick0(ClickEvent e)
{
	Window.alert("details added");
	d.clear();
	ldet l=new ldet();
	d.add(l);
}
@UiHandler("req")
void onClick1(ClickEvent e)
{
	String s="";
	a2.show(s, new AsyncCallback<String>() {
		
		@Override
		public void onSuccess(String result) {
			// TODO Auto-generated method stub
			Window.confirm(result);
		}
		
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert(caught.getMessage());
		}
	});
	
}

@UiHandler("chat")
void onClick2(ClickEvent e)
{
	Window.alert("this is a chat box");
}


@UiHandler("out")
void onClick4(ClickEvent e)
{
	Window.alert("you are logged out");
	d.clear();
	login l=new login();
	d.add(l);
}

@UiHandler("chat")
void onClick5(ClickEvent e)
{
	
	d.clear();
	chat l=new chat();
	d.add(l);
}
@UiHandler("event")
void onClick6(ClickEvent e)
{
	
	d.clear();
	event l=new event();
	d.add(l);
}

 
}
