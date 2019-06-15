package infamous;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.protocol.https.RequireHttps;
import org.apache.wicket.request.mapper.parameter.PageParameters;


@RequireHttps
public class Welcome extends WebPage {
	String userId;
	Page prevPage;

	public Welcome(String userId, Page prevPage) {
		this();
		this.userId = userId;
		this.prevPage = prevPage;
	}
	
	public Welcome() {
		add(new Label("message", this::getUserId));
		add(getLinkToUserProfile(),getLinkToLogin());
	}
	
	public Welcome(PageParameters params) {
		this();
		setUserId(params.get("userId").toString());
	}
	
	
	public Link<Void> getLinkToLogin() {
		return new Link<Void>("linkToLogin") {
			public void onClick() {
			setResponsePage(prevPage==null ? new Login() : prevPage);
		}};
	}
	
	public Link<Void> getLinkToUserProfile() {
		return new Link<Void>("linkToUserProfile") {
			public void onClick() {
				setResponsePage(Login.class);
		}};

	}
	

	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
