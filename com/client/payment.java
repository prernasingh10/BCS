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

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialContainer;

public class payment extends Composite{

	private static paymentUiBinder uiBinder = GWT.create(paymentUiBinder.class);

	interface paymentUiBinder extends UiBinder<Widget, payment> {
	}

	public payment() {
		initWidget(uiBinder.createAndBindUi(this));
	}
public payment(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		//button.setText(firstName);
	}

@UiField
MaterialButton back,sub;
@UiField
MaterialContainer c;

@UiHandler("back")
void onClick0(ClickEvent e)
{
	c.clear();
	flist f=new flist();
	c.add(f);
	
}

}
