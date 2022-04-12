package anotherstep2;

import org.eclipse.jgit.errors.RepositoryNotFoundException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.ServiceMayNotContinueException;
import org.eclipse.jgit.transport.resolver.RepositoryResolver;
import org.eclipse.jgit.transport.resolver.ServiceNotAuthorizedException;
import org.eclipse.jgit.transport.resolver.ServiceNotEnabledException;
 
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
 //a GitHttpResolver.java file that creates a Repository by yourself
public class GitHttpResolver implements RepositoryResolver<HttpServletRequest> {
    @Override
    public Repository open(HttpServletRequest request, String name) throws RepositoryNotFoundException, ServiceNotAuthorizedException, ServiceNotEnabledException, ServiceMayNotContinueException {
        System.out.println("ServletPath: " + request.getServletPath());
        System.out.println("name: " + name);
 
        try {
        	
        	// No bear repository 
            return new FileRepository("D:\\meveodata\\default\\git\\afs");
            //default path : D:\\meveodata\\default\\git\\
            
         //   git clone http://localhost:9090/gitservers/gitservlet/afs
            	
                        
            
            // for authentication : https://github.com/ijokarumawak/jgit-auth-example
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}


