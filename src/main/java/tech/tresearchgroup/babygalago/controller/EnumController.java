package tech.tresearchgroup.babygalago.controller;

import tech.tresearchgroup.schemas.galago.enums.*;

import java.util.LinkedList;
import java.util.List;

public class EnumController {
    public static List<String> getCountryValues() {
        List<String> stringList = new LinkedList<>();
        for (CountryEnum countryEnum : CountryEnum.values()) {
            stringList.add(toCamelCase(countryEnum.name()));
        }
        return stringList;
    }

    public static List<String> getLanguagesValues() {
        List<String> stringList = new LinkedList<>();
        for (LanguagesEnum languagesEnum : LanguagesEnum.values()) {
            stringList.add(toCamelCase(languagesEnum.name()));
        }
        return stringList;
    }

    public static List<String> getMpaaValues() {
        List<String> stringList = new LinkedList<>();
        for (MPAARatingEnum mpaaRatingEnum : MPAARatingEnum.values()) {
            stringList.add(toCamelCase(mpaaRatingEnum.name()));
        }
        return stringList;
    }

    public static List<String> getMovieGenres() {
        List<String> stringList = new LinkedList<>();
        for (MovieGenreEnum movieGenreEnum : MovieGenreEnum.values()) {
            stringList.add(toCamelCase(movieGenreEnum.name()));
        }
        return stringList;
    }

    public static List<String> getPlaybackQuality() {
        List<String> stringList = new LinkedList<>();
        for (PlaybackQualityEnum playbackQualityEnum : PlaybackQualityEnum.values()) {
            stringList.add(toCamelCase(playbackQualityEnum.name()));
        }
        return stringList;
    }

    public static List<String> getGamePlatforms() {
        List<String> stringList = new LinkedList<>();
        for (GamePlatformEnum gamePlatformEnum : GamePlatformEnum.values()) {
            stringList.add(toCamelCase(gamePlatformEnum.name()));
        }
        return stringList;
    }

    private static String toCamelCase(String value) {
        String withoutUnderscores = value.replaceAll("_", " ");
        String[] words = withoutUnderscores.split("[\\W_]+");
        StringBuilder builder = new StringBuilder();
        for (String s : words) {
            String word = s.isEmpty() ? s : Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
            builder.append(word).append(" ");
        }
        return builder.toString();
    }
}
