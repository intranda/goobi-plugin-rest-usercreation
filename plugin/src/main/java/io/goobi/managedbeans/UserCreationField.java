package io.goobi.managedbeans;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import lombok.Data;

@Data
public class UserCreationField {

    private String type;
    private boolean displayInTable;
    private String fieldType;
    private String label;
    private String name;
    private String position;
    private boolean required;
    private String validation;
    private String validationErrorMessage;

    private String value;
    private String subValue;
    private List<String> selectItemList;

    private boolean validationError = false;

    private String helpMessage;

    private String shortLabel;

    public void setBooleanValue(boolean val) {
        if (val) {
            value = "true";
        } else {
            value = "false";
        }
    }

    public boolean getBooleanValue() {
        return StringUtils.isNotBlank(value) && "true".equals(value);
    }

    public boolean validateValue() {

        String val = value;
        if (StringUtils.isNotBlank(subValue)) {
            val = subValue;
        }

        validationError = false;
        if (required && StringUtils.isBlank(val)) {
            validationError = true;
            return false;
        }

        if (StringUtils.isNotBlank(validation) && StringUtils.isNotBlank(val)) {
            if (!val.matches(validation)) {
                validationError = true;
                return false;
            }

        }
        return true;
    }
}
