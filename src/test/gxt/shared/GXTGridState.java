package test.gxt.shared;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.terminal.gwt.client.ComponentState;

public class GXTGridState extends ComponentState {

	private List<MyBean> data = new ArrayList<MyBean>();

	public List<MyBean> getData() {
		return data;
	}

	public void setData(List<MyBean> data) {
		this.data = data;
	}

}
