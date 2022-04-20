package mygit;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.ReceivePack;
import org.eclipse.jgit.transport.resolver.ReceivePackFactory;


public class MyReceivePackFactory implements ReceivePackFactory<HttpServletRequest> {

	@Override
	public ReceivePack create(HttpServletRequest req, Repository db) {
		ReceivePack pack = new ReceivePack(db);
		pack.setPreReceiveHook(new UpdateHook());
		System.out.println("create--->>");
		return pack;
	}
}