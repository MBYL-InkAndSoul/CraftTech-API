package inkandsoul.ctapi.main.common.both.util;

public final class TimeUtil {
	public static int secToTick(float s){
		return (int)(s*20);
	}
	public static float tickToSec(int t){
		return ((float) t /20);
	}

	public static String tickToSecIntoString(float t){
		return t/20+"s";
	}
}
