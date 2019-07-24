package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.shared.farmerslist;
import com.shared.fdet;

import gwt.material.design.addins.client.overlay.MaterialOverlay;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCollection;
import gwt.material.design.client.ui.MaterialCollectionItem;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialHeader;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialTextBox;

public class flist extends Composite{

	private static flistUiBinder uiBinder = GWT.create(flistUiBinder.class);

	interface flistUiBinder extends UiBinder<Widget, flist> {
	}

	public flist() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	int j,n;
	@UiField
	MaterialButton out,event,payment,show;
	@UiField
	MaterialContainer cc;
	@UiField
	MaterialCollection mc;
	
	
	
	

	public flist(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		//button.setText(firstName);
	}
	
	@UiHandler("event")
	void onclick00(ClickEvent e)
	{
		cc.clear();
		seve s=new seve();
		cc.add(s);
	}
	@UiHandler("out")
	void onClick0(ClickEvent e)
	{
		cc.clear();
		login l=new login();
		cc.add(l);
		Window.alert("You are logged out");
		
	}

	@UiHandler("payment")
	void onClick00(ClickEvent e)
	{
		cc.clear();
		payment p=new payment();
		cc.add(p);
		Window.alert("payment method");
	}
	private final GreetingServiceAsync a2 = GWT.create(GreetingService.class);
@UiHandler("show")
void onClick(ClickEvent e)
{
	String l="";
	a2.allfar(l, new AsyncCallback<farmerslist>() {
		
		@Override
		public void onSuccess(farmerslist result) {
			// TODO Auto-generated method stub
			n=result.getN();
			String x[]=new String[n];
			x=result.getF();
			for(j=0;j<n;j++)
			{
				MaterialCollectionItem mci = new MaterialCollectionItem();
				MaterialLink m1=new MaterialLink(x[j]);
				m1.setTextColor(Color.BLACK);
				mci.add(m1);
				mc.add(mci);
				mci.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						// TODO Auto-generated method stub
						String i=m1.getText();
						
						fadet fd = new fadet(i);
						cc.clear();
						cc.add(fd);
					}
				});
			}
		}
		
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert(caught.getMessage());
		}
	});
}
}

