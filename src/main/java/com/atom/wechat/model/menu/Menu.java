package com.atom.wechat.model.menu;

import lombok.Data;

import java.util.List;

/**
 * 自定义菜单
 *
 * @author Atom
 */
@Data
public class Menu {
    private List<Button> button;
}
