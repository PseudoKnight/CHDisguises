package me.pseudoknight.chdisguises;

import com.laytonsmith.PureUtilities.Version;
import com.laytonsmith.abstraction.MCEntity;
import com.laytonsmith.annotations.api;
import com.laytonsmith.core.CHVersion;
import com.laytonsmith.core.Static;
import com.laytonsmith.core.constructs.CNull;
import com.laytonsmith.core.constructs.CVoid;
import com.laytonsmith.core.constructs.Construct;
import com.laytonsmith.core.constructs.Target;
import com.laytonsmith.core.environments.Environment;
import com.laytonsmith.core.exceptions.CRE.CREBadEntityException;
import com.laytonsmith.core.exceptions.CRE.CREThrowable;
import com.laytonsmith.core.exceptions.ConfigRuntimeException;
import com.laytonsmith.core.functions.AbstractFunction;
import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.DisguiseType;
import me.libraryaddict.disguise.disguisetypes.MiscDisguise;
import me.libraryaddict.disguise.disguisetypes.MobDisguise;
import me.libraryaddict.disguise.disguisetypes.PlayerDisguise;
import me.libraryaddict.disguise.disguisetypes.TargetedDisguise;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class Functions {
	public static String docs() {
		return "Functions for the LibsDisguises plugin.";
	}

	@api
	public static class disguise_entity extends AbstractFunction {

		public Class<? extends CREThrowable>[] thrown() {
			return new Class[]{CREBadEntityException.class};
		}

		public boolean isRestricted() {
			return true;
		}

		public Boolean runAsync() {
			return false;
		}

		public Construct exec(Target t, Environment environment, Construct... args) throws ConfigRuntimeException {
			MCEntity entity = Static.getEntity(args[0], t);
			if(args[1] instanceof CNull) {
				 DisguiseAPI.undisguiseToAll((Entity) entity.getHandle());
				return CVoid.VOID;
			}
			DisguiseType type = DisguiseType.getType(EntityType.valueOf(args[1].val()));
			TargetedDisguise disguise;
			if(type.isMob()) {
				disguise = new MobDisguise(type);
			} else if(type.isPlayer()) {
				disguise = new PlayerDisguise(args[2].val());
			} else if(type.isMisc()) {
				disguise = new MiscDisguise(type);
			} else {
				return CVoid.VOID;
			}
			DisguiseAPI.disguiseToAll((Entity) entity.getHandle(), disguise);
			return CVoid.VOID;
		}

		public String getName() {
			return "disguise_entity";
		}

		public Integer[] numArgs() {
			return new Integer[]{2,3};
		}

		public String docs() {
			return "void {entityUUID, disguiseType, [data]} Disguises an entity as the specified disguise."
					+ " If disguiseType is \"PLAYER\", data can be the player name.";
		}

		public Version since() {
			return CHVersion.V3_3_2;
		}

	}

}
