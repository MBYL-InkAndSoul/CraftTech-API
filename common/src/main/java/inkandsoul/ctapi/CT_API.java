package inkandsoul.ctapi;

import inkandsoul.ctapi.registries.ModMachines;
import inkandsoul.ctapi.registries.ModRegistries;
import inkandsoul.ctapi.util.ResourceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CT_API {
	public static final String MOD_ID = "ctapi";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final ResourceUtil.Location LOCATION = new ResourceUtil.Location(MOD_ID);
	public static void init() {
		ModMachines.init();
		ModRegistries.init();
	}
}