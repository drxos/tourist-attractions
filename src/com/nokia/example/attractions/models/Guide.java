/**
* Copyright (c) 2012-2013 Nokia Corporation. All rights reserved.
* Nokia and Nokia Connecting People are registered trademarks of Nokia Corporation. 
* Oracle and Java are trademarks or registered trademarks of Oracle and/or its
* affiliates. Other product and company names mentioned herein may be trademarks
* or trade names of their respective owners. 
* See LICENSE.TXT for license information.
*/
package com.nokia.example.attractions.models;

import com.nokia.maps.common.GeoCoordinate;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Describes a guide.
 */
public final class Guide {

    private String id = "";
    private String purchaseTicket = "";  // purchase ticket from Nokia store
    private String account = "";  // account from Nokia store
    private String url = "";
    private String imageUrl = "";
    private String city = "";
    private String price = "";
    private boolean restorable = false;
    private String country = "";
    private String latitude = "0";
    private String longitude = "0";
    private String urlPrefix = "";  // prefix to be added to urls in attractions

    /**
     * @return location of the guide
     */
    public final GeoCoordinate getCenter() {
        return new GeoCoordinate(Double.parseDouble(latitude),
            Double.parseDouble(longitude), 0);
    }

    /**
     * @see Object#equals(java.lang.Object) 
     */
    public final boolean equals(Object o) {
        if (o != null && o instanceof Guide) {
            return this.id.equals(((Guide) o).id);
        }
        return false;
    }

    /**
     * @see Object#hashCode()  
     */
    public final int hashCode() {
        return this.id.hashCode();
    }

    /**
     * Write guide to a data stream.
     * @param dout data stream
     * @throws IOException 
     */
    public final void writeTo(DataOutputStream dout)
        throws IOException {
        dout.writeUTF(id);
        dout.writeUTF(purchaseTicket);
        dout.writeUTF(url);
        dout.writeUTF(imageUrl);
        dout.writeUTF(city);
        dout.writeUTF(account);
    }

    /**
     * Read a guide from a data stream
     * @param din data stream
     * @return new guide read from din
     * @throws IOException 
     */
    public static Guide readFrom(DataInputStream din)
        throws IOException {
        Guide guide = new Guide();
        guide.id = din.readUTF();
        guide.purchaseTicket = din.readUTF();
        guide.url = din.readUTF();
        guide.imageUrl = din.readUTF();
        guide.city = din.readUTF();
        guide.account = din.readUTF();
        return guide;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getPrice() {
        return price;
    }

    public boolean isRestorable() {
        return restorable;
    }

    public String getPurchaseTicket() {
        return purchaseTicket;
    }

    public String getAccount() {
        return account;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlPrefix() {
        return urlPrefix;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setRestorable(boolean restorable) {
        this.restorable = restorable;
    }

    public void setPurchaseTicket(String purchaseTicket) {
        this.purchaseTicket = purchaseTicket;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUrlPrefix(String urlPrefix) {
        this.urlPrefix = urlPrefix;
    }
}
