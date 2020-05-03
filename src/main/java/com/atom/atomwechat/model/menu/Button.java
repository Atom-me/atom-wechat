package com.atom.atomwechat.model.menu;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Atom
 */
@Data
public class Button {
    private String name;
    private String type;
    @JsonProperty(value = "sub_button")
    private List<Button> subButton;
}
