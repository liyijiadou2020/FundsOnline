package com.atguigu.crowd.service.impl.test;

import com.atguigu.crowd.entity.Auth;
import com.atguigu.crowd.mapper.AuthMapper;
import com.atguigu.crowd.service.impl.AuthServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

/**
 * Created with IntelliJ IDEA 2023.2.2
 *
 * @author Li Yijia
 * @date 2024/3/22
 */
class AuthServiceImplTest {
    @Mock
    private AuthMapper authMapper;

    @InjectMocks
    private AuthServiceImpl authService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    // -----------
    @Test
    public void getAll_ReturnsFullList() {
        when(authMapper.selectByExample(any())).thenReturn(Collections.singletonList(new Auth()));
        List<Auth> result = authService.getAll();
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void getAll_ReturnsEmptyListWhenNoAuths() {
        when(authMapper.selectByExample(any())).thenReturn(Collections.emptyList());
        List<Auth> result = authService.getAll();
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // -----------
@Test
public void getAssignedAuthIdByRoleId_ReturnsIdList() {
    when(authMapper.selectAssignedAuthIdByRoleId(anyInt())).thenReturn(Collections.singletonList(1));
    List<Integer> result = authService.getAssignedAuthIdByRoleId(1);
    assertNotNull(result);
    assertFalse(result.isEmpty());
}

    @Test
    public void getAssignedAuthIdByRoleId_ReturnsEmptyListForNonExistentRole() {
        when(authMapper.selectAssignedAuthIdByRoleId(anyInt())).thenReturn(Collections.emptyList());
        List<Integer> result = authService.getAssignedAuthIdByRoleId(-1);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // ----------
    @Test
    public void saveRoleAuthRelathinship_SuccessWithNonEmptyList() {
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("roleId", Collections.singletonList(1));
        map.put("authIdArray", Collections.singletonList(1));

        doNothing().when(authMapper).deleteOldRelationship(anyInt());
        doNothing().when(authMapper).insertNewRelationship(anyInt(), anyList());

        assertDoesNotThrow(() -> authService.saveRoleAuthRelathinship(map));
    }

    @Test
    public void saveRoleAuthRelathinship_SuccessWithEmptyList() {
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("roleId", Collections.singletonList(1));
        map.put("authIdArray", Collections.emptyList());

        doNothing().when(authMapper).deleteOldRelationship(anyInt());

        assertDoesNotThrow(() -> authService.saveRoleAuthRelathinship(map));
    }

    @Test
    public void saveRoleAuthRelathinship_InvalidKeyInMap() {
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("wrongKey", Collections.singletonList(1));
        // Настройка и ожидание не требуется, так как метод не будет вызван из-за неправильного ключа
        assertThrows(Exception.class, () -> authService.saveRoleAuthRelathinship(map));
    }

    @Test
    public void saveRoleAuthRelathinship_NullMap() {
        assertThrows(NullPointerException.class, () -> authService.saveRoleAuthRelathinship(null));
    }

}
