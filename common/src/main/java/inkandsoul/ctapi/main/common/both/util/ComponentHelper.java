package inkandsoul.ctapi.main.common.both.util;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public final class ComponentHelper {
    public static MutableComponent translatable(String textId){
        return translatable("", textId);
    }

    public static MutableComponent translatable(String prefix, String textId){
        return Component.translatable(prefix+textId);
    }
    /**
     * 用於創建文本内容，如果textId對於的翻譯鍵文本不存在則使用elseText的硬編碼内容。
     * @param textId 文本翻譯鍵
     * @param elseText 代替的硬編碼文本
     * @return 文本
     */
    public static MutableComponent translatableElse(String textId, String elseText){
        return translatableElse("", textId, elseText);
    }

    public static MutableComponent translatableElse(String prefix, String textId, String elseText){
        var textId2 = prefix+textId;
        var result = Component.translatable(textId);
        return result.getString().equals(textId2) ? Component.literal(elseText) : result;
    }
}
