package anotherstep2;


import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "gitserver", urlPatterns = { "/gitservlet/*" }, loadOnStartup = 1, initParams = {
		@WebInitParam(name = "base-path", value = "D:\\meveodata\\default\\git"),
		@WebInitParam(name = "export-all", value = "true") })
public class GitServlet extends org.eclipse.jgit.http.server.GitServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("my study: " + config.getServletName());
		setRepositoryResolver(new GitHttpResolver());
		super.init(config);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		// User should be authenticated

		try {
			req.login("masum", "suma");
		} catch (ServletException e) {
			System.out.println(e.getMessage());

			return;
		}

		System.out.println("--------------->>>" + req.getUserPrincipal().getName());
		System.out.println("--------------->>>" + req.getUserPrincipal());

		if (req.getUserPrincipal() == null) {
			res.addHeader("WWW-Authenticate", "Basic realm=\"Meveo Git access\", charset=\"UTF-8\"");
			res.getWriter().print("You must be logged to access the Meveo Git server");
			res.setStatus(401);
			return;
		}

	}

}

//   git clone http://localhost:9090/gitservers/gitservlet/afs

//                                 /contextpath/servletpath/remaing part of default repo


//---------------------------------EROR ------------------------

//git.exe push --progress "origin" master:master
//XML error: no element found
//error: no DAV locking support on http://localhost:9090/gitservers/git/afs/
//fatal: git-http-push failed
//error: failed to push some refs to 'http://localhost:9090/gitservers/git/afs'

//----------solution ---------

//https://bbs.archlinux.org/viewtopic.php?id=112166



//https://stackoverflow.com/questions/7073504/cannot-get-http-on-git-to-work/7073618#7073618

//https://stackoverflow.com/questions/9243404/unable-to-push-a-git-repo-via-http

//https://daveceddia.com/deploy-git-repo-to-server/

//https://dev.cloudstack.apache.narkive.com/1NLJSQfz/git-repo-down-error-no-dav-locking-support

//https://www.youtube.com/watch?v=mYhF95r5uIo