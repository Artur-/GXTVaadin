package test.gxt.shared;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.terminal.gwt.client.AbstractFieldState;
import com.vaadin.terminal.gwt.client.ComponentState;

public class GXTComboBoxState extends AbstractFieldState {
	private List<String> options = new ArrayList<String>();

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

}
