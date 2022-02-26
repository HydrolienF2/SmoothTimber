package net.sourcewriters.smoothtimber.api.platform.command;

import com.syntaxphoenix.avinity.command.ISource;

public abstract class PlatformSource implements ISource {

    protected final IPlatformSender sender;

    public PlatformSource(final IPlatformSender sender) {
        this.sender = sender;
    }

    public final IPlatformSender getSender() {
        return sender;
    }

    @Override
    public final boolean hasPermission(final String id) {
        return sender.isPermitted(id);
    }

}
