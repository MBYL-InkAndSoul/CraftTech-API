package inkandsoul.ctapi.util;

public final class ChemistryUtil {
    /**
     * Format formula numbers.
     * @param formula Need to format formula.
     * @return Formatted formula.
     */
    public static String formatNumber(String formula){
        // ₀₁₂₃₄₅₆₇₈₉
        return formula.replaceAll("_1"," ")
                .replaceAll("_2", "₂")
                .replaceAll("_3", "₃")
                .replaceAll("_4", "₄")
                .replaceAll("_5", "₅")
                .replaceAll("_6", "₆")
                .replaceAll("_7", "₇")
                .replaceAll("_8", "₈")
                .replaceAll("_9", "₉");
    }
}
