package test.gxt.client;

import test.gxt.shared.MyBean;

import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface MyBeanProperties extends PropertyAccess<MyBean> {
	ModelKeyProvider<MyBean> id();

	ValueProvider<MyBean, String> firstName();

	ValueProvider<MyBean, String> lastName();

	ValueProvider<MyBean, Integer> age();
}
