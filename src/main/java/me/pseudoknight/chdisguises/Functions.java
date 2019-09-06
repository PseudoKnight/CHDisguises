package me.pseudoknight.chdisguises;

import com.laytonsmith.PureUtilities.Version;
import com.laytonsmith.abstraction.MCEntity;
import com.laytonsmith.annotations.api;
import com.laytonsmith.core.MSVersion;
import com.laytonsmith.core.Static;
import com.laytonsmith.core.constructs.CNull;
import com.laytonsmith.core.constructs.CVoid;
import com.laytonsmith.core.constructs.Target;
import com.laytonsmith.core.environments.Environment;
import com.laytonsmith.core.exceptions.CRE.CREBadEntityException;
import com.laytonsmith.core.exceptions.CRE.CREThrowable;
import com.laytonsmith.core.exceptions.ConfigRuntimeException;
import com.laytonsmith.core.functions.AbstractFunction;
import com.laytonsmith.core.natives.interfaces.Mixed;

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

		public Mixed exec(Target t, Environment environment, Mixed... args) throws ConfigRuntimeException {
			MCEntity entity = Static.getEntity(args[0], t);
			if(args[1] instanceof CNull) {
				DisguiseUtil.Undisguise(entity);
			} else {
				String data = null;
				if(args.length == 3) {
					data = args[2].val();
				}
				DisguiseUtil.Disguise(entity, args[1].val(), data, t);
			}
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
			return MSVersion.V3_3_2;
		}

	}

}
