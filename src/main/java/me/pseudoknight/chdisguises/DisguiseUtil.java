package me.pseudoknight.chdisguises;

import com.laytonsmith.abstraction.MCEntity;
import com.laytonsmith.core.constructs.Target;
import com.laytonsmith.core.exceptions.CRE.CREInsufficientArgumentsException;
import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class DisguiseUtil {
	static void Disguise(MCEntity entity, String input, String data, Target t) {
		DisguiseType type = DisguiseType.getType(EntityType.valueOf(input));
		TargetedDisguise disguise;
		if(type.isMob()) {
			disguise = new MobDisguise(type);
		} else if(type.isPlayer()) {
			if(data == null) {
				throw new CREInsufficientArgumentsException("Expected player name argument", t);
			}
			disguise = new PlayerDisguise(data);
		} else if(type.isMisc()) {
			disguise = new MiscDisguise(type);
		} else {
			return;
		}
		DisguiseAPI.disguiseToAll((Entity) entity.getHandle(), disguise);
	}

	static void Undisguise(MCEntity entity) {
		DisguiseAPI.undisguiseToAll((Entity) entity.getHandle());
	}
}
