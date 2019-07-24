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
import com.shared.fdet;
import com.sun.java.swing.plaf.windows.resources.windows;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialIntegerBox;
import gwt.material.design.client.ui.MaterialTextArea;
import gwt.material.design.client.ui.MaterialTextBox;

public class fadet extends Composite {

	private static fadetUiBinder uiBinder = GWT.create(fadetUiBinder.class);

	interface fadetUiBinder extends UiBinder<Widget, fadet> {
	}
	String i;
	public fadet() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	MaterialButton back, show;
	@UiField
	MaterialButton book;
	@UiField
	MaterialButton chat;
	@UiField
	MaterialTextBox add;
	@UiField
	MaterialTextBox name, email, aadhar, fid, mob;
	@UiField
	MaterialContainer x;

	private final GreetingServiceAsync a2 = GWT.create(GreetingService.class);

	public fadet(String i) {
		initWidget(uiBinder.createAndBindUi(this));
		this.i=i;
	}

	@UiHandler("back")
	void onClick(ClickEvent e) {
		x.clear();
		flist f = new flist();
		x.add(f);
	}

	@UiHandler("book")
	void onClick1(ClickEvent e) {
		String r="prerna";
		a2.book(r, new AsyncCallback<String>() {
			
			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				Window.alert(result);
				x.clear();
				flist f = new flist();
				x.add(f);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert(caught.getMessage());
			}
		});
	}

	@UiHandler("show")
	void onClick0(ClickEvent e) {

		fdet f = new fdet();
		a2.det(f,i, new AsyncCallback<fdet>() {

			@Override
			public void onSuccess(fdet result) {
				// TODO Auto-generated method stub
				String s1 = result.getF_id();
				String s2 = result.getName();
				String s3 = result.getMobile();
				String s4 = result.getAddress();
				String s5 = result.getAadhar();
				String s6 = result.getEmail();
			
				/*
				 * mob.setPlaceholder(s3); add.setLabel(s4); aadhar.setValue(s5);
				 * email.setName(s6);
				 */

				fid.setText(s1);
				name.setText(s2);
				mob.setText(s3);
				add.setText(s4);
				aadhar.setText(s5);
				email.setText(s6);
				Window.alert("yaaaassssssss");
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert(caught.getMessage());
			}
		});
	}

	@UiHandler("chat")
	void onClick2(ClickEvent e) {
		x.clear();
		chat c = new chat();
		x.add(c);
	}
}