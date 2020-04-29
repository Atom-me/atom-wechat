package com.atom.atomwechat.model.menu;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author atom
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ViewButton extends Button {
    private String url;
}
