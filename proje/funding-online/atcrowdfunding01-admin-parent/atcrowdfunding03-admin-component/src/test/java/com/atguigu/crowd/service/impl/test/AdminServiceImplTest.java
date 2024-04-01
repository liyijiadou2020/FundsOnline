package com.atguigu.crowd.service.impl.test;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.exception.LoginAcctAlreadyInUseException;
import com.atguigu.crowd.exception.LoginAcctAlreadyInUseForUpdateException;
import com.atguigu.crowd.exception.LoginFailedException;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.service.impl.AdminServiceImpl;
import com.atguigu.crowd.util.CrowdUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DuplicateKeyException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA 2023.2.2
 *
 * @author Li Yijia
 * @date 2024/3/21
 */
public class AdminServiceImplTest {
    @Mock
    private AdminMapper adminMapper;

    @InjectMocks
    private AdminServiceImpl adminService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void saveAdmin_Success() {
        Admin admin = new Admin(null, "testUser", "password", "Test User", "test@example.com", null);
        // doNothing().when(adminMapper).insert(any(Admin.class));
        when(adminMapper.insert(admin)).thenReturn(1);
        adminService.saveAdmin(admin);
        verify(adminMapper).insert(admin);
        // assertDoesNotThrow(() -> adminService.saveAdmin(admin));
    }

    @Test
    public void saveAdmin_ThrowsExceptionOnDuplicateKey() {
        Admin admin = new Admin(null, "testUser", "password", "Test User", "test@example.com", null);
        doThrow(new DuplicateKeyException("Duplicate Key")).when(adminMapper).insert(any(Admin.class));
        assertThrows(LoginAcctAlreadyInUseException.class, () -> adminService.saveAdmin(admin));
    }

    // -----------------------
    @Test
    public void getAll_ReturnsNonEmptyList() {
        List<Admin> expectedList = Arrays.asList(new Admin());
        when(adminMapper.selectByExample(any())).thenReturn(expectedList);
        List<Admin> resultList = adminService.getAll();
        assertFalse(resultList.isEmpty());
    }

    // -----------------------
    @Test
    public void getAdminByLoginAcct_Success() {
        String loginAcct = "testUser";
        String originPwd = "password";
        String afterPwd = CrowdUtil.md5(originPwd);
        when(adminMapper.selectByExample(any())).thenReturn(
            Collections.singletonList(new Admin(1, loginAcct, afterPwd, "Test User", "test@example.com", null)));
        assertDoesNotThrow(() -> adminService.getAdminByLoginAcct(loginAcct, originPwd));
    }

    @Test
    public void getAdminByLoginAcct_FailedLogin() {
        when(adminMapper.selectByExample(any())).thenReturn(Collections.emptyList());
        assertThrows(LoginFailedException.class, () -> adminService.getAdminByLoginAcct("wrongUser", "password"));
    }

    // -----------------------
    @Test
    public void remove_Success() {
        when(adminMapper.deleteByPrimaryKey(anyInt())).thenReturn(1);
        assertDoesNotThrow(() -> adminService.remove(1));
    }

    @Test
    public void remove_NonExistentAdmin() {
        doThrow(new RuntimeException("Admin not found")).when(adminMapper).deleteByPrimaryKey(anyInt());
        // Так как метод не предполагает обработку исключений в случае отсутствия администратора, тестовый кейс
        // адаптирован под общий подход к исключениям
        assertThrows(RuntimeException.class, () -> adminService.remove(-1));
    }

    // -----------------------
    @Test
    public void update_Success() {
        when(adminMapper.updateByPrimaryKeySelective(any(Admin.class))).thenReturn(1);
        assertDoesNotThrow(() -> adminService.update(new Admin()));
    }

    @Test
    public void update_ThrowsExceptionOnDuplicateKey() {
        doThrow(new DuplicateKeyException("Duplicate Key")).when(adminMapper)
            .updateByPrimaryKeySelective(any(Admin.class));
        assertThrows(LoginAcctAlreadyInUseForUpdateException.class, () -> adminService.update(new Admin()));
    }

    // -----------------------
    @Test
    public void saveAdminRoleRelationship_SuccessWithNonEmptyList() {
        doNothing().when(adminMapper).deleteOLdRelationship(anyInt());
        doNothing().when(adminMapper).insertNewRelationship(anyInt(), anyList());
        assertDoesNotThrow(() -> adminService.saveAdminRoleRelationship(1, Arrays.asList(1, 2, 3)));
    }

    @Test
    public void saveAdminRoleRelationship_SuccessWithEmptyList() {
        doNothing().when(adminMapper).deleteOLdRelationship(anyInt());
        // Поскольку в методе нет явной проверки на пустой список для вставки новых связей, предполагается, что операция
        // просто не выполняется, не вызывая ошибок.
        assertDoesNotThrow(() -> adminService.saveAdminRoleRelationship(1, new ArrayList<>()));
    }
    // -----------------------

}
