package test.gxt;

import java.lang.reflect.Method;

import test.gxt.shared.GXTGridRpc;
import test.gxt.shared.GXTGridState;
import test.gxt.shared.MyBean;

import com.vaadin.tools.ReflectTools;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Component;

public class GXTGrid extends AbstractComponent {

	private MyBean value = null;

	public interface ValueChangeListener {
		public static final Method METHOD = ReflectTools.findMethod(
				ValueChangeListener.class, "valueChange",
				ValueChangeEvent.class);

		public void valueChange(ValueChangeEvent event);

	}

	public static class ValueChangeEvent extends Component.Event {

		public ValueChangeEvent(Component source) {
			super(source);
		}

	}

	private GXTGridRpc rpc = new GXTGridRpc() {

		public void selected(MyBean bean) {
			setValue(bean);
		}
	};

	public GXTGrid() {
		registerRpc(rpc); 
		setHeight("300px");
	}

	public void setValue(MyBean bean) {
		this.value = bean;
		fireEvent(new ValueChangeEvent(GXTGrid.this));
	}

	public void addListener(ValueChangeListener listener) {
		addListener(ValueChangeEvent.class, listener,
				ValueChangeListener.METHOD);
	}

	public void addRow(MyBean bean) {
		getState().getData().add(bean);
		requestRepaint();
	}

	@Override
	public GXTGridState getState() {
		return (GXTGridState) super.getState();
	}

	public MyBean getValue() {
		return value;
	}

}
