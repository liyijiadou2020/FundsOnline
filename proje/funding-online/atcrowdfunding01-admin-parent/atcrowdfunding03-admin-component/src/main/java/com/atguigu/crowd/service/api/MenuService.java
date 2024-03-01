package com.atguigu.crowd.service.api;
import com.atguigu.crowd.entity.Menu;

import java.util.List;

/**
 * Created: 2024/3/1
 * Author: Li Yijia
 * Description:
 */
public interface MenuService {
    List<Menu> getAll();

    void saveMenu(Menu menu);

    void updateMenu(Menu menu);

    void removeMenu(Integer id);

}
