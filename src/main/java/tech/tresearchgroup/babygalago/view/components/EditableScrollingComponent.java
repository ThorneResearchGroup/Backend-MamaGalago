package tech.tresearchgroup.babygalago.view.components;

import j2html.tags.DomContent;
import tech.tresearchgroup.schemas.galago.ui.Card;

import java.util.List;

import static j2html.TagCreator.*;

public class EditableScrollingComponent {
    public static DomContent render(boolean editable, String title, List<Card> cards, String url, int size) {
        return render(editable, title, cards, url, false, size);
    }

    public static DomContent render(boolean editable, String title, List<Card> cards, String url, boolean fixedTitle, int size) {
        boolean goodCards = false;
        if (cards != null) {
            if (cards.size() > 0) {
                goodCards = true;
            }
        }
        if (editable) {
            if (goodCards) {
                return span(
                    label(title).withClass("topicLabel"),
                    br(),
                    a().withClass("btn floatRight fas fa-plus").withHref(url).withText("Add"),
                    br(),
                    div(each(cards, card -> PosterViewComponent.render(card, size))).withClass("scrolling-wrapper")
                );
            } else {
                return span(
                    label(title).withClass("topicLabel"),
                    br(),
                    a().withClass("btn floatRight fas fa-plus").withHref(url).withText("Add"),
                    br()
                );
            }
        }
        if (goodCards) {
            return span(
                label(title).withClass("topicLabel"),
                br(),
                div(each(cards, card -> PosterViewComponent.render(card, size))).withClass("scrolling-wrapper")
            );
        } else {
            if (fixedTitle) {
                return span(
                    label(title).withClass("topicLabel"),
                    br()
                );
            }
            return null;
        }
    }
}
