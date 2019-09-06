package me.pseudoknight.chdisguises;

import com.laytonsmith.PureUtilities.SimpleVersion;
import com.laytonsmith.PureUtilities.Version;
import com.laytonsmith.core.extensions.AbstractExtension;
import com.laytonsmith.core.extensions.MSExtension;

@MSExtension("CHDisguises")
public class Extension extends AbstractExtension {

	public Version getVersion() {
		return new SimpleVersion(0,0,3);
	}

	@Override
	public void onStartup() {
		System.out.println("CHDisguises " + getVersion() + " loaded.");
	}

	@Override
	public void onShutdown() {
		System.out.println("CHDisguises " + getVersion() + " unloaded.");
	}

}
