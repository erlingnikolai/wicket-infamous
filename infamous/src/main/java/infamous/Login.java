package infamous;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.LambdaModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.protocol.https.RequireHttps;

@RequireHttps
public class Login extends BasePage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userId;
	private String password;

	/**
	 * 
	 */

	public Login() {
		TextField userIdField = new TextField("userId",LambdaModel.of(this::getUserId, this::setUserId));
		PasswordTextField passField = new PasswordTextField("password", new PropertyModel(this, "password"));
		passField.setResetPassword(false);
		LoginForm form = new LoginForm("loginForm");
		form.add(userIdField);
		form.add(passField);
		add(form);
	}

	class LoginForm extends Form<Object> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;


		public LoginForm(String id) {
			super(id);
		}

		@Override
		public void onSubmit() {
			String userId = getUserId();
			String password = getPassword();

			if (authenticate(userId, password)) {
				Welcome welcomePage = new Welcome();
				welcomePage.setUserId(userId);
				setResponsePage(welcomePage);

			} else {
				System.out.println("The user id/ password combination is incorrect!\n");
			}
		}
		
	
		private boolean authenticate(final String userId, final String password) {
			return true;
		//	return("wicket".equals(userId) && "wicket".equals(password) ? true : false);
		}
		protected String getUserId() {
			return userId;
		}

		protected String getPassword() {
			return password;
		}
	}
	
	protected String getUserId() {
		return userId;
	}

	protected String getPassword() {
		return password;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
