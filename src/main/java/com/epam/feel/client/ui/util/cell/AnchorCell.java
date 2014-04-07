package com.epam.feel.client.ui.util.cell;

import org.apache.commons.lang.StringUtils;
import com.epam.feel.client.ui.util.StringUtilities;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.Anchor;

/**
 * Link Cell class for tables inherited from AbstractCellTable<T>.
 * 
 * @author Sergey_Klyosov
 */
public class AnchorCell extends AbstractCell<AnchorCell.LinkedText> {

    public static class LinkedText implements Comparable<LinkedText> {

        public LinkedText(String name, String link) {
            this.name = name;
            this.link = link;
        }

        public String name;
        public String link;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        @Override
        public int compareTo(LinkedText o) {
            final String strToCompare = (name != null) ? name : StringUtils.EMPTY;
            return strToCompare.compareTo(o.getName());
        }

    }

    /**
     * Render a cell
     */
    @Override
    public void render(com.google.gwt.cell.client.Cell.Context context, LinkedText value, SafeHtmlBuilder sb) {

        if ((value == null) || (value.getName() == null) || (value.getName().isEmpty())) {
            return;
        }

        if (!StringUtilities.isUrl(value.getLink())) {
            sb.appendHtmlConstant(value.getName());
        } else {
            Anchor a = new Anchor();
            a.setHref(value.getLink());
            a.setTarget("_blank");
            a.setText(value.getName());
            sb.appendHtmlConstant(a.toString());
        }
    }

}
