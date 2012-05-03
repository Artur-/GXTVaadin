package test.gxt.client;

import test.gxt.GXTComboBox;
import test.gxt.shared.GXTComboBoxState;

import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.form.ComboBox;
import com.sencha.gxt.widget.core.client.form.SimpleComboBox;
import com.vaadin.terminal.gwt.client.communication.StateChangeEvent;
import com.vaadin.terminal.gwt.client.ui.AbstractComponentConnector;
import com.vaadin.terminal.gwt.client.ui.Connect;

@Connect(GXTComboBox.class)
public class GXTComboBoxConnector extends AbstractComponentConnector {

	private LabelProvider<? super String> labelProvider = new LabelProvider<String>() {

		public String getLabel(String item) {
			return item.toString();
		}
	};

	@Override
	public GXTComboBoxState getState() {
		return (GXTComboBoxState) super.getState();
	}

	@Override
	public void onStateChanged(StateChangeEvent stateChangeEvent) {
		super.onStateChanged(stateChangeEvent);

		getWidget().getStore().clear();
		getWidget().getStore().addAll(getState().getOptions());

	}

	@Override
	protected Widget createWidget() {
		return new SimpleComboBox<String>(labelProvider);
	}

	@Override
	public ComboBox<String> getWidget() {
		return (ComboBox<String>) super.getWidget();
	}

}
