package com.contentful.tea.java.services.localization;

import com.contentful.tea.java.models.Settings;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;
import static java.util.Locale.getDefault;

@Component
public class LocalizedStringsFromResourcesProvider implements LocalizedStringsProvider {

  @Autowired
  public Settings settings;

  private final Map<String, Map<String, String>> localizations = new HashMap<>();

  public LocalizedStringsFromResourcesProvider() {
    final Gson gson = new GsonBuilder().create();
    populateLocalization(gson, "en-US");
    populateLocalization(gson, "de-DE");
  }

  @Override public String localize(Keys key) {
    return localize(settings.getLocale(), key);
  }

  @Override public String localize(String locale, Keys key) {
    final Map<String, String> localized = localizations.get(locale);
    if (localized != null) {
      return localized.get(key.name());
    } else {
      return null;
    }
  }

  private void populateLocalization(Gson gson, String locale) {
    final String path = format(getDefault(), "locales/json/%s.json", locale);
    final ClassLoader classLoader = this.getClass().getClassLoader();
    final InputStream resourceAsStream = classLoader.getResourceAsStream(path);
    final InputStreamReader reader = new InputStreamReader(resourceAsStream);
    final Map fromJson = gson.fromJson(reader, Map.class);

    localizations.put(locale, fromJson);
  }
}
