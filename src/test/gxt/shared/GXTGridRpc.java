package test.gxt.shared;

import com.vaadin.terminal.gwt.client.communication.ServerRpc;

public interface GXTGridRpc extends ServerRpc {

	public void selected(MyBean bean);

}
