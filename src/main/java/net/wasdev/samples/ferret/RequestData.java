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
package net.wasdev.samples.ferret;

import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public final class RequestData {
    private final String method;
    private final String uri;
    private final String protocol;
    private final String servletPath;
    private final String pathInfo;
    private final String pathTranslated;
    private final String characterEncoding;
    private final String queryString;
    private final int contentLength;
    private final String contentType;
    private final String serverName;
    private final int serverPort;
    private final String remoteUser;
    private final String remoteAddress;
    private final String remoteHost;
    private final int remotePort;
    private final String localAddress;
    private final String localHost;
    private final int localPort;
    private final String authorizationScheme;
    private final Locale preferredClientLocale;
    private final List<Locale> allClientLocales;
    private final String contextPath;
    private final Principal userPrincipal;
    private final Map<String, List<String>> requestHeaders;
    private final Map<String, String> cookies;
    private final Map<String, String> requestAttributes;

    public RequestData(final HttpServletRequest request) {
        method = request.getMethod();
        uri = request.getRequestURI();
        protocol = request.getProtocol();
        servletPath = request.getServletPath();
        pathInfo = request.getPathInfo();
        pathTranslated = request.getPathTranslated();
        characterEncoding = request.getCharacterEncoding();
        queryString = request.getQueryString();
        contentLength = request.getContentLength();
        contentType = request.getContentType();
        serverName = request.getServerName();
        serverPort = request.getServerPort();
        remoteUser = request.getRemoteUser();
        remoteAddress = request.getRemoteAddr();
        remoteHost = request.getRemoteHost();
        remotePort = request.getRemotePort();
        localAddress = request.getLocalAddr();
        localHost = request.getLocalName();
        localPort = request.getLocalPort();
        authorizationScheme = request.getAuthType();
        preferredClientLocale = request.getLocale();
        allClientLocales = Collections.list(request.getLocales());
        contextPath = request.getContextPath();
        userPrincipal = request.getUserPrincipal();
        requestHeaders = getRequestHeaders(request);
        cookies = getCookies(request.getCookies());
        requestAttributes = getRequestAttributes(request);
    }

    private Map<String, List<String>> getRequestHeaders(final HttpServletRequest httpServletRequest) {
        final List<String> headerNames = Collections.list(httpServletRequest.getHeaderNames());
        final Map<String, List<String>> headers = new TreeMap<String, List<String>>();
        for (final String name : headerNames) {
            final List<String> header = Collections.list(httpServletRequest.getHeaders(name));
            headers.put(name, header);
        }
        return headers;
    }

    private Map<String, String> getRequestAttributes(final HttpServletRequest httpServletRequest) {
        final List<String> attributeNames = Collections.list(httpServletRequest.getAttributeNames());
        final Map<String, String> attributes = new TreeMap<String, String>();
        for (final String name : attributeNames) {
            final Object attribute = httpServletRequest.getAttribute(name);
            if (attribute != null) {
                attributes.put(name, attribute.toString());
            } else {
                attributes.put(name, "");
            }
        }
        return attributes;
    }

    private Map<String, String> getCookies(final Cookie[] cookies) {
        final Map<String, String> map = new TreeMap<String, String>();
        if (cookies != null) {
            for (final Cookie cookie : cookies) {
                map.put(cookie.getName(), cookie.getValue());
            }
        }
        return map;
    }

    public String getMethod() {
        return method;
    }

    public String getUri() {
        return uri;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getServletPath() {
        return servletPath;
    }

    public String getPathInfo() {
        return pathInfo;
    }

    public String getPathTranslated() {
        return pathTranslated;
    }

    public String getCharacterEncoding() {
        return characterEncoding;
    }

    public String getQueryString() {
        return queryString;
    }

    public int getContentLength() {
        return contentLength;
    }

    public String getContentType() {
        return contentType;
    }

    public String getServerName() {
        return serverName;
    }

    public int getServerPort() {
        return serverPort;
    }

    public String getRemoteUser() {
        return remoteUser;
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public String getRemoteHost() {
        return remoteHost;
    }

    public int getRemotePort() {
        return remotePort;
    }

    public String getLocalAddress() {
        return localAddress;
    }

    public String getLocalHost() {
        return localHost;
    }

    public int getLocalPort() {
        return localPort;
    }

    public String getAuthorizationScheme() {
        return authorizationScheme;
    }

    public List<Locale> getAllClientLocales() {
        return allClientLocales;
    }

    public Locale getPreferredClientLocale() {
        return preferredClientLocale;
    }

    public String getContextPath() {
        return contextPath;
    }

    public Principal getUserPrincipal() {
        return userPrincipal;
    }

    public Map<String, List<String>> getRequestHeaders() {
        return requestHeaders;
    }

    public Map<String, String> getCookies() {
        return cookies;
    }

    public Map<String, String> getRequestAttributes() {
        return requestAttributes;
    }

    @Override
    public String toString() {
        return "<p>method = " + method + "</p> uri = " + uri + "</p> protocol = " + protocol + "</p> servletPath = "
                + servletPath + "</p> pathInfo = " + pathInfo + "</p> pathTranslated = " + pathTranslated
                + "</p> characterEncoding = " + characterEncoding + "</p> queryString = " + queryString
                + "</p> contentLength = " + contentLength + "</p> contentType = " + contentType + "</p> serverName = "
                + serverName + "</p> serverPort = " + serverPort + "</p> remoteUser = " + remoteUser
                + "</p> remoteAddress = " + remoteAddress + "</p> remoteHost = " + remoteHost + "</p> remotePort = "
                + remotePort + "</p> localAddress = " + localAddress + "</p> localHost = " + localHost
                + "</p> localPort = " + localPort + "</p> authorizationScheme = " + authorizationScheme
                + "</p> preferredClientLocale = " + preferredClientLocale + "</p> allClientLocales = "
                + allClientLocales + "</p> contextPath = " + contextPath + "</p> userPrincipal = " + userPrincipal
                + "</p> requestHeaders = " + requestHeaders + "</p> cookies = " + cookies
                + "</p> requestAttributes = " + requestAttributes;
    }

    public Map<String, Object> getAsMap() {
        Map<String, Object> map = new TreeMap<String, Object>();
        map.put("authorizationScheme", authorizationScheme);
        map.put("preferredClientLocale", preferredClientLocale);
        map.put("allClientLocales", allClientLocales);
        map.put("contextPath", contextPath);
        map.put("userPrincipal", userPrincipal);
        map.put("requestHeaders", requestHeaders);
        map.put("requestAttributes", requestAttributes);
        map.put("cookies", cookies);
        map.put("method", method);
        map.put("uri", uri);
        map.put("protocol", protocol);
        map.put("servletPath", servletPath);
        map.put("pathInfo", pathInfo);
        map.put("pathTranslated", pathTranslated);
        map.put("characterEncoding", characterEncoding);
        map.put("queryString", queryString);
        map.put("contentLength", contentLength);
        map.put("contentType", contentType);
        map.put("serverName", serverName);
        map.put("serverPort", serverPort);
        map.put("remoteUser", remoteUser);
        map.put("remoteAddress", remoteAddress);
        map.put("remoteHost", remoteHost);
        map.put("remotePort", remotePort);
        map.put("localHost", localHost);
        map.put("localPort", localPort);
        return map;
    }

}
