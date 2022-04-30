package mygit;

import java.text.MessageFormat;
import java.util.Collection;

import org.eclipse.jgit.transport.PostReceiveHook;
import org.eclipse.jgit.transport.PreReceiveHook;
import org.eclipse.jgit.transport.ReceiveCommand;
import org.eclipse.jgit.transport.ReceiveCommand.Result;
import org.eclipse.jgit.transport.ReceivePack;

public class UpdateHook implements PreReceiveHook, PostReceiveHook {

	@Override
	public void onPreReceive(ReceivePack rp, Collection<ReceiveCommand> commands) {

		System.out.println("onPreReceive--->>");

		for (ReceiveCommand cmd : commands) {
			sendRejection(cmd, "git push failed due to compilation error!", "customer");
		}
		return;

		// Reject all non-fast-forward updates
		/*
		 * for (ReceiveCommand c : commands) { if (c.getType() ==
		 * Type.UPDATE_NONFASTFORWARD) { c.setResult(Result.REJECTED_NONFASTFORWARD); }
		 * 
		 * 
		 * 
		 * }
		 */
	}

	@Override
	public void onPostReceive(ReceivePack rp, Collection<ReceiveCommand> commands) {
		System.out.println("onPostReceive--->>");
		for (ReceiveCommand cmd : commands) {
			sendRejection(cmd, "git push failed due to compilation error!", "customer");
		}
		return;

	}

	public void sendRejection(final ReceiveCommand cmd, final String why, Object... objects) {
		String text = MessageFormat.format(why, objects);
		cmd.setResult(Result.REJECTED_OTHER_REASON, text);
	}
}