package preprocessor;

import java.util.Locale;

public class PreProcessorToLowerImpl implements PreProcessor {
    @Override
    public String changeCase(String str) {
        return str.toLowerCase(Locale.ROOT);
    }
}
