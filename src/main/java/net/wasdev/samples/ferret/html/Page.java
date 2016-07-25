/*******************************************************************************
 * Copyright (c) 2014 IBM Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package net.wasdev.samples.ferret.html;

import java.util.ArrayList;
import java.util.List;

public final class Page {
    private static final String HEAD = "<!DOCTYPE html>" //
            + "<html>" //
            + "<head>" //
            + "<meta charset=\"ISO-8859-1\">" //
            + "<title>Ferret</title>" //
            + "<link rel='stylesheet' type='text/css' href='/ferret/static/style.css'>" //
            + "</head>";

    private static final String BODY_START = "<body>";

    private static final String BODY_END = "</body>" //
            + "</html>";

    private final List<Element> bodyElements = new ArrayList<Element>();

    public Page() {
    }

    public Page withBodyElement(final Element element) {
        bodyElements.add(element);
        return this;
    }

    public String toHtml() {
        return HEAD + BODY_START + getBodyElements() + BODY_END;
    }

    private String getBodyElements() {
        final StringBuilder sb = new StringBuilder();
        for (final Element bodyElement : bodyElements) {
            sb.append(bodyElement.toHtml());
        }
        return sb.toString();
    }

}
