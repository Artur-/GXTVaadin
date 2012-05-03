package test.gxtapp;

import java.util.ArrayList;
import java.util.List;

import test.gxt.GXTComboBox;
import test.gxt.GXTGrid;
import test.gxt.GXTTextField;
import test.gxt.GXTGrid.ValueChangeEvent;
import test.gxt.GXTGrid.ValueChangeListener;
import test.gxt.shared.MyBean;

import com.vaadin.annotations.Theme;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.terminal.WrappedRequest;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Label.ContentMode;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Root;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@Theme("chameleon")
public class GxtRoot extends Root {
	List<String> options = new ArrayList<String>();
	List<MyBean> beans = new ArrayList<MyBean>();
	{
		beans.add(new MyBean("1", "John", "Doe", 42));
		beans.add(new MyBean("2", "Foo", "Bar", 101));
		beans.add(new MyBean("3", "Artur", "Signell", 31));

		options.add("New York");
		options.add("Madrid");
		options.add("Malaga");
		options.add("Turku");
	}

	@Override
	public void init(WrappedRequest request) {
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setSpacing(true);
		horizontalLayout.setMargin(true);
		setContent(horizontalLayout);
		addComponent(createGXT());
		addComponent(createVaadin());

	}

	private Component createVaadin() {
		Panel p = new Panel("Vaadin Components");
		VerticalLayout layout = new VerticalLayout();
		p.setContent(layout);

		final Table table = new Table();
		table.setSelectable(true);
		table.setImmediate(true);
		table.setHeight("300px");
		table.setWidth("302px");

		BeanItemContainer<MyBean> bic = new BeanItemContainer<MyBean>(
				MyBean.class);
		for (MyBean bean : beans) {
			bic.addBean(bean);
		}
		table.setContainerDataSource(bic);
		layout.addComponent(table);

		final Label valueLabel = new Label("", ContentMode.XHTML);
		valueLabel.setWidth("400px");

		table.addListener(new Property.ValueChangeListener() {

			public void valueChange(
					com.vaadin.data.Property.ValueChangeEvent event) {
				valueLabel.setValue(valueLabel.getValue() + "<br/>Selected: "
						+ table.getValue());

			}
		});
		layout.addComponent(valueLabel);

		ComboBox combo = new ComboBox("Vaadin ComboBox");
		for (String option : options)
			combo.addItem(option);
		layout.addComponent(combo);

		TextField textField = new TextField();
		textField.setCaption("Vaadin TextField with input prompt");
		textField.setInputPrompt("Please enter a value");
		textField.setValue("Some text");
		layout.addComponent(textField);

		return p;
	}

	private Component createGXT() {
		Panel p = new Panel("GXT 3 Components");
		VerticalLayout layout = new VerticalLayout();
		p.setContent(layout);

		final GXTGrid grid = new GXTGrid();
		for (MyBean bean : beans) {
			grid.addRow(bean);
		}
		layout.addComponent(grid);
		final Label valueLabel = new Label("", ContentMode.XHTML);
		valueLabel.setWidth("400px");

		grid.addListener(new ValueChangeListener() {

			public void valueChange(ValueChangeEvent event) {
				valueLabel.setValue(valueLabel.getValue() + "<br/>Selected: "
						+ grid.getValue());
			}
		});
		layout.addComponent(valueLabel);

		GXTComboBox combo = new GXTComboBox();
		combo.setCaption("GXT ComboBox");
		combo.getState().getOptions().addAll(options);
		layout.addComponent(combo);

		GXTTextField textField = new GXTTextField();
		textField.setCaption("GXT TextField with input prompt");
		textField.setInputPrompt("Please enter a value");
		textField.setValue("Some text");
		layout.addComponent(textField);

		return p;
	}
}
