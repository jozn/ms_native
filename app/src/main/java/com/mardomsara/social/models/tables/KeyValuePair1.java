package com.mardomsara.social.models.tables;

import com.github.gfx.android.orma.annotation.*;

@Table
public class KeyValuePair1 {

    static final String kKey = "Key";

    @Column(kKey) // specifies the name
	private String key;

    @Column // omits the name
    private String value;

    @Getter(kKey)
    public String getKey() {
        return key;
    }

    @Setter(kKey)
    public void setKey(String key) {
        this.key = key;
    }

    // used as a getter for the "value" column
    // @Getter is optional in this case
    public String getValue() {
        return value;
    }

    // used as a setter for the "value" column
    // @Setter is optional in this case
    public void setValue(String value) {
        this.value = value;
    }
}