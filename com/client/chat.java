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

public class chat extends Composite{

	private static chatUiBinder uiBinder = GWT.create(chatUiBinder.class);

	interface chatUiBinder extends UiBinder<Widget, chat> {
	}

	public chat() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	public chat(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		//button.setText(firstName);
	}
@UiField
MaterialContainer c;
@UiField
MaterialButton back;

@UiHandler("back")
void onClick(ClickEvent e)
{
	c.clear();
	fport f=new fport();
	c.add(f);
}

}
