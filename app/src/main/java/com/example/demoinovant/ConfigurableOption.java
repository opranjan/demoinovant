package com.example.demoinovant;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ConfigurableOption {

    @SerializedName("attribute_id")
    private int attributeId;

    @SerializedName("type")
    private String type;

    @SerializedName("attribute_code")
    private String attributeCode;

    @SerializedName("attributes")
    private List<Attribute> attributes;

    public int getAttributeId() {
        return attributeId;
    }

    public String getType() {
        return type;
    }

    public String getAttributeCode() {
        return attributeCode;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }
}

