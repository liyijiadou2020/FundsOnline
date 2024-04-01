/**
 * Created with IntelliJ IDEA 2023.2.2
 *
 * @author Li Yijia
 * @date 2024/3/22
 */
package com.atguigu.crowd.service.impl.test;

import static org.junit.jupiter.api.Assertions.*;
import com.atguigu.crowd.entity.Menu;
import com.atguigu.crowd.mapper.MenuMapper;
import com.atguigu.crowd.service.impl.MenuServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class MenuServiceImplTest {
    @Mock
    private MenuMapper menuMapper;

    @InjectMocks
    private MenuServiceImpl menuService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // ----------------
    @Test
    void getAll_ReturnsFullList() {
        when(menuMapper.selectByExample(any())).thenReturn(Collections.singletonList(new Menu()));
        List<Menu> result = menuService.getAll();
        assertFalse(result.isEmpty(), "The result should not be empty when menus exist");
    }

    @Test
    void getAll_ReturnsEmptyListWhenNoMenus() {
        when(menuMapper.selectByExample(any())).thenReturn(Collections.emptyList());
        List<Menu> result = menuService.getAll();
        assertTrue(result.isEmpty(), "The result should be empty when no menus exist");
    }

    // ----------------
    @Test
    void saveMenu_SuccessfullySavesMenu() {
        Menu menu = new Menu();
        menu.setName("New Menu");
        when(menuMapper.insert(any(Menu.class))).thenReturn(1);
        assertDoesNotThrow(() -> menuService.saveMenu(menu));
    }

    @Test
    void saveMenu_FailsWithInvalidData() {
        assertDoesNotThrow(() -> menuService.saveMenu(null), "Saving null should not throw an exception");
    }

    // ----------------------
    @Test
    void updateMenu_SuccessfullyUpdatesMenu() {
        Menu menu = new Menu();
        menu.setId(1);
        menu.setName("Updated Menu");
        when(menuMapper.updateByPrimaryKeySelective(any(Menu.class))).thenReturn(1);
        assertDoesNotThrow(() -> menuService.updateMenu(menu));
    }

    @Test
    void updateMenu_FailsWithInvalidData() {
        Menu menu = new Menu(); // Например, без установленного ID
        assertDoesNotThrow(() -> menuService.updateMenu(menu),
            "Updating menu without ID should not throw an exception");
    }

    // ----------------------
    @Test
    void removeMenu_SuccessfullyRemovesMenu() {

        when(menuMapper.deleteByPrimaryKey(anyInt())).thenReturn(1);
        assertDoesNotThrow(() -> menuService.removeMenu(1));
    }


    @Test
    void removeMenu_FailsWithNonexistentId002() {
        assertDoesNotThrow(() -> menuService.removeMenu(-1),
                "Removing menu with nonexistent ID should not throw an exception");
    }


}
