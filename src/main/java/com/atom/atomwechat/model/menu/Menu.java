package com.atom.atomwechat.model.menu;

import lombok.Data;

import java.util.List;

/**
 * 自定义菜单
 *
 * @author atom
 */
@Data
public class Menu {
    private List<Button> button;
}
