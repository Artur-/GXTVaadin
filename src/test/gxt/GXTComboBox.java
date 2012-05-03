package test.gxt;

import test.gxt.shared.GXTComboBoxState;

import com.vaadin.ui.ComboBox;

public class GXTComboBox extends ComboBox {

	@Override
	public GXTComboBoxState getState() {
		return (GXTComboBoxState) super.getState();
	}
}
