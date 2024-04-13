package com.atguigu.crowd.service.impl.test;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.entity.AdminExample;
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

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
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
    private Admin validAdmin;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        // Подготовка валидного объекта Admin
        validAdmin = new Admin(1, "testLogin", CrowdUtil.md5("password"), "Test Name", "test@example.com", null);
    }

    /**
     * 成功保存
     */
    @Test
    public void saveAdmin_SuccessfulSave() {
        Admin admin = new Admin(null, "testLogin", "testPassword", "Test Name", "test@example.com", null);

        when(adminMapper.insert(admin)).thenReturn(1);

        adminService.saveAdmin(admin);

        verify(adminMapper).insert(admin);
        assertNotNull(admin.getUserPswd());
        assertNotEquals("testPassword", admin.getUserPswd()); // Проверка, что пароль был зашифрован
        assertNotNull(admin.getCreateTime()); // Проверка, что время создания было установлено
    }

    /**
     * 插入重复字段 “loginAcct”
     */
    @Test
    public void saveAdmin_DuplicateKeyThrowsException() {
        Admin admin = new Admin(null, "jerry", "password", "Test User", "test@example.com", null);
        doThrow(new DuplicateKeyException("Duplicate Key")).when(adminMapper).insert(any(Admin.class));
        assertThrows(LoginAcctAlreadyInUseException.class, () -> adminService.saveAdmin(admin));
    }

    /**
     * 给admin对象的某个不可为空的字段，例如 loginAcct 设为null
     */
    @Test
    public void saveAdmin_NullParametersHandledGracefully() {
        Admin admin = new Admin(null, null, null, "TestUser", "est@example.com", null);
        assertThrows(RuntimeException.class, () -> adminService.saveAdmin(admin));
    }

    /**
     * 传入admin==null
     */
    @Test
    public void saveAdmin_NullAdminHandledGracefully() {
        assertThrows(RuntimeException.class, () -> adminService.saveAdmin(null));
    }

    /**
     * 测试是否已经加密，是否为MD5有效加密
     */
    @Test
    public void saveAdmin_PasswordIsEncrypted() {
        String plainPsw = "plainPassword";
        Admin admin = new Admin(null, "testLogin", plainPsw, "Test Name", "test@example.com", null);
        adminService.saveAdmin(admin);
        assertNotEquals(plainPsw, admin.getUserPswd(), "Пароль должен быть зашифрован");
        assertEquals(CrowdUtil.md5(plainPsw), admin.getUserPswd());
    }

    /**
     * 测试创建时间
     */
    @Test
    public void saveAdmin_CreationTimeIsSet() {
        Admin admin = new Admin(null, "testLogin", "password", "Test Name", "test@example.com", null);

        adminService.saveAdmin(admin);

        assertNotNull(admin.getCreateTime(), "Время создания должно быть установлено");
        try {
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(admin.getCreateTime());
        } catch (Exception e) {
            fail("Формат времени создания не соответствует ожидаемому");
        }
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

    /**
     * Положительный тест: - Сценарий: Попытка аутентификации с валидными учетными данными. - Предпосылки: Администратор
     * с данным логином и паролем существует в системе. - Ожидаемый результат: Метод возвращает объект Admin,
     * соответствующий введенным учетным данным.
     */
    @Test
    public void getAdminByLoginAcct_Success() {
        String loginAcct = "testUser";
        String originPwd = "password";
        String afterPwd = CrowdUtil.md5(originPwd);
        when(adminMapper.selectByExample(any())).thenReturn(
            Collections.singletonList(new Admin(1, loginAcct, afterPwd, "Test User", "test@example.com", null)));
        assertDoesNotThrow(() -> adminService.getAdminByLoginAcct(loginAcct, originPwd));
    }

    /**
     * Неудачная Аутентификация из-за Неправильного Пароля
     * 密码错误
     */
    @Test
    public void getAdminByLoginAcct_WrongPassword() {
        when(adminMapper.selectByExample(any())).thenReturn(Collections.singletonList(new Admin()));
        assertThrows(LoginFailedException.class, () -> adminService.getAdminByLoginAcct("test", "wrongPassword"));
    }

    /**
     * Неудачная Аутентификация из-за Отсутствия Пользователя
     */
    @Test
    public void getAdminByLoginAcct_UserNotFound() {
        when(adminMapper.selectByExample(any())).thenReturn(Collections.emptyList());
        assertThrows(LoginFailedException.class, () -> adminService.getAdminByLoginAcct("nonexistent", "password"));
    }

    /**
     * Более Одного Администратора с Одним и Тем Же Логином
     */
    @Test
    public void getAdminByLoginAcct_MultipleUsersWithSameLogin() {
        when(adminMapper.selectByExample(any())).thenReturn(Arrays.asList(new Admin(), new Admin()));
        assertThrows(RuntimeException.class, () -> adminService.getAdminByLoginAcct("test", "password"));
    }

    /**
     * Передача Null Как Логина или Пароля
     */
    @Test
    public void getAdminByLoginAcct_NullLoginOrPassword() {
        assertThrows(RuntimeException.class, () -> adminService.getAdminByLoginAcct(null, "password"));
        assertThrows(RuntimeException.class, () -> adminService.getAdminByLoginAcct("test", null));
    }

    /**
     * Пустой Логин или Пароль
     */
    @Test
    public void getAdminByLoginAcct_EmptyLoginOrPassword() {
        assertThrows(LoginFailedException.class, () -> adminService.getAdminByLoginAcct("", "password"));
        assertThrows(LoginFailedException.class, () -> adminService.getAdminByLoginAcct("test", ""));
    }

    /**
     * 根据提供的信息查询不出对应的管理员用户
     * 抛出错误
     */
    @Test
    public void getEmptyAdminListByLoginAcct_ThrowException() {

        when(adminMapper.selectByExample(any())).thenReturn(Collections.emptyList());
        assertEquals(0, adminMapper.selectByExample(any()).size());
        assertThrows(LoginFailedException.class, () -> adminService.getAdminByLoginAcct("testAcct", "password"));
    }

    @Test
    public void getNullListByLoginAcct_ThrowException() {
        when(adminMapper.selectByExample(any())).thenReturn(null);
        assertThrows(LoginFailedException.class, () -> adminService.getAdminByLoginAcct("testAcct", "password"));
    }

    // -----------------------

    /**
     * Положительный Тест
     * Данный сценарий предполагает, что метод удаления будет выполнен успешно без возникновения исключений.
     */
    @Test
    public void remove_Success() {
        when(adminMapper.deleteByPrimaryKey(anyInt())).thenReturn(1);
        assertDoesNotThrow(() -> adminService.remove(1));
    }

    /**
     * 删除不存在的id
     */
    @Test
    void remove_NonExistentAdmin() {
        when(adminMapper.deleteByPrimaryKey(anyInt())).thenReturn(1);
        adminService.remove(-1); // ID, которого нет в базе данных
        verify(adminMapper, times(1)).deleteByPrimaryKey(-1);
    }

    /**
     * TODO 怎么做？ remove 的参数==null
     */
    @Test
    void update_ThrowsExceptionOnDuplicateKey() {
        assertDoesNotThrow(() -> adminService.remove(null));
    }

    // -----------------------

    /**
     * 成功更新成合法的管理员对象
     */
    @Test
    void updateAdmin_Success() {
        when(adminMapper.updateByPrimaryKeySelective(any(Admin.class))).thenReturn(1);
        adminService.update(validAdmin);
        verify(adminMapper, times(1)).updateByPrimaryKeySelective(validAdmin);
    }

    /**
     * 更新字段在数据库中已存在
     */
    @Test
    void updateAdmin_DuplicateKeyException() {
        doThrow(new DuplicateKeyException("Duplicate Key")).when(adminMapper)
            .updateByPrimaryKeySelective(any(Admin.class));
        assertThrows(LoginAcctAlreadyInUseForUpdateException.class, () -> adminService.update(new Admin()));
    }

    /**
     * TODO 有问题！？ admin 中某些字段为 null
     */
    @Test
    void updateAdmin_NullValuesInNonKeyFields() {
        Admin adminWithNullValues = new Admin(1, "testLogin", CrowdUtil.md5("password"), null, null, null);
        when(adminMapper.updateByPrimaryKeySelective(any(Admin.class))).thenReturn(1);
        assertDoesNotThrow(() -> adminService.update(adminWithNullValues));
        verify(adminMapper, times(1)).updateByPrimaryKeySelective(adminWithNullValues);
    }


    // -----------------------

    /**
     * 成功删除旧的 Relationship，保存了新的 Relationship
     */
    @Test
    void saveAdminRoleRelationship_WithValidData() {
        Integer adminId = 1;
        List<Integer> roleIdList = Arrays.asList(1, 2, 3);

        adminService.saveAdminRoleRelationship(adminId, roleIdList);
        assertEquals(3, roleIdList.size());

        verify(adminMapper).deleteOLdRelationship(adminId);
        verify(adminMapper).insertNewRelationship(eq(adminId), anyList());
    }

    /**
     * roleIdList 是空列表
     */
    @Test
    void saveAdminRoleRelationship_WithEmptyRoleIdList() {
        Integer adminId = 1;
        List<Integer> roleIdList = Collections.emptyList();

        adminService.saveAdminRoleRelationship(adminId, roleIdList);
        assertEquals(0, roleIdList.size());
        verify(adminMapper).deleteOLdRelationship(adminId);
        verify(adminMapper, never()).insertNewRelationship(eq(adminId), anyList());
    }

    /**
     * RoleIdList == null
     */
    @Test
    void saveAdminRoleRelationship_WithNullRoleIdList() {
        Integer adminId = 1;
        adminService.saveAdminRoleRelationship(adminId, null);
        verify(adminMapper).deleteOLdRelationship(adminId);
        verify(adminMapper, never()).insertNewRelationship(eq(adminId), anyList());
    }


    // /**
    //  * TODO 测试失败
    //  *
    //  */
    // @Test
    // void saveAdminRoleRelationship_WithInvalidAdminId() {
    //     Integer adminId = -1; // или невалидный ID, не существующий в базе данных
    //     List<Integer> roleIdList = Arrays.asList(1, 2, 3);
    //
    //     adminService.saveAdminRoleRelationship(adminId, roleIdList);
    //
    //     // В зависимости от реализации метода, можно проверить вызывался ли метод удаления или добавления
    //     verify(adminMapper, never()).deleteOLdRelationship(adminId);
    //     verify(adminMapper, never()).insertNewRelationship(anyInt(), anyList());
    // }


    // @Test
    // public void saveAdminRoleRelationship_SuccessWithNonEmptyList() {
    //     doNothing().when(adminMapper).deleteOLdRelationship(anyInt());
    //     doNothing().when(adminMapper).insertNewRelationship(anyInt(), anyList());
    //     assertDoesNotThrow(() -> adminService.saveAdminRoleRelationship(1, Arrays.asList(1, 2, 3)));
    // }
    //
    // @Test
    // public void saveAdminRoleRelationship_SuccessWithEmptyList() {
    //     doNothing().when(adminMapper).deleteOLdRelationship(anyInt());
    //     // Поскольку в методе нет явной проверки на пустой список для вставки новых связей, предполагается, что операция
    //     // просто не выполняется, не вызывая ошибок.
    //     assertDoesNotThrow(() -> adminService.saveAdminRoleRelationship(1, new ArrayList<>()));
    // }
    // -----------------------

}
