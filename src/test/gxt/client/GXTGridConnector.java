package test.gxt.client;

import java.util.ArrayList;
import java.util.List;

import test.gxt.GXTGrid;
import test.gxt.shared.GXTGridRpc;
import test.gxt.shared.GXTGridState;
import test.gxt.shared.MyBean;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.selection.SelectionChangedEvent;
import com.sencha.gxt.widget.core.client.selection.SelectionChangedEvent.SelectionChangedHandler;
import com.vaadin.terminal.gwt.client.communication.RpcProxy;
import com.vaadin.terminal.gwt.client.communication.StateChangeEvent;
import com.vaadin.terminal.gwt.client.ui.AbstractComponentConnector;
import com.vaadin.terminal.gwt.client.ui.Connect;

@Connect(GXTGrid.class)
public class GXTGridConnector extends AbstractComponentConnector {

	private GXTGridRpc rpc = RpcProxy.create(GXTGridRpc.class, this);

	private ListStore<MyBean> store;

	private ColumnModel<MyBean> columnModel;

	private List<ColumnConfig<MyBean, ?>> columnConfig;

	private MyBeanProperties myBeanProperties;

	@Override
	protected void init() {
		super.init();
		getWidget().setColumnReordering(true);
		getWidget().setHideHeaders(false);

		getWidget().getSelectionModel().addSelectionChangedHandler(
				new SelectionChangedHandler<MyBean>() {

					public void onSelectionChanged(
							SelectionChangedEvent<MyBean> event) {
						List<MyBean> selection = event.getSelection();

						if (selection == null || selection.isEmpty())
							rpc.selected(null);
						else
							rpc.selected(selection.get(0));
					}

				});
	}

	@Override
	public GXTGridState getState() {
		return (GXTGridState) super.getState();
	}

	@Override
	public void onStateChanged(StateChangeEvent stateChangeEvent) {
		super.onStateChanged(stateChangeEvent);
		store.clear();
		// getWidget().getColumnModel().getColumns().clear();

		List<MyBean> beans = getState().getData();
		if (beans == null || beans.isEmpty())
			return;

		store.addAll(getState().getData());
		// getWidget().getView().getHeader().refresh();
	}

	@Override
	public Grid<MyBean> getWidget() {
		return (Grid) super.getWidget();
	}

	@Override
	protected Widget createWidget() {
		myBeanProperties = GWT.create(MyBeanProperties.class);

		store = new ListStore<MyBean>(myBeanProperties.id());
		columnConfig = new ArrayList<ColumnConfig<MyBean, ?>>();
		columnConfig.add(new ColumnConfig<MyBean, String>(myBeanProperties
				.firstName(), 100, "First Name"));
		columnConfig.add(new ColumnConfig<MyBean, String>(myBeanProperties
				.lastName(), 100, "Last Name"));
		columnConfig.add(new ColumnConfig<MyBean, Integer>(myBeanProperties
				.age(), 50, "Age"));

		columnModel = new ColumnModel<MyBean>(columnConfig);
		return new Grid<MyBean>(store, columnModel);
	}
}
