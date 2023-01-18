package tech.tresearchgroup.babygalago.view.components;

import j2html.tags.DomContent;
import org.jetbrains.annotations.NotNull;

import static j2html.TagCreator.*;

public class SortByFormComponent {
    public static @NotNull DomContent render() {
        return form(
            label("Sort by:").withFor("sortBy"),
            select(
                option("Name Asc").withValue("nameAsc"),
                option("Name Desc").withValue("nameDesc"),
                option("Year Asc").withValue("yearAsc"),
                option("Year Desc").withValue("yearDesc"),
                option("Popularity Asc").withValue("popularityAsc"),
                option("Popularity Desc").withValue("popularityDesc"),
                option("Rating Asc").withValue("ratingAsc"),
                option("Rating Desc").withValue("ratingDesc")
            ).withId("sortBy").withName("sortBy"),
            button("Go").withType("submit")
        ).withId("sortByForm");
    }
}
