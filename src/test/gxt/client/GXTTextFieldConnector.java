package test.gxt.client;

import test.gxt.GXTTextField;

import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.vaadin.terminal.gwt.client.ApplicationConnection;
import com.vaadin.terminal.gwt.client.Paintable;
import com.vaadin.terminal.gwt.client.UIDL;
import com.vaadin.terminal.gwt.client.communication.StateChangeEvent;
import com.vaadin.terminal.gwt.client.ui.AbstractFieldConnector;
import com.vaadin.terminal.gwt.client.ui.Connect;

@Connect(GXTTextField.class)
public class GXTTextFieldConnector extends AbstractFieldConnector implements
		Paintable {

	@Override
	public void onStateChanged(StateChangeEvent stateChangeEvent) {
		super.onStateChanged(stateChangeEvent);

	}

	@Override
	public TextField getWidget() {
		return (TextField) super.getWidget();
	}

	@Override
	public Widget createWidget() {
		return new TextField();
	}

	public void updateFromUIDL(UIDL uidl, ApplicationConnection client) {
		String inputPrompt = uidl.getStringAttribute("prompt");
		getWidget().setEmptyText(inputPrompt);
		String text = uidl.getStringVariable("text");
		getWidget().setText(text);
	}
}
