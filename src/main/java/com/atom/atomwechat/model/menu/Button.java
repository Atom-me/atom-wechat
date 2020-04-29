package com.atom.atomwechat.model.menu;

import lombok.Data;

import java.util.List;

/**
 * @author atom
 */
@Data
public class Button {
    private String name;
    private String type;
    private List<Button> sub_button;
}
