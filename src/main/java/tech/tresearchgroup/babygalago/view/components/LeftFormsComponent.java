package tech.tresearchgroup.babygalago.view.components;

import j2html.tags.DomContent;
import org.jetbrains.annotations.NotNull;

import static j2html.TagCreator.div;

public class LeftFormsComponent {
    public static @NotNull DomContent render(String mediaType) {
        return div(
            FilterByComponent.render(),
            BulkActionsComponent.render(mediaType)
        ).withClass("leftForms");
    }
}
