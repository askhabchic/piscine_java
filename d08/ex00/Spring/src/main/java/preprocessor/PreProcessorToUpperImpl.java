package preprocessor;

import java.util.Locale;

public class PreProcessorToUpperImpl implements PreProcessor {
    @Override
    public String changeCase(String str) {
        return str.toUpperCase(Locale.ROOT);
    }
}
