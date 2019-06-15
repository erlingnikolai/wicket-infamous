package infamous;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;

public class UserProfileForm extends Form {

	public UserProfileForm(String id, IModel model) {
		super(id, model);
	}


	
	@Override
	protected void onSubmit() {
		System.out.println(getModelObject());
	}
	

}
