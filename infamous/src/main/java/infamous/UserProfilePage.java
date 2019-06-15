package infamous;

import java.util.Arrays;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.protocol.https.RequireHttps;


@RequireHttps
public class UserProfilePage extends BasePage {
	
	public UserProfilePage() {
		UserProfile userProfile = new UserProfile();
		CompoundPropertyModel userProfileModel = new CompoundPropertyModel(userProfile);
		Form form = new UserProfileForm("userProfile", userProfileModel);
		
		TextField userNameComp = new TextField("name");
		TextField addressComp = new TextField("address");
		TextField cityComp = new TextField("city");		
		DropDownChoice countriesComp = new DropDownChoice("country",  Arrays.asList(new String[] {"India", "US", "UK"}));		
		TextField pinComp = new TextField("pin");
		add(form);
		form.add(userNameComp, addressComp, cityComp, countriesComp, pinComp);
	}
}
