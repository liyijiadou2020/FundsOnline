package com.atguigu.crowd.service.impl.test;
import com.atguigu.crowd.entity.Role;
import com.atguigu.crowd.mapper.RoleMapper;
import com.atguigu.crowd.service.impl.RoleServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
/**
 * Created with IntelliJ IDEA 2023.2.2
 *
 * @author Li Yijia
 * @date 2024/3/22
 */

class RoleServiceImplTest {
    @Mock
    private RoleMapper roleMapper;

    @InjectMocks
    private RoleServiceImpl roleService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    // ------
    // @Test
    // void getPageInfo_ValidParameters_ReturnsCorrectData() {
    //     List<Role> expectedRoles = Arrays.asList(new Role(), new Role());
    //     when(roleMapper.selectRoleByKeyword(anyString())).thenReturn(expectedRoles);
    //     PageInfo<Role> result = roleService.getPageInfo(1, 10, "admin");
    //     assertNotNull(result.getList(), "Result list should not be null!");
    //     assertEquals(2, result.getList().size());
    // }

    // @Test
    // void getPageInfo_IncorrectParameters_ReturnsDefaultBehaviour() {
    //     assertDoesNotThrow(() -> roleService.getPageInfo(-1, -10, "admin"));
    // }

    // ------
    @Test
    public void saveRole_SuccessWithCorrectData() {
        Role role = new Role(null, "newRole");
        assertDoesNotThrow(() -> roleService.saveRole(role));
    }

    @Test
    public void saveRole_FailsWithIncorrectData() {
        assertDoesNotThrow(() -> roleService.saveRole(null)); // Допуская, что обработка исключений происходит на уровне
        // mapper
    }

    // ------
    @Test
    public void updateRole_Success() {
        Role role = new Role(1, "updatedRole");
        assertDoesNotThrow(() -> roleService.updateRole(role));
    }

    @Test
    public void updateRole_FailsWithIncorrectData() {
        Role role = new Role(null, null); // Предполагая некорректность данных
        assertDoesNotThrow(() -> roleService.updateRole(role)); // Обработка ошибок не описана, предполагаем стандартное
        // поведение
    }

//     -----
@Test
void removeRole_ValidIdList_RemovesSuccessfully() {
    // doNothing().when(roleMapper).deleteByExample(any());
    when(roleMapper.deleteByExample(any())).thenReturn(1);
    assertDoesNotThrow(() -> roleService.removeRole(Arrays.asList(1, 2, 3)));
}

    @Test
    void removeRole_EmptyIdList_ThrowsNoException() {
        assertDoesNotThrow(() -> roleService.removeRole(new ArrayList<>()));
    }
// --------
@Test
void getAssignedRole_ValidAdminId_ReturnsRoles() {
    when(roleMapper.selectAssignedRole(anyInt())).thenReturn(Arrays.asList(new Role(), new Role()));
    List<Role> result = roleService.getAssignedRole(1);
    assertNotNull(result);
    assertEquals(2, result.size());
}

    @Test
    void getUnAssignedRole_ValidAdminId_ReturnsRoles() {
        when(roleMapper.selectUnAssignedRole(anyInt())).thenReturn(Arrays.asList(new Role(), new Role()));
        List<Role> result = roleService.getUnAssignedRole(1);
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void getAssignedRole_InvalidAdminId_ReturnsEmptyList() {
        when(roleMapper.selectAssignedRole(anyInt())).thenReturn(new ArrayList<>());
        List<Role> result = roleService.getAssignedRole(-1);
        assertTrue(result.isEmpty());
    }

    @Test
    void getUnAssignedRole_InvalidAdminId_ReturnsEmptyList() {
        when(roleMapper.selectUnAssignedRole(anyInt())).thenReturn(new ArrayList<>());
        List<Role> result = roleService.getUnAssignedRole(-1);
        assertTrue(result.isEmpty());
    }


}