

package org.meveo.service.git;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/*
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;*/
import org.eclipse.jgit.api.AddCommand;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PullCommand;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.api.RebaseCommand;
import org.eclipse.jgit.api.RebaseCommand.Operation;
import org.eclipse.jgit.api.ResetCommand;
import org.eclipse.jgit.api.ResetCommand.ResetType;
import org.eclipse.jgit.api.RmCommand;
import org.eclipse.jgit.api.Status;
import org.eclipse.jgit.api.errors.EmptyCommitException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.diff.DiffFormatter;
import org.eclipse.jgit.diff.RawTextComparator;
import org.eclipse.jgit.internal.storage.file.WindowCache;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.SubmoduleConfig;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.storage.file.WindowCacheConfig;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.util.io.DisabledOutputStream;
import org.meveo.api.git.GitRepository;
import org.slf4j.Logger;

/**
 * Git client class to manipulate repositories
 *
 * @author Clement Bareth
 * @author Edward P. Legaspi | edward.legaspi@manaty.net
 * @since 6.4.0
 * @version 6.9.0
 */

public class GitClient {

   
   
    /**
     * Stage the files correspondings to the given pattern and create commit
     *
     * @param gitRepository Repository to commit
     * @param patterns      Pattern of the files to stage
     * @param message       Commit message
     * @throws UserNotAuthorizedException if user does not have write access to the repository
     * @throws Exception          if repository cannot be open or commited
     * @throws IllegalArgumentException   if pattern list is empty
     */
    public void commit(GitRepository gitRepository, List<String> patterns, String message) throws Exception {
     
    }

    /**
     * Stage the files in parameter and create commit
     *
     * @param gitRepository Repository to commit
     * @param files         Files to stage
     * @param message       Commit message
     * @throws UserNotAuthorizedException if user does not have write access to the repository
     * @throws Exception          if repository cannot be open, commited, or if a file is not child of the repository
     */
    public void commitFiles(GitRepository gitRepository, List<File> files, String message) throws Exception {
       
    }

    /**
     * Push the repositories' commits to upstream
     *
     * @param gitRepository Repository to push
     * @param username      Optional - Username to use when pushing
     * @param password      Optional - Password to use when pushing
     * @throws UserNotAuthorizedException if user does not have write access to the repository
     * @throws IllegalArgumentException   if repository has no remote
     * @throws Exception          if repository cannot be opened or if a problem happen during the push
     */
    public void push(GitRepository gitRepository, String username, String password) throws Exception {
       
    }

    /**
     * Pull with rebase the upstream's content
     *
     * @param gitRepository Repository to update
     * @param username      Optional - Username to use when pulling
     * @param password      Optional - Password to use when pulling
     * @throws UserNotAuthorizedException if user does not have write access to the repository
     * @throws IllegalArgumentException   if repository has no remote
     * @throws Exception          if repository cannot be opened or if a problem happen during the pull
     */
    public void pull(GitRepository gitRepository, String username, String password) throws Exception {
       

    }


    /**
     * Checkout an other branch of the repository
     *
     * @param gitRepository GitRepository where to execute the checkout
     * @param branch        Name of the branch to checkout
     * @param createBranch  Whether to create the branch if it does not exists
     * @throws Exception          if the GitRepository cannot be opened or the checkout cannot be done
     * @throws UserNotAuthorizedException if user does not have write access to the repository
     */
    public void checkout(GitRepository gitRepository, String branch, boolean createBranch) throws Exception {
       
    }


    /**
     * Return the head commit of a repository
     *
     * @param gitRepository {@link GitRepository} to retrieve head commit from
     * @return the head commit
     * @throws Exception if we cannot read the repositories branches
     */
    public RevCommit getHeadCommit(GitRepository gitRepository) throws Exception {
    	
    	return null;
       
    }

    /**
     * Build the list of files modified in a given commit
     *
     * @param gitRepository Repository holding the commit
     * @param commit        The commit to analyze
     * @return the list of files modified
     */
    public List<DiffEntry> getDiffs(GitRepository gitRepository, RevCommit commit) throws Exception {
    	return null;
    }

    /**
     * Reset a repository to a given commit
     *
     * @param gitRepository {@link GitRepository} to reset
     * @param commit        Commit to reset onto
     */
    public void reset(GitRepository gitRepository, RevCommit commit) throws Exception {
     
    }

    protected List<DiffEntry> getDiffs(Repository repository, RevCommit leftCommit, RevCommit rightCommit) throws IOException {
        try(DiffFormatter df = new DiffFormatter(DisabledOutputStream.INSTANCE)) {
            df.setRepository(repository);
            df.setDiffComparator(RawTextComparator.DEFAULT);
            df.setDetectRenames(true);
            return df.scan(leftCommit.getTree(), rightCommit.getTree());
        }
    }

    /**
     * Compute difference between two commits for a given repository
     *
     * @param repository  {@link Repository} to scan
     * @param leftCommit  Left commit to compare
     * @param rightCommit Right commit to compare
     * @return the modified files between the two commits
     */
    public Set<String> getModifiedFiles(List<DiffEntry> diffs) throws IOException {
        Set<String> modifiedFiles = new HashSet<>();

        for (DiffEntry diff : diffs) {
            modifiedFiles.add(diff.getNewPath());
            modifiedFiles.add(diff.getOldPath());
        }

        return modifiedFiles;
    }

  

}
