package me.pseudoknight.chdisguises;

import com.laytonsmith.PureUtilities.SimpleVersion;
import com.laytonsmith.PureUtilities.Version;
import com.laytonsmith.core.Static;
import com.laytonsmith.core.extensions.AbstractExtension;
import com.laytonsmith.core.extensions.MSExtension;

import java.util.logging.Level;

@MSExtension("CHDisguises")
public class Extension extends AbstractExtension {

	public Version getVersion() {
		return new SimpleVersion(0,0,3);
	}

	@Override
	public void onStartup() {
		Static.getLogger().log(Level.INFO, "CHDisguises " + getVersion() + " loaded.");
	}

	@Override
	public void onShutdown() {
		Static.getLogger().log(Level.INFO, "CHDisguises " + getVersion() + " unloaded.");
	}

}
