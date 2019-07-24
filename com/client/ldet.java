package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
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
import gwt.material.design.client.ui.MaterialCheckBox;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialFloatBox;
import gwt.material.design.client.ui.MaterialLongBox;
import gwt.material.design.client.ui.MaterialTextArea;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.client.ui.table.MaterialDataTable;
import com.shared.nuti;

public class ldet extends Composite{
private static ldetUiBinder uiBinder = GWT.create(ldetUiBinder.class);
	interface ldetUiBinder extends UiBinder<Widget, ldet> {
	}
	public ldet() {
		initWidget(uiBinder.createAndBindUi(this));
	}
public ldet(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		//button.setText(firstName);
	}

@UiField
MaterialLongBox lon,lat;
@UiField
MaterialFloatBox nut,larea;
@UiField
MaterialTextArea crop;
@UiField
MaterialButton back,sub;
@UiField
MaterialContainer c;

private final GreetingServiceAsync a2 = GWT.create(GreetingService.class);
@UiHandler("sub")
void onClick0(ClickEvent e)
{
	nuti n = new nuti();
	n.setLatitude(lat.getText());
	n.setLongitude(lon.getText());
	n.setLand_area(larea.getText());
	n.setCrops(crop.getText());
	n.setNutrients(nut.getText());
	a2.land(n, new AsyncCallback<String>() {
		
		@Override
		public void onSuccess(String result) {
			// TODO Auto-generated method stub
			Window.alert(result);
			c.clear();
			fport f=new fport();
			c.add(f);
		}
		
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert(caught.getMessage());
		}
	});
	
}
@UiHandler("back")
void onClick1(ClickEvent e)
{
	
	c.clear();
	fport f=new fport();
	c.add(f);

}
}
