package test.gxt;

import test.gxt.shared.GXTComboBoxState;

import com.vaadin.terminal.gwt.client.ComponentState;
import com.vaadin.ui.AbstractComponent;

public class GXTComboBox extends AbstractComponent {

	@Override
	public GXTComboBoxState getState() {
		return (GXTComboBoxState) super.getState();
	}
}
