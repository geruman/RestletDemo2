package com.restlet.course.project;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

public class GameAPI extends Application {



	public static void main(String[] args) {
		try {
			Component component = new Component();
			component.getServers().add(Protocol.HTTP, 8182);
			component.getDefaultHost().attach(new GameAPI());
			component.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Restlet createInboundRoot() {
		Router router = new Router(getContext());
		router.attach("/player/{id}", SearchOnePlayerController.class);
		router.attach("/players", PlayerCrudController.class);
		router.setDefaultMatchingQuery(true);
		return router;
	}

}