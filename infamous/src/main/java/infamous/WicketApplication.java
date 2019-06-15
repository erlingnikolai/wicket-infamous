package infamous;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.https.HttpsConfig;
import org.apache.wicket.protocol.https.HttpsMapper;

public class WicketApplication extends WebApplication{

	@Override
	public Class<? extends Page> getHomePage() {
		return Login.class;
	}
	
	
	@Override
	public void init(){
	   setRootRequestMapper(new HttpsMapper(getRootRequestMapper(),
	                                       new HttpsConfig(8080, 8443)));
	}

}
